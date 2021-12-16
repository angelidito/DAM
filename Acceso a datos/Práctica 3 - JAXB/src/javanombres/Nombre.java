
package javanombres;

public class Nombre {
	private String name = null;
	private String origen = null;
	private String nacional = null;
	private String significado = null;
	private String abstracto = null;

	public Nombre() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "{" + " nombre='" + getName() + "'" + ", origen='" + getOrigen() + "'" + ", nacional='" + getNacional()
				+ "'" + ", significado='" + getSignificado() + "'" + ", abstracto='" + getAbstracto() + "'" + "}";
	}

}
