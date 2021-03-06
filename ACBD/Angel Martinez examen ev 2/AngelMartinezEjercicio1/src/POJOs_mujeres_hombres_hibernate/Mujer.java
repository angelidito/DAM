package POJOs_mujeres_hombres_hibernate;
// Generated 17-feb-2022 9:22:01 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Mujer generated by hbm2java
 */
@Entity
@Table(name="mujer"
    ,catalog="mujeres_hombres_hibernate"
)
public class Mujer  implements java.io.Serializable {


     private int idMujer;
     private Hombre hombre;
     private String nombreMujer;
     private Integer edadMujer;

    public Mujer() {
    }

	
    public Mujer(int idMujer) {
        this.idMujer = idMujer;
    }
    public Mujer(int idMujer, Hombre hombre, String nombreMujer, Integer edadMujer) {
       this.idMujer = idMujer;
       this.hombre = hombre;
       this.nombreMujer = nombreMujer;
       this.edadMujer = edadMujer;
    }
   
     @Id 

    
    @Column(name="id_mujer", unique=true, nullable=false)
    public int getIdMujer() {
        return this.idMujer;
    }
    
    public void setIdMujer(int idMujer) {
        this.idMujer = idMujer;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_marido_fk")
    public Hombre getHombre() {
        return this.hombre;
    }
    
    public void setHombre(Hombre hombre) {
        this.hombre = hombre;
    }

    
    @Column(name="nombre_mujer")
    public String getNombreMujer() {
        return this.nombreMujer;
    }
    
    public void setNombreMujer(String nombreMujer) {
        this.nombreMujer = nombreMujer;
    }

    
    @Column(name="edad_mujer")
    public Integer getEdadMujer() {
        return this.edadMujer;
    }
    
    public void setEdadMujer(Integer edadMujer) {
        this.edadMujer = edadMujer;
    }




}


