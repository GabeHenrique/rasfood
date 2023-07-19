package br.com.rasmoo.restaurante.service;

import br.com.rasmoo.restaurante.dao.CategoriaDao;
import br.com.rasmoo.restaurante.dao.ItemCardapioDao;
import br.com.rasmoo.restaurante.model.Categoria;
import br.com.rasmoo.restaurante.model.ItemCardapio;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.Scanner;

import static br.com.rasmoo.restaurante.util.JpaUtil.getEntityManagerRasfood;

public class ItemCardapioService {
  public static void main(String[] args) {
    EntityManager entityManager = getEntityManagerRasfood();

    cadastrarItemCardapio(entityManager, cadastrarCategoria(entityManager));

  }

  private static Categoria cadastrarCategoria(EntityManager entityManager) {
    CategoriaDao categoriaDao = new CategoriaDao(entityManager);
    Categoria pratoPrincipal = Categoria.builder()
        .nome("Prato Principal")
        .build();

    categoriaDao.cadastrar(pratoPrincipal);
    entityManager.clear();
    return pratoPrincipal;
  }

  private static void cadastrarItemCardapio(EntityManager entityManager, Categoria categoria) {
    Scanner scanner = new Scanner(System.in);

    ItemCardapio risoto = ItemCardapio.builder()
        .nome("Risoto de Palmito")
        .descricao("Risoto com acompanhamento de cogumelos salteados")
        .disponivel(true)
        .categoria(categoria)
        .valor(BigDecimal.valueOf(69.95))
        .build();

    ItemCardapio salmao = ItemCardapio.builder()
        .nome("Salmão no Vapor")
        .descricao("Salmão cozido no vapor com ervas aromáticas")
        .disponivel(true)
        .categoria(categoria)
        .valor(BigDecimal.valueOf(84.89))
        .build();

    ItemCardapioDao itemCardapioDao = new ItemCardapioDao(entityManager);
    itemCardapioDao.cadastrar(risoto);
    itemCardapioDao.cadastrar(salmao);

    System.out.println(itemCardapioDao.consultarTodos());

    System.out.println("Digite um parâmetro de buscas:");
    var parametro = scanner.next();
    System.out.println(itemCardapioDao.consultarPorNome(parametro));

    entityManager.clear();
  }
}
