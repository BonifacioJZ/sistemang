package com.bonifacio.juarez.sistemang.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "patients")
public class Patient  extends Person{
    @ManyToMany(targetEntity = Familiar.class,
                cascade = {
                        CascadeType.PERSIST,
                        CascadeType.MERGE
                },
                fetch = FetchType.LAZY)
    @JoinTable(name = "patient_familiar",
            joinColumns = {@JoinColumn(name = "fk_patient")},
            inverseJoinColumns = {@JoinColumn(name = "fk_familiar")}
    )
    @JsonIgnore
    private Set<Familiar> familiars;


    public Patient(String name, String lastName, String phone, String email, String colony, String city, Date birthday, String address, String curp) {
        super(name, lastName, phone, email, colony, city, birthday, address, curp);
    }

    public Set<Familiar> getFamiliars() {
        return familiars;
    }

    public void setFamiliars(Set<Familiar> familiars) {
        this.familiars = familiars;
    }
}
