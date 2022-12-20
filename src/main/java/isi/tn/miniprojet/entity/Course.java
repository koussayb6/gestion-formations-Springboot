package isi.tn.miniprojet.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="CourseId")
	private Long IdCourse;
	@Column(unique = true,nullable = false)
	private String title;
	private Ptype courseType;
	private Long duree;
	private Long nb_session;
	private Double budget;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="course")
	private List<CourseSession> courseSessions;
	
	
	@ManyToOne
	private Domaine domaine;

}
