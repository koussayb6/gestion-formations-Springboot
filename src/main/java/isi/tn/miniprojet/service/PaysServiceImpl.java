package isi.tn.miniprojet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.tn.miniprojet.entity.Pays;
import isi.tn.miniprojet.repository.PaysRepository;
import isi.tn.miniprojet.response.MessageResponse;

@Service
public class PaysServiceImpl implements IPaysService {
	@Autowired
	PaysRepository paysRepository;

	@Override
	public MessageResponse<Pays> save(Pays pays) {
		 boolean existe = paysRepository.existsByLibelle(pays.getLibelle());
	        if (existe){
	            return new MessageResponse<Pays>(false,"Echec !","Cette domaine existe déja !",null);
	        }
	        
	        return new MessageResponse<Pays>(true,"Succès","Opération réalisée avec succès.",paysRepository.save(pays));
	}

	@Override
	public MessageResponse<Pays> update(Pays pays) {
		boolean existe = paysRepository.existsById(pays.getIdPays());
        if (!existe){
            return new MessageResponse<Pays>(false,"Echec !","Opération non réalisée !",null);
        }
        return new MessageResponse<Pays>(true,"Succès","Opération réalisée avec succès.",paysRepository.save(pays));
	}

	@Override
	public MessageResponse<Pays> delete(Long id) {
		Pays pays = findById(id);
        if (pays==null){
            return new MessageResponse<Pays>(false,"Echec","Cet enregistrement n'existe pas !",null);
        }
        paysRepository.delete(pays);
        return new MessageResponse<Pays>(true,"Succès", "L'enregistrement a été supprimé avec succès.",null);
	}

	@Override
	public List<Pays> findAll() {
		return paysRepository.findAll();
	}

	@Override
	public Pays findById(Long id) {
		Pays pays = paysRepository.findById(id).orElse(null);
        return pays;
	}
	

}
