
namespace CapaPresentacion
{
    partial class Login
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
			this.label1 = new System.Windows.Forms.Label();
			this.label2 = new System.Windows.Forms.Label();
			this.iconPictureBox1 = new FontAwesome.Sharp.IconPictureBox();
			this.label3 = new System.Windows.Forms.Label();
			this.label4 = new System.Windows.Forms.Label();
			this.label5 = new System.Windows.Forms.Label();
			this.txtUsuario = new System.Windows.Forms.TextBox();
			this.txtContra = new System.Windows.Forms.TextBox();
			this.iconLogin = new FontAwesome.Sharp.IconButton();
			this.btnSalir = new FontAwesome.Sharp.IconButton();
			((System.ComponentModel.ISupportInitialize)(this.iconPictureBox1)).BeginInit();
			this.SuspendLayout();
			// 
			// label1
			// 
			this.label1.BackColor = System.Drawing.Color.SteelBlue;
			this.label1.Dock = System.Windows.Forms.DockStyle.Left;
			this.label1.Location = new System.Drawing.Point(0, 0);
			this.label1.Name = "label1";
			this.label1.Size = new System.Drawing.Size(205, 236);
			this.label1.TabIndex = 0;
			// 
			// label2
			// 
			this.label2.AutoSize = true;
			this.label2.BackColor = System.Drawing.Color.SteelBlue;
			this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.label2.ForeColor = System.Drawing.Color.White;
			this.label2.Location = new System.Drawing.Point(-2, 191);
			this.label2.Name = "label2";
			this.label2.Size = new System.Drawing.Size(207, 25);
			this.label2.TabIndex = 1;
			this.label2.Text = "SISTEMA DE VENTA";
			// 
			// iconPictureBox1
			// 
			this.iconPictureBox1.BackColor = System.Drawing.Color.SteelBlue;
			this.iconPictureBox1.IconChar = FontAwesome.Sharp.IconChar.Store;
			this.iconPictureBox1.IconColor = System.Drawing.Color.White;
			this.iconPictureBox1.IconFont = FontAwesome.Sharp.IconFont.Auto;
			this.iconPictureBox1.IconSize = 139;
			this.iconPictureBox1.Location = new System.Drawing.Point(32, 28);
			this.iconPictureBox1.Name = "iconPictureBox1";
			this.iconPictureBox1.Size = new System.Drawing.Size(141, 139);
			this.iconPictureBox1.TabIndex = 2;
			this.iconPictureBox1.TabStop = false;
			// 
			// label3
			// 
			this.label3.AutoSize = true;
			this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.label3.Location = new System.Drawing.Point(292, 9);
			this.label3.Name = "label3";
			this.label3.Size = new System.Drawing.Size(148, 20);
			this.label3.TabIndex = 3;
			this.label3.Text = "INICIAR SESIÓN";
			// 
			// label4
			// 
			this.label4.AutoSize = true;
			this.label4.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.label4.Location = new System.Drawing.Point(241, 41);
			this.label4.Name = "label4";
			this.label4.Size = new System.Drawing.Size(50, 13);
			this.label4.TabIndex = 4;
			this.label4.Text = "Usuario";
			// 
			// label5
			// 
			this.label5.AutoSize = true;
			this.label5.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.label5.Location = new System.Drawing.Point(241, 115);
			this.label5.Name = "label5";
			this.label5.Size = new System.Drawing.Size(71, 13);
			this.label5.TabIndex = 5;
			this.label5.Text = "Contraseña";
			// 
			// txtUsuario
			// 
			this.txtUsuario.Location = new System.Drawing.Point(244, 69);
			this.txtUsuario.Name = "txtUsuario";
			this.txtUsuario.Size = new System.Drawing.Size(165, 20);
			this.txtUsuario.TabIndex = 6;
			// 
			// txtContra
			// 
			this.txtContra.Location = new System.Drawing.Point(244, 147);
			this.txtContra.Name = "txtContra";
			this.txtContra.PasswordChar = '*';
			this.txtContra.Size = new System.Drawing.Size(165, 20);
			this.txtContra.TabIndex = 7;
			// 
			// iconLogin
			// 
			this.iconLogin.BackColor = System.Drawing.Color.RoyalBlue;
			this.iconLogin.Cursor = System.Windows.Forms.Cursors.Hand;
			this.iconLogin.FlatAppearance.BorderColor = System.Drawing.Color.White;
			this.iconLogin.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
			this.iconLogin.ForeColor = System.Drawing.Color.White;
			this.iconLogin.IconChar = FontAwesome.Sharp.IconChar.DoorOpen;
			this.iconLogin.IconColor = System.Drawing.Color.White;
			this.iconLogin.IconFont = FontAwesome.Sharp.IconFont.Auto;
			this.iconLogin.IconSize = 21;
			this.iconLogin.ImageAlign = System.Drawing.ContentAlignment.TopLeft;
			this.iconLogin.Location = new System.Drawing.Point(244, 189);
			this.iconLogin.Name = "iconLogin";
			this.iconLogin.Size = new System.Drawing.Size(102, 25);
			this.iconLogin.TabIndex = 8;
			this.iconLogin.Text = "Iniciar Sesión";
			this.iconLogin.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
			this.iconLogin.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText;
			this.iconLogin.UseVisualStyleBackColor = false;
			this.iconLogin.Click += new System.EventHandler(this.iconLogin_Click);
			// 
			// btnSalir
			// 
			this.btnSalir.BackColor = System.Drawing.Color.Firebrick;
			this.btnSalir.Cursor = System.Windows.Forms.Cursors.Hand;
			this.btnSalir.FlatAppearance.BorderColor = System.Drawing.Color.White;
			this.btnSalir.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
			this.btnSalir.ForeColor = System.Drawing.Color.White;
			this.btnSalir.IconChar = FontAwesome.Sharp.IconChar.TimesCircle;
			this.btnSalir.IconColor = System.Drawing.Color.White;
			this.btnSalir.IconFont = FontAwesome.Sharp.IconFont.Auto;
			this.btnSalir.IconSize = 21;
			this.btnSalir.ImageAlign = System.Drawing.ContentAlignment.TopLeft;
			this.btnSalir.Location = new System.Drawing.Point(352, 189);
			this.btnSalir.Name = "btnSalir";
			this.btnSalir.Size = new System.Drawing.Size(102, 25);
			this.btnSalir.TabIndex = 10;
			this.btnSalir.Text = "Cerrar Sesión";
			this.btnSalir.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
			this.btnSalir.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText;
			this.btnSalir.UseVisualStyleBackColor = false;
			this.btnSalir.Click += new System.EventHandler(this.btnSalir_Click);
			// 
			// Login
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.BackColor = System.Drawing.Color.White;
			this.ClientSize = new System.Drawing.Size(532, 236);
			this.Controls.Add(this.btnSalir);
			this.Controls.Add(this.iconLogin);
			this.Controls.Add(this.txtContra);
			this.Controls.Add(this.txtUsuario);
			this.Controls.Add(this.label5);
			this.Controls.Add(this.label4);
			this.Controls.Add(this.label3);
			this.Controls.Add(this.iconPictureBox1);
			this.Controls.Add(this.label2);
			this.Controls.Add(this.label1);
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
			this.Name = "Login";
			this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
			this.Text = "Login";
			((System.ComponentModel.ISupportInitialize)(this.iconPictureBox1)).EndInit();
			this.ResumeLayout(false);
			this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private FontAwesome.Sharp.IconPictureBox iconPictureBox1;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.TextBox txtUsuario;
        private System.Windows.Forms.TextBox txtContra;
        private FontAwesome.Sharp.IconButton iconLogin;
        private FontAwesome.Sharp.IconButton btnSalir;
    }
}