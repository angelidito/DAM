using CapaEntidad;
using CapaNegocio;
using CapaPresentacion.Utilidades;
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Windows.Forms;


namespace CapaPresentacion
{
	public partial class frmUsuarios : Form
	{
		public frmUsuarios()
		{
			InitializeComponent();
		}

		private void frmUsuarios_Load(object sender, EventArgs e)
		{
			cboestado.Items.Add(new OpcionCombo() { Valor = 1, Texto = "ACTIVO" });
			cboestado.Items.Add(new OpcionCombo() { Valor = 0, Texto = "NO ACTIVO" });
			cboestado.DisplayMember = "Texto";
			cboestado.ValueMember = "Valor";
			cboestado.SelectedIndex = 0;

			List<Rol> listaRol = new CN_Rol().Listar();

			foreach (Rol item in listaRol)
			{
				cborol.Items.Add(new OpcionCombo() { Valor = item.IdRol, Texto = item.Descripcion });
			}
			cborol.DisplayMember = "Texto";
			cborol.ValueMember = "Valor";
			cborol.SelectedIndex = 0;

			foreach (DataGridViewColumn columna in dgvdata.Columns)
			{
				if (columna.Visible == true && columna.Name != "btnseleccionar")
					cbobusqueda.Items.Add(new OpcionCombo() { Valor = columna.Name, Texto = columna.HeaderText });
			}
			cbobusqueda.DisplayMember = "Texto";
			cbobusqueda.ValueMember = "Valor";
			cborol.SelectedIndex = 0;

			//mostrar usuarios
			List<Usuario> listausuario = new CN_Usuario().Listar();

			foreach (Usuario item in listausuario)
			{
				dgvdata.Rows.Add(new object[] {
					"", item.IdUsuario, item.Documento, item.NombreCompleto, item.Correo, item.Clave,
					item.oRol.IdRol, item.oRol.Descripcion,
					item.Estado == true ? 1 : 0,
					item.Estado == true ? "Activo" : "No activo" });
			}
		}

		private void btnguardar_Click(object sender, EventArgs e)
		{
			dgvdata.Rows.Add(new object[]{"", txtId.Text, txtdocumento.Text, txtnombrecompleto.Text, txtcorreo.Text, txtclave.Text,
				((OpcionCombo)cborol.SelectedItem).Valor.ToString(),
				 ((OpcionCombo)cborol.SelectedItem).Texto.ToString(),
				  ((OpcionCombo)cboestado.SelectedItem).Valor.ToString(),
					 ((OpcionCombo)cboestado.SelectedItem).Texto.ToString()
			});

			Limpiar();
		}

		private void Limpiar()
		{
			txtId.Text = "0";
			txtdocumento.Text = "";
			txtnombrecompleto.Text = "";
			txtcorreo.Text = "";
			txtclave.Text = "";
			txtconfirmarclave.Text = "";
			cborol.SelectedIndex = 0;
			cboestado.SelectedIndex = 0;

			//para que situe el foco en el primer combobox de usuario   
			txtdocumento.Select();
		}

		private void dgvdata_CellPainting(object sender, DataGridViewCellPaintingEventArgs e)
		{
			if (e.RowIndex < 0)
				return;
			if (e.ColumnIndex == 0)
			{
				e.Paint(e.CellBounds, DataGridViewPaintParts.All);

				var w = Properties.Resources.ok.Width;
				var h = Properties.Resources.ok.Height;
				var x = e.CellBounds.Left + (e.CellBounds.Width - w) / 2;
				var y = e.CellBounds.Top + (e.CellBounds.Height - h) / 2;

				e.Graphics.DrawImage(Properties.Resources.ok, new Rectangle(x, y, w, h));
			}
		}

		private void dgvdata_CellContentClick(object sender, DataGridViewCellEventArgs e)
		{

		}
	}
}
