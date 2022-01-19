package uno;

public class Name {
	private String nombre = null;
	private String origen = null;
	private String nacional = null;
	private String significado = null;
	private String abstracto = null;

	public Name() {
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getOrigen() {
		return this.origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getNacional() {
		return this.nacional;
	}

	public void setNacional(String nacional) {
		this.nacional = nacional;
	}

	public String getSignificado() {
		return this.significado;
	}

	public void setSignificado(String significado) {
		this.significado = significado;
	}

	public String getAbstracto() {
		return this.abstracto;
	}

	public void setAbstracto(String abstracto) {
		this.abstracto = abstracto;
	}

	@Override
	public String toString() {
		return "{" + " nombre='" + getNombre() + "'" + ", origen='" + getOrigen() + "'" + ", nacional='" + getNacional()
				+ "'" + ", significado='" + getSignificado() + "'" + ", abstracto='" + getAbstracto() + "'" + "}";
	}

}
