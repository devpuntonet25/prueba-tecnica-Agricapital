package com.hgallgo.prueba.service;

import com.hgallgo.prueba.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    String save(Usuario usuario);
    List<Usuario> findAll();

    Optional<Usuario> findByEmail(String email);
    Page<Usuario> getUsuariosPagination(Pageable pageable);
}
