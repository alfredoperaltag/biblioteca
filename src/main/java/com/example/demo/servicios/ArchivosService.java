package com.example.demo.servicios;

import com.example.demo.entidades.Archivos;

import java.util.List;

public interface ArchivosService {
    public boolean agregarArchivo(Archivos archivo);
    public Archivos obtenerArchivo(int archivoId);
    public boolean actualizarArchivo(Archivos archivo);
    public boolean borrarArchivo(Archivos archivo);
    public List<Archivos> listarArchivos();
    public List<Archivos> listarArchivosPorTipo(String tipo);
    public int numeroArchivosPorTipo(String tipo);
}
