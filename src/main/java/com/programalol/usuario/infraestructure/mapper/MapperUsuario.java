package com.programalol.usuario.infraestructure.mapper;

import com.programalol.usuario.domain.model.Usuario;
import com.programalol.usuario.infraestructure.driver_adapters.jpa_repository.UsuarioData;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperUsuario {
    public Usuario toUsuario(UsuarioData usuarioData){
        return new Usuario(
                usuarioData.getIdentificador(),
                usuarioData.getNombre(),
                usuarioData.getApellido(),
                usuarioData.getCorreo()
        );
    }

    public UsuarioData toUsuarioData(Usuario usuario){
        return new UsuarioData(
                usuario.getIdentificador(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getCorreo()
        );
    }

    public List<UsuarioData> toUsuariosData(List<Usuario> usuarios){
        List<UsuarioData> usuariosDataList = new ArrayList<>();
        for (Usuario usuario: usuarios) {
            UsuarioData usuarioData = new UsuarioData(
                    usuario.getIdentificador(),
                    usuario.getNombre(),
                    usuario.getApellido(),
                    usuario.getCorreo()
            );
            usuariosDataList.add(usuarioData);
        }
        return usuariosDataList;
    }

    public List<Usuario> toUsuarios(List<UsuarioData> usuariosData){
        List<Usuario> usuariosList = new ArrayList<>();
        for (UsuarioData usuarioData: usuariosData) {
            Usuario usuario = new Usuario(
                    usuarioData.getIdentificador(),
                    usuarioData.getNombre(),
                    usuarioData.getApellido(),
                    usuarioData.getCorreo()
            );
            usuariosList.add(usuario);
        }
        return usuariosList;
    }

    public MapperUsuario() {
    }

}
