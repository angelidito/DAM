
namespace ANGEL_MARTINEZDIEZ_1EVA
{
	partial class Form1
	{
		/// <summary>
		/// Variable del diseñador necesaria.
		/// </summary>
		private System.ComponentModel.IContainer components = null;

		/// <summary>
		/// Limpiar los recursos que se estén usando.
		/// </summary>
		/// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
		protected override void Dispose(bool disposing)
		{
			if (disposing && (components != null))
			{
				components.Dispose();
			}
			base.Dispose(disposing);
		}

		#region Código generado por el Diseñador de Windows Forms

		/// <summary>
		/// Método necesario para admitir el Diseñador. No se puede modificar
		/// el contenido de este método con el editor de código.
		/// </summary>
		private void InitializeComponent()
		{
			this.components = new System.ComponentModel.Container();
			this.panelLogin = new System.Windows.Forms.Panel();
			this.contraseña = new System.Windows.Forms.TextBox();
			this.usuario = new System.Windows.Forms.TextBox();
			this.button2 = new System.Windows.Forms.Button();
			this.btnLogin = new System.Windows.Forms.Button();
			this.label2 = new System.Windows.Forms.Label();
			this.label1 = new System.Windows.Forms.Label();
			this.panelReservas = new System.Windows.Forms.Panel();
			this.bienvenida = new System.Windows.Forms.Label();
			this.btnCerrarSesion = new System.Windows.Forms.Button();
			this.btnReservar = new System.Windows.Forms.Button();
			this.panelPiscolabis = new System.Windows.Forms.Panel();
			this.label9 = new System.Windows.Forms.Label();
			this.panelBocaditos = new System.Windows.Forms.Panel();
			this.label8 = new System.Windows.Forms.Label();
			this.radioButton4 = new System.Windows.Forms.RadioButton();
			this.radioButton5 = new System.Windows.Forms.RadioButton();
			this.radioButton6 = new System.Windows.Forms.RadioButton();
			this.panelBebidas = new System.Windows.Forms.Panel();
			this.label7 = new System.Windows.Forms.Label();
			this.radioButton3 = new System.Windows.Forms.RadioButton();
			this.radioButton2 = new System.Windows.Forms.RadioButton();
			this.radioButton1 = new System.Windows.Forms.RadioButton();
			this.piscolabis = new System.Windows.Forms.CheckBox();
			this.label6 = new System.Windows.Forms.Label();
			this.panelSalas = new System.Windows.Forms.Panel();
			this.label3 = new System.Windows.Forms.Label();
			this.label4 = new System.Windows.Forms.Label();
			this.label5 = new System.Windows.Forms.Label();
			this.sala0 = new System.Windows.Forms.ComboBox();
			this.sala2 = new System.Windows.Forms.ComboBox();
			this.sala1 = new System.Windows.Forms.ComboBox();
			this.personas = new System.Windows.Forms.NumericUpDown();
			this.errorProvider = new System.Windows.Forms.ErrorProvider(this.components);
			this.panelLogin.SuspendLayout();
			this.panelReservas.SuspendLayout();
			this.panelPiscolabis.SuspendLayout();
			this.panelBocaditos.SuspendLayout();
			this.panelBebidas.SuspendLayout();
			this.panelSalas.SuspendLayout();
			((System.ComponentModel.ISupportInitialize)(this.personas)).BeginInit();
			((System.ComponentModel.ISupportInitialize)(this.errorProvider)).BeginInit();
			this.SuspendLayout();
			// 
			// panelLogin
			// 
			this.panelLogin.BackColor = System.Drawing.SystemColors.ControlLight;
			this.panelLogin.Controls.Add(this.contraseña);
			this.panelLogin.Controls.Add(this.usuario);
			this.panelLogin.Controls.Add(this.button2);
			this.panelLogin.Controls.Add(this.btnLogin);
			this.panelLogin.Controls.Add(this.label2);
			this.panelLogin.Controls.Add(this.label1);
			this.panelLogin.Location = new System.Drawing.Point(9, 12);
			this.panelLogin.Name = "panelLogin";
			this.panelLogin.Size = new System.Drawing.Size(776, 46);
			this.panelLogin.TabIndex = 0;
			// 
			// contraseña
			// 
			this.contraseña.Location = new System.Drawing.Point(341, 14);
			this.contraseña.Name = "contraseña";
			this.contraseña.PasswordChar = '*';
			this.contraseña.Size = new System.Drawing.Size(184, 20);
			this.contraseña.TabIndex = 5;
			// 
			// usuario
			// 
			this.usuario.Location = new System.Drawing.Point(72, 15);
			this.usuario.Name = "usuario";
			this.usuario.Size = new System.Drawing.Size(184, 20);
			this.usuario.TabIndex = 4;
			// 
			// button2
			// 
			this.button2.Location = new System.Drawing.Point(664, 13);
			this.button2.Name = "button2";
			this.button2.Size = new System.Drawing.Size(100, 23);
			this.button2.TabIndex = 3;
			this.button2.Text = "Cerrar programa";
			this.button2.UseVisualStyleBackColor = true;
			this.button2.Click += new System.EventHandler(this.button2_Click);
			// 
			// btnLogin
			// 
			this.btnLogin.Location = new System.Drawing.Point(554, 13);
			this.btnLogin.Name = "btnLogin";
			this.btnLogin.Size = new System.Drawing.Size(91, 23);
			this.btnLogin.TabIndex = 2;
			this.btnLogin.Text = "Iniciar Sesion";
			this.btnLogin.UseVisualStyleBackColor = true;
			this.btnLogin.Click += new System.EventHandler(this.btnLogin_Click);
			// 
			// label2
			// 
			this.label2.AutoSize = true;
			this.label2.Location = new System.Drawing.Point(273, 18);
			this.label2.Name = "label2";
			this.label2.Size = new System.Drawing.Size(64, 13);
			this.label2.TabIndex = 1;
			this.label2.Text = "Contraseña:";
			// 
			// label1
			// 
			this.label1.AutoSize = true;
			this.label1.Location = new System.Drawing.Point(20, 18);
			this.label1.Name = "label1";
			this.label1.Size = new System.Drawing.Size(46, 13);
			this.label1.TabIndex = 0;
			this.label1.Text = "Usuario:";
			// 
			// panelReservas
			// 
			this.panelReservas.BackColor = System.Drawing.SystemColors.GradientInactiveCaption;
			this.panelReservas.Controls.Add(this.bienvenida);
			this.panelReservas.Controls.Add(this.btnCerrarSesion);
			this.panelReservas.Controls.Add(this.btnReservar);
			this.panelReservas.Controls.Add(this.panelPiscolabis);
			this.panelReservas.Controls.Add(this.label6);
			this.panelReservas.Controls.Add(this.panelSalas);
			this.panelReservas.Controls.Add(this.personas);
			this.panelReservas.Location = new System.Drawing.Point(9, 64);
			this.panelReservas.Name = "panelReservas";
			this.panelReservas.Size = new System.Drawing.Size(776, 380);
			this.panelReservas.TabIndex = 1;
			this.panelReservas.Visible = false;
			// 
			// bienvenida
			// 
			this.bienvenida.AutoSize = true;
			this.bienvenida.Location = new System.Drawing.Point(41, 18);
			this.bienvenida.Name = "bienvenida";
			this.bienvenida.Size = new System.Drawing.Size(65, 13);
			this.bienvenida.TabIndex = 9;
			this.bienvenida.Text = "Bienvenid@";
			// 
			// btnCerrarSesion
			// 
			this.btnCerrarSesion.Location = new System.Drawing.Point(537, 337);
			this.btnCerrarSesion.Name = "btnCerrarSesion";
			this.btnCerrarSesion.Size = new System.Drawing.Size(95, 23);
			this.btnCerrarSesion.TabIndex = 7;
			this.btnCerrarSesion.Text = "Cerrar sesión";
			this.btnCerrarSesion.UseVisualStyleBackColor = true;
			this.btnCerrarSesion.Click += new System.EventHandler(this.btnCerrarSesion_Click);
			// 
			// btnReservar
			// 
			this.btnReservar.Location = new System.Drawing.Point(650, 337);
			this.btnReservar.Name = "btnReservar";
			this.btnReservar.Size = new System.Drawing.Size(75, 23);
			this.btnReservar.TabIndex = 6;
			this.btnReservar.Text = "Reservar";
			this.btnReservar.UseVisualStyleBackColor = true;
			this.btnReservar.Click += new System.EventHandler(this.reservarHora);
			// 
			// panelPiscolabis
			// 
			this.panelPiscolabis.BackColor = System.Drawing.SystemColors.GradientActiveCaption;
			this.panelPiscolabis.Controls.Add(this.label9);
			this.panelPiscolabis.Controls.Add(this.panelBocaditos);
			this.panelPiscolabis.Controls.Add(this.panelBebidas);
			this.panelPiscolabis.Controls.Add(this.piscolabis);
			this.panelPiscolabis.Location = new System.Drawing.Point(44, 173);
			this.panelPiscolabis.Name = "panelPiscolabis";
			this.panelPiscolabis.Size = new System.Drawing.Size(681, 143);
			this.panelPiscolabis.TabIndex = 10;
			// 
			// label9
			// 
			this.label9.AutoSize = true;
			this.label9.Location = new System.Drawing.Point(48, 72);
			this.label9.Name = "label9";
			this.label9.Size = new System.Drawing.Size(140, 13);
			this.label9.TabIndex = 17;
			this.label9.Text = "(Presupuesto máximo: 2.5 €)";
			// 
			// panelBocaditos
			// 
			this.panelBocaditos.Controls.Add(this.label8);
			this.panelBocaditos.Controls.Add(this.radioButton4);
			this.panelBocaditos.Controls.Add(this.radioButton5);
			this.panelBocaditos.Controls.Add(this.radioButton6);
			this.panelBocaditos.Enabled = false;
			this.panelBocaditos.Location = new System.Drawing.Point(458, 21);
			this.panelBocaditos.Name = "panelBocaditos";
			this.panelBocaditos.Size = new System.Drawing.Size(199, 100);
			this.panelBocaditos.TabIndex = 16;
			// 
			// label8
			// 
			this.label8.AutoSize = true;
			this.label8.Location = new System.Drawing.Point(12, 12);
			this.label8.Name = "label8";
			this.label8.Size = new System.Drawing.Size(49, 13);
			this.label8.TabIndex = 15;
			this.label8.Text = "Bocadito";
			// 
			// radioButton4
			// 
			this.radioButton4.AutoSize = true;
			this.radioButton4.Location = new System.Drawing.Point(15, 28);
			this.radioButton4.Name = "radioButton4";
			this.radioButton4.Size = new System.Drawing.Size(85, 17);
			this.radioButton4.TabIndex = 14;
			this.radioButton4.TabStop = true;
			this.radioButton4.Text = "radioButton4";
			this.radioButton4.UseVisualStyleBackColor = true;
			// 
			// radioButton5
			// 
			this.radioButton5.AutoSize = true;
			this.radioButton5.Location = new System.Drawing.Point(15, 51);
			this.radioButton5.Name = "radioButton5";
			this.radioButton5.Size = new System.Drawing.Size(85, 17);
			this.radioButton5.TabIndex = 13;
			this.radioButton5.TabStop = true;
			this.radioButton5.Text = "radioButton5";
			this.radioButton5.UseVisualStyleBackColor = true;
			// 
			// radioButton6
			// 
			this.radioButton6.AutoSize = true;
			this.radioButton6.Location = new System.Drawing.Point(15, 74);
			this.radioButton6.Name = "radioButton6";
			this.radioButton6.Size = new System.Drawing.Size(85, 17);
			this.radioButton6.TabIndex = 12;
			this.radioButton6.TabStop = true;
			this.radioButton6.Text = "radioButton6";
			this.radioButton6.UseVisualStyleBackColor = true;
			// 
			// panelBebidas
			// 
			this.panelBebidas.Controls.Add(this.label7);
			this.panelBebidas.Controls.Add(this.radioButton3);
			this.panelBebidas.Controls.Add(this.radioButton2);
			this.panelBebidas.Controls.Add(this.radioButton1);
			this.panelBebidas.Enabled = false;
			this.panelBebidas.Location = new System.Drawing.Point(247, 21);
			this.panelBebidas.Name = "panelBebidas";
			this.panelBebidas.Size = new System.Drawing.Size(185, 100);
			this.panelBebidas.TabIndex = 13;
			// 
			// label7
			// 
			this.label7.AutoSize = true;
			this.label7.Location = new System.Drawing.Point(12, 12);
			this.label7.Name = "label7";
			this.label7.Size = new System.Drawing.Size(40, 13);
			this.label7.TabIndex = 15;
			this.label7.Text = "Bebida";
			// 
			// radioButton3
			// 
			this.radioButton3.AutoSize = true;
			this.radioButton3.Location = new System.Drawing.Point(15, 74);
			this.radioButton3.Name = "radioButton3";
			this.radioButton3.Size = new System.Drawing.Size(85, 17);
			this.radioButton3.TabIndex = 14;
			this.radioButton3.TabStop = true;
			this.radioButton3.Text = "radioButton3";
			this.radioButton3.UseVisualStyleBackColor = true;
			// 
			// radioButton2
			// 
			this.radioButton2.AutoSize = true;
			this.radioButton2.Location = new System.Drawing.Point(15, 51);
			this.radioButton2.Name = "radioButton2";
			this.radioButton2.Size = new System.Drawing.Size(85, 17);
			this.radioButton2.TabIndex = 13;
			this.radioButton2.TabStop = true;
			this.radioButton2.Text = "radioButton2";
			this.radioButton2.UseVisualStyleBackColor = true;
			// 
			// radioButton1
			// 
			this.radioButton1.AutoSize = true;
			this.radioButton1.Location = new System.Drawing.Point(15, 28);
			this.radioButton1.Name = "radioButton1";
			this.radioButton1.Size = new System.Drawing.Size(85, 17);
			this.radioButton1.TabIndex = 12;
			this.radioButton1.TabStop = true;
			this.radioButton1.Text = "radioButton1";
			this.radioButton1.UseVisualStyleBackColor = true;
			// 
			// piscolabis
			// 
			this.piscolabis.AutoSize = true;
			this.piscolabis.Location = new System.Drawing.Point(51, 52);
			this.piscolabis.Name = "piscolabis";
			this.piscolabis.Size = new System.Drawing.Size(73, 17);
			this.piscolabis.TabIndex = 11;
			this.piscolabis.TabStop = false;
			this.piscolabis.Text = "Piscolabis";
			this.piscolabis.UseVisualStyleBackColor = true;
			this.piscolabis.CheckedChanged += new System.EventHandler(this.piscolabis_CheckedChanged);
			// 
			// label6
			// 
			this.label6.AutoSize = true;
			this.label6.Location = new System.Drawing.Point(56, 137);
			this.label6.Name = "label6";
			this.label6.Size = new System.Drawing.Size(112, 13);
			this.label6.TabIndex = 9;
			this.label6.Text = "Número de asistentes:";
			// 
			// panelSalas
			// 
			this.panelSalas.BackColor = System.Drawing.SystemColors.GradientActiveCaption;
			this.panelSalas.Controls.Add(this.label3);
			this.panelSalas.Controls.Add(this.label4);
			this.panelSalas.Controls.Add(this.label5);
			this.panelSalas.Controls.Add(this.sala0);
			this.panelSalas.Controls.Add(this.sala2);
			this.panelSalas.Controls.Add(this.sala1);
			this.panelSalas.Location = new System.Drawing.Point(44, 43);
			this.panelSalas.Name = "panelSalas";
			this.panelSalas.Size = new System.Drawing.Size(681, 72);
			this.panelSalas.TabIndex = 4;
			// 
			// label3
			// 
			this.label3.AutoSize = true;
			this.label3.Location = new System.Drawing.Point(12, 16);
			this.label3.Name = "label3";
			this.label3.Size = new System.Drawing.Size(100, 13);
			this.label3.TabIndex = 6;
			this.label3.Text = "Sala 1 (max. 8 pax.)";
			// 
			// label4
			// 
			this.label4.AutoSize = true;
			this.label4.Location = new System.Drawing.Point(244, 16);
			this.label4.Name = "label4";
			this.label4.Size = new System.Drawing.Size(106, 13);
			this.label4.TabIndex = 7;
			this.label4.Text = "Sala 2 (max. 10 pax.)";
			// 
			// label5
			// 
			this.label5.AutoSize = true;
			this.label5.Location = new System.Drawing.Point(476, 16);
			this.label5.Name = "label5";
			this.label5.Size = new System.Drawing.Size(152, 13);
			this.label5.TabIndex = 8;
			this.label5.Text = "Sala 3/comedor (max. 20 pax.)";
			// 
			// sala0
			// 
			this.sala0.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
			this.sala0.FormattingEnabled = true;
			this.sala0.Location = new System.Drawing.Point(15, 32);
			this.sala0.Name = "sala0";
			this.sala0.Size = new System.Drawing.Size(185, 21);
			this.sala0.TabIndex = 1;
			this.sala0.SelectedIndexChanged += new System.EventHandler(this.sala0_SelectedIndexChanged);
			// 
			// sala2
			// 
			this.sala2.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
			this.sala2.FormattingEnabled = true;
			this.sala2.Location = new System.Drawing.Point(479, 32);
			this.sala2.Name = "sala2";
			this.sala2.Size = new System.Drawing.Size(185, 21);
			this.sala2.TabIndex = 3;
			this.sala2.SelectedIndexChanged += new System.EventHandler(this.sala2_SelectedIndexChanged);
			// 
			// sala1
			// 
			this.sala1.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
			this.sala1.FormattingEnabled = true;
			this.sala1.Location = new System.Drawing.Point(247, 32);
			this.sala1.Name = "sala1";
			this.sala1.Size = new System.Drawing.Size(185, 21);
			this.sala1.TabIndex = 2;
			this.sala1.SelectedIndexChanged += new System.EventHandler(this.sala1_SelectedIndexChanged);
			// 
			// personas
			// 
			this.personas.Location = new System.Drawing.Point(174, 135);
			this.personas.Minimum = new decimal(new int[] {
            1,
            0,
            0,
            0});
			this.personas.Name = "personas";
			this.personas.Size = new System.Drawing.Size(127, 20);
			this.personas.TabIndex = 0;
			this.personas.Value = new decimal(new int[] {
            1,
            0,
            0,
            0});
			this.personas.ValueChanged += new System.EventHandler(this.checkNumPersonas);
			// 
			// errorProvider
			// 
			this.errorProvider.ContainerControl = this;
			// 
			// Form1
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(800, 467);
			this.Controls.Add(this.panelReservas);
			this.Controls.Add(this.panelLogin);
			this.MaximizeBox = false;
			this.MinimizeBox = false;
			this.Name = "Form1";
			this.ShowIcon = false;
			this.Text = "Sistema de reserva de salas";
			this.Load += new System.EventHandler(this.Form1_Load);
			this.panelLogin.ResumeLayout(false);
			this.panelLogin.PerformLayout();
			this.panelReservas.ResumeLayout(false);
			this.panelReservas.PerformLayout();
			this.panelPiscolabis.ResumeLayout(false);
			this.panelPiscolabis.PerformLayout();
			this.panelBocaditos.ResumeLayout(false);
			this.panelBocaditos.PerformLayout();
			this.panelBebidas.ResumeLayout(false);
			this.panelBebidas.PerformLayout();
			this.panelSalas.ResumeLayout(false);
			this.panelSalas.PerformLayout();
			((System.ComponentModel.ISupportInitialize)(this.personas)).EndInit();
			((System.ComponentModel.ISupportInitialize)(this.errorProvider)).EndInit();
			this.ResumeLayout(false);

		}

