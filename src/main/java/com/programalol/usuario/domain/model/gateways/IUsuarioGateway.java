package com.programalol.usuario.domain.model.gateways;

import com.programalol.usuario.domain.model.Usuario;

import java.util.List;

public interface IUsuarioGateway {
    Usuario guardar(Usuario usuario);
    void eliminar(Long id);
    Usuario buscarPorId(Long id);
    List<Usuario> obtenerUsuarios();
}
