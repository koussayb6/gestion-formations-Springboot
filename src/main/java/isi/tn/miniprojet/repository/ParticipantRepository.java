package isi.tn.miniprojet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isi.tn.miniprojet.entity.Participant;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
	boolean existsByEmail(String email);

}
