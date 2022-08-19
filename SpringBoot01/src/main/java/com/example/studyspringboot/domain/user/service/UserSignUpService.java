package com.example.studyspringboot.domain.user.service;

import com.example.studyspringboot.domain.auth.domain.Certification;
import com.example.studyspringboot.domain.auth.domain.repository.CertificationRepository;
import com.example.studyspringboot.domain.auth.exception.CodeAlreadyExpiredException;
import com.example.studyspringboot.domain.auth.exception.EmailCodeNotVerifiedException;
import com.example.studyspringboot.domain.auth.service.EmailService;
import com.example.studyspringboot.domain.user.domain.User;
import com.example.studyspringboot.domain.user.domain.repository.UserRepository;
import com.example.studyspringboot.domain.user.exception.UserExistException;
import com.example.studyspringboot.domain.user.presentation.dto.request.UserSignUpRequest;
import com.example.studyspringboot.global.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserSignUpService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CertificationRepository certificationRepository;
    private final EmailService emailService;

    @Transactional
    public void signUp(UserSignUpRequest request) {

        if (userRepository.findByAccountId(request.getAccountId()).isPresent() ||
                userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw UserExistException.EXCEPTION;
        }

        emailService.sendEmail(request.getEmail());

        Certification certification = certificationRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> CodeAlreadyExpiredException.EXCEPTION);

        if (!certification.isVerify()) {
            throw EmailCodeNotVerifiedException.EXCEPTION;
        }

        User user = User.builder()
                .accountId(request.getAccountId())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .name(request.getName())
                .sex(request.getSex())
                .role(Role.USER)
                .build();
        userRepository.save(user);
    }

}
