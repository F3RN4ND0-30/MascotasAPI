package com.mascotas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mascotas.dto.TipoMascotaRequest;
import com.mascotas.dto.TipoMascotaResponds;
import com.mascotas.mapper.TipoMascotaMapper;
import com.mascotas.models.TipoMascota;
import com.mascotas.repository.TipoMascotaRepository;
import com.mascotas.service.ITipoMascotaService;

@Service
public class TipoMascotaServiceImpl implements ITipoMascotaService {

    @Autowired
    private TipoMascotaRepository tipoMascotaRepository;

    @Override
    public List<TipoMascotaResponds> findAll() {
        return tipoMascotaRepository.findAll().stream()
                .map(TipoMascotaMapper::entityToDto).toList();
    }

    @Override
    public TipoMascotaResponds findById(Long id) {
        return TipoMascotaMapper.entityToDto(tipoMascotaRepository.findById(id).orElseThrow());
    }

    @Override
    public TipoMascotaResponds create(TipoMascotaRequest tipoMascotaRequest) {
        TipoMascota tipoMascota = TipoMascota.builder()
                .nombre(tipoMascotaRequest.nombre()).build();
        TipoMascota mascota = tipoMascotaRepository.save(tipoMascota);
        return TipoMascotaMapper.entityToDto(mascota);
    }

    @Override
    public void update(TipoMascotaRequest tipoMascotaRequest, Long id) {
        TipoMascota tipomascotaFound = tipoMascotaRepository.findById(id).orElseThrow();
        tipomascotaFound.setNombre(tipoMascotaRequest.nombre());
        tipoMascotaRepository.save(tipomascotaFound);
    }

    @Override
    public void delete(Long id) {
        tipoMascotaRepository.deleteById(id);
    }

}
