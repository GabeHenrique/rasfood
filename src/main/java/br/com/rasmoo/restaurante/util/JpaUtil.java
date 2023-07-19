package br.com.rasmoo.restaurante.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {

  private static final EntityManagerFactory RASFOOD = Persistence.createEntityManagerFactory("rasfood");

  public static EntityManager getEntityManagerRasfood() {
    return RASFOOD.createEntityManager();
  }
}
