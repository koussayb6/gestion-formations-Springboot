package isi.tn.miniprojet.service;

import java.util.List;

import isi.tn.miniprojet.entity.Profil;
import isi.tn.miniprojet.response.MessageResponse;

public interface IProfilService {
	public MessageResponse<Profil> save(Profil profil);
    public MessageResponse<Profil> update(Profil profil);
    public MessageResponse<Profil> delete(Long id);
    public List<Profil> findAll();
    public Profil findById(Long id);

}
