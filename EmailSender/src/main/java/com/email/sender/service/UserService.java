package com.email.sender.service;

import com.email.sender.controller.dto.request.EmailRequest;
import com.email.sender.controller.dto.request.EmailVerifiedRequest;
import com.email.sender.controller.dto.request.UserSignUpRequest;
import com.email.sender.entity.Certification;
import com.email.sender.entity.User;
import com.email.sender.exception.CodeAlreadyExpiredException;
import com.email.sender.exception.CodeNotCorrectException;
import com.email.sender.exception.EmailNotCertifiedException;
import com.email.sender.exception.UserExistException;
import com.email.sender.repository.CertificationRepository;
import com.email.sender.repository.UserRepository;
import com.email.sender.type.Certified;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

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
