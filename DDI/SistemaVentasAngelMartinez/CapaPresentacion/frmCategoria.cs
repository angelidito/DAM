using CapaEntidad;
using CapaNegocio;
using CapaPresentacion.Utilidades;
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Windows.Forms;

namespace CapaPresentacion
{
    public partial class frmCategoria : Form
    {
        public frmCategoria()
        {
            InitializeComponent();
        }

        private void frmCategoria_Load(object sender, EventArgs e)
        {
            cboestado.Items.Add(new OpcionCombo() { Valor = 1, Texto = "ACTIVO" });
            cboestado.Items.Add(new OpcionCombo() { Valor = 0, Texto = "NO ACTIVO" });
            cboestado.DisplayMember = "Texto";
            cboestado.ValueMember = "Valor";
            cboestado.SelectedIndex = 0;

            foreach (DataGridViewColumn columna in dgvdata.Columns)
            {
                if (columna.Visible == true && columna.Name != "btnseleccionar")
                    cbobusqueda.Items.Add(new OpcionCombo() { Valor = columna.Name, Texto = columna.HeaderText });
            }

            cbobusqueda.DisplayMember = "Texto";
            cbobusqueda.ValueMember = "Valor";
            cbobusqueda.SelectedIndex = 0;

            List<Categoria> lista = new CN_Categoria().Listar();
            foreach (Categoria item in lista)
            {
                dgvdata.Rows.Add(new object[] {
                    "",
                    item.IdCategoria,
                    item.Descripcion,
                    item.Estado ? 1 : 0,
                    item.Estado ? "Activo" : "No Activo"
                    });
            }
        }

        private void btnguardar_Click(object sender, EventArgs e)
        {
            string mensaje = string.Empty;

            Categoria objcategoria = new Categoria()
            {

                IdCategoria = Convert.ToInt32(txtId.Text),
                Descripcion = txtdescripcion.Text,
                Estado = Convert.ToInt32(((OpcionCombo)cboestado.SelectedItem).Valor) == 1
            };

            if (objcategoria.IdCategoria == 0)
            {
                int idusuariogenerado = new CN_Categoria().Registrar(objcategoria, out mensaje);
                if (idusuariogenerado != 0)
                {
                    dgvdata.Rows.Add(new object[]{
                        "",
                        txtId.Text,
                        txtdescripcion.Text,
                        ((OpcionCombo)cboestado.SelectedItem).Valor.ToString(),
                        ((OpcionCombo)cboestado.SelectedItem).Texto.ToString()
                    });
                    Limpiar();
                }
                else
                {
                    MessageBox.Show(mensaje);
                }
                // return;
            }
            else
            {
                bool resultado = new CN_Categoria().Editar(objcategoria, out mensaje);

                if (!resultado)
                {
                    DataGridViewRow row = dgvdata.Rows[Convert.ToInt32(txtIndice.Text)];
                    row.Cells["Id"].Value = txtId.Text;
                    row.Cells["Descripcion"].Value = txtdescripcion.Text;
                    row.Cells["EstadoValor"].Value = ((OpcionCombo)cboestado.SelectedItem).Valor.ToString();
                    row.Cells["Estado"].Value = ((OpcionCombo)cboestado.SelectedItem).Texto.ToString();
                    MessageBox.Show("Cambios registrados.");
                    Limpiar();
                }
            }
        }
        private void Limpiar()
        {
            txtIndice.Text = "-1";
            txtId.Text = "0";
            txtdescripcion.Text = "";
            cboestado.SelectedIndex = 0;

            txtdescripcion.Select();
        }

        private void btneliminar_Click(object sender, EventArgs e)
        {
            if (Convert.ToInt32(txtId.Text) == 0)
                return;
            if (MessageBox.Show("¿Desea eliminar la categoria?", "Mensaje", MessageBoxButtons.YesNo, MessageBoxIcon.Question) != DialogResult.Yes)
                return;

            string mensaje = string.Empty;
            Categoria objcategoria = new Categoria()
            {
                IdCategoria = Convert.ToInt32(txtId.Text)
            };

            bool respuesta = new CN_Categoria().Eliminar(objcategoria, out mensaje);
            if (!respuesta)
            {
                dgvdata.Rows.RemoveAt(Convert.ToInt32(txtIndice.Text));
                Limpiar();
            }
            else
            {
                MessageBox.Show(mensaje, "Mensaje", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
            }
        }

        private void btnlimpiar_Click(object sender, EventArgs e)
        {
            Limpiar();
        }

        private void btnBuscarC_Click(object sender, EventArgs e)
        {
            if (cbobusqueda.SelectedIndex == -1)
            {
                MessageBox.Show("Seleccione un filtro.", "Mensaje", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }
            if (dgvdata.Rows.Count <= 0)
                return;

            string columna = ((OpcionCombo)cbobusqueda.SelectedItem).Valor.ToString();
            foreach (DataGridViewRow row in dgvdata.Rows)
            {
                if (row.Cells[columna].Value.ToString().Trim().ToUpper().Contains(txtbusqueda.Text.Trim().ToUpper()))
                    row.Visible = true;
                else
                    row.Visible = false;
            }
        }

        private void btnlimpiarbuscador_Click(object sender, EventArgs e)
        {
            txtbusqueda.Text = "";
            cbobusqueda.SelectedIndex = 0;
            foreach (DataGridViewRow row in dgvdata.Rows)
                row.Visible = true;
        }

        private void dgvdata_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            int indice = e.RowIndex;

            if (dgvdata.Columns[e.ColumnIndex].Name != "btnSeleccionar" || indice < 0)
                return;

            txtIndice.Text = indice.ToString();
            txtId.Text = dgvdata.Rows[indice].Cells["IdCategoria"].Value.ToString();
            txtdescripcion.Text = dgvdata.Rows[indice].Cells["Descripcion"].Value.ToString();

            foreach (OpcionCombo oc in cboestado.Items)
            {
                if (Convert.ToInt32(oc.Valor) == Convert.ToInt32(dgvdata.Rows[indice].Cells["EstadoValor"].Value))
                {
                    int indice_combo = cboestado.Items.IndexOf(oc);
                    cboestado.SelectedIndex = indice_combo;
                    break;
                }
            }

        }

        private void dgvdata_CellPainting(object sender, DataGridViewCellPaintingEventArgs e)
        {
            if (e.RowIndex < 0 || e.ColumnIndex != 0)
                return;

            e.Paint(e.CellBounds, DataGridViewPaintParts.All);
            var w = Properties.Resources.ok.Width;
            var h = Properties.Resources.ok.Height;
            var x = e.CellBounds.Left + (e.CellBounds.Width - w) / 2;
            var y = e.CellBounds.Top + (e.CellBounds.Height - h) / 2;
            e.Graphics.DrawImage(Properties.Resources.ok, new Rectangle(x, y, w, h));
            e.Handled = true;
        }

    }
}
