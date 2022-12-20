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

import isi.tn.miniprojet.entity.Pays;
import isi.tn.miniprojet.response.MessageResponse;
import isi.tn.miniprojet.service.PaysServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/pays")
public class PaysController {
	 @Autowired
	    private PaysServiceImpl paysService;

	    @GetMapping
	    public List<Pays> findAll() {
	        return paysService.findAll();
	    }

	    @PostMapping
	    public MessageResponse<Pays> save(@RequestBody Pays profil) {
	        return paysService.save(profil);
	    }

	    @PutMapping
	    public MessageResponse<Pays> update(@RequestBody Pays profil) {
	        return paysService.update(profil);
	    }

	   @GetMapping("/{code}")
	    public Pays findById(@PathVariable("code") Long id) {
	        return paysService.findById(id);
	    }

	    @DeleteMapping("/{id}")
	    public MessageResponse<Pays> delete(@PathVariable Long id) {
	        return paysService.delete(id);
	    }

}
