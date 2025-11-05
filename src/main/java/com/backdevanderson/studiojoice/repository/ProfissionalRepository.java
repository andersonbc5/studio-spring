package com.backdevanderson.studiojoice.repository;


import com.backdevanderson.studiojoice.entity.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {

    Optional<Profissional> findByNome(String nome);

    Optional<Profissional> findByEspecialidade(String especialidade);
}
