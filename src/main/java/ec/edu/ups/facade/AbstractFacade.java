/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.facade;

import jakarta.persistence.EntityManager;

/**
 *
 * @author johan
 */
public abstract class AbstractFacade <T>{
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    protected abstract EntityManager getEntityManager();
    
    public void create(T entity){
        getEntityManager().persist(entity);
    }
    
    public void edit(T entity){
        getEntityManager().merge(entity);
        
    }
}