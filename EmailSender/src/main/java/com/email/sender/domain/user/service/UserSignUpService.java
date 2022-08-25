package com.email.sender.domain.user.service;

import com.email.sender.domain.auth.presentation.dto.request.EmailVerifiedRequest;
import com.email.sender.domain.auth.service.MailService;
import com.email.sender.domain.user.presentation.dto.request.UserSignUpRequest;
import com.email.sender.domain.auth.domain.Certification;
import com.email.sender.domain.user.domain.User;
import com.email.sender.domain.user.exception.UserExistException;
import com.email.sender.domain.auth.domain.repository.CertificationRepository;
import com.email.sender.domain.user.domain.repository.UserRepository;
import com.email.sender.domain.auth.domain.type.Certified;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserSignUpService {

    private final MailService mailService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CertificationRepository certificationRepository;

    @Transactional
    public void signUp(UserSignUpRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw UserExistException.EXCEPTION;
        }

        mailService.sendEmail(request.getEmail());

        Certification certification = certificationRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> CodeAlreadyExpiredException.EXCEPTION);

        if (certification.getCertified() == (Certified.CERTIFIED)) {
            userRepository.save(User.builder()
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .name(request.getName())
                    .build());
        } else throw EmailNotCertifiedException.EXCEPTION;
    }

    @Transactional
    public void verifyAccount(EmailVerifiedRequest request) {
        certificationRepository.findByEmail(request.getEmail())
                .filter(s -> request.getCode().equals(s.getCode()))
                .map(certification -> certificationRepository.save(certification.updateCertified(Certified.CERTIFIED)))
                .orElseThrow(() -> CodeNotCorrectException.EXCEPTION);
    }

}
