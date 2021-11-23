using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Prog_01_02
{
	public partial class Form1 : Form
	{
		public Form1()
		{
			InitializeComponent();
		}

		private void Form1_Load(object sender, EventArgs e)
		{
			lblMensaje.Text = "";
		}

		private void btnSaludo_Click(object sender, EventArgs e)
		{
			lblMensaje.Text = "Hola, " + tbNombre.Text;
			this.Text = "Prog_01_02";
		}
	}
}
