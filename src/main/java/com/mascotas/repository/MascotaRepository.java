package com.mascotas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mascotas.models.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota,Long>{

}
