package com.example.studyspringboot.domain.auth.service;

import com.example.studyspringboot.domain.auth.domain.Certification;
import com.example.studyspringboot.domain.auth.domain.repository.CertificationRepository;
import com.example.studyspringboot.domain.auth.exception.SendMessageFailedException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class EmailService {

    private final CertificationRepository certificationRepository;
    private final JavaMailSender javaMailSender;

    @Value("${code.exp}")
    private Integer CODE_EXP;

    @Value("${mail.email}")
    private String myEmail;

    public static final Random RANDOM = new Random();

    public String sendCode(String email) {
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            String code = createRandomCode();
            message.setFrom(myEmail);
            message.addRecipients(Message.RecipientType.TO, email);
            message.setSubject("[이메일 인증]");
            message.setText(code);
            javaMailSender.send(message);
            return code;
        } catch (MessagingException e) {
            throw SendMessageFailedException.EXCEPTION;
        }
    }

    @Transactional
    public void sendEmail(String email) {
        certificationRepository.findByEmail(email)
                .map(certification -> certificationRepository.save(certification.updateCode(sendCode(email))))
                .orElseGet(() -> certificationRepository.save(Certification.builder()
                        .code(sendCode(email))
                        .email(email)
                        .codeExp(CODE_EXP)
                        .isVerify(false)
                        .build()));
    }

    private String createRandomCode() {
        return String.format("%06d", RANDOM.nextInt(1000000) % 1000000);
    }

}
