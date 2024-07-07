package com.fabio.loja_virtual.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usuario")
@Data
@EqualsAndHashCode
@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", initialValue = 1, allocationSize = 1)
public class Usuario implements UserDetails, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
    @Column(name = "id")
    private Long id;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_atual_senha", nullable = false)
    private Date dataAtualSenha;

    @ManyToOne(targetEntity = Pessoa.class)
    @JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
    private Pessoa pessoa;

    /**
     * Atributo que define a relação de um para muitos entre a entidade Usuario e Acesso, configurada para carregamento preguiçoso (LAZY).
     * A relação é mapeada através de uma tabela de junção chamada 'usuario_acesso', que possui restrições de unicidade para as colunas 'usuario_id' e 'acesso_id',
     * garantindo que cada par de usuário e acesso seja único na tabela.
     * A tabela de junção 'usuario_acesso' é especificada com os seguintes detalhes:
     * - 'usuario_id': coluna que referencia a chave primária 'id' da tabela 'usuario', atuando como uma chave estrangeira.
     * - 'acesso_id': coluna que referencia a chave primária 'id' da tabela 'acesso', também atuando como uma chave estrangeira.
     * As restrições de chave estrangeira são definidas para ambas as colunas, garantindo a integridade referencial entre as tabelas 'usuario' e 'acesso'.
     */
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_acesso", uniqueConstraints = @UniqueConstraint(columnNames = {"usuario_id", "acesso_id"},
            name = "unique_aceesso_user"),
            joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id", table = "usuario",
                    unique = false, foreignKey = @ForeignKey(name = "usuario_fk", value = ConstraintMode.CONSTRAINT)),
            inverseJoinColumns = @JoinColumn(name = "acesso_id", unique = false, referencedColumnName = "id", table = "acesso",
                    foreignKey = @ForeignKey(name = "acesso_fk", value = ConstraintMode.CONSTRAINT)))
    private List<Acesso> acessos;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.acessos;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
