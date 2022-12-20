package isi.tn.miniprojet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isi.tn.miniprojet.entity.Trainer;
import isi.tn.miniprojet.entity.User;
import isi.tn.miniprojet.entity.Domaine;
import isi.tn.miniprojet.entity.Structure;
import isi.tn.miniprojet.repository.DomaineRepository;
import isi.tn.miniprojet.repository.StructureRepository;
import isi.tn.miniprojet.repository.TrainerRepository;
import isi.tn.miniprojet.response.MessageResponse;

@Service
public class TrainerServiceImpl implements ITrainerService{
	@Autowired
	TrainerRepository trainerRepository;
	@Autowired
	StructureRepository structureRepository;

	@Transactional
	@Override
	public MessageResponse<Trainer> save(Trainer trainer,Long IdStructure) {
		 boolean existe = trainerRepository.existsByEmail(trainer.getEmail());
		    if (existe){
		        return new MessageResponse<Trainer>(false,"Echec !","Cet formateur existe déja !",null);
		    }
		    Structure structure = structureRepository.findById(IdStructure).orElse(null);
		    trainer.setStructure(structure);
		    return new MessageResponse<Trainer>(true,"Succès","Formateur ajouté avec succès.",trainerRepository.save(trainer));
	}

	@Transactional
	@Override
	public MessageResponse<Trainer> update(Trainer trainer,Long IdStructure) {
		boolean existe = trainerRepository.existsByEmail(trainer.getEmail());
	    if (!existe){
	        return new MessageResponse<Trainer>(false,"Echec !","Cet formateur existe déja !",null);
	    }
	    Structure structure = structureRepository.findById(IdStructure).orElse(null);
	    trainer.setStructure(structure);
	    return new MessageResponse<Trainer>(true,"Succès","Formateur ajouté avec succès.",trainerRepository.save(trainer));
	}

	@Override
	public MessageResponse<Trainer> delete(Long id) {
		Trainer trainer = findById(id);
	    if (trainer==null){
	        return new MessageResponse<Trainer>(false,"Echec","Cet utilisateur n'existe pas !",null);
	    }
	    trainerRepository.delete(trainer);
	    return new MessageResponse<Trainer>(true,"Succès", "L'utilisateur a été supprimé avec succès.",null);
	}

	@Override
	public List<Trainer> findAll() {
		return trainerRepository.findAll();
	}

	@Override
	public Trainer findById(Long id) {
		Trainer trainer = trainerRepository.findById(id).orElse(null);
		return trainer;
	}
}
