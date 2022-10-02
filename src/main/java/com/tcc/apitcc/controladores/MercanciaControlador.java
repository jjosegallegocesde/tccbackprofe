package com.tcc.apitcc.controladores;


import com.tcc.apitcc.entidades.Mercancia;
import com.tcc.apitcc.servicios.MercanciaServicio;
import com.tcc.apitcc.servicios.serviciosimpl.MercanciaServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("api/tcc/mercancias")
public class MercanciaControlador {

    @Autowired
    MercanciaServicioImpl mercanciaServicio;

    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody Mercancia mercancia){
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(mercanciaServicio.registrar(mercancia));
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
                    .body(mercanciaServicio.buscarTodos());

        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error. Por favor revise\"}");

        }

    }

    @GetMapping("/{iup}")
    public ResponseEntity<?> buscarMercancia(@PathVariable Integer iup){

        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(mercanciaServicio.buscarPorId(iup));

        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error. Por favor revise\"}");
        }
    }

    @PutMapping("/{iup}")
    public ResponseEntity<?> actualizarMercancia(@PathVariable Integer id, @RequestBody Mercancia mercancia){

        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(mercanciaServicio.actualizar(id,mercancia));
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Error. Por favor revise: "+error+"\"}");
        }

    }

    @DeleteMapping("/{iup}")
    public ResponseEntity<?> eliminarMercancia(@PathVariable Integer id){

        try{
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body(mercanciaServicio.borrar(id));
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Error. Por favor revise: "+error+"\"}");
        }

    }





}
