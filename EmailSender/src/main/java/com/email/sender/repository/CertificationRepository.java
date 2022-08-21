package com.email.sender.repository;

import com.email.sender.entity.Certification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CertificationRepository extends CrudRepository<Certification, String> {

    Optional<Certification> findByEmail(String email);

}
