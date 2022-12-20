package isi.tn.miniprojet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isi.tn.miniprojet.entity.Profil;

@Repository
public interface ProfilRepository extends JpaRepository<Profil, Long> {
	boolean existsById(Long IdProfil);

	boolean existsByLibelle(String libelle);

}
