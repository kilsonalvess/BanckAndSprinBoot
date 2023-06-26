package com.br.Projeto.Service;

import com.br.Projeto.Repositorio.UsuarioRepositorio;
import com.br.Projeto.Model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {


    @Autowired
    private UsuarioRepositorio usuarioRepository;

    public List<Usuario> getUsuarios() {
        return this.usuarioRepository.findAll();
    }

    public Usuario getUsuarioPorId(Long idUsuario) {
        return this.usuarioRepository.findById(idUsuario).orElse(null);
    }

    @Transactional
    public Usuario inserirOuAtualizar(Usuario usuario) {
        Usuario usuarioInserido = this.usuarioRepository.save(usuario);
        if (usuario.getIdade() < 18) {
            throw new RuntimeException("Menor de idade não permitido");
        }
        return usuarioInserido;
    }

    public void apagar(Long id) {
        this.usuarioRepository.deleteById(id);
    }
}














