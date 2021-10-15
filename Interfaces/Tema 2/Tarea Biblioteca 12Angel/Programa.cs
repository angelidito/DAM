using System;

namespace Tarea_Biblioteca_12Angel
{
	class Program
	{

		private static Biblioteca biblioteca;
		private static int capacidad;
		static void Main(string[] args)
		{
			int opt;

			capacidad = 10;
			biblioteca = new Biblioteca(capacidad);
			do
			{
				Console.WriteLine("Bienvenido a la biblioteca Mori M." +
					"\nDisponemos de capacidad para {0} libros." +
					"\nSiéntase como en casa." +
					"\n1. Añadir libro a la biblioteca." +
					"\n2. Mostrar la biblioteca." +
					"\n3. Borrar libro de la biblioteca." +
					"\n4. Mostrar el número de libros que componen la biblioteca." +
					"\n5. Salir.", capacidad);
				opt = Convert.ToInt32(Console.ReadLine());
				switch (opt)
				{
					case 1:
						AñadirLibro();
						break;
					case 2:
						biblioteca.Mostrar();
						break;
					case 3:
						BorrarLibro();
						break;
					case 4:
						biblioteca.NumeroLibros();
						break;
					case 5:
						Console.WriteLine("Adiós");
						break;

					default:
						Console.WriteLine("Elija una de las opciones disponibles.");
						break;
				}
			} while (opt != 5);
		}

		private static void BorrarLibro()
		{
			string titulo;

			Console.WriteLine("¿Cuál es el título del libro que desea borrar?");
			titulo = Console.ReadLine();
			biblioteca.BorrarLibro(titulo);
		}



		private static void AñadirLibro()
		{
			Libro libro;
			string titulo;
			string nombre;
			string apellidos;
			Autor autor;
			int isbn;

			Console.WriteLine("¿Cuál es el título del libro que desea añadir?");
			titulo = Console.ReadLine();
			Console.WriteLine("¿Cuál es el autor del libro?");
			autor = Console.ReadLine();
			Console.WriteLine("¿Cuál es el ISBN?");
			isbn = Convert.ToInt32(Console.ReadLine());
			libro = new Libro(titulo, isbn, autor);

			biblioteca.BorrarLibro(titulo);
		}
	}
}
