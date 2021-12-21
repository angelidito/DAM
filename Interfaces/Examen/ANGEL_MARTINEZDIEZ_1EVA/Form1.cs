using System;
using System.Collections.Generic;
using System.Windows.Forms;

namespace ANGEL_MARTINEZDIEZ_1EVA
{
	public partial class Form1 : Form
	{
		String usuarioActivo = "M. Rajoy";

		ComboBox[] salas = new ComboBox[3];

		int[,] horarios = {
						{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 2, 2, 0, 0 }
						};

		String[,] reservas = {
						{ "disponible", "disponible", "disponible", "disponible", "disponible", "disponible", "disponible", "disponible", "disponible" },
						{ "disponible", "disponible", "disponible", "disponible", "disponible", "disponible", "disponible", "disponible", "disponible" },
						{ "disponible", "disponible", "disponible", "disponible", "disponible",    "comedor",    "comedor", "disponible", "disponible" }
						};

		Dictionary<string, Double> bebidas
			= new Dictionary<string, Double>(){
					{ "agua", 0.5 },
					{ "café y leche", 1 },
					{ "zumo de naranja",1.5 }
			};

		Dictionary<string, Double> bocaditos
			 = new Dictionary<string, Double>(){
					{ "cruasán", 1 },
					{ "jamón", 1.5 },
					{ "vegetal", 2 }
			 };


		int salaSelecionada = -1;
		int indxSelecionado = -1;
		public Form1()
		{
			InitializeComponent();

			salas[0] = sala0;
			salas[1] = sala1;
			salas[2] = sala2;

			actualizarHorarios();

			setRadioButtons();
		}

		private void setRadioButtons()
		{
			//TODO
		}

		private void actualizarHorarios()
		{
			for (int i = 0; i < 3; i++)
			{
				salas[i].Items.Clear();
				for (int j = 0; j < 9; j++)
				{
					String str = (j + 8) + ":00 - " + reservas[i, j];
					salas[i].Items.Add(str);
				}
			}
		}

		private void reservarHora(object sender, EventArgs e)
		{

			checkNumPersonas(null, null);

			if (salaSelecionada == -1)
			{
				errorProvider.SetError(panelSalas, "Escoja una sala.");
				return;
			}
			errorProvider.SetError(panelSalas, "");


			int hora = salas[salaSelecionada].SelectedIndex;

			if (hora == -1 || !checkHoraLibre(hora))
			{
				errorProvider.SetError(panelSalas, "Escoja una hora disponible.");
				return;
			}

			errorProvider.SetError(panelSalas, "");

			horarios[salaSelecionada, hora] = 1;
			reservas[salaSelecionada, hora] = usuarioActivo;
			actualizarHorarios();

			new Reserva(usuarioActivo).ShowDialog();


		}

		private void checkNumPersonas(object sender, EventArgs e)
		{
			bool ok = true;

			if (salaSelecionada == 0 && personas.Value > 8)
				ok = false;
			else if (salaSelecionada == 1 && personas.Value > 10)
				ok = false;
			else if (salaSelecionada == 2 && personas.Value > 20)
				ok = false;
			else if (salaSelecionada == -1)
			{
				errorProvider.SetError(panelSalas, "Escoja una sala");
				errorProvider.SetError(personas, "");
				return;
			}

			if (ok)
				errorProvider.SetError(personas, "");
			else
				errorProvider.SetError(personas, "Nº de personas excedido");

		}

		private bool checkHoraLibre(int hora)
		{
			if (horarios[salaSelecionada, hora] == 0)
				return true;
			else
				return false;
		}

		private void sala0_SelectedIndexChanged(object sender, EventArgs e)
		{
			checkNumPersonas(null, null);
			if (sala0.SelectedIndex != -1)
			{
				salaSelecionada = 0;
				indxSelecionado = sala0.SelectedIndex;
				errorProvider.SetError(panelSalas, "");
			}

			sala1.SelectedIndex = -1;
			sala2.SelectedIndex = -1;

			salas[salaSelecionada].SelectedIndex = indxSelecionado;


		}

		private void sala1_SelectedIndexChanged(object sender, EventArgs e)
		{
			checkNumPersonas(null, null);
			if (sala1.SelectedIndex != -1)
			{
				salaSelecionada = 1;
				indxSelecionado = sala1.SelectedIndex;
				errorProvider.SetError(panelSalas, "");
			}
			sala0.SelectedIndex = -1;
			sala2.SelectedIndex = -1;
			salas[salaSelecionada].SelectedIndex = indxSelecionado;


		}

		private void sala2_SelectedIndexChanged(object sender, EventArgs e)
		{
			checkNumPersonas(null, null);
			if (sala2.SelectedIndex != -1)
			{
				salaSelecionada = 2;
				indxSelecionado = sala2.SelectedIndex;
				errorProvider.SetError(panelSalas, "");
			}
			sala0.SelectedIndex = -1;
			sala1.SelectedIndex = -1;
			salas[salaSelecionada].SelectedIndex = indxSelecionado;

		}

		private void piscolabis_CheckedChanged(object sender, EventArgs e)
		{
			if (piscolabis.Checked)
			{
				panelBebidas.Enabled = true;
				panelBocaditos.Enabled = true;
			}
			else
			{
				panelBebidas.Enabled = false;
				panelBocaditos.Enabled = false;
			}
		}

		private void btnCerrarSesion_Click(object sender, EventArgs e)
		{
			panelReservas.Hide();
			panelLogin.Show();
		}

		private void Form1_Load(object sender, EventArgs e)
		{

		}

		private void btnLogin_Click(object sender, EventArgs e)
		{

			//TODO
			if (usuario.Text == "" || contraseña.Text == "")
			{
				errorProvider.SetError(contraseña, "Usuario o contraseña incorrectos.");
				return;
			}

			errorProvider.SetError(contraseña, "");

			usuarioActivo = usuario.Text;

			panelReservas.Show();
			panelLogin.Hide();
		}

		private void button2_Click(object sender, EventArgs e)
		{
			this.Close();
		}
	}
}
