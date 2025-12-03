package main.java.mx.uv.listi.SaludarDatos;

import javax.annotation.processing.Generated;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Saludadores {
    @Id
    @GeneratedValue(strategy)
    private integer id;
    private String nombre;
}
