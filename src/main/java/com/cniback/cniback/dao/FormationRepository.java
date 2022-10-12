package com.cniback.cniback.dao;



import com.cniback.cniback.modele.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.cniback.cniback.dao")
public interface FormationRepository extends JpaRepository<Formation,Integer> {
}
