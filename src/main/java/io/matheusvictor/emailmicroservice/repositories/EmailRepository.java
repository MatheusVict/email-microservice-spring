package io.matheusvictor.emailmicroservice.repositories;

import io.matheusvictor.emailmicroservice.domain.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
}
