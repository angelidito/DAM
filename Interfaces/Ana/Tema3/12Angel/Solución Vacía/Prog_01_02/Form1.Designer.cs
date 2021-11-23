namespace Prog_01_02
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
			this.lblNombre = new System.Windows.Forms.Label();
			this.tbNombre = new System.Windows.Forms.TextBox();
			this.lblMensaje = new System.Windows.Forms.Label();
			this.btnSaludo = new System.Windows.Forms.Button();
			this.SuspendLayout();
			// 
			// lblNombre
			// 
			this.lblNombre.AutoSize = true;
			this.lblNombre.Location = new System.Drawing.Point(20, 48);
			this.lblNombre.Name = "lblNombre";
			this.lblNombre.Size = new System.Drawing.Size(50, 13);
			this.lblNombre.TabIndex = 0;
			this.lblNombre.Text = "Nombre: ";
			// 
			// tbNombre
			// 
			this.tbNombre.Location = new System.Drawing.Point(76, 45);
			this.tbNombre.Name = "tbNombre";
			this.tbNombre.Size = new System.Drawing.Size(100, 20);
			this.tbNombre.TabIndex = 1;
			// 
			// lblMensaje
			// 
			this.lblMensaje.AutoSize = true;
			this.lblMensaje.Location = new System.Drawing.Point(73, 68);
			this.lblMensaje.Name = "lblMensaje";
			this.lblMensaje.Size = new System.Drawing.Size(35, 13);
			this.lblMensaje.TabIndex = 2;
			this.lblMensaje.Text = "label1";
			// 
			// btnSaludo
			// 
			this.btnSaludo.Location = new System.Drawing.Point(215, 43);
			this.btnSaludo.Name = "btnSaludo";
			this.btnSaludo.Size = new System.Drawing.Size(75, 23);
			this.btnSaludo.TabIndex = 3;
			this.btnSaludo.Text = "Saludar";
			this.btnSaludo.UseVisualStyleBackColor = true;
			this.btnSaludo.Click += new System.EventHandler(this.btnSaludo_Click);
			// 
			// Form1
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(532, 295);
			this.Controls.Add(this.btnSaludo);
			this.Controls.Add(this.lblMensaje);
			this.Controls.Add(this.tbNombre);
			this.Controls.Add(this.lblNombre);
			this.Name = "Form1";
			this.Text = "Form1";
			this.Load += new System.EventHandler(this.Form1_Load);
			this.ResumeLayout(false);
			this.PerformLayout();

		}

		#endregion

		private System.Windows.Forms.Label lblNombre;
		private System.Windows.Forms.TextBox tbNombre;
		private System.Windows.Forms.Label lblMensaje;
		private System.Windows.Forms.Button btnSaludo;
	}
}

