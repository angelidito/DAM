using System;

namespace Tarea_Biblioteca_12Angel
{
	internal class Biblioteca
	{
		public Libro[] listaLibros;

		public Biblioteca(int capacidad)
		{
			this.listaLibros = new Libro[capacidad];
		}

		public int NumeroLibros()
		{
			int num;

			num = 0;
			foreach (Libro l in listaLibros)
				if (l != null)
					num++;
			return num;
		}

		public void AñadirLibro(Libro nuevoLibro)
		{
			bool añadido;

			añadido = false;
			for (int i = 0; i < listaLibros.Length && !añadido; i++)
				if (listaLibros[i] == null)
				{
					listaLibros[i] = nuevoLibro;
					añadido = true;
				}
			if (!añadido)
				Console.WriteLine("No queda espacio en la biblioteca. No se pueden añadir más libros");
		}

		public void BorrarLibro(string titulo)
		{
			bool borrado;
			Libro libro;

			borrado = false;
			for (int i = 0; i < listaLibros.Length && !borrado; i++)
			{
				libro = listaLibros[i];
				if (libro != null && String.Equals(libro.ObtenerTitulo(), titulo))
				{
					listaLibros[i] = null;
					borrado = true;
				}
			}
			if (borrado)
				Console.WriteLine("Se ha borrado {0}.", titulo);
			else
				Console.WriteLine("No se ha borrado {0}.", titulo);
		}

		public void Mostrar()
		{
			bool hayLibros = false;
			foreach (Libro libro in listaLibros)
				if (libro != null)
				{
					libro.Mostrar();
					hayLibros = true;
				}
			if (!hayLibros)
				Console.WriteLine("No hay libros en la biblioteca.");
		}
	}


}

