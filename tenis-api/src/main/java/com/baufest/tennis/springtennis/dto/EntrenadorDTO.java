package com.baufest.tennis.springtennis.dto;

import org.json.JSONObject;

public class EntrenadorDTO {
    private String nombre;
    private Long id;
    //Constructores
    public EntrenadorDTO(String nombre) {
        this.nombre = nombre;
    }

    public EntrenadorDTO(String nombre, Long id) {
        this.nombre = nombre;
        this.id = id;
    }

    public EntrenadorDTO() {
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
