package com.tcc.apitcc.servicios.serviciosimpl;

import com.tcc.apitcc.entidades.Mercancia;
import com.tcc.apitcc.entidades.Zona;
import com.tcc.apitcc.repositorios.ZonaRepositorio;
import com.tcc.apitcc.servicios.ServicioBase;
import com.tcc.apitcc.servicios.ZonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZonaServicioImpl implements ServicioBase<Zona> {

    @Autowired
    ZonaRepositorio zonaRepositorio;

    @Override
    public List<Zona> buscarTodos() throws Exception {
        try{

            List<Zona> zonas=zonaRepositorio.findAll();
            return zonas;

        }catch(Exception errorServicio){
            throw new Exception(errorServicio.getMessage());
        }
    }

    @Override
    public Zona buscarPorId(Integer id) throws Exception {
        try{

            Optional<Zona> zona=zonaRepositorio.findById(id);
            return zona.get();

        }catch(Exception errorServicio){
            throw new Exception(errorServicio.getMessage());
        }
    }

    @Override
    public Zona registrar(Zona entidad) throws Exception {
        try{

            entidad = zonaRepositorio.save(entidad);
            return entidad;

        }catch(Exception errorServicio){
            throw new Exception(errorServicio.getMessage());
        }
    }

    @Override
    public Zona actualizar(Integer id, Zona entidad) throws Exception {
        try{

            Optional<Zona> zonaBuscada=zonaRepositorio.findById(id);
            Zona zona=zonaBuscada.get();
            zona=zonaRepositorio.save(entidad);
            return zona;

        }catch(Exception errorServicio){
            throw new Exception(errorServicio.getMessage());
        }
    }

    @Override
    public boolean borrar(Integer id) throws Exception {
        try{

            if(zonaRepositorio.existsById(id)){
                zonaRepositorio.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }

        }catch(Exception errorServicio){
            throw new Exception(errorServicio.getMessage());
        }
    }
}
