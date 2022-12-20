package isi.tn.miniprojet.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Trainer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TrainerId")
	private Long IdTrainer;
	@Column(unique = true, nullable = false)
	private String firstname;
	private String lastname;
	private String email;
	private int phone;
	@Enumerated(EnumType.STRING)
	private Ttype trainertype;

	@ManyToOne
	private Structure structure;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "trainer")
	private List<CourseSession> CourseSessions;

}

//1..* session formation
//*..1 organisme
//idOrganisme int Id de l’organisme de formateur
