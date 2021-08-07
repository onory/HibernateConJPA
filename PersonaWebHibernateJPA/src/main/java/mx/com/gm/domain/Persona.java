/*
 * clase de entidad que se usara para conectar ala base de dato y se definio en properties.xml
 */
package mx.com.gm.domain;

import java.io.Serializable;
import javax.persistence.*;


@Entity //indica ser una entidad para uso de DB
//@Table(name="nombre de tabla en DB"Persona"") //se usa en caso de no identificar la tabla por diferencias de camel
public class Persona implements Serializable{
    
    private static final long serialVersionUID =1L; // implementa interfase de Serializable
    
    @Column(name="id_persona") // desgina la columna de la tabla para ser utilizada por la variable
                              // se utiliza cuando no coincide el nombre de la tabla con variable
    @Id // indica ser la llave primaria
    private int idPersona;
    
     private String nombre; //el nombre de tabla y variable coincide, no es encesario usar Colum
     private String apellido;
     private String email;
     private String telefono;
     
     //constructor vacio
     
     public Persona(){}

     //GETS y SETS
     
    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", telefono=" + telefono + '}';
    }
     
    
     
}

