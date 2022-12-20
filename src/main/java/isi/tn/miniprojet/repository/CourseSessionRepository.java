package isi.tn.miniprojet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isi.tn.miniprojet.entity.CourseSession;

@Repository
public interface CourseSessionRepository extends JpaRepository<CourseSession, Long> {

}
