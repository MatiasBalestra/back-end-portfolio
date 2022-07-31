package com.example.demo.Entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idPersona;

    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String email;
    @Column
    private String profession;
    @Column
    private String localization;
    @Column
    private String twitter;
    @Column
    private String instagram;
    @Column
    private String linkedin;
    @Column
    private String github;
    @Column
    private String telefono;
    @Column
    private String fecha_nac;
    @Column
    private String url_photo;
    @Column
    private String url_banner;
    @Column
    private String about_me;


    public Persona() {
    }

    public Persona(Long idPersona, String name, String surname, String email, String profession, String localization, String twitter, String instagram, String linkedin, String github, String telefono, String fecha_nac, String url_photo, String url_banner, String about_me) {
        this.idPersona = idPersona;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.profession = profession;
        this.localization = localization;
        this.twitter = twitter;
        this.instagram = instagram;
        this.linkedin = linkedin;
        this.github = github;
        this.telefono = telefono;
        this.fecha_nac = fecha_nac;
        this.url_photo = url_photo;
        this.url_banner = url_banner;
        this.about_me = about_me;
    }


    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn (name = "id_persona")
    private List<Skills> Skills=new ArrayList<>();

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn (name = "id_persona")
    private List<Education> Education=new ArrayList<>();

    /**RELACION CON TABLA EXPERIENCE**/

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="id_persona")
    private List<Experience> experiences = new ArrayList<>();

    /**RELACION CON TABLA PROJECT**/

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="id_persona")
    private List<Project> projects = new ArrayList<>();
}
