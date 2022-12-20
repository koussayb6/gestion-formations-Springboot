package isi.tn.miniprojet.service;

import isi.tn.miniprojet.entity.Domaine;
import isi.tn.miniprojet.response.MessageResponse;

import java.util.List;

public interface IDomaineService {
    public MessageResponse<Domaine> save(Domaine domaine);
    public MessageResponse<Domaine> update(Domaine domaine);
    public MessageResponse<Domaine> delete(Long id);
    public List<Domaine> findAll();
    public Domaine findById(Long id);
}
