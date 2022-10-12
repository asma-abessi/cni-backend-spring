package com.cniback.cniback.dao;


import com.cniback.cniback.modele.Pointage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.cniback.cniback.dao")
public interface PointageRepository extends JpaRepository<Pointage,Integer> {
}
