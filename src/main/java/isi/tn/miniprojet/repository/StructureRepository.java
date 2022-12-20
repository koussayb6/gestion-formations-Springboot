package isi.tn.miniprojet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isi.tn.miniprojet.entity.Structure;

@Repository
public interface StructureRepository extends JpaRepository<Structure, Long> {
	boolean existsById(Long IdStructure);

	boolean existsByLibelle(String libelle);

}
