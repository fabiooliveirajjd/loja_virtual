package com.fabio.loja_virtual.model;

import com.fabio.loja_virtual.enuns.TipoEndereco;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "endereco")
@Data
@EqualsAndHashCode
@SequenceGenerator(name = "seq_endereco", sequenceName = "seq_endereco", initialValue = 1, allocationSize = 1)
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_endereco")
    @Column(name = "id")
    private Long id;

    @Column(name = "rua_logra", nullable = false)
    private String ruaLogra;

    @Column(name = "cep", nullable = false)
    private String cep;

    @Column(name = "numero", nullable = false)
    private String numero;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "bairro", nullable = false)
    private String bairro;

    @Column(name = "uf", nullable = false)
    private String uf;

    @Column(name = "cidade", nullable = false)
    private String cidade;

    @ManyToOne(targetEntity = Pessoa.class)
    @JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
    private Pessoa pessoa;

    @Enumerated(EnumType.STRING)
    private TipoEndereco tipoEndereco;

}
