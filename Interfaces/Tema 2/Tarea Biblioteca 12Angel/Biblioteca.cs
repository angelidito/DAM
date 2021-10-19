using System;
using System.Collections.Generic;

namespace Tarea_Biblioteca_12Angel
{
	internal class Biblioteca
	{
		public List<Libro> listaLibros;

		public Biblioteca(int capacidad)
		{
			this.listaLibros = new List<Libro>();
		}

		public int NumeroLibros()
		{
			return listaLibros.Count;
		}

		public void AñadirLibro(Libro libro)
		{
			listaLibros.Add(libro);
		}

		public void BorrarLibro(string titulo)
		{
			bool borrado;
			Libro libro;

			borrado = false;
			for (int i = 0; i < listaLibros.Count && !borrado; i++)
			{
				libro = listaLibros[i];
				if (libro != null && String.Equals(libro.ObtenerTitulo(), titulo))
				{
					listaLibros.RemoveAt(i);
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
			if (NumeroLibros() == 0)
				Console.WriteLine("No hay libros en la biblioteca.");
			else
				foreach (Libro libro in listaLibros)
					if (libro != null)
						libro.Mostrar();
		}
	}


}

