package com.baufest.tennis.springtennis.model;

import org.json.JSONObject;

import javax.persistence.*;

@Entity
@Table (name = "Entrenador")
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) /* Valor Auto-generado con la estategia: GenerationType.IDENTITY */
    private Long id;
    @Column (nullable = false)
    private String nombre;

    //Constructores
    public Entrenador(String nombre) {
        this.nombre = nombre;
    }

    public Entrenador(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Entrenador() {
    }
    //Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JSONObject toJSONObject() {
        JSONObject jo = new JSONObject();
        jo.put("id",getId());
        jo.put("nombre",getNombre());
        return jo;
    }
}
