package isi.tn.miniprojet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isi.tn.miniprojet.entity.Course;
import isi.tn.miniprojet.entity.Domaine;
import isi.tn.miniprojet.repository.CourseRepository;
import isi.tn.miniprojet.repository.DomaineRepository;
import isi.tn.miniprojet.response.MessageResponse;

@Service
public class CourseServiceImpl implements ICourseService {

	@Autowired
	CourseRepository courseRepository;
	@Autowired
	DomaineRepository domaineRepository;

	@Transactional
	@Override
	public MessageResponse<Course> save(Course course, Long IdDomaine) {

		Domaine domaine = domaineRepository.findById(IdDomaine).orElse(null);
		course.setDomaine(domaine);
		return new MessageResponse<Course>(true, "Succès", "Formation ajouté avec succès.",
				courseRepository.save(course));
	}

	@Transactional
	@Override
	public MessageResponse<Course> update(Course course, Long IdDomaine) {
		boolean existe = courseRepository.existsById(course.getIdCourse());
		if (!existe) {
			return new MessageResponse<Course>(false, "Echec !", "Opération non réalisée !", null);

		}
		Domaine domaine = domaineRepository.findById(IdDomaine).orElse(null);
		course.setDomaine(domaine);
		return new MessageResponse<Course>(true, "Succès", "Formation ajouté avec succès.",
				courseRepository.save(course));
	}

	@Transactional
	@Override
	public MessageResponse<Course> delete(Long id) {
		Course course = findById(id);
		if (course == null) {
			return new MessageResponse<Course>(false, "Echec", "Cet utilisateur n'existe pas !", null);
		}
		courseRepository.delete(course);
		return new MessageResponse<Course>(true, "Succès", "L'utilisateur a été supprimé avec succès.", null);
	}

	@Override
	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	@Override
	public Course findById(Long id) {
		Course course = courseRepository.findById(id).orElse(null);
		return course;
	}

}
