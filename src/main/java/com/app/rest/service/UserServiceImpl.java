package com.app.rest.service;

import com.app.rest.dao.UserRepository;
import com.app.rest.dto.UserDTO;
import com.app.rest.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Primary
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User userCheck = userRepository.findUserByEmail(userDTO.getEmail());
        if(userCheck != null) throw  new RuntimeException("Data exist");
        User user = new User();
        if(userDTO.getPassword() != null && !(userDTO.getPassword()).equals("")){
            userDTO.setEncryptedPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        }
        BeanUtils.copyProperties(userDTO, user);
        User persistedUser = userRepository.save(user);
        UserDTO savedUser = new UserDTO();
        BeanUtils.copyProperties(persistedUser, savedUser);
        return savedUser;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return null;
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public boolean deleteUser(Integer id) {
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }


//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        return null;
//    }
}
