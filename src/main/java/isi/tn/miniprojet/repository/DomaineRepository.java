package isi.tn.miniprojet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isi.tn.miniprojet.entity.Domaine;

@Repository
public interface DomaineRepository extends JpaRepository<Domaine, Long> {

    boolean existsByLibelle(String libelle);
}
