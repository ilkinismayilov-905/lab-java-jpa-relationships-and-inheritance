package org.example.lab.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.lab.enums.GuestStatus;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private GuestStatus status;

    @ManyToMany(mappedBy = "guests")
    private List<Event> events = new ArrayList<>();
}
