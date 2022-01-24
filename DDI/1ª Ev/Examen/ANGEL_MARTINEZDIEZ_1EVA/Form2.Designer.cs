
namespace ANGEL_MARTINEZDIEZ_1EVA
{
	partial class Reserva
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
			this.textBox = new System.Windows.Forms.RichTextBox();
			this.cerrar = new System.Windows.Forms.Button();
			this.SuspendLayout();
			// 
			// textBox
			// 
			this.textBox.Location = new System.Drawing.Point(12, 12);
			this.textBox.Name = "textBox";
			this.textBox.Size = new System.Drawing.Size(256, 68);
			this.textBox.TabIndex = 2;
			this.textBox.Text = "";
			// 
			// cerrar
			// 
			this.cerrar.Location = new System.Drawing.Point(99, 86);
			this.cerrar.Name = "cerrar";
			this.cerrar.Size = new System.Drawing.Size(75, 23);
			this.cerrar.TabIndex = 3;
			this.cerrar.Text = "Aceptar";
			this.cerrar.UseVisualStyleBackColor = true;
			this.cerrar.Click += new System.EventHandler(this.cerrar_Click);
			// 
			// Reserva
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(280, 117);
			this.Controls.Add(this.cerrar);
			this.Controls.Add(this.textBox);
			this.MaximizeBox = false;
			this.MinimizeBox = false;
			this.Name = "Reserva";
			this.ShowIcon = false;
			this.Text = "Mensaje del sistema";
			this.ResumeLayout(false);

		}

		#endregion

		private System.Windows.Forms.RichTextBox textBox;
		private System.Windows.Forms.Button cerrar;
	}
}