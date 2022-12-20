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

import isi.tn.miniprojet.entity.Trainer;
import isi.tn.miniprojet.response.MessageResponse;
import isi.tn.miniprojet.service.TrainerServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/trainer")
public class TrainerController {
	
	    @Autowired
	    private TrainerServiceImpl trainerService;

	    @GetMapping
	    public List<Trainer> findAll() {
	        return trainerService.findAll();
	    }

	    @PostMapping("/{IdStructure}")
	    public MessageResponse<Trainer> save(@RequestBody Trainer trainer,@PathVariable("IdStructure") Long IdStructure) {
	        return trainerService.save(trainer,IdStructure);
	    }

	    @PutMapping("/{IdStructure}")
	    public MessageResponse<Trainer> update(@RequestBody Trainer trainer,@PathVariable("IdStructure") Long IdStructure) {
	        return trainerService.update(trainer,IdStructure);
	    }

	   @GetMapping("/{code}")
	    public Trainer findById(@PathVariable("code") Long id) {
	        return trainerService.findById(id);
	    }

	    @DeleteMapping("/{id}")
	    public MessageResponse<Trainer> delete(@PathVariable Long id) {
	        return trainerService.delete(id);
	    }

}
