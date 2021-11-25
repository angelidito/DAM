package dom;

public class Jugador {

	private String capitan;
	private String nombre;
	private String equipo;
	private String salario;


	public Jugador() {
	}

	public String getCapitan() {
		return this.capitan;
	}

	public void setCapitan(String capitan) {
		this.capitan = capitan;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEquipo() {
		return this.equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public String getSalario() {
		return this.salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "{" +
			" capitan='" + getCapitan() + "'" +
			", nombre='" + getNombre() + "'" +
			", equipo='" + getEquipo() + "'" +
			", salario='" + getSalario() + "'" +
			"}";
	}

}
