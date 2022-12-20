package isi.tn.miniprojet.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Pays {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PayslId")
	private Long IdPays;
	@Column(unique = true, nullable = false)
	private String libelle;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pays")
	private List<Participant> Participants;

}
