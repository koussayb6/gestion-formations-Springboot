package isi.tn.miniprojet.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import isi.tn.miniprojet.entity.CourseSession;
import isi.tn.miniprojet.entity.Participant;
import isi.tn.miniprojet.response.MessageResponse;
import isi.tn.miniprojet.service.ParticipantServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/participant")
public class ParticipantController {
	@Autowired
    @Resource
    private ParticipantServiceImpl participantService;
	
	 @GetMapping
	    public List<Participant> findAll() {
	        return participantService.findAll();
	    }

	    @PostMapping("/{IdProfil}/{IdStructure}/{IdPays}")
	 
	    public MessageResponse<Participant> save(@RequestBody Participant participant,@PathVariable("IdProfil") Long IdProfil,@PathVariable("IdStructure") Long IdStructure,@PathVariable("IdPays") Long IdPays) {
	        return participantService.save(participant, IdProfil, IdStructure, IdPays);
	    }

	    @PutMapping("/{IdProfil}/{IdStructure}/{IdPays}")
	    public MessageResponse<Participant> update(@RequestBody Participant participant,@PathVariable("IdProfil") Long IdProfil,@PathVariable("IdStructure") Long IdStructure,@PathVariable("IdPays") Long IdPays) {
	        return participantService.update(participant, IdProfil, IdStructure, IdPays);
	    }
	    
	    @GetMapping("/{code}")
	    public Participant findById(@PathVariable("code") Long id) {
	        return participantService.findById(id);
	    }

	    @DeleteMapping("/{id}")
	    public MessageResponse<Participant> delete(@PathVariable Long id) {
	        return participantService.delete(id);
	    }

	    
}
