package isi.tn.miniprojet.controller;

import java.util.List;

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

import isi.tn.miniprojet.entity.Profil;
import isi.tn.miniprojet.response.MessageResponse;
import isi.tn.miniprojet.service.ProfilServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/profil")
public class ProfilController {
	 @Autowired
	    private ProfilServiceImpl profilService;

	    @GetMapping
	    public List<Profil> findAll() {
	        return profilService.findAll();
	    }

	    @PostMapping
	    public MessageResponse<Profil> save(@RequestBody Profil profil) {
	        return profilService.save(profil);
	    }

	    @PutMapping
	    public MessageResponse<Profil> update(@RequestBody Profil profil) {
	        return profilService.update(profil);
	    }

	   @GetMapping("/{code}")
	    public Profil findById(@PathVariable("code") Long id) {
	        return profilService.findById(id);
	    }

	    @DeleteMapping("/{id}")
	    public MessageResponse<Profil> delete(@PathVariable Long id) {
	        return profilService.delete(id);
	    }

}
