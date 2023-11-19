package io.matheusvictor.emailmicroservice.controllers;

import io.matheusvictor.emailmicroservice.domain.Email;
import io.matheusvictor.emailmicroservice.dtos.EmailDTO;
import io.matheusvictor.emailmicroservice.services.EmailService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class EmailController {
    private final EmailService emailService;

    private final Logger logger = LogManager.getLogger(EmailController.class);

    @PostMapping("/sending-email")
    public ResponseEntity<Email> sendingEmail(@RequestBody @Valid EmailDTO emailDTO) {
        Email email = new Email();
        BeanUtils.copyProperties(emailDTO, email);
        emailService.sendEmail(email);
        logger.trace("TRACE"); // level 1 with details
        logger.debug("DEBUG"); // level 2 with details
        logger.info("INFO"); // level 3 less details
        logger.warn("WARN"); // level 4 less details
        logger.error("ERROR"); // level 5 less details
        logger.fatal("FATAL"); // level 6 less details
        return ResponseEntity.status(HttpStatus.CREATED).body(email);
    }
}
