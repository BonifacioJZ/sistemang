package com.bonifacio.juarez.sistemang.repositories;

import com.bonifacio.juarez.sistemang.entities.Familiar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface FamiliarRepository extends JpaRepository<Familiar, UUID> {
}
