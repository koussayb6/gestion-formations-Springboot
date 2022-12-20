package isi.tn.miniprojet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isi.tn.miniprojet.entity.Pays;

@Repository
public interface PaysRepository extends JpaRepository<Pays, Long> {
	boolean existsByLibelle(String libelle);

}
