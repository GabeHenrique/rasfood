package br.com.rasmoo.restaurante.dao;

import br.com.rasmoo.restaurante.model.ItemCardapio;
import jakarta.persistence.EntityManager;

import java.util.Collections;
import java.util.List;

public class ItemCardapioDao {

  private final EntityManager entityManager;

  public ItemCardapioDao(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public void cadastrar(final ItemCardapio itemCardapio) {
    this.entityManager.getTransaction().begin();
    this.entityManager.persist(itemCardapio);
    this.entityManager.getTransaction().commit();
  }

  public ItemCardapio consultarPorId(final Integer id) {
    return this.entityManager.find(ItemCardapio.class, id);
  }

  public List<ItemCardapio> consultarTodos() {
    try {
      var query = "SELECT c FROM ItemCardapio c";
      return this.entityManager.createQuery(query, ItemCardapio.class).getResultList();
    } catch (Exception e) {
      return Collections.emptyList();
    }
  }

  public List<ItemCardapio> consultarPorNome(String param) {
    try {
      var query = "SELECT c FROM ItemCardapio c WHERE c.nome ilike :param or c.descricao ilike :param";
      return this.entityManager.createQuery(query, ItemCardapio.class)
          .setParameter("param", "%" + param + "%")
          .getResultList();
    } catch (Exception e) {
      return Collections.emptyList();
    }
  }

  public void atualizar(final ItemCardapio itemCardapio) {
    this.entityManager.getTransaction().begin();
    this.entityManager.merge(itemCardapio);
    this.entityManager.getTransaction().commit();
    this.entityManager.close();
  }

  public void deletar(final ItemCardapio itemCardapio) {
    this.entityManager.getTransaction().begin();
    this.entityManager.remove(itemCardapio);
    this.entityManager.getTransaction().commit();
  }

}
