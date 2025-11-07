package com.backdevanderson.studiojoice.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "tb_clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @Pattern(regexp = "\\d{11}", message = "O CPF deve conter 11 digitos")
    @Column(unique = true, nullable = false, length = 11)
    private String cpf;

    @Email
    private String email;

    @NotBlank
    private String telefone;


    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Agendamento> agendamentos;
}
