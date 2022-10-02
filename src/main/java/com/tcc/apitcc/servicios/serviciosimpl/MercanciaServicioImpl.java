package com.tcc.apitcc.servicios.serviciosimpl;


import com.tcc.apitcc.entidades.Mercancia;
import com.tcc.apitcc.repositorios.MercanciaRepositorio;
import com.tcc.apitcc.servicios.ServicioBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class MercanciaServicioImpl implements ServicioBase<Mercancia> {

    @Autowired
    private MercanciaRepositorio mercanciaRepositorio;

    @Override
    @Transactional(readOnly = true)
    public List<Mercancia> buscarTodos() throws Exception {
        try{

            List<Mercancia> mercancias=mercanciaRepositorio.findAll();
            return mercancias;

        }catch(Exception errorServicio){
            throw new Exception(errorServicio.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Mercancia buscarPorId(Integer id) throws Exception {
        try{

            Optional<Mercancia> mercancia=mercanciaRepositorio.findById(id);
            return mercancia.get();

        }catch(Exception errorServicio){
            throw new Exception(errorServicio.getMessage());
        }
    }

    @Override
    @Transactional
    public Mercancia registrar(Mercancia entidad) throws Exception {
        try{

           entidad = mercanciaRepositorio.save(entidad);
           return entidad;

        }catch(Exception errorServicio){
            throw new Exception(errorServicio.getMessage());
        }
    }

    @Override
    @Transactional
    public Mercancia actualizar(Integer id, Mercancia entidad) throws Exception {
        try{

            Optional<Mercancia> mercanciaBuscada=mercanciaRepositorio.findById(id);
            Mercancia mercancia=mercanciaBuscada.get();
            mercancia=mercanciaRepositorio.save(entidad);
            return mercancia;

        }catch(Exception errorServicio){
            throw new Exception(errorServicio.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean borrar(Integer id) throws Exception {
        try{

            if(mercanciaRepositorio.existsById(id)){
                mercanciaRepositorio.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }

        }catch(Exception errorServicio){
            throw new Exception(errorServicio.getMessage());
        }
    }
}
