/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jpamapping;

import com.mycompany.entity.Categories;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author tss
 */
public class App {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_JpaMapping_jar_1.0PU");
        EntityManager em = emf.createEntityManager();
        List<Categories> cat = em.createQuery("select e from Categories e order by e.categoryName", Categories.class).getResultList();

        cat.forEach(v -> System.out.println(v.getCategoryName()));
    }

}
