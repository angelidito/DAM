using System;
using System.Linq;
using System.Windows.Forms;

namespace Tarea_2_3
{
	public partial class Login : Form
	{
		bool[] validData = new bool[] { false, false, false, true };
		public Login()
		{
			InitializeComponent();
			btnReservar.Enabled = false;
		}

		private void checkName(object sender, EventArgs e)
		{
			if (nombre.Text.Trim() != string.Empty && nombre.Text.Trim().Length > 2 && nombre.Text.All(Char.IsLetter))
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
			validateData(1, true);
		}
		private void checkCombo2(object sender, EventArgs e)
		{
			validateData(2, true);
		}
		private void checkEmpadronado(object sender, EventArgs e)
		{
			if (!esPadron.Checked)
				validateData(3, true);
			else
				checkPadron(null, null);
		}

		private void checkPadron(object sender, EventArgs e)
		{


			if (padron.Text.Trim() != string.Empty && padron.Text.Trim().Length > 2 && padron.Text.All(Char.IsLetter))
			{
				errorProvider.SetError(padron, "");
				validateData(3, true);
			}
			else
			{
				errorProvider.SetError(padron, "El nombre debe contener sólo letras.");
				validateData(3, false);
			}
		}





		private void validateData(int i, bool isValid)
		{
			int ok = 0;
			
			validData[i] = isValid;
			foreach (bool v in validData)
				if (v) ok++;
			if (ok == validData.Length)
				btnReservar.Enabled = true;
			else
				btnReservar.Enabled = false;
		}
	}


}
