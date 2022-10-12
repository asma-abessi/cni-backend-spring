package com.cniback.cniback.dao;



import  com.cniback.cniback.modele.Avance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(" com.cniback.cniback.dao")
public interface AvanceRepository extends JpaRepository<Avance,Integer> {
}
