package com.programalol.usuario.infraestructure.entry_points;

import com.programalol.usuario.domain.model.Usuario;
import com.programalol.usuario.domain.usecase.UsuarioUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
    private final UsuarioUseCase usuarioUseCase;

    @GetMapping("/find")
    public ResponseEntity<Usuario> findById(@RequestParam("id") Long id) throws Exception {
        Optional<Usuario> usuario = Optional.ofNullable(usuarioUseCase.buscarPorId(id));
        if (usuario.isPresent()){
            return new ResponseEntity<>(usuario.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Usuario>> getAll() throws Exception {
        List<Usuario> usuarios = usuarioUseCase.obtenerUsuariosTodos();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    public UsuarioController(UsuarioUseCase usuarioUseCase) {
        this.usuarioUseCase = usuarioUseCase;
    }

}
