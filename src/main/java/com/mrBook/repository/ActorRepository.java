package com.mrBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrBook.entity.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer>{

}
