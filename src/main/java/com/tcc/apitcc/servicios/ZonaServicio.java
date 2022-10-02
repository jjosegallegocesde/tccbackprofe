package com.tcc.apitcc.servicios;

import com.tcc.apitcc.entidades.Zona;

import java.util.Optional;

public interface ZonaServicio {

    public Iterable<Zona> buscarZonas();

    public Optional<Zona> buscarZonaPorId(Integer id);

    public Zona guardarZona(Zona zona);

    public void eliminarZonaPorId(Integer id);

}
