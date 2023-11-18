package io.matheusvictor.emailmicroservice.consumers;

import io.matheusvictor.emailmicroservice.domain.Email;
import io.matheusvictor.emailmicroservice.dtos.EmailDTO;
import io.matheusvictor.emailmicroservice.services.EmailService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Log4j2
public class EmailConsumer {
    private EmailService emailService;

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listen(@Payload EmailDTO emailDTO) {
        Email email = new Email();
        BeanUtils.copyProperties(emailDTO, email);
        emailService.sendEmail(email);
        log.info("Email status: " + email.getStatusEmail().toString());
    }
}
