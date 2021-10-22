using System;

namespace Tarea_Biblioteca_12Angel
{
	internal class Autor
	{
		private string nombre;
		private string apellidos;

		public Autor(string nombre, string apellidos)
		{
			this.nombre = nombre;
			this.apellidos = apellidos;
		}

		public void Mostrar()
		{
			Console.Write("{0}, {1}", apellidos, nombre);
		}
	}
}
