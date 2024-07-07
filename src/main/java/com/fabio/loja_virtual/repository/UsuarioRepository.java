package com.fabio.loja_virtual.repository;

import com.fabio.loja_virtual.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT u FROM Usuario u WHERE u.login = ?1")
    Usuario findUserByLogin(String login);
}
