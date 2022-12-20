package isi.tn.miniprojet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isi.tn.miniprojet.entity.Participant;
import isi.tn.miniprojet.entity.Pays;
import isi.tn.miniprojet.entity.Profil;
import isi.tn.miniprojet.entity.Structure;
import isi.tn.miniprojet.repository.ParticipantRepository;
import isi.tn.miniprojet.repository.PaysRepository;
import isi.tn.miniprojet.repository.ProfilRepository;
import isi.tn.miniprojet.repository.StructureRepository;
import isi.tn.miniprojet.response.MessageResponse;

@Service
public class ParticipantServiceImpl implements IParticipantService {
	@Autowired
	ParticipantRepository participantRepository;
	@Autowired
	ProfilRepository profilRepository;
	@Autowired
	StructureRepository structureRepository;
	@Autowired
	PaysRepository paysRepository;

	@Transactional
	@Override
	public MessageResponse<Participant> save(Participant participant, Long IdProfil, Long IdStructure, Long IdPays) {
		boolean existe = participantRepository.existsByEmail(participant.getEmail());
		if (existe) {
			return new MessageResponse<Participant>(false, "Echec !", "Cette session de formation existe déja !", null);
		}
		Profil profil = profilRepository.findById(IdProfil).orElse(null);
		participant.setProfil(profil);
		Structure structure = structureRepository.findById(IdStructure).orElse(null);
		participant.setStructure(structure);
		Pays pays = paysRepository.findById(IdPays).orElse(null);
		participant.setPays(pays);
		return new MessageResponse<Participant>(true, "Succès", "Session de formation ajouté avec succès.",
				participantRepository.save(participant));
	}

	@Transactional
	@Override
	public MessageResponse<Participant> update(Participant participant, Long IdProfil, Long IdStructure, Long IdPays) {
		boolean existe = participantRepository.existsById(participant.getIdParticipant());
		if (!existe) {
			return new MessageResponse<Participant>(false, "Echec !", "Cette session de formation n'existe pas !",
					null);
		}
		Profil profil = profilRepository.findById(IdProfil).orElse(null);
		participant.setProfil(profil);
		Structure structure = structureRepository.findById(IdStructure).orElse(null);
		participant.setStructure(structure);
		Pays pays = paysRepository.findById(IdPays).orElse(null);
		participant.setPays(pays);
		return new MessageResponse<Participant>(true, "Succès", "Session de formation mise à jour avec succès.",
				participantRepository.save(participant));
	}

	@Override
	public MessageResponse<Participant> delete(Long IdParticipant) {
		Participant participant = findById(IdParticipant);
		if (participant == null) {
			return new MessageResponse<Participant>(false, "Echec", "Ce participant n'existe pas !", null);
		}
		participantRepository.delete(participant);
		return new MessageResponse<Participant>(true, "Succès", "Le participant a été supprimé avec succès.", null);
	}

	@Override
	public List<Participant> findAll() {
		return participantRepository.findAll();
	}

	@Override
	public Participant findById(Long IdParticipant) {
		Participant participant = participantRepository.findById(IdParticipant).orElse(null);
		return participant;
	}

}
