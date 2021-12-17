
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
			// Ticket
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(249, 299);
			this.Controls.Add(this.ticketText);
			this.MaximizeBox = false;
			this.MaximumSize = new System.Drawing.Size(265, 338);
			this.MinimizeBox = false;
			this.Name = "Ticket";
			this.Text = "Town Place - Ticket de reserva";
			this.ResumeLayout(false);

		}

		#endregion

		private System.Windows.Forms.RichTextBox ticketText;
	}
}