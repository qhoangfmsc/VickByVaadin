package com.athenaweb.backend.repository;

import com.athenaweb.backend.entity.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultantRepository extends JpaRepository <Consultant, Long> {
}
