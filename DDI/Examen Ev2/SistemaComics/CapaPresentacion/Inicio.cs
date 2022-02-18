﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using CapaEntidad;
using CapaNegocio;
using FontAwesome.Sharp;

namespace CapaPresentacion
{
    public partial class Inicio : Form
    {
        private static Usuario usuarioActual;
        private static IconMenuItem MenuActivo = null;
        private static Form FormularioActivo = null;

        public Inicio(Usuario objusuario)
        {
            usuarioActual = objusuario;
            InitializeComponent();
        }

        private void Inicio_Load(object sender, EventArgs e)
        {
            lblUsuario.Text = usuarioActual.NombreCompleto;
            //List<Permiso> ListaPermisos = new CN_Permiso().Listar(usuarioActual.IdPersona);

            //foreach (IconMenuItem iconMenu in Menu.Items){
            //    bool encontrado = ListaPermisos.Any(m => m.NombreMenu == iconMenu.Name);
            //    if (encontrado  == true)
            //    {
            //        iconMenu.Visible = false;
            //    }
            //}
        }

        private void AbrirFormulario(IconMenuItem menu, Form formulario)
        {
            if (MenuActivo != null)
            {
                MenuActivo.BackColor = Color.White;
            }
            menu.BackColor = Color.Silver;
            MenuActivo = menu;

            if (FormularioActivo != null)
            {
                FormularioActivo.Close();
            }

            FormularioActivo = formulario;
            formulario.TopLevel = false;
            formulario.FormBorderStyle = FormBorderStyle.None;
            formulario.Dock = DockStyle.Fill;
            formulario.BackColor = Color.SteelBlue;
            contenedor.Controls.Add(formulario);
            formulario.Show();
        }

        private void menuusarios_Click(object sender, EventArgs e)
        {
            AbrirFormulario(menuMantenedor, new frmProductos());
        }

        private void submenucategoria_Click(object sender, EventArgs e)
        {
        }

        private void submenuproducto_Click(object sender, EventArgs e)
        {
        }

        private void submenuregistrarventa_Click(object sender, EventArgs e)
        {
        }

        private void submenudetalleventa_Click(object sender, EventArgs e)
        {
        }

        private void submenuregistracompra_Click(object sender, EventArgs e)
        {
        }

        private void submenudetallecompra_Click(object sender, EventArgs e)
        {
        }

        private void menuclientes_Click(object sender, EventArgs e)
        {
        }

        private void menuproveedores_Click(object sender, EventArgs e)
        {
        }

        private void menuinformes_Click(object sender, EventArgs e)
        {
        }

        private void contenedor_Paint(object sender, PaintEventArgs e)
        {

        }

        private void MenuTitulo_ItemClicked(object sender, ToolStripItemClickedEventArgs e)
        {
        }

		private void label2_Click(object sender, EventArgs e)
		{

		}
	}
}
