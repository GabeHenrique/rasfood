package br.com.rasmoo.restaurante.dao;

import br.com.rasmoo.restaurante.model.Categoria;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CategoriaDao {

  private final EntityManager entityManager;

  public CategoriaDao(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public void cadastrar(final Categoria categoria) {
    this.entityManager.getTransaction().begin();
    this.entityManager.persist(categoria);
    this.entityManager.getTransaction().commit();
  }

  public Categoria consultarPorId(final Integer id) {
    return this.entityManager.find(Categoria.class, id);
  }

  public List<Categoria> consultarTodos() {
    var query = "SELECT c FROM Categoria c";
    return this.entityManager.createQuery(query, Categoria.class).getResultList();
  }

  public void atualizar(final Categoria categoria) {
    this.entityManager.getTransaction().begin();
    this.entityManager.merge(categoria);
    this.entityManager.getTransaction().commit();
    this.entityManager.close();
  }

  public void deletar(final Categoria categoria) {
    this.entityManager.getTransaction().begin();
    this.entityManager.remove(categoria);
    this.entityManager.getTransaction().commit();
  }

}
