package com.mrBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrBook.entity.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer>{

}
