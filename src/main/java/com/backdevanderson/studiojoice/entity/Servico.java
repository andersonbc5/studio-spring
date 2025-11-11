package com.backdevanderson.studiojoice.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Setter
@Entity
@Table(name = "tb_servico")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;
    @NotNull
    private Double preco;

    @Column(name = "tempo_duracao")
    @NotNull(message = "Tempo de duração é obrigatório")
    private Integer tempoDuracao;

    @OneToMany(mappedBy = "servico")
    @JsonIgnore
    private List<Agendamento> agendamentos;
}
