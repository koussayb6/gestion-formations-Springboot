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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Participant implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ParticipantId")
	private Long idParticipant;
	@Column(unique = true, nullable = false)
	private String fname;
	private String lname;
	@Email
	private String email;
	private Long tel;
	@Enumerated(EnumType.STRING)
	private Ptype type;

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	private List<CourseSession> courseSessions;

	@ManyToOne
	private Profil profil;

	@ManyToOne
	private Pays pays;

	@ManyToOne
	private Structure structure;
}
