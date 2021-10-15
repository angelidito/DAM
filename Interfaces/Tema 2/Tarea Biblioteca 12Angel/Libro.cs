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
			Console.WriteLine("{0} - {1}; ISBN: {2}", titulo, autor, isbn);
		}

		public string ObtenerTitulo()
		{
			return titulo;
		}
	}
}
