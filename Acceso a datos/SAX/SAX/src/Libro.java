public class Libro {
	private String publicacdoEn;
	private String titulo;
	private String Autor;

	public Libro() {
	}


	public Libro(String publicacdoEn, String titulo, String Autor) {
		this.publicacdoEn = publicacdoEn;
		this.titulo = titulo;
		this.Autor = Autor;
	}

	public String getPublicacdoEn() {
		return this.publicacdoEn;
	}

	public void setPublicacdoEn(String publicacdoEn) {
		this.publicacdoEn = publicacdoEn;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return this.Autor;
	}

	public void setAutor(String Autor) {
		this.Autor = Autor;
	}



	
}
