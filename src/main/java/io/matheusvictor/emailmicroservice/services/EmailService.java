package io.matheusvictor.emailmicroservice.services;

import io.matheusvictor.emailmicroservice.domain.Email;

public interface EmailService {
    void sendEmail(Email email);
}
