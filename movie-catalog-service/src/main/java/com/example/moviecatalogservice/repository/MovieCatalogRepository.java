package com.example.moviecatalogservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.moviecatalogservice.model.Catalog;

@Repository
public interface MovieCatalogRepository extends JpaRepository<Catalog, Integer> {

}
