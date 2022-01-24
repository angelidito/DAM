using System;
using System.Linq;
using System.Windows.Forms;

namespace Práctica_2_2
{
	public partial class Datos : Form
	{
		public Datos()
		{
			InitializeComponent();
			btnOrder.Enabled = false;
			ControlBotones();
		}

		private void btnExit_Click(object sender, EventArgs e)
		{
			this.Close();
		}


		private void tbNameTextChanged()
		{

		}


		private void ControlBotones()
		{
			String emptyFields = "";
			Boolean ok = true;
			if (tbName.Text.Trim() != string.Empty && tbName.Text.All(Char.IsLetter))
				errorProvider1.SetError(tbName, "");
			else
			{
				if (tbNbr.Text.Trim() == string.Empty)
					emptyFields += "El nombre está vacío. ";
				else
					errorProvider1.SetError(tbName, "El nombre debe contener sólo lertas.");
				ok = false;
			}

			if (tbNbr.Text.Trim() != string.Empty && tbNbr.Text.Length != 10 && tbNbr.Text.All(Char.IsDigit))
				errorProvider1.SetError(tbNbr, "");
			else
			{
				if (tbNbr.Text.Trim() == string.Empty)
					emptyFields += "El teléfono está vacío. ";
				else
					errorProvider1.SetError(tbNbr, "El teléfono sólo debe contener los 9 números que lo componen.");
				ok = false;
			}

			if (cbAddress.Text.Trim() != string.Empty)
				errorProvider1.SetError(cbAddress, "");
			else
			{
				emptyFields += "La dirección está vacía.  ";
				ok = false;
			}

			if (tbAddressData.Text.Trim() != string.Empty)
				errorProvider1.SetError(tbAddressData, "");
			else
			{
				emptyFields += "El campo nº, piso, etc está vacío.";
				ok = false;
			}

			errorProvider1.SetError(btnOrder, emptyFields);


			if (ok)
				btnOrder.Enabled = true;
		}

		private new void TextChanged(object sender, EventArgs e)
		{
			ControlBotones();
		}

		private void btnOrder_Click(object sender, EventArgs e)
		{
			new Menu(veganOpt.Checked).Show();
		}
	}
}
