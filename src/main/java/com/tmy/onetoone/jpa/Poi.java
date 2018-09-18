package com.tmy.onetoone.jpa;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "poi")
public class Poi implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ENABLED")
    private Long enabled;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "poi", fetch = FetchType.EAGER)
    private ECRParams ecrParams;

    //This is to force the ECR_Params to have the POI_ID or we can use constructor in ECR_PARAMS
    public void setEcrParams(ECRParams ecrParams) {
        this.ecrParams = ecrParams;
        this.ecrParams.setPoi(this);
    }
}
