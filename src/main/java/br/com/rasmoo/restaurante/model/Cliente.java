package br.com.rasmoo.restaurante.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cd_cliente")
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_cliente")
  private Integer id;
  @Column(name = "cpjCnpj")
  private String cpfCnpj;
  @Column(name = "nome")
  private String nome;
  @Column(name = "cep")
  private String cep;
}
