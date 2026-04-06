package org.example.lab.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Conference extends Event {
    @OneToMany(cascade = CascadeType.ALL)
    private List<Speaker> speakers = new ArrayList<>();
}