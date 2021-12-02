
namespace WindowsFormsApp1
{
	partial class Solicitud
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
		private void InitializeComponent()
		{
			this.panel1 = new System.Windows.Forms.Panel();
			this.label2 = new System.Windows.Forms.Label();
			this.cb_origen = new System.Windows.Forms.ComboBox();
			this.label1 = new System.Windows.Forms.Label();
			this.lbl_personal_data = new System.Windows.Forms.Label();
			this.cb_razas = new System.Windows.Forms.ComboBox();
			this.btnSalir = new System.Windows.Forms.Button();
			this.lblTitulo = new System.Windows.Forms.Label();
			this.panel2 = new System.Windows.Forms.Panel();
			this.tb_prestamo = new System.Windows.Forms.TextBox();
			this.label3 = new System.Windows.Forms.Label();
			this.cb_cuotas = new System.Windows.Forms.ComboBox();
			this.label4 = new System.Windows.Forms.Label();
			this.label5 = new System.Windows.Forms.Label();
			this.btnConfirmarSolicitud = new System.Windows.Forms.Button();
			this.panel1.SuspendLayout();
			this.panel2.SuspendLayout();
			this.SuspendLayout();
			// 
			// panel1
			// 
			this.panel1.BackColor = System.Drawing.Color.Chocolate;
			this.panel1.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
			this.panel1.Controls.Add(this.label2);
			this.panel1.Controls.Add(this.cb_origen);
			this.panel1.Controls.Add(this.label1);
			this.panel1.Controls.Add(this.lbl_personal_data);
			this.panel1.Controls.Add(this.cb_razas);
			this.panel1.Location = new System.Drawing.Point(41, 120);
			this.panel1.Name = "panel1";
			this.panel1.Size = new System.Drawing.Size(286, 150);
			this.panel1.TabIndex = 1;
			// 
			// label2
			// 
			this.label2.AutoSize = true;
			this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.label2.Location = new System.Drawing.Point(21, 102);
			this.label2.Name = "label2";
			this.label2.Size = new System.Drawing.Size(113, 17);
			this.label2.TabIndex = 6;
			this.label2.Text = "Lugar de origen:";
			// 
			// cb_origen
			// 
			this.cb_origen.BackColor = System.Drawing.Color.WhiteSmoke;
			this.cb_origen.FormattingEnabled = true;
			this.cb_origen.Location = new System.Drawing.Point(140, 98);
			this.cb_origen.Name = "cb_origen";
			this.cb_origen.Size = new System.Drawing.Size(121, 21);
			this.cb_origen.TabIndex = 5;
			// 
			// label1
			// 
			this.label1.AutoSize = true;
			this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.label1.Location = new System.Drawing.Point(89, 54);
			this.label1.Name = "label1";
			this.label1.Size = new System.Drawing.Size(45, 17);
			this.label1.TabIndex = 4;
			this.label1.Text = "Raza:";
			// 
			// lbl_personal_data
			// 
			this.lbl_personal_data.AutoSize = true;
			this.lbl_personal_data.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.lbl_personal_data.ForeColor = System.Drawing.Color.White;
			this.lbl_personal_data.Location = new System.Drawing.Point(21, 15);
			this.lbl_personal_data.Name = "lbl_personal_data";
			this.lbl_personal_data.Size = new System.Drawing.Size(135, 17);
			this.lbl_personal_data.TabIndex = 3;
			this.lbl_personal_data.Text = "Datos personales";
			// 
			// cb_razas
			// 
			this.cb_razas.BackColor = System.Drawing.Color.WhiteSmoke;
			this.cb_razas.FormattingEnabled = true;
			this.cb_razas.Location = new System.Drawing.Point(140, 50);
			this.cb_razas.Name = "cb_razas";
			this.cb_razas.Size = new System.Drawing.Size(121, 21);
			this.cb_razas.TabIndex = 2;
			// 
			// btnSalir
			// 
			this.btnSalir.Location = new System.Drawing.Point(700, 412);
			this.btnSalir.Name = "btnSalir";
			this.btnSalir.Size = new System.Drawing.Size(75, 23);
			this.btnSalir.TabIndex = 5;
			this.btnSalir.Text = "Salir";
			this.btnSalir.UseVisualStyleBackColor = true;
			this.btnSalir.Click += new System.EventHandler(this.btnSalir_Click);
			// 
			// lblTitulo
			// 
			this.lblTitulo.AutoSize = true;
			this.lblTitulo.BackColor = System.Drawing.Color.Transparent;
			this.lblTitulo.Font = new System.Drawing.Font("Palatino Linotype", 24F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.lblTitulo.Location = new System.Drawing.Point(86, 52);
			this.lblTitulo.Name = "lblTitulo";
			this.lblTitulo.Size = new System.Drawing.Size(204, 44);
			this.lblTitulo.TabIndex = 6;
			this.lblTitulo.Text = "Bienvenido, ";
			// 
			// panel2
			// 
			this.panel2.BackColor = System.Drawing.Color.Chocolate;
			this.panel2.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
			this.panel2.Controls.Add(this.tb_prestamo);
			this.panel2.Controls.Add(this.label3);
			this.panel2.Controls.Add(this.cb_cuotas);
			this.panel2.Controls.Add(this.label4);
			this.panel2.Controls.Add(this.label5);
			this.panel2.Location = new System.Drawing.Point(425, 120);
			this.panel2.Name = "panel2";
			this.panel2.Size = new System.Drawing.Size(286, 150);
			this.panel2.TabIndex = 7;
			// 
			// tb_prestamo
			// 
			this.tb_prestamo.BackColor = System.Drawing.Color.WhiteSmoke;
			this.tb_prestamo.Location = new System.Drawing.Point(140, 50);
			this.tb_prestamo.Name = "tb_prestamo";
			this.tb_prestamo.Size = new System.Drawing.Size(121, 20);
			this.tb_prestamo.TabIndex = 7;
			// 
			// label3
			// 
			this.label3.AutoSize = true;
			this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.label3.ImageAlign = System.Drawing.ContentAlignment.TopLeft;
			this.label3.Location = new System.Drawing.Point(78, 102);
			this.label3.Name = "label3";
			this.label3.Size = new System.Drawing.Size(56, 17);
			this.label3.TabIndex = 6;
			this.label3.Text = "Cuotas:";
			this.label3.TextAlign = System.Drawing.ContentAlignment.TopRight;
			// 
			// cb_cuotas
			// 
			this.cb_cuotas.BackColor = System.Drawing.Color.WhiteSmoke;
			this.cb_cuotas.FormattingEnabled = true;
			this.cb_cuotas.Location = new System.Drawing.Point(140, 98);
			this.cb_cuotas.Name = "cb_cuotas";
			this.cb_cuotas.Size = new System.Drawing.Size(121, 21);
			this.cb_cuotas.TabIndex = 5;
			// 
			// label4
			// 
			this.label4.AutoSize = true;
			this.label4.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.label4.Location = new System.Drawing.Point(62, 54);
			this.label4.Name = "label4";
			this.label4.Size = new System.Drawing.Size(72, 17);
			this.label4.TabIndex = 4;
			this.label4.Text = "Préstamo:";
			// 
			// label5
			// 
			this.label5.AutoSize = true;
			this.label5.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.label5.ForeColor = System.Drawing.Color.White;
			this.label5.Location = new System.Drawing.Point(28, 15);
			this.label5.Name = "label5";
			this.label5.Size = new System.Drawing.Size(135, 17);
			this.label5.TabIndex = 3;
			this.label5.Text = "Datos personales";
			// 
			// btnConfirmarSolicitud
			// 
			this.btnConfirmarSolicitud.BackColor = System.Drawing.Color.Chocolate;
			this.btnConfirmarSolicitud.Cursor = System.Windows.Forms.Cursors.Hand;
			this.btnConfirmarSolicitud.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.btnConfirmarSolicitud.ForeColor = System.Drawing.Color.Navy;
			this.btnConfirmarSolicitud.Location = new System.Drawing.Point(330, 324);
			this.btnConfirmarSolicitud.Name = "btnConfirmarSolicitud";
			this.btnConfirmarSolicitud.Size = new System.Drawing.Size(100, 49);
			this.btnConfirmarSolicitud.TabIndex = 8;
			this.btnConfirmarSolicitud.Text = "Solicitar prestamo";
			this.btnConfirmarSolicitud.UseVisualStyleBackColor = false;
			this.btnConfirmarSolicitud.Click += new System.EventHandler(this.btnConfirmarSolicitud_Click);
			// 
			// Solicitud
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.BackColor = System.Drawing.Color.SaddleBrown;
			this.ClientSize = new System.Drawing.Size(804, 461);
			this.Controls.Add(this.btnConfirmarSolicitud);
			this.Controls.Add(this.panel2);
			this.Controls.Add(this.lblTitulo);
			this.Controls.Add(this.btnSalir);
			this.Controls.Add(this.panel1);
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.Fixed3D;
			this.MaximizeBox = false;
			this.Name = "Solicitud";
			this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
			this.Text = "Banco de la Media Tierra";
			this.TransparencyKey = System.Drawing.Color.Transparent;
			this.panel1.ResumeLayout(false);
			this.panel1.PerformLayout();
			this.panel2.ResumeLayout(false);
			this.panel2.PerformLayout();
			this.ResumeLayout(false);
			this.PerformLayout();

		}

		private System.Windows.Forms.Panel panel1;
		private System.Windows.Forms.ComboBox cb_razas;
		private System.Windows.Forms.Button btnSalir;
		private System.Windows.Forms.Label lblTitulo;
		private System.Windows.Forms.Label label2;
		private System.Windows.Forms.ComboBox cb_origen;
		private System.Windows.Forms.Label label1;
		private System.Windows.Forms.Label lbl_personal_data;
		private System.Windows.Forms.Panel panel2;
		private System.Windows.Forms.TextBox tb_prestamo;
		private System.Windows.Forms.Label label3;
		private System.Windows.Forms.ComboBox cb_cuotas;
		private System.Windows.Forms.Label label4;
		private System.Windows.Forms.Label label5;
		private System.Windows.Forms.Button btnConfirmarSolicitud;
	}
}