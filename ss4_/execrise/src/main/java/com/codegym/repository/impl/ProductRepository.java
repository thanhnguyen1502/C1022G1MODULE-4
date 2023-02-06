package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.ConnectionUtil;
import com.codegym.repository.IProductRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {


    @Override
    public List<Product> findAll() {
        List<Product> productList = null;
        Session session = ConnectionUtil.sessionFactory.openSession();
        productList = session.createQuery("FROM Product", Product.class).getResultList();
        session.close();
        return productList;
    }

    @Override
    public void add(Product product) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.save(product);
        transaction.commit();
        session.close();

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void remove(int id) {
    Product product = ConnectionUtil.entityManager.find(Product.class, id);
        EntityTransaction entityTransaction = ConnectionUtil.entityManager.getTransaction();
        entityTransaction.begin();
        ConnectionUtil.entityManager.remove(product);
        entityTransaction.commit();
    }

    @Override
    public Product findByName(String name) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Product> query = session.createQuery("from Product as p where name =:name");
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    @Override
    public Product findById(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Product> query = session.createQuery("from Product as p where id = : id");
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Product showDetail(int id) {

        return null;
    }
}
