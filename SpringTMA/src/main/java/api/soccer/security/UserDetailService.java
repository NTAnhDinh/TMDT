package api.soccer.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import api.soccer.management.model.NguoiChoi;
import api.soccer.management.repository.NguoiChoiRepository;
import api.soccer.management.service.NguoiChoiService;
@Service
public class UserDetailService implements UserDetailsService {

	@Autowired
	NguoiChoiService nguoichoiRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		NguoiChoi player = nguoichoiRepository.findByUsername(username);
		
		if (player == null) {
			throw new UsernameNotFoundException("UserName " + username + " not found");
		}
		System.out.println(new UserDetail(player).toString());
		return new UserDetail(player);
//		return null;
	}

}
