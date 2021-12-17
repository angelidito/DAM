
namespace Tarea_2_3
{
	partial class Login
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
			this.panel1 = new System.Windows.Forms.Panel();
			this.nombre = new System.Windows.Forms.TextBox();
			this.label4 = new System.Windows.Forms.Label();
			this.esPadron = new System.Windows.Forms.CheckBox();
			this.padron = new System.Windows.Forms.TextBox();
			this.pista = new System.Windows.Forms.ComboBox();
			this.hora = new System.Windows.Forms.ComboBox();
			this.label3 = new System.Windows.Forms.Label();
			this.label2 = new System.Windows.Forms.Label();
			this.label1 = new System.Windows.Forms.Label();
			this.btnReservar = new System.Windows.Forms.Button();
			this.errorProvider = new System.Windows.Forms.ErrorProvider(this.components);
			this.panel1.SuspendLayout();
			((System.ComponentModel.ISupportInitialize)(this.errorProvider)).BeginInit();
			this.SuspendLayout();
			// 
			// panel1
			// 
			this.panel1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(100)))), ((int)(((byte)(50)))), ((int)(((byte)(225)))), ((int)(((byte)(50)))));
			this.panel1.Controls.Add(this.nombre);
			this.panel1.Controls.Add(this.label4);
			this.panel1.Controls.Add(this.esPadron);
			this.panel1.Controls.Add(this.padron);
			this.panel1.Controls.Add(this.pista);
			this.panel1.Controls.Add(this.hora);
			this.panel1.Controls.Add(this.label3);
			this.panel1.Controls.Add(this.label2);
			this.panel1.Controls.Add(this.label1);
			this.panel1.Controls.Add(this.btnReservar);
			this.panel1.Location = new System.Drawing.Point(122, 47);
			this.panel1.Name = "panel1";
			this.panel1.Padding = new System.Windows.Forms.Padding(3);
			this.panel1.Size = new System.Drawing.Size(500, 300);
			this.panel1.TabIndex = 0;
			// 
			// nombre
			// 
			this.nombre.BackColor = System.Drawing.Color.White;
			this.nombre.Location = new System.Drawing.Point(125, 75);
			this.nombre.MaxLength = 42;
			this.nombre.Name = "nombre";
			this.nombre.Size = new System.Drawing.Size(282, 23);
			this.nombre.TabIndex = 10;
			this.nombre.TextChanged += new System.EventHandler(this.checkName);
			// 
			// label4
			// 
			this.label4.AutoSize = true;
			this.label4.BackColor = System.Drawing.Color.Transparent;
			this.label4.Location = new System.Drawing.Point(65, 78);
			this.label4.Name = "label4";
			this.label4.Size = new System.Drawing.Size(54, 15);
			this.label4.TabIndex = 9;
			this.label4.Text = "Nombre:";
			// 
			// esPadron
			// 
			this.esPadron.AutoSize = true;
			this.esPadron.BackColor = System.Drawing.Color.Transparent;
			this.esPadron.Location = new System.Drawing.Point(125, 162);
			this.esPadron.Name = "esPadron";
			this.esPadron.Size = new System.Drawing.Size(123, 19);
			this.esPadron.TabIndex = 8;
			this.esPadron.Text = "Soy empadronado";
			this.esPadron.UseVisualStyleBackColor = false;
			// 
			// padron
			// 
			this.padron.BackColor = System.Drawing.Color.White;
			this.padron.Location = new System.Drawing.Point(350, 160);
			this.padron.MaxLength = 8;
			this.padron.Name = "padron";
			this.padron.Size = new System.Drawing.Size(57, 23);
			this.padron.TabIndex = 7;
			// 
			// pista
			// 
			this.pista.BackColor = System.Drawing.Color.White;
			this.pista.FormattingEnabled = true;
			this.pista.Location = new System.Drawing.Point(125, 104);
			this.pista.Name = "pista";
			this.pista.Size = new System.Drawing.Size(282, 23);
			this.pista.TabIndex = 6;
			// 
			// hora
			// 
			this.hora.BackColor = System.Drawing.Color.White;
			this.hora.FormattingEnabled = true;
			this.hora.Location = new System.Drawing.Point(125, 133);
			this.hora.Name = "hora";
			this.hora.Size = new System.Drawing.Size(282, 23);
			this.hora.TabIndex = 6;
			// 
			// label3
			// 
			this.label3.AutoSize = true;
			this.label3.BackColor = System.Drawing.Color.Transparent;
			this.label3.Location = new System.Drawing.Point(254, 163);
			this.label3.Name = "label3";
			this.label3.Size = new System.Drawing.Size(90, 15);
			this.label3.TabIndex = 5;
			this.label3.Text = "Código padrón:";
			// 
			// label2
			// 
			this.label2.AutoSize = true;
			this.label2.BackColor = System.Drawing.Color.Transparent;
			this.label2.Location = new System.Drawing.Point(43, 136);
			this.label2.Name = "label2";
			this.label2.Size = new System.Drawing.Size(76, 15);
			this.label2.TabIndex = 3;
			this.label2.Text = "Hora reserva:";
			// 
			// label1
			// 
			this.label1.AutoSize = true;
			this.label1.BackColor = System.Drawing.Color.Transparent;
			this.label1.Location = new System.Drawing.Point(29, 107);
			this.label1.Name = "label1";
			this.label1.Size = new System.Drawing.Size(90, 15);
			this.label1.TabIndex = 2;
			this.label1.Text = "Quiero reservar:";
			// 
			// btnReservar
			// 
			this.btnReservar.Location = new System.Drawing.Point(125, 208);
			this.btnReservar.Name = "btnReservar";
			this.btnReservar.Size = new System.Drawing.Size(75, 23);
			this.btnReservar.TabIndex = 0;
			this.btnReservar.Text = "button1";
			this.btnReservar.UseVisualStyleBackColor = true;
			// 
			// errorProvider
			// 
			this.errorProvider.ContainerControl = this;
			// 
			// Login
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.BackgroundImage = global::Tarea_2_3.Properties.Resources.deportes;
			this.ClientSize = new System.Drawing.Size(734, 411);
			this.Controls.Add(this.panel1);
			this.MaximizeBox = false;
			this.Name = "Login";
			this.ShowIcon = false;
			this.SizeGripStyle = System.Windows.Forms.SizeGripStyle.Hide;
			this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
			this.Text = "Tenis Town - Inicio";
			this.panel1.ResumeLayout(false);
			this.panel1.PerformLayout();
			((System.ComponentModel.ISupportInitialize)(this.errorProvider)).EndInit();
			this.ResumeLayout(false);

		}

		#endregion

		private System.Windows.Forms.Panel panel1;
		private System.Windows.Forms.ComboBox hora;
		private System.Windows.Forms.Label label3;
		private System.Windows.Forms.Label label2;
		private System.Windows.Forms.Label label1;
		private System.Windows.Forms.Button button1;
		private System.Windows.Forms.ComboBox pista;
		private System.Windows.Forms.TextBox padron;
		private System.Windows.Forms.CheckBox esPadron;
		private System.Windows.Forms.NumericUpDown numericUpDown1;
		private System.Windows.Forms.TextBox nombre;
		private System.Windows.Forms.Label label4;
		private System.Windows.Forms.Button btnReservar;
		private System.Windows.Forms.ErrorProvider errorProvider;
	}
}

