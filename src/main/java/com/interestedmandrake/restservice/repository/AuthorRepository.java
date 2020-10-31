package com.interestedmandrake.restservice.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.interestedmandrake.restservice.dto.AuthorDTO;
import com.interestedmandrake.restservice.entity.AuthorEntity;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer>{
	
	List<AuthorEntity> findAll();
	AuthorEntity save(AuthorEntity authorEntity);
	Optional<AuthorEntity> findById(Integer id);
}
