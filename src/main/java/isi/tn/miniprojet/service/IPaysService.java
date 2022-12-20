package isi.tn.miniprojet.service;

import java.util.List;

import isi.tn.miniprojet.entity.Pays;
import isi.tn.miniprojet.response.MessageResponse;

public interface IPaysService {
	public MessageResponse<Pays> save(Pays pays);
    public MessageResponse<Pays> update(Pays pays);
    public MessageResponse<Pays> delete(Long id);
    public List<Pays> findAll();
    public Pays findById(Long id);

}
