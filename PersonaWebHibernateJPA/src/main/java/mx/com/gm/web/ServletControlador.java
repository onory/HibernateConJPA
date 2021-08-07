/*
 * Servlet controlador, extiende de HttpServlet
 */
package mx.com.gm.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import mx.com.gb.servicio.ServicioPersonas;
import mx.com.gm.domain.Persona;

@WebServlet("/ServletControlador") // se indica Pat que es un Servlet y el nombre para acceder
public class ServletControlador extends  HttpServlet {
    
    //Procesamos la peticion
    @Override //doGet es un metodo que extiende de HttpServlet por ello se sobre escribe
    protected  void doGet(HttpServletRequest request, HttpServletResponse response){
        
        ServicioPersonas servicioPeronas = new ServicioPersonas(); //objeto para usar metodos de ServicioPersonas
                                                                   // en este caso listar personas, como acceso a vista
        List<Persona> personas = servicioPeronas.listarPersonas(); // llamamos a metodo asignandola a la lista
        
        //Seleccionamos el alcance en request
                            //nombre con el q se comparte
                                       //objeto q se comparte
        request.setAttribute("personas",personas);
        
      try{  
          
      
        //redireccionamos al JSP que se seleccionara
        request.getRequestDispatcher("/WEB-INF/listado.jsp").forward(request, response);
        
      }catch(ServletException ex){
          ex.printStackTrace(System.out);
      }catch (IOException ex){
        ex.printStackTrace(System.out);
    }
    
  } 
    
}