		#endregion

		private System.Windows.Forms.Panel panelLogin;
		private System.Windows.Forms.TextBox contraseña;
		private System.Windows.Forms.TextBox usuario;
		private System.Windows.Forms.Button button2;
		private System.Windows.Forms.Button btnLogin;
		private System.Windows.Forms.Label label2;
		private System.Windows.Forms.Label label1;
		private System.Windows.Forms.Panel panelReservas;
		private System.Windows.Forms.ComboBox sala2;
		private System.Windows.Forms.ComboBox sala1;
		private System.Windows.Forms.ComboBox sala0;
		private System.Windows.Forms.NumericUpDown personas;
		private System.Windows.Forms.Panel panelSalas;
		private System.Windows.Forms.Panel panelPiscolabis;
		private System.Windows.Forms.CheckBox piscolabis;
		private System.Windows.Forms.Label label6;
		private System.Windows.Forms.Label label3;
		private System.Windows.Forms.Label label4;
		private System.Windows.Forms.Label label5;
		private System.Windows.Forms.ErrorProvider errorProvider;
		private System.Windows.Forms.RadioButton radioButton1;
		private System.Windows.Forms.Panel panelBebidas;
		private System.Windows.Forms.RadioButton radioButton3;
		private System.Windows.Forms.RadioButton radioButton2;
		private System.Windows.Forms.Label label7;
		private System.Windows.Forms.Label label9;
		private System.Windows.Forms.Panel panelBocaditos;
		private System.Windows.Forms.Label label8;
		private System.Windows.Forms.RadioButton radioButton4;
		private System.Windows.Forms.RadioButton radioButton5;
		private System.Windows.Forms.RadioButton radioButton6;
		private System.Windows.Forms.Button btnCerrarSesion;
		private System.Windows.Forms.Button btnReservar;
		private System.Windows.Forms.Label bienvenida;
	}
}

