package com.fabio.loja_virtual.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "forma_pagamento")
@Data
@EqualsAndHashCode
@SequenceGenerator(name = "seq_forma_pagamento", sequenceName = "seq_forma_pagamento", allocationSize = 1, initialValue = 1)
public class FormaPagamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_forma_pagamento")
    private Long id;


    @Column(nullable = false)
    private String descricao;

//    @ManyToOne(targetEntity = PessoaJuridica.class)
//    @JoinColumn(name = "empresa_id", nullable = false,
//            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "empresa_id_fk"))
//    private PessaJuridica empresa;
}
