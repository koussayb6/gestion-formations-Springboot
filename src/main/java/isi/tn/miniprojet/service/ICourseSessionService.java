package isi.tn.miniprojet.service;

import java.util.List;

import isi.tn.miniprojet.entity.CourseSession;
import isi.tn.miniprojet.response.MessageResponse;

public interface ICourseSessionService {
	public MessageResponse<CourseSession> save(CourseSession courseSession, Long structureid, Long IdTrainer,
			Long CourseId);

	public MessageResponse<CourseSession> update(CourseSession courseSession, Long structureid, Long IdTrainer,
			Long CourseId);

	public MessageResponse<CourseSession> delete(Long IdCourseSession);

	public List<CourseSession> findAll();

	public CourseSession findById(Long IdCourseSession);

	public MessageResponse<CourseSession> addOrRemoveParticipantFromSession(Long IdCourseSession, Long idParticipant);

}
