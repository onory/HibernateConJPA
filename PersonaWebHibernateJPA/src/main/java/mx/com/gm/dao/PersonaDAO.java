/*
 * Clase que aplica patron DAO
*contendra las operaciones basicas de consulta para DB
 */
package mx.com.gm.dao;

import java.util.List;
import javax.persistence.*;
import mx.com.gm.domain.Persona;

public class PersonaDAO {
    
    private EntityManagerFactory emf;
    private EntityManager em;
    
    //constructor
    
    public PersonaDAO(){
                                               //unidad de persistencia declarada en percistence
    emf = Persistence.createEntityManagerFactory("HibernatePU");
    em = emf.createEntityManager();
    
    }
    
    //metodo de listar
    
    public List<Persona> listar(){
                                  //Persona refiere a la clase
        String hq1= "SELECT p FROM Persona p"; // se crea la consulta a ejecutar
        Query query = em.createQuery(hq1); // recupera la consulta como objeto
        List<Persona> personas = query.getResultList(); // recupera por query el metodo getREsultList la lista de persona    
    
       return personas;
    
    }
    
    //metodo insertar
    // para insertar se requiere una transaccion
    
    public void insertar(Persona persona){
      
     try{ //se genera una excepcion para rollback en caso de fallo al insertar
         
     
        em.getTransaction().begin(); // inicia transaccion
        em.persist(persona);// guarda el objeto en DB
        em.getTransaction().commit();// se hace comit de la transaccion
        
    }catch(Exception ex){
        
        ex.printStackTrace(System.out);
        em.getTransaction().rollback(); // se llama el rollback
    }
     finally{
         if(em != null){
             em.close(); // se cierra transaccion en JEE se cierra en automatico y puede omitirse
         }
     }
        
    }
    
    //Metodo UPDATE
    
    public void modificar(Persona persona){
      
     try{ //se genera una excepcion para rollback en caso de fallo al insertar
         
     
        em.getTransaction().begin(); // inicia transaccion
        em.merge(persona);// sincroniza el estado del objeto con la DB para actualizarla
        em.getTransaction().commit();// se hace comit de la transaccion
        
    }catch(Exception ex){
        
        ex.printStackTrace(System.out);
        em.getTransaction().rollback(); // se llama el rollback
    }
     /*finally{
         if(em != null){
             em.close(); // se cierra transaccion en JEE se cierra en automatico y puede omitirse
         }
     }*/
        
    }
    //metodo para buscar persona, se usa para generar el merge antes de hacer un update
    public Persona buscarPersonaId(Persona p){
        
        return em.find(Persona.class, p.getIdPersona()); //busca el objeto de persona
    }
    
    
     //Metodo DLEETE
    
    public void eliminar (Persona persona){
        
       try{ //se genera una excepcion para rollback en caso de fallo al insertar
         
     
        em.getTransaction().begin(); // inicia transaccion
        em.remove(em.merge(persona));// sincroniza el estado del objeto con la DB para despues aplicar remove
        em.getTransaction().commit();// se hace comit de la transaccion
        
    }catch(Exception ex){
        
        ex.printStackTrace(System.out);
        em.getTransaction().rollback(); // se llama el rollback
    } 
        
    }
}
