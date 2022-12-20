package isi.tn.miniprojet.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Structure implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "StructureId")
	private Long IdStructure;
	@Column(unique = true, nullable = false)
	private String libelle;

	@Enumerated(EnumType.STRING)
	private Stype stype;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "structure")
	private List<Trainer> Trainers;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "structure")
	private List<CourseSession> CourseSessions;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "structure")
	private List<Participant> Participants;

}
