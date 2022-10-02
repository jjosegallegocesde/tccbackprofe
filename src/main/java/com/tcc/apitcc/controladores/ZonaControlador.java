package com.tcc.apitcc.controladores;

import com.tcc.apitcc.entidades.Mercancia;
import com.tcc.apitcc.entidades.Zona;
import com.tcc.apitcc.servicios.serviciosimpl.MercanciaServicioImpl;
import com.tcc.apitcc.servicios.serviciosimpl.ZonaServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/tcc/zonas")
public class ZonaControlador {

    @Autowired
    ZonaServicioImpl zonaServicio;

    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody Zona zona){
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(zonaServicio.registrar(zona));
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Error. Por favor revise: "+error+"\"}");
        }
    }

    @GetMapping
    public ResponseEntity<?> buscarTodos(){

        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(zonaServicio.buscarTodos());

        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error. Por favor revise\"}");

        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarZona(@PathVariable Integer id){

        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(zonaServicio.buscarPorId(id));

        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error. Por favor revise\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarMercancia(@PathVariable Integer id, @RequestBody Zona zona){

        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(zonaServicio.actualizar(id,zona));
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Error. Por favor revise: "+error+"\"}");
        }

    }



}
