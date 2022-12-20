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

import isi.tn.miniprojet.entity.Structure;
import isi.tn.miniprojet.response.MessageResponse;
import isi.tn.miniprojet.service.StructureServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/structure")
public class StructureController {
	@Autowired
    private StructureServiceImpl structureService;
	
	@GetMapping
    public List<Structure> findAll() {
        return structureService.findAll();
    }

    @PostMapping
    //@ResponseBody
    public MessageResponse<Structure> save(@RequestBody Structure structure) {
        return structureService.save(structure);
    }

    @PutMapping
    public MessageResponse<Structure> update(@RequestBody Structure structure) {
        return structureService.update(structure);
    }

   @GetMapping("/{code}")
    public Structure findById(@PathVariable("code") Long id) {
        return structureService.findById(id);
    }

    @DeleteMapping("/{id}")
    public MessageResponse<Structure> delete(@PathVariable Long id) {
        return structureService.delete(id);
    }


}
