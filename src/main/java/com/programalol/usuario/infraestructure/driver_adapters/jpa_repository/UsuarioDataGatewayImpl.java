package com.programalol.usuario.infraestructure.driver_adapters.jpa_repository;

import com.programalol.usuario.domain.model.Usuario;
import com.programalol.usuario.domain.model.gateways.IUsuarioGateway;
import com.programalol.usuario.infraestructure.mapper.MapperUsuario;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioDataGatewayImpl implements IUsuarioGateway {
    private final MapperUsuario mapperUsuario;
    private final IUsuarioDataJpaRepository usuarioDataJpaRepository;

    public UsuarioDataGatewayImpl(MapperUsuario mapperUsuario, IUsuarioDataJpaRepository usuarioDataJpaRepository) {
        this.mapperUsuario = mapperUsuario;
        this.usuarioDataJpaRepository = usuarioDataJpaRepository;
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        UsuarioData usuarioData = mapperUsuario.toUsuarioData(usuario);
        UsuarioData usuarioReturn = usuarioDataJpaRepository.save(usuarioData);
        return mapperUsuario.toUsuario(usuarioReturn);
    }

    @Override
    public void eliminar(Long id) {
        usuarioDataJpaRepository.deleteById(id);
    }

    @Override
    public Usuario buscarPorId(Long id) {
        Optional<UsuarioData> usuarioData  = usuarioDataJpaRepository.findById(id);
        return mapperUsuario.toUsuario(usuarioData.get());
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        List<UsuarioData> usuariosData = (List<UsuarioData>) usuarioDataJpaRepository.findAll();
        return mapperUsuario.toUsuarios(usuariosData);
    }
}
