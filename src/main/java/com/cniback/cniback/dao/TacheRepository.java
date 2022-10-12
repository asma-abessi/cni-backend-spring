package com.cniback.cniback.dao;




import com.cniback.cniback.modele.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.formalab.ecommerce.dao")
public interface TacheRepository extends JpaRepository<Tache,Integer> {
}
