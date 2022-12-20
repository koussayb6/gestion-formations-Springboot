package  isi.tn.miniprojet.controller;

import isi.tn.miniprojet.entity.Domaine;
import isi.tn.miniprojet.response.MessageResponse;
import isi.tn.miniprojet.service.DomaineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/domaine")
public class DomaineController {

    @Autowired
    private DomaineServiceImpl domaineService;

    @GetMapping
    public List<Domaine> findAll() {
        return domaineService.findAll();
    }

    @PostMapping
    //@ResponseBody
    public MessageResponse<Domaine> save(@RequestBody Domaine domaine) {
        return domaineService.save(domaine);
    }

    @PutMapping
    public MessageResponse<Domaine> update(@RequestBody Domaine domaine) {
        return domaineService.update(domaine);
    }

   @GetMapping("/{code}")
    public Domaine findById(@PathVariable("code") Long id) {
        return domaineService.findById(id);
    }

    @DeleteMapping("/{id}")
    public MessageResponse<Domaine> delete(@PathVariable Long id) {
        return domaineService.delete(id);
    }
}


