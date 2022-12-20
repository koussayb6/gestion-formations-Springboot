package isi.tn.miniprojet.service;

import java.util.List;

import isi.tn.miniprojet.entity.Participant;
import isi.tn.miniprojet.response.MessageResponse;

public interface IParticipantService {
	public MessageResponse<Participant> save(Participant participant,Long IdProfil, Long IdStructure, Long IdPays);
    public MessageResponse<Participant> update(Participant participant,Long IdProfil, Long IdStructure, Long IdPays); 
    public MessageResponse<Participant> delete(Long IdParticipant);
    public List<Participant> findAll();
    public Participant findById(Long IdParticipant);

}
