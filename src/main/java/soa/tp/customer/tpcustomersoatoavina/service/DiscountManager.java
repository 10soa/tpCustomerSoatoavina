/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soa.tp.customer.tpcustomersoatoavina.service;

import soa.tp.customer.tpcustomersoatoavina.entity.Discount;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;

/**
 * Façade pour gérer les Discount_Code
 *
 * @author Soa
 */
@RequestScoped
public class DiscountManager {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager dm;

    @Transactional
    public void persist(Discount discount) {
        dm.persist(discount);
    }

    public List<Discount> getAllDiscounts() {
        Query query = dm.createNamedQuery("Discount.findAll");
        return query.getResultList();
    }

    public Discount findById(String code) {
        return dm.find(Discount.class, code);
    }

    /**
     * trier discount par ordre croissant
     * @return
     */
    public List<Discount> getAllDiscountsAsc() {
        Query query = dm.createQuery("SELECT dis FROM Discount dis ORDER BY dis.rate ASC");
        return query.getResultList();
    }

    /**
     * trier discount par ordre decroisssant
     * @return
     */
    public List<Discount> getAllDiscountsDesc() {
        Query query = dm.createQuery("SELECT dis FROM Discount dis ORDER BY dis.rate DESC");
        return query.getResultList();
    }
}
