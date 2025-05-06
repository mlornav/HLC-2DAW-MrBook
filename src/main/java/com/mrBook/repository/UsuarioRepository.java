package com.mrBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrBook.entity.Admin;

@Repository
public interface UsuarioRepository extends JpaRepository<Admin, Integer>{

}
