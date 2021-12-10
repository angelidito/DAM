using System;
using System.Collections.Generic;
using System.Windows.Forms;

namespace Práctica_2_2
{
	public partial class Menu : Form
	{
		private Boolean vegan;
		Dictionary<string, Double> bebidas;
		public Menu(Boolean vegan)
		{
			InitializeComponent();
			btnViewOrder.Enabled = false;
			this.vegan = vegan;
			if (vegan)
			{
				cbPlato1.Items.AddRange(new object[] {
					"",
					"Arroz",
					"Avena",
					"Alcachofas"}
					);
				cbPlato2.Items.AddRange(new object[] {
					"Barritas de cereal",
					"Bocaditos de vegetal",
					"Botellitas de maiz"}
					);
				cbPlato3.Items.AddRange(new object[] {
					"",
					"Cactus caídos",
					"Cosicas ricas a base de hojas secas",
					"Cochinilla de chocolate"}
					);
			}
			else
			{
				cbPlato1.Items.AddRange(new object[] {
					"",
					"Deditos de langostino",
					"Dardos de mandril",
					"Despachado de burro"}
					);
				cbPlato2.Items.AddRange(new object[] {
					"Estadío de criadilla",
					"Estofado de antílope",
					"Escogido de gallo"}
					);
				cbPlato3.Items.AddRange(new object[] {
					"",
					"Farulitos de mono",
					"Foundue de de sesos dulces",
					"Fascias secretas"}
					);
			}

			bebidas = new Dictionary<string, Double>(){
					{ "Café", 2 },
					{ "Cocacola", 3 },
					{ "Cubata", 4.50 },
					{ "Zumo de bebé koala", 8.2 },
					{ "Virgulillas", 3.50 }};

			this.cbBebida.Items.AddRange(new object[] {
			"",
			"Café",
			"Cocacola",
			"Cubata",
			"Zumo de bebé koala",
			"Virgulillas"});
		}

		private void btnExit_Click(object sender, EventArgs e)
		{
			this.Close();
		}

		private void ControlBoton(object sender, EventArgs e)
		{
			Double precio = 0;
			if (cbPlato1.SelectedIndex != -1 && cbPlato1.SelectedItem.ToString() != "")
				precio += 4.4;

			if (cbPlato2.SelectedIndex != -1 && cbPlato2.SelectedItem.ToString() != "")
			{
				btnViewOrder.Enabled = true;
				precio += 5.5;
			}

			if (vegan)
				precio *= 1.2;

			if (cbPlato3.SelectedIndex != -1 && cbPlato3.SelectedItem.ToString() != "")
				precio += 3;

			if (cbBebida.SelectedIndex != -1 && cbBebida.SelectedItem.ToString() != "")
				foreach (KeyValuePair<string, Double> bebida in bebidas)
					if (bebida.Key.CompareTo(cbBebida.SelectedItem.ToString()) == 0)
					{
						precio += bebida.Value;
						break;
					}
			// precio += Double.Parse(cbBebida.SelectedItem.ToString().Split("- ")[1].Split("€")[0]);

			if (breadOpt.Checked)
				precio += 0.8;

			btnViewOrder.Text = "Visualizar pedido\nTotal: " + Math.Round(precio, 2) + "€";
		}

	}
}