package isi.tn.miniprojet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isi.tn.miniprojet.entity.User;
import isi.tn.miniprojet.repository.UserRepository;
import isi.tn.miniprojet.response.MessageResponse;

@Service
//@Componentpublic
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;

	@Transactional
	@Override
//<User> generic type
	public MessageResponse<User> save(User user) {
		boolean existe = userRepository.existsByEmail(user.getEmail());
		if (existe) {
			return new MessageResponse<User>(false, "Echec !", "Cet utilisateur existe déja !", null);
		}

		return new MessageResponse<User>(true, "Succès", "Utilisateur ajouté avec succès.", userRepository.save(user));
	}

	@Transactional
	@Override
	public MessageResponse<User> update(User user) {
		boolean existe = userRepository.existsByEmail(user.getEmail());
		if (!existe) {
			return new MessageResponse<User>(false, "Echec !", "Opération non réalisée !", null);

		}
		User user1 = userRepository.findById(user.getId()).orElse(null);
		user.setEmail(user.getEmail());
		user1.setUsername(user.getUsername());

		return new MessageResponse<User>(true, "Succès", "Opération réalisée avec succès.", userRepository.save(user1));
	}

	@Transactional
	@Override
	public MessageResponse<User> delete(Long id) {
		User user = findById(id);
		if (user == null) {
			return new MessageResponse<User>(false, "Echec", "Cet utilisateur n'existe pas !", null);
		}
		userRepository.delete(user);
		return new MessageResponse<User>(true, "Succès", "L'utilisateur a été supprimé avec succès.", null);
	}

	@Override
	public List<User> findAll() {

		return userRepository.findAll();
	}

	@Override
	public User findById(Long id) {

		User user = userRepository.findById(id).orElse(null);
		return user;
	}

}
