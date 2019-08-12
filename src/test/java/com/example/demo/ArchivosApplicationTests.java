package com.example.demo;

import com.example.demo.entidades.Archivos;
import com.example.demo.servicios.ArchivosService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArchivosApplicationTests {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    @Qualifier("ArchivosService")
    private ArchivosService service;

    @Test
    public void agregarArchivo() {
        try{
            Archivos archivo = new Archivos("Audio", ".MP3, .AC3", "TODOS", "conflictos de la segunda guerra mundial", "Historia", "David Peralta", "historia, guerra", Date.valueOf("2018-07-10"), "segunda", "prueba");
            if (service.agregarArchivo(archivo)){
                log.info("se agrego el archivo correctamente");
            }else{
                log.warn("no fue posible agregar el archivo");
            }
        }catch (Exception ex){
            log.error(ex.getMessage());
        }
    }

    @Test
    public void obtenerArchivo(){
        try {
            Archivos archivo = service.obtenerArchivo(0);
            if (archivo != null){
                log.info("Se obtuvo el archivo: \n"+archivo.toString());
            }else {
                log.warn("no se encontro el archivo");
            }
        }catch (Exception ex){
            log.error(ex.getMessage());
        }
    }

    @Test
    public void actualizarArchivo(){
        try {
            if (service.obtenerArchivo(3) != null){
                Archivos archivo = new Archivos(3,"Imagen", ".MP3, .AC3", "TODOS", "Conflictos de la primer guerra mundial", "Historia", "Alfredo Peralta", "historia, guerra", Date.valueOf("2018-07-10"), "segunda", "prueba");
                service.actualizarArchivo(archivo);
                log.info("se actualizo el archivo");
            }else{
                log.warn("No se encontro el archivo");
            }
        }catch (Exception ex){
            log.error(ex.getMessage());
        }
    }

    @Test
    public void borrarArchivo(){
        Archivos archivo = service.obtenerArchivo(2);
        try{
            if (archivo != null){
                if (service.borrarArchivo(archivo)){
                    log.info("se elimino el archivo");
                }else {
                    log.warn("no se elimino el archivo");
                }
            }else{
                log.warn("no se encontro el archivo");
            }
        }catch (Exception ex){
            log.error(ex.getMessage());
        }
    }

    @Test
    public void listarArchivos(){
        try {
            List<Archivos> archivo = service.listarArchivos();
            if (archivo != null){
                for (Archivos archivos : archivo){
                    log.info(archivos.toString());
                }
            }else {
                log.warn("No se pudieron listar los archivos");
            }
        }catch (Exception ex){
            log.error("No se encontro la lista "+ex.getMessage());
        }
    }

    @Test
    public void listarArchivosPorTipo(){
        try {
            List<Archivos> archivo = service.listarArchivosPorTipo("audio");
            if (archivo != null){
                for (Archivos archivos : archivo){
                    log.info(archivos.toString());
                }
            }else {
                log.warn("No se encontraron resultados");
            }
        }catch (Exception ex){
            log.error(ex.getMessage());
        }
    }

    @Test
    public void numeroArchivosPorTipo(){
        try {
            int numero = service.numeroArchivosPorTipo("Imagen");
            if (numero != 0){
                log.info("Numero de archivos: "+numero);
            }else {
                log.warn("Aun no tiene archivos registrados");
            }
        }catch (Exception ex){
            log.error(ex.getMessage());
        }
    }
}
