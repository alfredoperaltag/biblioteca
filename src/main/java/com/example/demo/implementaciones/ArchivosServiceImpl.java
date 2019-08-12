package com.example.demo.implementaciones;

import com.example.demo.entidades.Archivos;
import com.example.demo.repositorios.ArchivosRepository;
import com.example.demo.servicios.ArchivosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ArchivosService")
public class ArchivosServiceImpl implements ArchivosService {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public ArchivosRepository archivosRepository;

    @Override
    public boolean agregarArchivo(Archivos archivo){
        try{
            if (archivo != null){
                archivosRepository.save(archivo);
                log.info("se agrego el archivo: "+archivo.toString());
                return true;
            }else{
                log.warn("El archivo esta vacio");
                return false;
            }
        }catch (Exception ex){
            log.error("ERROR: "+ex.getMessage());
            return false;
        }
    }

    @Override
    public Archivos obtenerArchivo(int archivoID){
        try{
            if (archivoID > 0){
                log.info("Se consulto: ID: "+archivoID);
                return archivosRepository.findById(archivoID).get();
            }
            return null;
        }catch (Exception ex){
            log.error(ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean actualizarArchivo(Archivos archivo){
        try {
            if (archivo != null){
                archivosRepository.save(archivo);
                log.info(("se actualizo el archivo: "+archivo.toString()));
                return true;
            }else{
                log.warn("El archivo llega vacio");
                return false;
            }
        }catch (Exception ex){
            log.error("ERROR: "+ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean borrarArchivo(Archivos archivo){
        try {
            if (archivo != null){
                archivosRepository.delete(archivo);
                log.info("Se elimino el archivo");
                return true;
            }
            return false;
        }catch (Exception ex){
            return false;
        }
    }

    @Override
    public List<Archivos> listarArchivos(){
        try{
            return (List<Archivos>) archivosRepository.findAll();
        }catch (Exception ex){
            log.error(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Archivos> listarArchivosPorTipo(String tipo){
        try {
            if (tipo != null){
                log.info("Se recibio: "+tipo);
                return archivosRepository.listarArchivosPorTipo(tipo);
            }log.warn("Tipo de archivo vacio");
            return null;
        }catch (Exception ex){
            log.error(ex.getMessage());
            return null;
        }
    }

    @Override
    public int numeroArchivosPorTipo(String tipo){
        try {
            if (tipo != null){
                log.info("Se recibio: "+tipo);
                return archivosRepository.numeroArchivosPorTipo(tipo);
            }else {
                log.warn("Tipo de archivo vacio");
                return 0;
            }
        }catch (Exception ex){
            log.error(ex.getMessage());
            return 0;
        }
    }
}
