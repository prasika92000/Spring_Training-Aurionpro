package com.aurionpro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.entity.ImageData;

public interface StorageRepository extends JpaRepository<ImageData,Long>{

	Optional<ImageData> findByName(String filename);  //find image by its name 
}
