package br.com.rasmoo.restaurante.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cd_cardapio_item")
public class ItemCardapio {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_item")
  private Integer id;
  @Column(name = "nome")
  private String nome;
  @Column(name = "descricao")
  private String descricao;
  @Column(name = "ind_disponivel")
  private Boolean disponivel;
  @Column(name = "valor")
  private BigDecimal valor;
  @Column(name = "data_registro")
  @Builder.Default
  private LocalDate dataRegistro = LocalDate.now();

  @ManyToOne(targetEntity = Categoria.class)
  @JoinColumn(name = "id_categoria")
  private Categoria categoria;

  @Override
  public String toString() {
    return "Prato{" +
        "id=" + id +
        ", nome='" + nome + '\'' +
        ", descricao='" + descricao + '\'' +
        ", disponivel=" + disponivel +
        ", valor=" + valor +
        ", dataRegistro=" + dataRegistro +
        '}';
  }
}
