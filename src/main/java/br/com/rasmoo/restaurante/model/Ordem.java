package br.com.rasmoo.restaurante.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ManyToAny;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cd_ordem")
public class Ordem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_ordem")
  private Integer id;
  @Column(name = "valor_total")
  private BigDecimal valorTotal;
  @Column(name = "data_criacao")
  @Builder.Default
  private LocalDateTime dataCriacao = LocalDateTime.now();

  @ManyToOne(targetEntity = Cliente.class)
  @JoinColumn(name = "id_cliente")
  private Cliente cliente;

  @ManyToMany(targetEntity = ItemCardapio.class)
  @JoinTable(name = "cd_ordem_item",
      joinColumns = @JoinColumn(name = "id_ordem"),
      inverseJoinColumns = @JoinColumn(name = "id_item"))
  private List<ItemCardapio> item;
}
