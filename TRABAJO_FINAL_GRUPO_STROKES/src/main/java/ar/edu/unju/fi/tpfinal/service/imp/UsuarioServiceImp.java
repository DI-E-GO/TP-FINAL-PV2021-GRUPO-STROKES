/**
 * 
 */
package ar.edu.unju.fi.tpfinal.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Usuario;
import ar.edu.unju.fi.tpfinal.repository.IUsuarioRepository;
import ar.edu.unju.fi.tpfinal.service.IUsuarioService;

/**
 * @author Diego
 *
 */
@Service
public class UsuarioServiceImp implements IUsuarioService {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	IUsuarioRepository userRepository;
	@Override
	public Usuario findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}
	@Override
	public Usuario registrar(Usuario user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

}
