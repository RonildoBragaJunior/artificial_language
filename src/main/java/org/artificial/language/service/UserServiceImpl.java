package org.artificial.language.service;

import java.util.Arrays;
import java.util.HashSet;

import org.artificial.language.model.Role;
import org.artificial.language.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import org.artificial.language.model.User;
import org.artificial.language.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        
        
        Role userRole = roleRepository.findByRole("ADMIN");
        if(userRole == null) {
			Role admin_role = new Role();
            admin_role.setRole("ADMIN");
            roleRepository.save(admin_role);
        }
        userRole = roleRepository.findByRole("ADMIN");
        
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}

}
