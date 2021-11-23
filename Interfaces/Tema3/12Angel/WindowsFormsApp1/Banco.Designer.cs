namespace WindowsFormsApp1
{
	partial class BancoForm
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
			this.SuspendLayout();
			// 
			// BancoForm
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.BackColor = System.Drawing.Color.SaddleBrown;
			this.ClientSize = new System.Drawing.Size(804, 461);
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.Fixed3D;
			this.MaximizeBox = false;
			this.Name = "BancoForm";
			this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
			this.Text = "Banco de la Media Tierra";
			this.ResumeLayout(false);

		}

		#endregion
	}
}

