using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tarea_Biblioteca_12Angel
{
    internal class Libro
    {
		private string titulo;
		private int isbn;
		private Autor autor;

		public Libro(string titulo, int isbn, Autor autor)
		{
			this.titulo = titulo;
			this.isbn = isbn;
			this.autor = autor;
		}

		public void AñadirAutor(Autor autor)
		{
			this.autor = autor;
		}

		public void Mostrar()
		{
			Console.Write("{0} - ", titulo);
			autor.Mostrar();
			Console.WriteLine("; ISBN: {0}", isbn);
		}

		public string ObtenerTitulo()
		{
			return titulo;
		}
	}
}
