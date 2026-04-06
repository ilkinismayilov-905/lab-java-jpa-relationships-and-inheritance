package org.example.lab.repository;

import org.example.lab.entity.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
}
