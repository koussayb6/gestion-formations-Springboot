package isi.tn.miniprojet.service;

import java.util.List;

import isi.tn.miniprojet.entity.Course;
import isi.tn.miniprojet.response.MessageResponse;

public interface ICourseService {

	public MessageResponse<Course> save(Course course, Long IdDomaine);

	public MessageResponse<Course> update(Course course, Long IdDomaine);

	public MessageResponse<Course> delete(Long id);

	public List<Course> findAll();

	public Course findById(Long id);

}
