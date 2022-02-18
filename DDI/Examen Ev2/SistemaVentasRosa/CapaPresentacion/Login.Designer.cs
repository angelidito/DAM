
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
			this.txtClave = new System.Windows.Forms.TextBox();
			this.btninicio = new FontAwesome.Sharp.IconButton();
			this.btnSalir = new FontAwesome.Sharp.IconButton();
			((System.ComponentModel.ISupportInitialize)(this.iconPictureBox1)).BeginInit();
			this.SuspendLayout();
			// 
			// label1
			// 
			this.label1.BackColor = System.Drawing.Color.SteelBlue;
			this.label1.Dock = System.Windows.Forms.DockStyle.Left;
			this.label1.Location = new System.Drawing.Point(0, 0);
			this.label1.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
			this.label1.Name = "label1";
			this.label1.Size = new System.Drawing.Size(205, 215);
			this.label1.TabIndex = 0;
			// 
			// label2
			// 
			this.label2.AutoSize = true;
			this.label2.BackColor = System.Drawing.Color.SteelBlue;
			this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.label2.ForeColor = System.Drawing.Color.White;
			this.label2.Location = new System.Drawing.Point(-2, 154);
			this.label2.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
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
			this.iconPictureBox1.IconSize = 104;
			this.iconPictureBox1.Location = new System.Drawing.Point(40, 21);
			this.iconPictureBox1.Margin = new System.Windows.Forms.Padding(0);
			this.iconPictureBox1.Name = "iconPictureBox1";
			this.iconPictureBox1.Size = new System.Drawing.Size(104, 113);
			this.iconPictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
			this.iconPictureBox1.TabIndex = 2;
			this.iconPictureBox1.TabStop = false;
			// 
			// label3
			// 
			this.label3.AutoSize = true;
			this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.label3.Location = new System.Drawing.Point(251, 9);
			this.label3.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
			this.label3.Name = "label3";
			this.label3.Size = new System.Drawing.Size(148, 20);
			this.label3.TabIndex = 3;
			this.label3.Text = "INICIAR SESION";
			// 
			// label4
			// 
			this.label4.AutoSize = true;
			this.label4.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.label4.Location = new System.Drawing.Point(253, 51);
			this.label4.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
			this.label4.Name = "label4";
			this.label4.Size = new System.Drawing.Size(64, 17);
			this.label4.TabIndex = 4;
			this.label4.Text = "Usuario";
			// 
			// label5
			// 
			this.label5.AutoSize = true;
			this.label5.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.label5.Location = new System.Drawing.Point(253, 108);
			this.label5.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
			this.label5.Name = "label5";
			this.label5.Size = new System.Drawing.Size(91, 17);
			this.label5.TabIndex = 5;
			this.label5.Text = "Contraseña";
			// 
			// txtUsuario
			// 
			this.txtUsuario.Location = new System.Drawing.Point(255, 69);
			this.txtUsuario.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
			this.txtUsuario.Name = "txtUsuario";
			this.txtUsuario.Size = new System.Drawing.Size(134, 20);
			this.txtUsuario.TabIndex = 6;
			// 
			// txtClave
			// 
			this.txtClave.Location = new System.Drawing.Point(256, 126);
			this.txtClave.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
			this.txtClave.Name = "txtClave";
			this.txtClave.PasswordChar = '*';
			this.txtClave.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
			this.txtClave.Size = new System.Drawing.Size(134, 20);
			this.txtClave.TabIndex = 7;
			this.txtClave.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
			// 
			// btninicio
			// 
			this.btninicio.BackColor = System.Drawing.Color.RoyalBlue;
			this.btninicio.Cursor = System.Windows.Forms.Cursors.Hand;
			this.btninicio.FlatAppearance.BorderColor = System.Drawing.Color.White;
			this.btninicio.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
			this.btninicio.ForeColor = System.Drawing.Color.White;
			this.btninicio.IconChar = FontAwesome.Sharp.IconChar.DoorOpen;
			this.btninicio.IconColor = System.Drawing.Color.White;
			this.btninicio.IconFont = FontAwesome.Sharp.IconFont.Auto;
			this.btninicio.IconSize = 21;
			this.btninicio.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
			this.btninicio.Location = new System.Drawing.Point(228, 160);
			this.btninicio.Margin = new System.Windows.Forms.Padding(0);
			this.btninicio.Name = "btninicio";
			this.btninicio.Size = new System.Drawing.Size(114, 24);
			this.btninicio.TabIndex = 8;
			this.btninicio.Text = "Iniciar Sesión";
			this.btninicio.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
			this.btninicio.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText;
			this.btninicio.UseVisualStyleBackColor = false;
			this.btninicio.Click += new System.EventHandler(this.btninicio_Click);
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
			this.btnSalir.Location = new System.Drawing.Point(351, 159);
			this.btnSalir.Margin = new System.Windows.Forms.Padding(0);
			this.btnSalir.Name = "btnSalir";
			this.btnSalir.Size = new System.Drawing.Size(72, 24);
			this.btnSalir.TabIndex = 9;
			this.btnSalir.Text = "Salir";
			this.btnSalir.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText;
			this.btnSalir.UseVisualStyleBackColor = false;
			this.btnSalir.Click += new System.EventHandler(this.btnSalir_Click);
			// 
			// Login
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.BackColor = System.Drawing.Color.White;
			this.ClientSize = new System.Drawing.Size(447, 215);
			this.Controls.Add(this.btnSalir);
			this.Controls.Add(this.btninicio);
			this.Controls.Add(this.txtClave);
			this.Controls.Add(this.txtUsuario);
			this.Controls.Add(this.label5);
			this.Controls.Add(this.label4);
			this.Controls.Add(this.label3);
			this.Controls.Add(this.iconPictureBox1);
			this.Controls.Add(this.label2);
			this.Controls.Add(this.label1);
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
			this.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
			this.Name = "Login";
			this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
			this.Text = "Login";
			this.Load += new System.EventHandler(this.Login_Load);
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
        private System.Windows.Forms.TextBox txtClave;
        private FontAwesome.Sharp.IconButton btninicio;
        private FontAwesome.Sharp.IconButton btnSalir;
    }
}