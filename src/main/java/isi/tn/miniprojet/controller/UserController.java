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

import isi.tn.miniprojet.entity.User;
import isi.tn.miniprojet.response.MessageResponse;
import isi.tn.miniprojet.service.UserServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
	
	    @Autowired
	    @Resource
	    private UserServiceImpl userService;

	    @GetMapping
	    public List<User> findAll() {
	        return userService.findAll();
	    }

	    @PostMapping
	    //@ResponseBody
	    public MessageResponse<User> save(@RequestBody User user) {
	        return userService.save(user);
	    }

	    @PutMapping
	    public MessageResponse<User> update(@RequestBody User user) {
	        return userService.update(user);
	    }

	   @GetMapping("/{code}")
	    public User findById(@PathVariable("code") Long id) {
	        return userService.findById(id);
	    }

	    @DeleteMapping("/{id}")
	    public MessageResponse<User> delete(@PathVariable Long id) {
	        return userService.delete(id);
	    }

}
