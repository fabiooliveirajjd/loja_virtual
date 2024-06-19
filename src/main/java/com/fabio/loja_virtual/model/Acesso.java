package com.fabio.loja_virtual.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "acesso")
@SequenceGenerator(name = "seq_acesso", sequenceName = "seq_acesso", initialValue = 1, allocationSize = 1)
public class Acesso implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_acesso")
    private Long id;

    @Column(name = "descricao", nullable = false)
    private String descricao; // Acesso ex: ROLE_ADMIN ou ROLE_SECRETARIO

    @Override
    public String getAuthority() {
        return this.descricao;
    }
}
