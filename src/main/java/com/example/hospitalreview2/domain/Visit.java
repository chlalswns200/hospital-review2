package com.example.hospitalreview2.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Visit extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    private LocalDate localDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String disease;

    private float amount;
}