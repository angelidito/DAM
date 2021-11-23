using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Prog_01
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
			this.Text = "";
		}

		private void button1_Click(object sender, EventArgs e)
		{
			lblMensaje.Text = "¡Hola, mundo!";
		}

		private void Mensaje_Click(object sender, EventArgs e)
		{

		}

		private void btnDespedida_Click(object sender, EventArgs e)
		{
			lblMensaje.Text = "¡Adios, mundo cruel!";
		}
	}
}
