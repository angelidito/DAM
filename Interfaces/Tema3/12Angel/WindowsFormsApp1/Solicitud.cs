using System;
using System.Windows.Forms;

namespace WindowsFormsApp1
{
	public partial class Solicitud : Form
	{
		public Solicitud(String nombre)
		{
		
			lblTitulo.Text = nombre;
			InitializeComponent();
		}

		private void btnSalir_Click(object sender, EventArgs e)
		{
			this.Close();
		}

		private void btnConfirmarSolicitud_Click(object sender, EventArgs e)
		{

		}
	}
}
