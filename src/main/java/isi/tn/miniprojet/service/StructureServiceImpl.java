package isi.tn.miniprojet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isi.tn.miniprojet.entity.Structure;
import isi.tn.miniprojet.repository.StructureRepository;
import isi.tn.miniprojet.response.MessageResponse;

@Service
public class StructureServiceImpl implements IStructureService {
	@Autowired
	StructureRepository structureRepository;

	@Transactional
	@Override
	public MessageResponse<Structure> save(Structure structure) {
		boolean existe = structureRepository.existsByLibelle(structure.getLibelle());
		if (existe) {
			return new MessageResponse<Structure>(false, "Echec !", "Cette session de formation existe déja !", null);
		}

		return new MessageResponse<Structure>(true, "Succès", "Opération réalisée avec succès.",
				structureRepository.save(structure));
	}

	@Transactional
	@Override
	public MessageResponse<Structure> update(Structure structure) {
		boolean existe = structureRepository.existsById(structure.getIdStructure());
		if (!existe) {
			return new MessageResponse<Structure>(false, "Echec !", "Opération non réalisée !", null);

		}
		return new MessageResponse<Structure>(true, "Succès", "Opération réalisée avec succès.",
				structureRepository.save(structure));
	}

	@Transactional
	@Override
	public MessageResponse<Structure> delete(Long id) {
		Structure structure = findById(id);
		if (structure == null) {
			return new MessageResponse<Structure>(false, "Echec", "Cet enregistrement n'existe pas !", null);
		}
		structureRepository.delete(structure);
		return new MessageResponse<Structure>(true, "Succès", "L'enregistrement a été supprimé avec succès.", null);
	}

	@Override
	public List<Structure> findAll() {
		return structureRepository.findAll();
	}

	@Override
	public Structure findById(Long id) {
		Structure structure = structureRepository.findById(id).orElse(null);
		return structure;
	}

}
