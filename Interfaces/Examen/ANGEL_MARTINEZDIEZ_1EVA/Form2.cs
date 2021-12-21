using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ANGEL_MARTINEZDIEZ_1EVA
{
	public partial class Reserva : Form
	{
		public Reserva(String usuario)
		{
			InitializeComponent();

			textBox.Text = "Reserva realizada correctamente para el usuario: " + usuario + ".\nNo se olvide de dejar la sala recogida al acabar.";
		}

		private void cerrar_Click(object sender, EventArgs e)
		{
			this.Close();
		}
	}
}
