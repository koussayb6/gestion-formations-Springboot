package isi.tn.miniprojet.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CourseSession implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CourseSessionId")
	private Long IdCourseSession;
	private String lieu;
	private Date date_debut;
	private Date date_fin;
	private Long nb_participant;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Participant> participants;

	@ManyToOne
	private Course course;

	@ManyToOne
	private Trainer trainer;

	@ManyToOne
	private Structure structure;

}
