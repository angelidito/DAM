using System;
using System.Linq;
using System.Windows.Forms;

namespace WindowsFormsApp1
{
	public partial class Banco : Form
	{
		public Banco()
		{
			InitializeComponent();
			btnSolicitarPrestamo.Enabled = false;
		}

		private void ControlBotones()
		{
			if (nombre.Text.Trim() != string.Empty && nombre.Text.All(Char.IsLetter))
			{
				btnSolicitarPrestamo.Enabled = true;
				errorProvider1.SetError(nombre, "");
			}
			else
			{
				btnSolicitarPrestamo.Enabled = false;

				if (!nombre.Text.All(Char.IsLetter))
				{
					errorProvider1.SetError(nombre, "El nombre sólo debe contener lertas");
				}
				else
				{
					errorProvider1.SetError(nombre, "");
				}
			}
		}

		private void btnSalir_Click(object sender, EventArgs e)
		{
			this.Close();
		}

		private void nombre_TextChanged(object sender, EventArgs e)
		{
			ControlBotones();
		}

		private void btnSolicitarPrestamo_Click(object sender, EventArgs e)
		{
			new Solicitud(nombre.Text.Trim()).Show();
		}
	}
}
