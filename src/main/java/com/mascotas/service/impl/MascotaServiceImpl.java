package com.mascotas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mascotas.dto.MascotaRequest;
import com.mascotas.dto.MascotaResponds;
import com.mascotas.mapper.MascotaMapper;
import com.mascotas.models.Mascota;
import com.mascotas.models.TipoMascota;
import com.mascotas.repository.MascotaRepository;
import com.mascotas.repository.TipoMascotaRepository;
import com.mascotas.service.IMascotaService;

@Service
public class MascotaServiceImpl implements IMascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private TipoMascotaRepository tipoMascotaRepository;

    @Override
    public List<MascotaResponds> findAll() {
        return mascotaRepository.findAll().stream()
                .map(MascotaMapper::entityToDto).toList();
    }

    @Override
    public MascotaResponds findById(Long id) {
        return MascotaMapper.entityToDto(mascotaRepository.findById(id).orElseThrow());
    }

    @Override
    public MascotaResponds create(MascotaRequest mascotaRequest) {
        TipoMascota tipoMascota = tipoMascotaRepository.findById(mascotaRequest.tipoMascotaId()).orElseThrow();
        Mascota mascota = Mascota.builder()
                .nombre(mascotaRequest.nombre())
                .edad(mascotaRequest.edad())
                .raza(mascotaRequest.raza())
                .tipoMascota(tipoMascota)
                .build();
        Mascota mascotaSave = mascotaRepository.save(mascota);
        return MascotaMapper.entityToDto(mascotaSave);
    }

    @Override
    public void update(MascotaRequest mascotaRequest, Long id) {
        Mascota mascotaFound = mascotaRepository.findById(id).orElseThrow();
        TipoMascota tipoMascota = tipoMascotaRepository.findById(mascotaRequest.tipoMascotaId()).orElseThrow();
        mascotaFound.setNombre(mascotaRequest.nombre());
        mascotaFound.setRaza(mascotaRequest.raza());
        mascotaFound.setEdad(mascotaRequest.edad());
        mascotaFound.setTipoMascota(tipoMascota);
        mascotaRepository.save(mascotaFound);
    }

    @Override
    public void delete(Long id) {
        mascotaRepository.deleteById(id);
    }

}
