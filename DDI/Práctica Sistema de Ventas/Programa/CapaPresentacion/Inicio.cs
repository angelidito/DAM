using CapaDatos;
using CapaEntidad;
using FontAwesome.Sharp;
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Windows.Forms;

namespace CapaPresentacion
{
	public partial class Inicio : Form
	{
		private static Usuario usuarioActual;
		private static IconMenuItem MenuActivo;
		private static Form Formularioactivo;
		public Inicio(Usuario objUsuario)
		{
			usuarioActual = objUsuario;
			InitializeComponent();
		}

		private void Inicio_Load(object sender, EventArgs e)
		{
			lblUsuario.Text = usuarioActual.NombreCompleto;

			List<Permiso> listaPermisos = new CD_Permiso().Listar(usuarioActual.IdUsuario);
			
			foreach(IconMenuItem iconMenu in Menu.MenuItems)
			{
				bool encontrado = listaPermisos.Any(m => m.NombreMenu == iconMenu.Name);
				if (encontrado == true)
				{
					iconMenu.Visible = false;
				}
			}
		}

		private void AbrirFormulario(IconMenuItem menu, Form formulario)
		{
			if (MenuActivo != null)
			{
				MenuActivo.BackColor = Color.White;
			}
			menu.BackColor = Color.Silver;
			MenuActivo = menu;

			if (Formularioactivo != null)
			{
				Formularioactivo.Close();
			}

			Formularioactivo = formulario;
			formulario.TopLevel = false;
			formulario.FormBorderStyle = FormBorderStyle.None;
			formulario.Dock = DockStyle.Fill;
			formulario.BackColor = Color.SteelBlue;

			contenedor.Controls.Add(formulario);

			formulario.Show();


		}

		private void iconUsuarios_Click(object sender, EventArgs e)
		{
			AbrirFormulario((IconMenuItem) sender, new frmUsuarios());
		}

		private void submenucategoria_Click(object sender, EventArgs e)
		{
			AbrirFormulario((IconMenuItem)sender, new frmCategoria());

		}

		private void submenuproducto_Click(object sender, EventArgs e)
		{
			AbrirFormulario((IconMenuItem)sender, new frmProducto());

		}

		private void submenuregistraventa_Click(object sender, EventArgs e)
		{
			AbrirFormulario((IconMenuItem)sender, new frmVenta());

		}

		private void submenudetalleventa_Click(object sender, EventArgs e)
		{
			AbrirFormulario((IconMenuItem)sender, new frmDetalleVenta());

		}

		private void submenuregistracompra_Click(object sender, EventArgs e)
		{
			AbrirFormulario((IconMenuItem)sender, new frmCompras());

		}

		private void submenudetallecompra_Click(object sender, EventArgs e)
		{
			AbrirFormulario((IconMenuItem)sender, new frmDetalleCompra());

		}

		private void iconClientes_Click(object sender, EventArgs e)
		{
			AbrirFormulario((IconMenuItem)sender, new frmClientes());

		}

		private void iconProveedores_Click(object sender, EventArgs e)
		{
			AbrirFormulario((IconMenuItem)sender, new frmProveedores());

		}

		private void iconReportes_Click(object sender, EventArgs e)
		{
			AbrirFormulario((IconMenuItem)sender, new frmInformes());

		}

	}
}
