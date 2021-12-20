
namespace Tarea_2_3
{
	partial class Ticket
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
			this.ticketText = new System.Windows.Forms.RichTextBox();
			this.btnAceptar = new System.Windows.Forms.Button();
			this.SuspendLayout();
			// 
			// ticketText
			// 
			this.ticketText.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(15)))), ((int)(((byte)(100)))), ((int)(((byte)(15)))));
			this.ticketText.CausesValidation = false;
			this.ticketText.Cursor = System.Windows.Forms.Cursors.IBeam;
			this.ticketText.Font = new System.Drawing.Font("Segoe UI", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
			this.ticketText.ForeColor = System.Drawing.Color.White;
			this.ticketText.Location = new System.Drawing.Point(0, 0);
			this.ticketText.Margin = new System.Windows.Forms.Padding(0);
			this.ticketText.Name = "ticketText";
			this.ticketText.ReadOnly = true;
			this.ticketText.Size = new System.Drawing.Size(250, 300);
			this.ticketText.TabIndex = 0;
			this.ticketText.Text = "";
			// 
			// btnAceptar
			// 
			this.btnAceptar.Location = new System.Drawing.Point(12, 152);
			this.btnAceptar.Name = "btnAceptar";
			this.btnAceptar.Size = new System.Drawing.Size(77, 26);
			this.btnAceptar.TabIndex = 1;
			this.btnAceptar.Text = "Aceptar";
			this.btnAceptar.UseVisualStyleBackColor = true;
			this.btnAceptar.Click += new System.EventHandler(this.btnAceptar_Click);
			// 
			// Ticket
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(234, 211);
			this.Controls.Add(this.btnAceptar);
			this.Controls.Add(this.ticketText);
			this.MaximizeBox = false;
			this.MaximumSize = new System.Drawing.Size(250, 250);
			this.MinimizeBox = false;
			this.MinimumSize = new System.Drawing.Size(250, 250);
			this.Name = "Ticket";
			this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
			this.Text = "Town Place - Ticket de reserva";
			this.ResumeLayout(false);

		}

		#endregion

		private System.Windows.Forms.RichTextBox ticketText;
		private System.Windows.Forms.Button btnAceptar;
	}
}