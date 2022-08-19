package com.example.studyspringboot.global.security.jwt;

import com.example.studyspringboot.domain.auth.domain.RefreshToken;
import com.example.studyspringboot.domain.auth.domain.repository.RefreshTokenRepository;
import com.example.studyspringboot.global.enums.Role;
import com.example.studyspringboot.global.exception.ExpiredJwtException;
import com.example.studyspringboot.global.exception.InvalidJwtException;
import com.example.studyspringboot.global.security.auth.AuthDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    private final JwtProperty jwtProperty;
    private final AuthDetailsService authDetailsService;
    private final RefreshTokenRepository refreshTokenRepository;

    public String generateAccessToken(String accountId, Role role) {
        return generateToken(accountId, role, "access", jwtProperty.getAccessExp());
    }

    public String generateRefreshToken(String accountId, Role role) {
        String refreshToken = generateToken(accountId, role, "refresh", jwtProperty.getRefreshExp());
        refreshTokenRepository.save(RefreshToken.builder()
                .accountId(accountId)
                .token(refreshToken)
                .ttl(jwtProperty.getRefreshExp())
                .build());

        return refreshToken;
    }

    private String generateToken(String accountId, Role role, String type, Long exp) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtProperty.getSecretKey())
                .setSubject(accountId)
                .setHeaderParam("type", type)
                .claim("authority", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + exp * 1000))
                .compact();
    }

    public String resolveToken(HttpServletRequest request) {
        String bearer = request.getHeader(jwtProperty.getHeader());
        return parseToken(bearer);
    }

    public String parseToken(String bearerToken) {
        if (bearerToken != null && bearerToken.startsWith(jwtProperty.getPrefix())) {
            return bearerToken.replace(jwtProperty.getPrefix(), "");
        }
        return null;
    }

    public Authentication authentication(String token) {
        UserDetails userDetails = authDetailsService.loadUserByUsername(getTokenSubject(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    private String getTokenSubject(String token) {
        return getTokenBody(token).getSubject();
    }

    private Claims getTokenBody(String token) {
        try {
            return Jwts.parser().setSigningKey(jwtProperty.getSecretKey())
                    .parseClaimsJws(token).getBody();
        } catch (io.jsonwebtoken.ExpiredJwtException e) {
            throw ExpiredJwtException.EXCEPTION;
        } catch (Exception e) {
            throw InvalidJwtException.EXCEPTION;
        }
    }

}
