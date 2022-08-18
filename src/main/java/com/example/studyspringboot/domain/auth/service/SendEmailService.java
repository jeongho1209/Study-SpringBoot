package com.example.studyspringboot.domain.auth.service;

import com.example.studyspringboot.domain.auth.presentation.dto.request.EmailVerifiedRequest;
import com.example.studyspringboot.domain.auth.presentation.dto.request.SendEmailRequest;
import com.example.studyspringboot.domain.auth.domain.repository.CertificationRepository;
import com.example.studyspringboot.domain.auth.exception.CodeNotCorrectException;
import com.example.studyspringboot.domain.user.exception.UserExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SendEmailService {

    private final CertificationRepository certificationRepository;
    private final EmailService emailService;

    @Transactional
    public void sendEmail(SendEmailRequest request) {
        if (certificationRepository.findByEmail(request.getEmail()).isPresent()) {
            throw UserExistException.EXCEPTION;
        }
        emailService.sendEmail(request.getEmail());
    }

    @Transactional
    public void verifyAccount(EmailVerifiedRequest request) {
        certificationRepository.findByEmail(request.getEmail())
                .filter(certification -> certification.getCode().equals(request.getCode()))
                .map(certification -> certificationRepository.save(certification.updateCertified(true)))
                .orElseThrow(() -> CodeNotCorrectException.EXCEPTION);
    }

}
