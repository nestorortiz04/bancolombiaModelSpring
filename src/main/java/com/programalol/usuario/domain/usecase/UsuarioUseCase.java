package com.programalol.usuario.domain.usecase;

import com.programalol.usuario.domain.model.Usuario;
import com.programalol.usuario.domain.model.gateways.IUsuarioGateway;
import org.springframework.stereotype.Service;

import java.util.List;

/////// Logica del negocio /////
public class UsuarioUseCase {
    private final IUsuarioGateway usuarioGateway;
    public Usuario guardarUsuario(Usuario usuario) throws Exception {
    if (usuario.getIdentificador() == null){
        throw new Exception("Falta Id de usuario");
    }
    return usuarioGateway.guardar(usuario);
    }

    public void eliminarPorId(Long id) throws Exception {
        try{
            usuarioGateway.eliminar(id);
        }catch (Exception error){
            throw new Exception("Error eliminar Usuario");
        }
    }

    public  Usuario buscarPorId(Long id) throws Exception {
        try{
         return usuarioGateway.buscarPorId(id);
        }catch (Exception error){
            System.out.println("usuario no Existe: " + error.getMessage());
            return null;
        }
    }

    public List<Usuario> obtenerUsuariosTodos() throws Exception{
        try {
            return usuarioGateway.obtenerUsuarios();
        }catch (Exception error){
            System.out.println("Error obteniendo usuarios: " + error.getMessage());
            return null;
        }
    }

    public UsuarioUseCase(IUsuarioGateway usuarioGateway) {
        this.usuarioGateway = usuarioGateway;
    }


}
