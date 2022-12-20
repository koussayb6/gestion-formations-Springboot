package isi.tn.miniprojet.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Domaine implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="DomaineId")
	private Long IdDomaine;
	@Column(unique = true,nullable = false)
	private String libelle;

    @JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="domaine")
	private List<Course> courses;

	}