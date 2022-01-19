package SAX.tres;

public class Jugador {

	private int num_jugador;
	private Boolean capitan;
	private String nombre;
	private String equipo;
	private int salario;

	public Jugador() {
	}

	public int getNum_jugador() {
		return this.num_jugador;
	}

	public void setNum_jugador(String num_jugador) {
		this.num_jugador = Integer.parseInt(num_jugador);
	}

	public Boolean isCapitan() {
		return this.capitan;
	}

	public Boolean getCapitan() {
		return this.capitan;
	}

	public void setCapitan(String capitan) {
		this.capitan = capitan.compareTo("SI") == 0;
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

	public int getSalario() {
		return this.salario;
	}

	public void setSalario(String salario) {
		this.salario =Integer.parseInt(salario);
	}

	@Override
	public String toString() {
		return "{" + " num_jugador='" + getNum_jugador() + "'" + ", capitan='" + isCapitan() + "'" + ", nombre='"
				+ getNombre() + "'" + ", equipo='" + getEquipo() + "'" + ", salario='" + getSalario() + "'" + "}";
	}

}
