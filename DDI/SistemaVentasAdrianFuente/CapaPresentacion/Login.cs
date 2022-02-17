using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

using System.Data;


using CapaNegocio;
using CapaEntidad;
using CapaDatos;




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
            List<Usuario> TEST = new CD_Usuario().Listar();

            Usuario ousuario = new CN_Usuario().Listar().Where(u => u.Documento == txtUsuario.Text && u.Clave == txtClave.Text).FirstOrDefault();

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
