
namespace Práctica_2_2
{
	partial class Menu
	{
		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.IContainer components = null;

		/// <summary>
		/// Clean up any resources being used.
		/// </summary>
		/// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
		protected override void Dispose(bool disposing)
		{
			if (disposing && (components != null))
			{
				components.Dispose();
			}
			base.Dispose(disposing);
		}

		#region Windows Form Designer generated code

		/// <summary>
		/// Required method for Designer support - do not modify
		/// the contents of this method with the code editor.
		/// </summary>
		private void InitializeComponent()
		{
			this.components = new System.ComponentModel.Container();
			this.cbPlato1 = new System.Windows.Forms.ComboBox();
			this.lblPlato1 = new System.Windows.Forms.Label();
			this.cbPlato3 = new System.Windows.Forms.ComboBox();
			this.lblPlato3 = new System.Windows.Forms.Label();
			this.cbPlato2 = new System.Windows.Forms.ComboBox();
			this.lblPlato2 = new System.Windows.Forms.Label();
			this.btnViewOrder = new System.Windows.Forms.Button();
			this.cbBebida = new System.Windows.Forms.ComboBox();
			this.lblDrink = new System.Windows.Forms.Label();
			this.btnExit = new System.Windows.Forms.Button();
			this.breadOpt = new System.Windows.Forms.CheckBox();
			this.errorProvider1 = new System.Windows.Forms.ErrorProvider(this.components);
			this.lblTittle = new System.Windows.Forms.Label();
			this.panel1 = new System.Windows.Forms.Panel();
			((System.ComponentModel.ISupportInitialize)(this.errorProvider1)).BeginInit();
			this.panel1.SuspendLayout();
			this.SuspendLayout();
			// 
			// cbPlato1
			// 
			this.cbPlato1.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
			this.cbPlato1.FormattingEnabled = true;
			this.cbPlato1.Location = new System.Drawing.Point(118, 30);
			this.cbPlato1.Name = "cbPlato1";
			this.cbPlato1.Size = new System.Drawing.Size(377, 23);
			this.cbPlato1.TabIndex = 14;
			this.cbPlato1.SelectedValueChanged += new System.EventHandler(this.ControlBoton);
			// 
			// lblPlato1
			// 
			this.lblPlato1.AutoSize = true;
			this.lblPlato1.Location = new System.Drawing.Point(37, 33);
			this.lblPlato1.Name = "lblPlato1";
			this.lblPlato1.Size = new System.Drawing.Size(75, 15);
			this.lblPlato1.TabIndex = 13;
			this.lblPlato1.Text = "Primer plato:";
			// 
			// cbPlato3
			// 
			this.cbPlato3.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
			this.cbPlato3.FormattingEnabled = true;
			this.cbPlato3.Location = new System.Drawing.Point(118, 117);
			this.cbPlato3.Name = "cbPlato3";
			this.cbPlato3.Size = new System.Drawing.Size(377, 23);
			this.cbPlato3.TabIndex = 16;
			this.cbPlato3.SelectedValueChanged += new System.EventHandler(this.ControlBoton);
			// 
			// lblPlato3
			// 
			this.lblPlato3.AutoSize = true;
			this.lblPlato3.Location = new System.Drawing.Point(69, 120);
			this.lblPlato3.Name = "lblPlato3";
			this.lblPlato3.Size = new System.Drawing.Size(43, 15);
			this.lblPlato3.TabIndex = 15;
			this.lblPlato3.Text = "Postre:";
			// 
			// cbPlato2
			// 
			this.cbPlato2.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
			this.cbPlato2.FormattingEnabled = true;
			this.cbPlato2.Location = new System.Drawing.Point(118, 59);
			this.cbPlato2.Name = "cbPlato2";
			this.cbPlato2.Size = new System.Drawing.Size(377, 23);
			this.cbPlato2.TabIndex = 18;
			this.cbPlato2.SelectedValueChanged += new System.EventHandler(this.ControlBoton);
			// 
			// lblPlato2
			// 
			this.lblPlato2.AutoSize = true;
			this.lblPlato2.Location = new System.Drawing.Point(25, 62);
			this.lblPlato2.Name = "lblPlato2";
			this.lblPlato2.Size = new System.Drawing.Size(87, 15);
			this.lblPlato2.TabIndex = 17;
			this.lblPlato2.Text = "Segundo plato:";
			// 
			// btnViewOrder
			// 
			this.btnViewOrder.Location = new System.Drawing.Point(118, 172);
			this.btnViewOrder.Name = "btnViewOrder";
			this.btnViewOrder.Size = new System.Drawing.Size(108, 73);
			this.btnViewOrder.TabIndex = 19;
			this.btnViewOrder.Text = "Visualizar pedido";
			this.btnViewOrder.UseVisualStyleBackColor = true;
			// 
			// cbBebida
			// 
			this.cbBebida.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
			this.cbBebida.FormattingEnabled = true;
			this.cbBebida.Location = new System.Drawing.Point(118, 88);
			this.cbBebida.Name = "cbBebida";
			this.cbBebida.Size = new System.Drawing.Size(377, 23);
			this.cbBebida.TabIndex = 21;
			this.cbBebida.SelectedValueChanged += new System.EventHandler(this.ControlBoton);
			// 
			// lblDrink
			// 
			this.lblDrink.AutoSize = true;
			this.lblDrink.Location = new System.Drawing.Point(66, 91);
			this.lblDrink.Name = "lblDrink";
			this.lblDrink.Size = new System.Drawing.Size(46, 15);
			this.lblDrink.TabIndex = 20;
			this.lblDrink.Text = "Bebida:";
			// 
			// btnExit
			// 
			this.btnExit.Location = new System.Drawing.Point(387, 172);
			this.btnExit.Name = "btnExit";
			this.btnExit.Size = new System.Drawing.Size(108, 73);
			this.btnExit.TabIndex = 22;
			this.btnExit.Text = "Salir";
			this.btnExit.UseVisualStyleBackColor = true;
			this.btnExit.Click += new System.EventHandler(this.btnExit_Click);
			// 
			// breadOpt
			// 
			this.breadOpt.AutoSize = true;
			this.breadOpt.Location = new System.Drawing.Point(118, 147);
			this.breadOpt.Name = "breadOpt";
			this.breadOpt.Size = new System.Drawing.Size(131, 19);
			this.breadOpt.TabIndex = 23;
			this.breadOpt.Text = "Quiero pan (+0.80€)";
			this.breadOpt.UseVisualStyleBackColor = true;
			this.breadOpt.CheckStateChanged += new System.EventHandler(this.ControlBoton);
			// 
			// errorProvider1
			// 
			this.errorProvider1.ContainerControl = this;
			// 
			// lblTittle
			// 
			this.lblTittle.AutoSize = true;
			this.lblTittle.Font = new System.Drawing.Font("Stencil", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
			this.lblTittle.Location = new System.Drawing.Point(134, 38);
			this.lblTittle.Name = "lblTittle";
			this.lblTittle.Size = new System.Drawing.Size(226, 29);
			this.lblTittle.TabIndex = 24;
			this.lblTittle.Text = "Restaurante S.L.";
			// 
			// panel1
			// 
			this.panel1.BackColor = System.Drawing.Color.Olive;
			this.panel1.Controls.Add(this.cbPlato1);
			this.panel1.Controls.Add(this.lblPlato1);
			this.panel1.Controls.Add(this.breadOpt);
			this.panel1.Controls.Add(this.lblPlato3);
			this.panel1.Controls.Add(this.btnExit);
			this.panel1.Controls.Add(this.cbPlato3);
			this.panel1.Controls.Add(this.cbBebida);
			this.panel1.Controls.Add(this.lblPlato2);
			this.panel1.Controls.Add(this.lblDrink);
			this.panel1.Controls.Add(this.cbPlato2);
			this.panel1.Controls.Add(this.btnViewOrder);
			this.panel1.Location = new System.Drawing.Point(134, 70);
			this.panel1.Name = "panel1";
			this.panel1.Size = new System.Drawing.Size(542, 269);
			this.panel1.TabIndex = 25;
			// 
			// Menu
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.BackColor = System.Drawing.Color.Tan;
			this.ClientSize = new System.Drawing.Size(800, 450);
			this.Controls.Add(this.panel1);
			this.Controls.Add(this.lblTittle);
			this.Name = "Menu";
			this.Text = "Menú General";
			((System.ComponentModel.ISupportInitialize)(this.errorProvider1)).EndInit();
			this.panel1.ResumeLayout(false);
			this.panel1.PerformLayout();
			this.ResumeLayout(false);
			this.PerformLayout();

		}

		#endregion

		private System.Windows.Forms.ComboBox cbPlato1;
		private System.Windows.Forms.Label lblPlato1;
		private System.Windows.Forms.ComboBox cbPlato3;
		private System.Windows.Forms.Label lblPlato3;
		private System.Windows.Forms.ComboBox cbPlato2;
		private System.Windows.Forms.Label lblPlato2;
		private System.Windows.Forms.Button btnViewOrder;
		private System.Windows.Forms.ComboBox cbBebida;
		private System.Windows.Forms.Label lblDrink;
		private System.Windows.Forms.Button btnExit;
		private System.Windows.Forms.CheckBox breadOpt;
		private System.Windows.Forms.ErrorProvider errorProvider1;
		private System.Windows.Forms.Label lblTittle;
		private System.Windows.Forms.Panel panel1;
	}
}