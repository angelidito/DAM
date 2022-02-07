using CapaEntidad;
using CapaNegocio;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Windows.Forms;

namespace CapaPresentacion
{
	public partial class Login : Form
	{
		public Login()
		{
			InitializeComponent();
		}

		private void btnSalir_Click(object sender, EventArgs e)
		{
			this.Close();
		}

		//Este método permite mostrar el Form1 cuando pulses en iniciar sesión
		private void iconLogin_Click(object sender, EventArgs e)
		{
			List<Usuario> TEXT = new CN_Usuario().Listar();

			Usuario ousuario = new CN_Usuario().Listar().Where(u => u.Documento == txtUsuario.Text && u.Clave == txtContra.Text).FirstOrDefault();

			if (ousuario != null)
			{
				Inicio form = new Inicio(ousuario);
				form.Show();
				this.Hide();

				form.FormClosing += frm_closing;
				//borrar contenido textbox usuario y clave
				txtUsuario.Text = "";
				txtContra.Text = "";
			}
			else
			{
				MessageBox.Show("Usuario erroneo o inexistente", "Mensaje", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
			}

		}
		//Este método hace que cuando pulses a la x de cerrar la pestaña, te vuelva al iniciar sesión
		private void frm_closing(object sender, FormClosingEventArgs e)
		{
			this.Show();
		}

		
	}
}
