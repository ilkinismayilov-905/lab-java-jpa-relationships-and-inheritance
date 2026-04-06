package org.example.lab.config;

import org.example.lab.entity.*;
import org.example.lab.repository.*;
import org.example.lab.enums.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final ContactRepository contactRepo;
    private final AssociationRepository assocRepo;
    private final EventRepository eventRepo;

    public DataLoader(ContactRepository contactRepo, AssociationRepository assocRepo, EventRepository eventRepo) {
        this.contactRepo = contactRepo;
        this.assocRepo = assocRepo;
        this.eventRepo = eventRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Contact> contacts = Arrays.asList(
                new Contact(null, "Tech Corp", "CEO", new Name("Mr.", "John", "D.", "Doe")),
                new Contact(null, "Health Plus", "Manager", new Name("Dr.", "Jane", null, "Smith")),
                new Contact(null, "Global Media", "PR Lead", new Name("Ms.", "Sarah", "Jane", "Parker"))
        );
        contactRepo.saveAll(contacts);

        Association assoc = new Association();
        assoc.setName("Nurse Association of Spain");

        for (int i = 1; i <= 7; i++) {
            Division div = new Division();
            div.setName("Division " + i);
            div.setDistrict("District " + (i % 3 == 0 ? "A" : "B"));

            Member pres = new Member(null, "President " + i, MemberStatus.ACTIVE, LocalDate.now());
            Member m1 = new Member(null, "Member " + i + "a", MemberStatus.ACTIVE, LocalDate.now().plusMonths(6));

            div.setPresident(pres);
            div.setMembers(Arrays.asList(pres, m1));
            assoc.getDivisions().add(div);
        }
        assocRepo.save(assoc);

        Guest g1 = new Guest(null, "Alice", GuestStatus.ATTENDING, new ArrayList<>());
        Guest g2 = new Guest(null, "Bob", GuestStatus.NO_RESPONSE, new ArrayList<>());
        Guest g3 = new Guest(null, "Charlie", GuestStatus.NOT_ATTENDING, new ArrayList<>());

        Speaker s1 = new Speaker(null, "Dr. Expert", 45);

        Conference conf = new Conference();
        conf.setTitle("Java Forward 2026");
        conf.setDate(LocalDate.now().plusDays(10));
        conf.setDuration(120);
        conf.setLocation("Convention Center");
        conf.setSpeakers(Arrays.asList(s1));
        conf.setGuests(Arrays.asList(g1, g2));

        Exhibition exh = new Exhibition();
        exh.setTitle("Art & Tech Expo");
        exh.setDate(LocalDate.now().plusDays(20));
        exh.setLocation("City Gallery");
        exh.setGuests(Arrays.asList(g1, g3));

        eventRepo.saveAll(Arrays.asList(conf, exh));

        System.out.println(">> All test data have been executed.");
    }
}