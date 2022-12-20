package isi.tn.miniprojet.service;

import java.util.List;

import isi.tn.miniprojet.entity.User;
import isi.tn.miniprojet.response.MessageResponse;

public interface IUserService {
	
	public MessageResponse<User> save(User user);
    public MessageResponse<User> update(User user);
    public MessageResponse<User> delete(Long id);
    public List<User> findAll();
    public User findById(Long id);

}
