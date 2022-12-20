package isi.tn.miniprojet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isi.tn.miniprojet.entity.Trainer;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long>{
	
	boolean existsByEmail(String email);

}
