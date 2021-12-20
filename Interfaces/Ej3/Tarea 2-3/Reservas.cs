using System;
using System.Linq;
using System.Windows.Forms;

namespace Tarea_2_3
{

	public partial class Login : Form
	{
		private object[] arrayPistas = new object[] { "", "Fútbol", "Fútbol Sala/Multiusos", "Baloncesto", "Pádel" };
		private bool[,] ocupation = new bool[4, 14];

		private bool[] validData = new bool[] { false, false, false, true };
		public Login()
		{
			InitializeComponent();
			btnReservar.Enabled = false;

			pistas.Items.AddRange(arrayPistas);
			for (int i = 0; i < 4; i++)
			{
				for (int j = 0; j < 14; j++)
				{
					ocupation[i, j] = false;
				}
			}
		}



		private void chargeHoras()
		{
			horas.Items.Clear();
			horas.Items.Add("");
			horas.SelectedIndex = 0;

			int i = pistas.SelectedIndex - 1;
			if (i != -1)
				for (int j = 0; j < 14; j++)
					if (!ocupation[i, j])
						horas.Items.Add((j + 8) + ":00 - " + (j + 9) + ":00");
		}


		private void checkName(object sender, EventArgs e)
		{
			if (nombre.Text.Trim() != string.Empty && nombre.Text.Trim().Length > 2)
			{
				errorProvider.SetError(nombre, "");
				validateData(0, true);
			}
			else
			{
				errorProvider.SetError(nombre, "El nombre debe contener sólo letras.");
				validateData(0, false);
			}
		}

		private void checkCombo1(object sender, EventArgs e)
		{
			chargeHoras();

			if (pistas.SelectedItem.ToString() != "")
			{
				validateData(1, true);
				errorProvider.SetError(pistas, "");
			}
			else
			{
				errorProvider.SetError(pistas, "Escoja una opción");
				validateData(1, false);
			}

		}
		private void checkCombo2(object sender, EventArgs e)
		{
			if (horas.SelectedItem.ToString() != "")
			{
				validateData(2, true);
				errorProvider.SetError(horas, "");
			}
			else
			{
				errorProvider.SetError(horas, "Escoja una opción");
				validateData(2, false);
			}
		}
		private void checkEmpadronado(object sender, EventArgs e)
		{
			if (!esPadron.Checked)
			{
				validateData(3, true);
				errorProvider.SetError(padron, "");
			}
			else
				checkPadron(null, null);
		}

		private void checkPadron(object sender, EventArgs e)
		{

			if (padron.Text.Trim() != string.Empty && padron.Text.Trim().Length > 2)
			{
				errorProvider.SetError(padron, "");
				validateData(3, true);
			}
			else
			{
				errorProvider.SetError(padron, "Al menos 3 caracteres.");
				validateData(3, false);
			}
		}

		private void validateData(int i, bool isValid)
		{
			int ok = 0;

			validData[i] = isValid;
			foreach (bool v in validData)
				if (v)
					ok++;

			if (ok == validData.Length)
				btnReservar.Enabled = true;
			else
			{
				btnReservar.Enabled = false;
				// errorProvider.SetError(btnReservar, ok+ " oks");
			}

		}

		private void btnReservar_Click(object sender, EventArgs e)
		{
			int precio = 18;

			if (esPadron.Checked)
				precio = 8;
			new Ticket(nombre.Text, pistas.SelectedItem.ToString(), horas.SelectedItem.ToString(), precio, padron.Text).ShowDialog();

			int i = pistas.SelectedIndex - 1;
			int j = horas.SelectedIndex;
			ocupation[i, j] = true;
			chargeHoras();

		
		}
	}


}
