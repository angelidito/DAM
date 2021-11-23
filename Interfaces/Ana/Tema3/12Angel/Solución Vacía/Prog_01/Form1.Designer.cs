namespace Prog_01
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
			this.btnSaludo = new System.Windows.Forms.Button();
			this.lblMensaje = new System.Windows.Forms.Label();
			this.btnDespedida = new System.Windows.Forms.Button();
			this.SuspendLayout();
			// 
			// btnSaludo
			// 
			this.btnSaludo.Location = new System.Drawing.Point(12, 12);
			this.btnSaludo.Name = "btnSaludo";
			this.btnSaludo.Size = new System.Drawing.Size(75, 23);
			this.btnSaludo.TabIndex = 0;
			this.btnSaludo.Text = "Saludar";
			this.btnSaludo.UseVisualStyleBackColor = true;
			this.btnSaludo.Click += new System.EventHandler(this.button1_Click);
			// 
			// lblMensaje
			// 
			this.lblMensaje.AutoSize = true;
			this.lblMensaje.Location = new System.Drawing.Point(72, 54);
			this.lblMensaje.Name = "lblMensaje";
			this.lblMensaje.Size = new System.Drawing.Size(35, 13);
			this.lblMensaje.TabIndex = 1;
			this.lblMensaje.Text = "label1";
			this.lblMensaje.Click += new System.EventHandler(this.Mensaje_Click);
			// 
			// btnDespedida
			// 
			this.btnDespedida.Location = new System.Drawing.Point(93, 12);
			this.btnDespedida.Name = "btnDespedida";
			this.btnDespedida.Size = new System.Drawing.Size(75, 23);
			this.btnDespedida.TabIndex = 2;
			this.btnDespedida.Text = "Despedir";
			this.btnDespedida.UseVisualStyleBackColor = true;
			this.btnDespedida.Click += new System.EventHandler(this.btnDespedida_Click);
			// 
			// Form1
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(766, 460);
			this.Controls.Add(this.btnDespedida);
			this.Controls.Add(this.lblMensaje);
			this.Controls.Add(this.btnSaludo);
			this.Name = "Form1";
			this.Text = "Form1";
			this.Load += new System.EventHandler(this.Form1_Load);
			this.ResumeLayout(false);
			this.PerformLayout();

		}

		#endregion

		private System.Windows.Forms.Button btnSaludo;
		private System.Windows.Forms.Label lblMensaje;
		private System.Windows.Forms.Button btnDespedida;
	}
}

