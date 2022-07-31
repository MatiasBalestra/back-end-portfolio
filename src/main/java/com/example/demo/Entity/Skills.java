package com.example.demo.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "skills")
public class Skills {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idSkills;


    @Column
    private String nameSkill;
    @Column
    private Integer levelSkill;
    @Column
    private String logoSkill;

    public Skills() {
    }

    public Skills(String nameSkill, Integer levelSkill, String logoSkill) {
        this.nameSkill = nameSkill;
        this.levelSkill = levelSkill;
        this.logoSkill = logoSkill;
    }

    @ManyToOne (fetch = FetchType.LAZY)
    @JsonIgnore()
    @JoinColumn (name = "id_persona")
    private Persona persona;

}
