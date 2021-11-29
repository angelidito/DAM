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
		}

		private void LblTitulo_Click(object sender, EventArgs e)
		{

		}

		private void btnSolicitarPrestamo_Click(object sender, EventArgs e)
		{
		}

		private void TextBox1_TextChanged(object sender, EventArgs e)
		{
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

		private void BancoForm_Load(object sender, EventArgs e)
		{

		}
	}
}
