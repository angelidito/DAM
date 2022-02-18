using CapaDatos;
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

		private void btninicio_Click(object sender, EventArgs e)
		{
			//List<Usuario> TEST = new CD_Persona().Listar();


			List<Usuario> users = new CN_Persona().Listar();

			Usuario ousuario = users.Where(u => u.Documento == txtUsuario.Text && u.Clave == txtClave.Text).FirstOrDefault();

			Console.WriteLine("\nUsuarios en la BD: " + users.Count());

			foreach (Usuario u in users)
			{
				Console.WriteLine("documento: +" + u.Documento + "; clave: " + u.Clave);
			}

			if (ousuario != null)
			{
				Inicio form = new Inicio(ousuario);
				form.Show();
				this.Hide();

				form.FormClosing += frm_closing;
				//borrar contenido textbox
				txtUsuario.Text = "";
				txtClave.Text = "";
			}
			else
			{
				MessageBox.Show("usuario erróneo o no existente", "Mensaje", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
			}

		}


		private void frm_closing(object sender, FormClosingEventArgs e)
		{
			this.Show();
		}

		private void Login_Load(object sender, EventArgs e)
		{

		}


	}
}
