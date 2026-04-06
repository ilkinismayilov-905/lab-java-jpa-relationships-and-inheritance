package org.example.lab.repository;

import org.example.lab.entity.Guest;
import org.example.lab.enums.GuestStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    List<Guest> findByStatus(GuestStatus status);
}
