package com.example.demo.repositorios;

import com.example.demo.entidades.Archivos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("ArchivosRepository")
public interface ArchivosRepository extends CrudRepository<Archivos, Serializable> {
    @Query(value = "SELECT * FROM archivos WHERE Tipo = :tipo", nativeQuery = true)
    public List<Archivos> listarArchivosPorTipo(@Param("tipo") String tipo);

    @Query(value = "SELECT COUNT(Tipo) FROM archivos WHERE Tipo = :tipo", nativeQuery = true)
    public int numeroArchivosPorTipo(@Param("tipo") String tipo);
}
