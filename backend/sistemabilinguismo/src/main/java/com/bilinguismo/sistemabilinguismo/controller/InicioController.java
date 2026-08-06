package com.bilinguismo.sistemabilinguismo.controller;

import com.bilinguismo.sistemabilinguismo.entity.Usuario;
import com.bilinguismo.sistemabilinguismo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InicioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public String inicio() {
        return "index";
    }

    @GetMapping("/registro")
    public String registro() {
        return "registro";
    }

    @PostMapping("/guardar")
    public String guardar(Usuario usuario) {

        usuarioService.guardar(usuario);

        return "redirect:/";
    }

    @GetMapping("/login")
public String login() {
    return "login";
}

@PostMapping("/login")
public String validarLogin(String correo, String contrasena) {

    Usuario usuario = usuarioService.iniciarSesion(correo, contrasena);

    if (usuario != null) {
        return "redirect:/";
    }

    return "login";
}
}
