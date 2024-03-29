package com.example.demo.controladores;

import com.example.demo.entidades.Archivos;
import com.example.demo.servicios.ArchivosService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/")
public class ArchivosController {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    private ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES,false);

    @Autowired
    @Qualifier("ArchivosService")
    private ArchivosService archivosService;

    @RequestMapping(path ="archivos",method = RequestMethod.POST)
    public @ResponseBody boolean registrarArchivo(@RequestBody String archivoJSON){
        try{
            Archivos archivo = new Archivos();

            archivo = mapper.readValue(archivoJSON, Archivos.class);
            log.info("Se recibio del formulario: \n"+archivo.toString());

            if (archivosService.agregarArchivo(archivo)){
                log.info("Se agrego el archivo correctamente");
                return true;
            }
            return false;
        }catch (Exception ex){
            log.error("ERROR: "+ex.getMessage());
            return false;
        }
    }

    @RequestMapping(path="archivos",method = RequestMethod.PUT)
    public @ResponseBody boolean actualizarArchivo(@RequestBody String archivoJSON){
        try{
            Archivos archivo = new Archivos();
            archivo = mapper.readValue(archivoJSON, Archivos.class);
            log.info("Se recibio del formulario: \n"+archivo.toString());
            if (archivosService.actualizarArchivo(archivo)){
                log.info("Se actualizo el archivo correctamente");
                return true;
            }
            return false;
        }catch (Exception ex){
            log.error("ERROR: "+ex.getMessage());
            return false;
        }
    }

    @RequestMapping(path = "archivos/{tipo}", method = RequestMethod.GET)
    //public @ResponseBody int CantidadDeArchivos(@PathVariable("tipo")String tipoArchivo){
    public @ResponseBody
    List<Archivos> listarArchivosPorTipo(@PathVariable("tipo")String tipoArchivo){
        try{
            if (tipoArchivo != null){
                log.info("Se recibe en controller: "+tipoArchivo);
                //return archivosService.numeroArchivosPorTipo(tipoArchivo);
                return archivosService.listarArchivosPorTipo(tipoArchivo);
            }
            log.warn("El tipo de archivo llega vacio");
            //return 0;
            return null;
        }catch (Exception ex){
            log.error("ERROR: "+ex.getMessage());
            //return 0;
            return null;
        }
    }

    @RequestMapping(path = "archivos",method = RequestMethod.DELETE)
    public @ResponseBody boolean borrarArchivo(@RequestBody String archivoJSON){
        try {
            if (archivoJSON!=null){
                Archivos archivo = mapper.readValue(archivoJSON, Archivos.class);
                return archivosService.borrarArchivo(archivo);
            }
            log.warn("El archivo llega vacio");
            return false;
        }catch (Exception ex){
            log.error(ex.getMessage());
            return false;
        }
    }
}
