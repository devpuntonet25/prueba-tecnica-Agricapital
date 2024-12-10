package com.hgallgo.prueba.controller;

import com.hgallgo.prueba.entity.Usuario;
import com.hgallgo.prueba.service.IUsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/usuarios")
public class UsuarioController {
    private IUsuarioService usuarioService;

    @Autowired
    public UsuarioController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody @Valid Usuario usuario) {
        // Si el formato del correo no es válido o es una cadena vacia, se retorna de forma automática el error 403
        String respuesta = usuarioService.save(usuario);
        return respuesta.equals("Ya existe") ? ResponseEntity.
                status(HttpStatus.NOT_ACCEPTABLE).body("No se puede crear un usuario con el correo "
                        + usuario.getEmail())
                : ResponseEntity.ok("Se ha creado el usuario con correo " + usuario.getEmail());
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    //Esta es la forma como se deben enviar los parámetros para la paginación
    // GET /v1/usuarios/pagination?page=0&size=5&sort=email,asc
    @GetMapping("/pagination")
    public ResponseEntity<Page<Usuario>> getUsuariosPagination(
            @PageableDefault(page = 0, size = 5, sort = "email", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        return ResponseEntity.ok(usuarioService.getUsuariosPagination(pageable));
    }

}
