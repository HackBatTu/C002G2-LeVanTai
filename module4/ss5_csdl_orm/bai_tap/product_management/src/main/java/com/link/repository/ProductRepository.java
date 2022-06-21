package com.link.repository;

import com.link.model.Product;
import com.link.repository.BaseRepository;
import com.link.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> getAllProduct() {
        TypedQuery<Product> typedQuery = BaseRepository.entityManager.createQuery("select p from Product p",Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        try {
            BaseRepository.entityManager.persist(product);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        }
    }

    @Override
    public Product findById(int id) {
        return BaseRepository.entityManager.find(Product.class,id);
    }

    @Override
    public void delete(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        try {
            BaseRepository.entityManager.remove(BaseRepository.entityManager.find(Product.class,id));
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        }
    }

    @Override
    public void edit(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        try {
            BaseRepository.entityManager.merge(product);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        }
    }

    @Override
    public List<Product> getProductByName(String search) {
        TypedQuery<Product> typedQuery = BaseRepository.entityManager.createQuery("select p from Product p where name like :searchValue",Product.class);
        typedQuery.setParameter("searchValue", "%" + search + "%");
        return typedQuery.getResultList();
    }
}