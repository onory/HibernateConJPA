/*
 * Clase que se utiliza con java bean o sprint para uso de clases}
 * transaccionales
 */
package mx.com.gb.servicio;

import java.util.List;
import mx.com.gm.dao.PersonaDAO;
import mx.com.gm.domain.Persona;


public class ServicioPersonas {
    
    private PersonaDAO personaDao;
    
//constructos
    public ServicioPersonas (){
    
    this.personaDao = new PersonaDAO(); //inicialisamos objeto
    
    } 
    
    
    //metodo q recupera el listado de personas
    public List<Persona> listarPersonas(){
        
        return this.personaDao.listar(); // el objeto PersonaDao accede a metodo listar
        
        
        
    }
    
    
}
