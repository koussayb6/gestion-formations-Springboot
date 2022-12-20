package isi.tn.miniprojet.controller;

import java.util.List;

import javax.annotation.Resource;

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

import isi.tn.miniprojet.entity.Course;
import isi.tn.miniprojet.response.MessageResponse;
import isi.tn.miniprojet.service.CourseServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/course")
public class CourseController {

	@Autowired
	@Resource
	private CourseServiceImpl courseService;

	@GetMapping
	public List<Course> findAll() {
		return courseService.findAll();
	}

	@PostMapping("/{IdDomaine}")
	public MessageResponse<Course> save(@RequestBody Course course, @PathVariable("IdDomaine") Long IdDomaine) {
		return courseService.save(course, IdDomaine);
	}

	@PutMapping("/{IdDomaine}")
	public MessageResponse<Course> update(@RequestBody Course course, @PathVariable("IdDomaine") Long IdDomaine) {
		return courseService.update(course, IdDomaine);
	}

	@GetMapping("/{code}")
	public Course findById(@PathVariable("code") Long id) {
		return courseService.findById(id);
	}

	@DeleteMapping("/{id}")
	public MessageResponse<Course> delete(@PathVariable Long id) {
		return courseService.delete(id);
	}
}
