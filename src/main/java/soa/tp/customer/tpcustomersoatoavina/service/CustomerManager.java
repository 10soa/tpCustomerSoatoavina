/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soa.tp.customer.tpcustomersoatoavina.service;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;
import soa.tp.customer.tpcustomersoatoavina.entity.Customer;

/**
 *
 * @author Soa
 */
@RequestScoped
public class CustomerManager {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;
    
    /**
     * getAllCustomers va exécuter une requête JPQL(langage de requête de JPA) dont le nom est "Customer.findAll", qui est définie dans l'entité Customer déjà écrite (la requête correspond à un "select *" sur les client
     * @return 
     */
    public List<Customer> getAllCustomers() {
        Query query = em.createNamedQuery("Customer.findAll");
        return query.getResultList();
    }
    
    /**
     * donne à gérer à l'entity manager le customer passé en paramètre (méthode merge dont les finesses seront étudiées dans le cours JPA)
     * @param customer
     * @return 
     */
    @Transactional
    public Customer update(Customer customer) {
        return em.merge(customer);
    }
    
    /**
     * ressemble à update, mais le paramètre de type Customer ne doit pas correspondre à des données déjà dans la base de données. persist génèrera un INSERT SQL dans la base de données.
     * @param customer 
     */
    @Transactional
    public void persist(Customer customer) {
        em.persist(customer);
    }
}
