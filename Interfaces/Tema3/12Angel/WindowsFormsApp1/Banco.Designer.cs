namespace WindowsFormsApp1
{
	partial class Banco
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
			this.btnSolicitarPrestamo = new System.Windows.Forms.Button();
			this.lblTitulo = new System.Windows.Forms.Label();
			this.lblNombre = new System.Windows.Forms.Label();
			this.nombre = new System.Windows.Forms.TextBox();
			this.btnSalir = new System.Windows.Forms.Button();
			this.pictureBox1 = new System.Windows.Forms.PictureBox();
			this.errorProvider1 = new System.Windows.Forms.ErrorProvider(this.components);
			((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
			((System.ComponentModel.ISupportInitialize)(this.errorProvider1)).BeginInit();
			this.SuspendLayout();
			// 
			// btnSolicitarPrestamo
			// 
			this.btnSolicitarPrestamo.BackColor = System.Drawing.Color.Chocolate;
			this.btnSolicitarPrestamo.Cursor = System.Windows.Forms.Cursors.Hand;
			this.btnSolicitarPrestamo.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.btnSolicitarPrestamo.ForeColor = System.Drawing.Color.Navy;
			this.btnSolicitarPrestamo.Location = new System.Drawing.Point(350, 274);
			this.btnSolicitarPrestamo.Name = "btnSolicitarPrestamo";
			this.btnSolicitarPrestamo.Size = new System.Drawing.Size(100, 49);
			this.btnSolicitarPrestamo.TabIndex = 0;
			this.btnSolicitarPrestamo.Text = "Solicitar prestamo";
			this.btnSolicitarPrestamo.UseVisualStyleBackColor = false;
			this.btnSolicitarPrestamo.Click += new System.EventHandler(this.btnSolicitarPrestamo_Click);
			// 
			// lblTitulo
			// 
			this.lblTitulo.AutoSize = true;
			this.lblTitulo.BackColor = System.Drawing.Color.Transparent;
			this.lblTitulo.Font = new System.Drawing.Font("Palatino Linotype", 24F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.lblTitulo.Location = new System.Drawing.Point(176, 166);
			this.lblTitulo.Name = "lblTitulo";
			this.lblTitulo.Size = new System.Drawing.Size(503, 44);
			this.lblTitulo.TabIndex = 1;
			this.lblTitulo.Text = "BANCO DE LA MEDIA TIERRA";
			this.lblTitulo.Click += new System.EventHandler(this.LblTitulo_Click);
			// 
			// lblNombre
			// 
			this.lblNombre.AutoSize = true;
			this.lblNombre.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.lblNombre.Location = new System.Drawing.Point(263, 238);
			this.lblNombre.Name = "lblNombre";
			this.lblNombre.Size = new System.Drawing.Size(81, 17);
			this.lblNombre.TabIndex = 2;
			this.lblNombre.Text = "Su nombre:";
			// 
			// nombre
			// 
			this.nombre.BackColor = System.Drawing.SystemColors.Window;
			this.nombre.Cursor = System.Windows.Forms.Cursors.IBeam;
			this.nombre.Location = new System.Drawing.Point(350, 238);
			this.nombre.Name = "nombre";
			this.nombre.Size = new System.Drawing.Size(225, 20);
			this.nombre.TabIndex = 3;
			this.nombre.TextChanged += new System.EventHandler(this.TextBox1_TextChanged);
			// 
			// btnSalir
			// 
			this.btnSalir.Location = new System.Drawing.Point(717, 397);
			this.btnSalir.Name = "btnSalir";
			this.btnSalir.Size = new System.Drawing.Size(75, 23);
			this.btnSalir.TabIndex = 4;
			this.btnSalir.Text = "Salir";
			this.btnSalir.UseVisualStyleBackColor = true;
			// 
			// pictureBox1
			// 
			this.pictureBox1.Image = global::WindowsFormsApp1.Properties.Resources.media_tierrra;
			this.pictureBox1.Location = new System.Drawing.Point(-3, -1);
			this.pictureBox1.Name = "pictureBox1";
			this.pictureBox1.Size = new System.Drawing.Size(252, 228);
			this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
			this.pictureBox1.TabIndex = 5;
			this.pictureBox1.TabStop = false;
			// 
			// errorProvider1
			// 
			this.errorProvider1.ContainerControl = this;
			// 
			// BancoForm
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.BackColor = System.Drawing.Color.SaddleBrown;
			this.ClientSize = new System.Drawing.Size(804, 461);
			this.Controls.Add(this.btnSalir);
			this.Controls.Add(this.nombre);
			this.Controls.Add(this.lblNombre);
			this.Controls.Add(this.lblTitulo);
			this.Controls.Add(this.btnSolicitarPrestamo);
			this.Controls.Add(this.pictureBox1);
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.Fixed3D;
			this.MaximizeBox = false;
			this.Name = "BancoForm";
			this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
			this.Text = "Banco de la Media Tierra";
			this.TransparencyKey = System.Drawing.Color.Transparent;
			this.Load += new System.EventHandler(this.BancoForm_Load);
			((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
			((System.ComponentModel.ISupportInitialize)(this.errorProvider1)).EndInit();
			this.ResumeLayout(false);
			this.PerformLayout();

		}

		#endregion

		private System.Windows.Forms.Button btnSolicitarPrestamo;
		private System.Windows.Forms.Label lblTitulo;
		private System.Windows.Forms.Label lblNombre;
		private System.Windows.Forms.TextBox nombre;
		private System.Windows.Forms.Button btnSalir;
		private System.Windows.Forms.PictureBox pictureBox1;
		private System.Windows.Forms.ErrorProvider errorProvider1;
	}
}

