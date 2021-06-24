package ar.edu.unju.fi.tpfinal.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Usuario;
import ar.edu.unju.fi.tpfinal.repository.IUsuarioRepository;

@Service
public class UserDetailsServiceImp implements UserDetailsService{
	@Autowired
	IUsuarioRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = userRepository.findByUsername(username);
		UserBuilder builder = null;
		if (usuario!=null) {
			builder=User.withUsername(username);
			builder.disabled(false);
			builder.password(usuario.getPassword());
			if(usuario.getRol().contains("Sales Rep")) {
				builder.authorities(new SimpleGrantedAuthority("ROLE_USER"));
			}else {
				builder.authorities(new SimpleGrantedAuthority("ROLE_ADMIN"));
			}
			
		} else {
			throw new UsernameNotFoundException("Usuario NO encontrado");
		}
		return builder.build();
	}

}
