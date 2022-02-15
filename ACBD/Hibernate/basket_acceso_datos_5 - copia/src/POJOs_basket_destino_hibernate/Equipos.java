package POJOs_basket_destino_hibernate;
// Generated 14-feb-2022 9:56:50 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Equipos generated by hbm2java
 */
@Entity
@Table(name="equipos"
    ,catalog="basket_destino"
)
public class Equipos  implements java.io.Serializable {


     private Integer idEquipo;
     private String nombreEquipo;
     private String ciudad;
     private String web;
     private Integer puntos;
     private Set<Partidos> partidosesForElocal = new HashSet<Partidos>(0);
     private Set<Partidos> partidosesForEvisitante = new HashSet<Partidos>(0);
     private Set<Jugadores> jugadoreses = new HashSet<Jugadores>(0);

    public Equipos() {
    }

	
    public Equipos(String nombreEquipo, String ciudad) {
        this.nombreEquipo = nombreEquipo;
        this.ciudad = ciudad;
    }
    public Equipos(String nombreEquipo, String ciudad, String web, Integer puntos, Set<Partidos> partidosesForElocal, Set<Partidos> partidosesForEvisitante, Set<Jugadores> jugadoreses) {
       this.nombreEquipo = nombreEquipo;
       this.ciudad = ciudad;
       this.web = web;
       this.puntos = puntos;
       this.partidosesForElocal = partidosesForElocal;
       this.partidosesForEvisitante = partidosesForEvisitante;
       this.jugadoreses = jugadoreses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_equipo", unique=true, nullable=false)
    public Integer getIdEquipo() {
        return this.idEquipo;
    }
    
    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    
    @Column(name="nombre_equipo", nullable=false, length=30)
    public String getNombreEquipo() {
        return this.nombreEquipo;
    }
    
    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    
    @Column(name="ciudad", nullable=false, length=30)
    public String getCiudad() {
        return this.ciudad;
    }
    
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    
    @Column(name="web", length=50)
    public String getWeb() {
        return this.web;
    }
    
    public void setWeb(String web) {
        this.web = web;
    }

    
    @Column(name="puntos")
    public Integer getPuntos() {
        return this.puntos;
    }
    
    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="equiposByElocal")
    public Set<Partidos> getPartidosesForElocal() {
        return this.partidosesForElocal;
    }
    
    public void setPartidosesForElocal(Set<Partidos> partidosesForElocal) {
        this.partidosesForElocal = partidosesForElocal;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="equiposByEvisitante")
    public Set<Partidos> getPartidosesForEvisitante() {
        return this.partidosesForEvisitante;
    }
    
    public void setPartidosesForEvisitante(Set<Partidos> partidosesForEvisitante) {
        this.partidosesForEvisitante = partidosesForEvisitante;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="equipos")
    public Set<Jugadores> getJugadoreses() {
        return this.jugadoreses;
    }
    
    public void setJugadoreses(Set<Jugadores> jugadoreses) {
        this.jugadoreses = jugadoreses;
    }




}

