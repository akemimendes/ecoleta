package com.akemi.ecoleta.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.akemi.ecoleta.model.Usuario;
import com.akemi.ecoleta.repository.UsuarioRepository;
import com.akemi.ecoleta.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> user=repository.findByEmail(email);
        if (user.isPresent()){
            return new UserSS(user.get().getId(),user.get().getEmail(),user.get().getSenha(),user.get().getPerfis());
        }
        throw new UsernameNotFoundException(email);
       
    }

}
