package POJOs_origen;
// Generated 31-ene-2022 10:13:35 by Hibernate Tools 4.3.1



/**
 * Partidos generated by hbm2java
 */
public class Partidos  implements java.io.Serializable {


     private PartidosId id;
     private Equipos equiposByElocal;
     private Equipos equiposByEvisitante;
     private String resultado;
     private Integer resultadolocal;
     private Integer resultadovisitante;
     private Integer arbitro;

    public Partidos() {
    }

	
    public Partidos(PartidosId id, Equipos equiposByElocal, Equipos equiposByEvisitante) {
        this.id = id;
        this.equiposByElocal = equiposByElocal;
        this.equiposByEvisitante = equiposByEvisitante;
    }
    public Partidos(PartidosId id, Equipos equiposByElocal, Equipos equiposByEvisitante, String resultado, Integer resultadolocal, Integer resultadovisitante, Integer arbitro) {
       this.id = id;
       this.equiposByElocal = equiposByElocal;
       this.equiposByEvisitante = equiposByEvisitante;
       this.resultado = resultado;
       this.resultadolocal = resultadolocal;
       this.resultadovisitante = resultadovisitante;
       this.arbitro = arbitro;
    }
   
    public PartidosId getId() {
        return this.id;
    }
    
    public void setId(PartidosId id) {
        this.id = id;
    }
    public Equipos getEquiposByElocal() {
        return this.equiposByElocal;
    }
    
    public void setEquiposByElocal(Equipos equiposByElocal) {
        this.equiposByElocal = equiposByElocal;
    }
    public Equipos getEquiposByEvisitante() {
        return this.equiposByEvisitante;
    }
    
    public void setEquiposByEvisitante(Equipos equiposByEvisitante) {
        this.equiposByEvisitante = equiposByEvisitante;
    }
    public String getResultado() {
        return this.resultado;
    }
    
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    public Integer getResultadolocal() {
        return this.resultadolocal;
    }
    
    public void setResultadolocal(Integer resultadolocal) {
        this.resultadolocal = resultadolocal;
    }
    public Integer getResultadovisitante() {
        return this.resultadovisitante;
    }
    
    public void setResultadovisitante(Integer resultadovisitante) {
        this.resultadovisitante = resultadovisitante;
    }
    public Integer getArbitro() {
        return this.arbitro;
    }
    
    public void setArbitro(Integer arbitro) {
        this.arbitro = arbitro;
    }




}


