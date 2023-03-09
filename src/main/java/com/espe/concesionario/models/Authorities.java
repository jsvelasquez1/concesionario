package com.espe.concesionario.models;

import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "AUTHORITIES")
public class Authorities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    @Column(unique = true)
    private String authority;
}
