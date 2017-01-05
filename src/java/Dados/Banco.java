package Dados;

import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Banco {
    
    private static Banco instance;
    
    protected EntityManager entityManager;
    
    public Banco(){
    }
    
    public EntityManager Acesso(){
        if (entityManager == null)
            entityManager = getEntityManager();
        
        return entityManager;
    }
    
    public static Banco getInstance(){
        
        if (instance == null)
            instance = new Banco();
        
        return instance;
    }
    
    private EntityManager getEntityManager(){
        
        try{
        
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("FrotaPersistencia");
            if (entityManager == null)
                entityManager = factory.createEntityManager();
                
        } catch (Exception e) {
            Logger.getGlobal().info("EntityManager:Frotas::::::  " + e.toString());
        } finally {
            return entityManager;
        }
    }
}