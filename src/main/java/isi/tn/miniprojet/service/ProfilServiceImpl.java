package isi.tn.miniprojet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isi.tn.miniprojet.entity.Profil;
import isi.tn.miniprojet.repository.ProfilRepository;
import isi.tn.miniprojet.response.MessageResponse;

@Service
public class ProfilServiceImpl implements IProfilService {

	@Autowired
	ProfilRepository profilRepository;

	@Transactional
	@Override
	public MessageResponse<Profil> save(Profil profil) {
		boolean existe = profilRepository.existsByLibelle(profil.getLibelle());
		if (existe) {
			return new MessageResponse<Profil>(false, "Echec !", "Cette domaine existe déja !", null);
		}

		return new MessageResponse<Profil>(true, "Succès", "Opération réalisée avec succès.",
				profilRepository.save(profil));
	}

	@Transactional
	@Override
	public MessageResponse<Profil> update(Profil profil) {
		boolean existe = profilRepository.existsById(profil.getIdProfil());
		if (!existe) {
			return new MessageResponse<Profil>(false, "Echec !", "Opération non réalisée !", null);
		}
		return new MessageResponse<Profil>(true, "Succès", "Opération réalisée avec succès.",
				profilRepository.save(profil));
	}

	@Transactional
	@Override
	public MessageResponse<Profil> delete(Long id) {
		Profil profil = findById(id);
		if (profil == null) {
			return new MessageResponse<Profil>(false, "Echec", "Cet enregistrement n'existe pas !", null);
		}
		profilRepository.delete(profil);
		return new MessageResponse<Profil>(true, "Succès", "L'enregistrement a été supprimé avec succès.", null);
	}

	@Override
	public List<Profil> findAll() {
		return profilRepository.findAll();
	}

	@Override
	public Profil findById(Long id) {
		Profil profil = profilRepository.findById(id).orElse(null);
		return profil;
	}

}
