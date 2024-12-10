package com.hgallgo.prueba.service.impl;

import com.hgallgo.prueba.entity.Usuario;
import com.hgallgo.prueba.repository.IUsuarioRepository;
import com.hgallgo.prueba.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    private IUsuarioRepository usuarioRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioServiceImpl(IUsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String save(Usuario usuario) {
        if (findByEmail(usuario.getEmail()).isPresent()) {
            return "Ya existe";
        }
        //Encriptamos antes de guardar en la base de datos
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuarioRepository.save(usuario);

        return "Se persiste";
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public Page<Usuario> getUsuariosPagination(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }
}
