package io.matheusvictor.emailmicroservice.repositories;

import io.matheusvictor.emailmicroservice.domain.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmailRepository extends JpaRepository<Email, UUID> {
}
