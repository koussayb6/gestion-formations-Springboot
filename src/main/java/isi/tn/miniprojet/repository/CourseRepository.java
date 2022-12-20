package isi.tn.miniprojet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isi.tn.miniprojet.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
