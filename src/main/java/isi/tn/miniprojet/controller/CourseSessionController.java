package isi.tn.miniprojet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import isi.tn.miniprojet.entity.CourseSession;
import isi.tn.miniprojet.response.MessageResponse;
import isi.tn.miniprojet.service.ICourseSessionService;

@RestController
@CrossOrigin("*")
@RequestMapping("/courseSession")
public class CourseSessionController {
	@Autowired
	private ICourseSessionService courseSessionService;// injecter l'interface -> couplage faible

	@GetMapping
	public List<CourseSession> findAll() {
		return courseSessionService.findAll();
	}

	@PostMapping("/{structureid}/{IdTrainer}/{IdCourse}")
	public MessageResponse<CourseSession> save(@RequestBody CourseSession courseSession,
			@PathVariable("structureid") Long structureid, @PathVariable("IdTrainer") Long IdTrainer,
			@PathVariable("IdCourse") Long IdCourse) {
		return courseSessionService.save(courseSession, structureid, IdTrainer, IdCourse);
	}

	@GetMapping("/{IdCourseSession}/{idParticipant}")
	public MessageResponse<CourseSession> addOrRemoveParticipantFromSession(
			@PathVariable("IdCourseSession") Long IdCourseSession, @PathVariable("idParticipant") Long idParticipant) {
		return courseSessionService.addOrRemoveParticipantFromSession(IdCourseSession, idParticipant);
	}

	@PutMapping("/{structureid}/{IdTrainer}/{IdCourse}")
	public MessageResponse<CourseSession> update(@RequestBody CourseSession courseSession,
			@PathVariable("structureid") Long structureid, @PathVariable("IdTrainer") Long IdTrainer,
			@PathVariable("IdCourse") Long IdCourse) {
		return courseSessionService.update(courseSession, structureid, IdTrainer, IdCourse);
	}

	@GetMapping("/{code}")
	public CourseSession findById(@PathVariable("code") Long id) {
		return courseSessionService.findById(id);
	}

	@DeleteMapping("/{id}")
	public MessageResponse<CourseSession> delete(@PathVariable Long id) {
		return courseSessionService.delete(id);
	}

}
