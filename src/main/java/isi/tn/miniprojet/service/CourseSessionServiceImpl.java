package isi.tn.miniprojet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isi.tn.miniprojet.entity.Course;
import isi.tn.miniprojet.entity.CourseSession;
import isi.tn.miniprojet.entity.Participant;
import isi.tn.miniprojet.entity.Structure;
import isi.tn.miniprojet.entity.Trainer;
import isi.tn.miniprojet.repository.CourseRepository;
import isi.tn.miniprojet.repository.CourseSessionRepository;
import isi.tn.miniprojet.repository.ParticipantRepository;
import isi.tn.miniprojet.repository.StructureRepository;
import isi.tn.miniprojet.repository.TrainerRepository;
import isi.tn.miniprojet.response.MessageResponse;

@Service
public class CourseSessionServiceImpl implements ICourseSessionService {

	@Autowired
	CourseSessionRepository courseSessionRepository;
	@Autowired
	StructureRepository structureRepository;
	@Autowired
	TrainerRepository trainerRepository;
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	ParticipantRepository participantRepository;

	@Transactional
	@Override
	public MessageResponse<CourseSession> save(CourseSession courseSession, Long structureid, Long IdTrainer,
			Long CourseId) {

		Structure structure = structureRepository.findById(structureid).orElse(null);
		courseSession.setStructure(structure);
		Trainer trainer = trainerRepository.findById(IdTrainer).orElse(null);
		courseSession.setTrainer(trainer);
		Course course = courseRepository.findById(CourseId).orElse(null);
		courseSession.setCourse(course);

		return new MessageResponse<CourseSession>(true, "Succès", "Session de formation ajouté avec succès.",
				courseSessionRepository.save(courseSession));
	}

	@Transactional
	@Override
	public MessageResponse<CourseSession> update(CourseSession courseSession, Long structureid, Long IdTrainer,
			Long CourseId) {
		boolean existe = courseSessionRepository.existsById(courseSession.getIdCourseSession());
		if (!existe) {
			return new MessageResponse<CourseSession>(false, "Echec !", "Cette session de formation n'existe pas !",
					null);
		}
		Structure structure = structureRepository.findById(structureid).orElse(null);
		courseSession.setStructure(structure);
		Trainer trainer = trainerRepository.findById(IdTrainer).orElse(null);
		courseSession.setTrainer(trainer);
		Course course = courseRepository.findById(CourseId).orElse(null);
		courseSession.setCourse(course);

		return new MessageResponse<CourseSession>(true, "Succès", "Session de formation mise à jour avec succès.",
				courseSessionRepository.save(courseSession));
	}

	@Override
	public MessageResponse<CourseSession> delete(Long IdCourseSession) {
		CourseSession courseSession = findById(IdCourseSession);
		if (courseSession == null) {
			return new MessageResponse<CourseSession>(false, "Echec", "Ce joueur n'existe pas !", null);
		}
		courseSessionRepository.delete(courseSession);
		return new MessageResponse<CourseSession>(true, "Succès", "Le joueur a été supprimé avec succès.", null);
	}

	@Override
	public List<CourseSession> findAll() {
		return courseSessionRepository.findAll();
	}

	@Override
	public CourseSession findById(Long IdCourseSession) {
		CourseSession courseSession = courseSessionRepository.findById(IdCourseSession).orElse(null);
		return courseSession;
	}

	@Override
	public MessageResponse<CourseSession> addOrRemoveParticipantFromSession(Long IdCourseSession, Long idParticipant) {
		CourseSession courseSession = courseSessionRepository.findById(IdCourseSession).orElse(null);
		Participant participant = participantRepository.findById(idParticipant).orElse(null);
		if (courseSession.getParticipants().contains(participant)) {
			courseSession.getParticipants().remove(participant);
			return new MessageResponse<CourseSession>(true, "success", "participant removed !",
					courseSessionRepository.save(courseSession));
		}
		courseSession.getParticipants().add(participant);
		return new MessageResponse<CourseSession>(true, "success", "participant added !",
				courseSessionRepository.save(courseSession));
	}

}
