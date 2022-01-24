
namespace Práctica_2_2
{
	partial class Datos
	{
		/// <summary>
		///  Required designer variable.
		/// </summary>
		private System.ComponentModel.IContainer components = null;

		/// <summary>
		///  Clean up any resources being used.
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
		///  Required method for Designer support - do not modify
		///  the contents of this method with the code editor.
		/// </summary>
		private void InitializeComponent()
		{
			this.components = new System.ComponentModel.Container();
			this.btnOrder = new System.Windows.Forms.Button();
			this.btnExit = new System.Windows.Forms.Button();
			this.lblTittle = new System.Windows.Forms.Label();
			this.lblName = new System.Windows.Forms.Label();
			this.lblNbr = new System.Windows.Forms.Label();
			this.lblAddress = new System.Windows.Forms.Label();
			this.tbName = new System.Windows.Forms.TextBox();
			this.tbNbr = new System.Windows.Forms.TextBox();
			this.tbAddressData = new System.Windows.Forms.TextBox();
			this.lblAddressData = new System.Windows.Forms.Label();
			this.veganOpt = new System.Windows.Forms.CheckBox();
			this.errorProvider1 = new System.Windows.Forms.ErrorProvider(this.components);
			this.cbAddress = new System.Windows.Forms.ComboBox();
			this.panel1 = new System.Windows.Forms.Panel();
			((System.ComponentModel.ISupportInitialize)(this.errorProvider1)).BeginInit();
			this.panel1.SuspendLayout();
			this.SuspendLayout();
			// 
			// btnOrder
			// 
			this.btnOrder.Location = new System.Drawing.Point(108, 185);
			this.btnOrder.Name = "btnOrder";
			this.btnOrder.Size = new System.Drawing.Size(92, 48);
			this.btnOrder.TabIndex = 0;
			this.btnOrder.Text = "Realizar pedido";
			this.btnOrder.UseVisualStyleBackColor = true;
			this.btnOrder.Click += new System.EventHandler(this.btnOrder_Click);
			// 
			// btnExit
			// 
			this.btnExit.Location = new System.Drawing.Point(393, 185);
			this.btnExit.Name = "btnExit";
			this.btnExit.Size = new System.Drawing.Size(92, 48);
			this.btnExit.TabIndex = 1;
			this.btnExit.Text = "Salir";
			this.btnExit.UseVisualStyleBackColor = true;
			this.btnExit.Click += new System.EventHandler(this.btnExit_Click);
			// 
			// lblTittle
			// 
			this.lblTittle.AutoSize = true;
			this.lblTittle.Font = new System.Drawing.Font("Stencil", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
			this.lblTittle.Location = new System.Drawing.Point(134, 38);
			this.lblTittle.Name = "lblTittle";
			this.lblTittle.Size = new System.Drawing.Size(226, 29);
			this.lblTittle.TabIndex = 2;
			this.lblTittle.Text = "Restaurante S.L.";
			// 
			// lblName
			// 
			this.lblName.AutoSize = true;
			this.lblName.Location = new System.Drawing.Point(48, 47);
			this.lblName.Name = "lblName";
			this.lblName.Size = new System.Drawing.Size(54, 15);
			this.lblName.TabIndex = 3;
			this.lblName.Text = "Nombre:";
			// 
			// lblNbr
			// 
			this.lblNbr.AutoSize = true;
			this.lblNbr.Location = new System.Drawing.Point(47, 76);
			this.lblNbr.Name = "lblNbr";
			this.lblNbr.Size = new System.Drawing.Size(55, 15);
			this.lblNbr.TabIndex = 4;
			this.lblNbr.Text = "Teléfono:";
			// 
			// lblAddress
			// 
			this.lblAddress.AutoSize = true;
			this.lblAddress.Location = new System.Drawing.Point(42, 105);
			this.lblAddress.Name = "lblAddress";
			this.lblAddress.Size = new System.Drawing.Size(60, 15);
			this.lblAddress.TabIndex = 5;
			this.lblAddress.Text = "Dirección:";
			// 
			// tbName
			// 
			this.tbName.Location = new System.Drawing.Point(108, 44);
			this.tbName.Name = "tbName";
			this.tbName.Size = new System.Drawing.Size(377, 23);
			this.tbName.TabIndex = 6;
			this.tbName.TextChanged += new System.EventHandler(this.TextChanged);
			// 
			// tbNbr
			// 
			this.tbNbr.Location = new System.Drawing.Point(108, 73);
			this.tbNbr.Name = "tbNbr";
			this.tbNbr.Size = new System.Drawing.Size(377, 23);
			this.tbNbr.TabIndex = 7;
			this.tbNbr.TextChanged += new System.EventHandler(this.TextChanged);
			// 
			// tbAddressData
			// 
			this.tbAddressData.Location = new System.Drawing.Point(108, 131);
			this.tbAddressData.Name = "tbAddressData";
			this.tbAddressData.Size = new System.Drawing.Size(377, 23);
			this.tbAddressData.TabIndex = 9;
			this.tbAddressData.TextChanged += new System.EventHandler(this.TextChanged);
			// 
			// lblAddressData
			// 
			this.lblAddressData.AutoSize = true;
			this.lblAddressData.Location = new System.Drawing.Point(28, 134);
			this.lblAddressData.Name = "lblAddressData";
			this.lblAddressData.Size = new System.Drawing.Size(74, 15);
			this.lblAddressData.TabIndex = 10;
			this.lblAddressData.Text = "Nº, piso, etc:";
			// 
			// veganOpt
			// 
			this.veganOpt.AutoSize = true;
			this.veganOpt.Location = new System.Drawing.Point(108, 160);
			this.veganOpt.Name = "veganOpt";
			this.veganOpt.Size = new System.Drawing.Size(198, 19);
			this.veganOpt.TabIndex = 11;
			this.veganOpt.Text = "Quiero que mi menú sea vegano";
			this.veganOpt.UseVisualStyleBackColor = true;
			// 
			// errorProvider1
			// 
			this.errorProvider1.ContainerControl = this;
			// 
			// cbAddress
			// 
			this.cbAddress.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
			this.cbAddress.FormattingEnabled = true;
			this.cbAddress.Items.AddRange(new object[] {
            "Calle Melancolía",
            "Avenida de las Almas Perdidas",
            "Boulevard de los Sueños Rotos",
            "Calle 13"});
			this.cbAddress.Location = new System.Drawing.Point(108, 102);
			this.cbAddress.Name = "cbAddress";
			this.cbAddress.Size = new System.Drawing.Size(377, 23);
			this.cbAddress.TabIndex = 12;
			this.cbAddress.SelectedValueChanged += new System.EventHandler(this.TextChanged);
			// 
			// panel1
			// 
			this.panel1.BackColor = System.Drawing.Color.Olive;
			this.panel1.Controls.Add(this.lblName);
			this.panel1.Controls.Add(this.btnOrder);
			this.panel1.Controls.Add(this.btnExit);
			this.panel1.Controls.Add(this.cbAddress);
			this.panel1.Controls.Add(this.lblNbr);
			this.panel1.Controls.Add(this.veganOpt);
			this.panel1.Controls.Add(this.lblAddress);
			this.panel1.Controls.Add(this.lblAddressData);
			this.panel1.Controls.Add(this.tbName);
			this.panel1.Controls.Add(this.tbAddressData);
			this.panel1.Controls.Add(this.tbNbr);
			this.panel1.Location = new System.Drawing.Point(134, 70);
			this.panel1.Name = "panel1";
			this.panel1.Size = new System.Drawing.Size(538, 267);
			this.panel1.TabIndex = 29;
			// 
			// Datos
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.BackColor = System.Drawing.Color.Tan;
			this.ClientSize = new System.Drawing.Size(800, 450);
			this.Controls.Add(this.panel1);
			this.Controls.Add(this.lblTittle);
			this.Name = "Datos";
			this.Text = "Restaurante S.L.";
			((System.ComponentModel.ISupportInitialize)(this.errorProvider1)).EndInit();
			this.panel1.ResumeLayout(false);
			this.panel1.PerformLayout();
			this.ResumeLayout(false);
			this.PerformLayout();

		}

		#endregion

		private System.Windows.Forms.Button btnOrder;
		private System.Windows.Forms.Button btnExit;
		private System.Windows.Forms.Label lblTittle;
		private System.Windows.Forms.Label lblName;
		private System.Windows.Forms.Label lblNbr;
		private System.Windows.Forms.Label lblAddress;
		private System.Windows.Forms.TextBox tbName;
		private System.Windows.Forms.TextBox tbNbr;
		private System.Windows.Forms.TextBox tbAddressData;
		private System.Windows.Forms.Label lblAddressData;
		private System.Windows.Forms.CheckBox veganOpt;
		private System.Windows.Forms.ErrorProvider errorProvider1;
		private System.Windows.Forms.ComboBox cbAddress;
		private System.Windows.Forms.Panel panel1;
	}
}

