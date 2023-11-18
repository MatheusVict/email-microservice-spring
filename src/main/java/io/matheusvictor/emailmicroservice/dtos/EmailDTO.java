package io.matheusvictor.emailmicroservice.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmailDTO {
    @NotBlank
    private String ownerRef;

    @Email
    private String emailTo;

    @Email
    private String emailFrom;

    @NotBlank
    private String subject;

    @NotBlank
    private String text;
}
