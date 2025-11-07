package com.backdevanderson.studiojoice.repository;

import com.backdevanderson.studiojoice.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    List<Agendamento> findByDataHoraBetween(LocalDateTime inicio, LocalDateTime fim);

    boolean existsByProfissionalIdAndDataHora(Long profissionalId, LocalDateTime dataHora );
}
