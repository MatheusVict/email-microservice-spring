package io.matheusvictor.emailmicroservice.services.impl;

import io.matheusvictor.emailmicroservice.domain.Email;
import io.matheusvictor.emailmicroservice.domain.StatusEmail;
import io.matheusvictor.emailmicroservice.repositories.EmailRepository;
import io.matheusvictor.emailmicroservice.services.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final EmailRepository emailRepository;
    private final JavaMailSender emailSender;

    @Override
    public void sendEmail(Email email) {
        email.setSendDataEmail(LocalDateTime.now());

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getEmailFrom());
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());
            emailSender.send(message);
            email.setStatusEmail(StatusEmail.SENT);
        } catch (MailException e) {
            email.setStatusEmail(StatusEmail.ERROR);
        } finally {
            emailRepository.save(email);
        }
    }
}
