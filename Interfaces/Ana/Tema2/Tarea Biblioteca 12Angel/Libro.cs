using System;

namespace Tarea_Biblioteca_12Angel
{
	internal class Libro
	{
		private string titulo;
		private int isbn;
		private Autor autor = null;

		public Libro(string titulo, int isbn)
		{
			this.titulo = titulo;
			this.isbn = isbn;
		}

		public void AñadirAutor()
		{
			String nombre;
			String apellidos;

			Console.WriteLine("Respecto al autor del libro:\n    - ¿Cuál es su nombre?");
			nombre = Console.ReadLine();

			Console.WriteLine("    - ¿Cómo se apellida?");
			apellidos = Console.ReadLine();

			this.autor = new Autor(nombre, apellidos);
		}

		public void Mostrar()
		{
			Console.Write("{0}", titulo);
			if (this.autor != null)
			{
				Console.Write(" - ");
				autor.Mostrar();
			}
			Console.WriteLine("; ISBN: {0}", isbn);
		}

		public string ObtenerTitulo()
		{
			return titulo;
		}
	}
}
