package isi.tn.miniprojet.service;

import isi.tn.miniprojet.response.MessageResponse;
import isi.tn.miniprojet.entity.Domaine;
import isi.tn.miniprojet.repository.DomaineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.validation.constraints.Null;

@Service
public class DomaineServiceImpl implements IDomaineService{

@Autowired
DomaineRepository domaineRepository;

    @Transactional
    @Override
    //<Domaine> generic type
    public MessageResponse<Domaine> save(Domaine domaine) {
        boolean existe = domaineRepository.existsByLibelle(domaine.getLibelle());
        if (existe){
            return new MessageResponse<Domaine>(false,"Echec !","Cette domaine existe déja !",null);
        }
        
        return new MessageResponse<Domaine>(true,"Succès","Opération réalisée avec succès.",domaineRepository.save(domaine));
    }


    @Transactional
    @Override
    public MessageResponse<Domaine> update(Domaine domaine) {
        boolean existe = domaineRepository.existsById(domaine.getIdDomaine());
        if (!existe){
            return new MessageResponse<Domaine>(false,"Echec !","Opération non réalisée !",null);

        }
        
        return new MessageResponse<Domaine>(true,"Succès","Opération réalisée avec succès.",domaineRepository.save(domaine));
    }

    @Transactional
    @Override
    public MessageResponse<Domaine> delete(Long id) {
        Domaine domaine = findById(id);
        if (domaine==null){
            return new MessageResponse<Domaine>(false,"Echec","Cet enregistrement n'existe pas !",null);
        }
        domaineRepository.delete(domaine);
        return new MessageResponse<Domaine>(true,"Succès", "L'enregistrement a été supprimé avec succès.",null);
    }

    @Override
    public List<Domaine> findAll() {

        return domaineRepository.findAll();
    }

    @Override
    public Domaine findById(Long id) {
        Domaine domaine = domaineRepository.findById(id).orElse(null);
        return domaine;
    }
}
