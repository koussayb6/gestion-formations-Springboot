package isi.tn.miniprojet.service;

import java.util.List;
import isi.tn.miniprojet.entity.Trainer;
import isi.tn.miniprojet.response.MessageResponse;

public interface ITrainerService {
	
	public MessageResponse<Trainer> save(Trainer trainer, Long IdStructure);
    public MessageResponse<Trainer> update(Trainer trainer,Long IdStructure);
    public MessageResponse<Trainer> delete(Long id);
    public List<Trainer> findAll();
    public Trainer findById(Long id);

}
