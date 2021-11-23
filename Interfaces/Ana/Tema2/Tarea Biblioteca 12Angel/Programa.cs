using System;

namespace Tarea_Biblioteca_12Angel
{
	class Programa
	{

		private static Biblioteca biblioteca;
		static void Main(string[] args)
		{
			biblioteca = new Biblioteca();
			int opt;
			do
			{
				Console.WriteLine("\nBienvenido a la biblioteca Mori M." +
					"\n\t1. Añadir libro a la biblioteca." +
					"\n\t2. Mostrar la biblioteca." +
					"\n\t3. Borrar libro de la biblioteca." +
					"\n\t4. Mostrar el número de libros que componen la biblioteca." +
					"\n\t5. Salir.");
				opt = Convert.ToInt32(Console.ReadLine());
				Console.WriteLine();
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
						Console.WriteLine("Hay {0} libros en la biblioteca.", biblioteca.NumeroLibros());
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
			string titulo;
			int isbn;
			Libro libro;

			Console.WriteLine("¿Cuál es el título del libro que desea añadir?");
			titulo = Console.ReadLine();
			Console.WriteLine("¿Cuál es el ISBN?");
			isbn = Convert.ToInt32(Console.ReadLine());

			libro = new Libro(titulo, isbn);
			libro.AñadirAutor();

			biblioteca.AñadirLibro(libro);
		}
	}
}
