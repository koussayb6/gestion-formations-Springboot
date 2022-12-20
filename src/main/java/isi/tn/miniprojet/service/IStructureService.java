package isi.tn.miniprojet.service;

import java.util.List;

import isi.tn.miniprojet.entity.Structure;
import isi.tn.miniprojet.response.MessageResponse;

public interface IStructureService {
	public MessageResponse<Structure> save(Structure structure);
    public MessageResponse<Structure> update(Structure structure);
    public MessageResponse<Structure> delete(Long id);
    public List<Structure> findAll();
    public Structure findById(Long id);

}
