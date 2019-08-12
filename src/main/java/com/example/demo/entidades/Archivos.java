package com.example.demo.entidades;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name = "Archivos")
public class Archivos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @NotNull
    @Size(min = 2,max = 40)
    @Column(length = 40,nullable = false)
    private String Tipo;

    @NotNull
    @Size(min = 2,max = 80)
    @Column(length = 80,nullable = false)
    private String Extenciones;

    @NotNull
    @Size(min = 2,max = 40)
    @Column(length = 40,nullable = false)
    private String Compartir;

    @NotNull
    @Size(min = 2,max = 120)
    @Column(length = 120,nullable = false)
    private String Titulo;

    @NotNull
    @Size(min = 2,max = 80)
    @Column(length = 80,nullable = false)
    private String Area;

    @NotNull
    @Size(min = 2,max = 120)
    @Column(length = 120,nullable = false)
    private String Autor;

    @NotNull
    @Column(columnDefinition = "TEXT", nullable = false)
    private String Etiqueta;

    @NotNull
    @Column(nullable = false)
    private Date Anio;

    @NotNull
    @Size(min = 2,max = 40)
    @Column(length = 40,nullable = false)
    private String Edicion;

    @Column(columnDefinition = "TEXT")
    private String Descripcion;

    @Column(nullable = true)
    private byte[] Portada;

    @Column(nullable = true)
    private byte[] Contraportada;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getExtenciones() {
        return Extenciones;
    }

    public void setExtenciones(String extenciones) {
        Extenciones = extenciones;
    }

    public String getCompartir() {
        return Compartir;
    }

    public void setCompartir(String compartir) {
        Compartir = compartir;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public String getEtiqueta() {
        return Etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        Etiqueta = etiqueta;
    }

    public Date getAnio() {
        return Anio;
    }

    public void setAnio(Date anio) {
        Anio = anio;
    }

    public String getEdicion() {
        return Edicion;
    }

    public void setEdicion(String edicion) {
        Edicion = edicion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public byte[] getPortada() {
        return Portada;
    }

    public void setPortada(byte[] portada) {
        Portada = portada;
    }

    public byte[] getContraportada() {
        return Contraportada;
    }

    public void setContraportada(byte[] contraportada) {
        Contraportada = contraportada;
    }

    public Archivos() {
    }

    public Archivos(int id, @NotNull @Size(min = 2, max = 40) String tipo, @NotNull @Size(min = 2, max = 80) String extenciones, @NotNull @Size(min = 2, max = 40) String compartir, @NotNull @Size(min = 2, max = 120) String titulo, @NotNull @Size(min = 2, max = 80) String area, @NotNull @Size(min = 2, max = 120) String autor, @NotNull String etiqueta, @NotNull Date anio, @NotNull @Size(min = 2, max = 40) String edicion, String descripcion, byte[] portada, byte[] contraportada) {
        this.Id = id;
        Tipo = tipo;
        Extenciones = extenciones;
        Compartir = compartir;
        Titulo = titulo;
        Area = area;
        Autor = autor;
        Etiqueta = etiqueta;
        Anio = anio;
        Edicion = edicion;
        Descripcion = descripcion;
        Portada = portada;
        Contraportada = contraportada;
    }

    public Archivos(@NotNull @Size(min = 2, max = 40) String tipo, @NotNull @Size(min = 2, max = 80) String extenciones, @NotNull @Size(min = 2, max = 40) String compartir, @NotNull @Size(min = 2, max = 120) String titulo, @NotNull @Size(min = 2, max = 80) String area, @NotNull @Size(min = 2, max = 120) String autor, @NotNull String etiqueta, @NotNull Date anio, @NotNull @Size(min = 2, max = 40) String edicion, String descripcion, byte[] portada, byte[] contraportada) {
        Tipo = tipo;
        Extenciones = extenciones;
        Compartir = compartir;
        Titulo = titulo;
        Area = area;
        Autor = autor;
        Etiqueta = etiqueta;
        Anio = anio;
        Edicion = edicion;
        Descripcion = descripcion;
        Portada = portada;
        Contraportada = contraportada;
    }

    public Archivos(@NotNull @Size(min = 2, max = 40) String tipo, @NotNull @Size(min = 2, max = 80) String extenciones, @NotNull @Size(min = 2, max = 40) String compartir, @NotNull @Size(min = 2, max = 120) String titulo, @NotNull @Size(min = 2, max = 80) String area, @NotNull @Size(min = 2, max = 120) String autor, @NotNull String etiqueta, @NotNull Date anio, @NotNull @Size(min = 2, max = 40) String edicion, String descripcion) {
        Tipo = tipo;
        Extenciones = extenciones;
        Compartir = compartir;
        Titulo = titulo;
        Area = area;
        Autor = autor;
        Etiqueta = etiqueta;
        Anio = anio;
        Edicion = edicion;
        Descripcion = descripcion;
    }

    public Archivos(int id, @NotNull @Size(min = 2, max = 40) String tipo, @NotNull @Size(min = 2, max = 80) String extenciones, @NotNull @Size(min = 2, max = 40) String compartir, @NotNull @Size(min = 2, max = 120) String titulo, @NotNull @Size(min = 2, max = 80) String area, @NotNull @Size(min = 2, max = 120) String autor, @NotNull String etiqueta, @NotNull Date anio, @NotNull @Size(min = 2, max = 40) String edicion, String descripcion) {
        this.Id = id;
        Tipo = tipo;
        Extenciones = extenciones;
        Compartir = compartir;
        Titulo = titulo;
        Area = area;
        Autor = autor;
        Etiqueta = etiqueta;
        Anio = anio;
        Edicion = edicion;
        Descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Archivos{" +
                "Id=" + Id +
                ", Tipo='" + Tipo + '\'' +
                ", Extenciones='" + Extenciones + '\'' +
                ", Compartir='" + Compartir + '\'' +
                ", Titulo='" + Titulo + '\'' +
                ", Area='" + Area + '\'' +
                ", Autor='" + Autor + '\'' +
                ", Etiqueta='" + Etiqueta + '\'' +
                ", Anio=" + Anio +
                ", Edicion='" + Edicion + '\'' +
                ", Descripcion='" + Descripcion + '\'' +
                ", Portada=" + Arrays.toString(Portada) +
                ", Contraportada=" + Arrays.toString(Contraportada) +
                '}';
    }
}
