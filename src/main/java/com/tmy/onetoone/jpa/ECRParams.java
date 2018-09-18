package com.tmy.onetoone.jpa;

import lombok.Data;

import lombok.ToString;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "ecr_params")
public class ECRParams implements Serializable {

    @Column(name = "NAME")
    private String name;

    @Column(name = "ENABLED")
    private Long enabled;

    @Id
    @OneToOne
    @JoinColumn(name = "POI_ID", nullable = false)
    @MapsId
    @ToString.Exclude
    private Poi poi;
}
