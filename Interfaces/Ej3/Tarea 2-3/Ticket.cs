using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace Tarea_2_3
{
	public partial class Ticket : Form
	{
		public Ticket(String nombre, String pista, String hora, String precio, String padron)
		{
			InitializeComponent();

			String[] texto = new String[7];

			int i = 0;
			texto[i++]= "Ticket de reserva nº: " + new Random().Next(10000,99999);
			texto[i++]= "Lugar: "+ pista;
			texto[i++]= "Reservante: " + nombre;
			texto[i++]= "Padrón: " + (padron== null? "NO": padron);
			texto[i++]= "Fecha: " + DateTime.Today.ToString("d");
			texto[i++]= "Hora: " + hora;
			texto[i++]= "Precio: " + precio;

			ticketText.Lines = texto;
		}
	}
}
