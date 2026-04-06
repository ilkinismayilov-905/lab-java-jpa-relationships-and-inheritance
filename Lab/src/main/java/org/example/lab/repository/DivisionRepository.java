package org.example.lab.repository;

import org.example.lab.entity.Division;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DivisionRepository extends JpaRepository<Division, Long> {
    List<Division> findByDistrict(String district); // Opsiyonel sorgu
}
