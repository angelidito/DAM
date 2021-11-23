namespace Prog_01_03
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
			this.lblA = new System.Windows.Forms.Label();
			this.lblB = new System.Windows.Forms.Label();
			this.txtA = new System.Windows.Forms.TextBox();
			this.txtB = new System.Windows.Forms.TextBox();
			this.SuspendLayout();
			// 
			// lblA
			// 
			this.lblA.AutoSize = true;
			this.lblA.Location = new System.Drawing.Point(54, 25);
			this.lblA.Name = "lblA";
			this.lblA.Size = new System.Drawing.Size(14, 13);
			this.lblA.TabIndex = 0;
			this.lblA.Text = "A";
			// 
			// lblB
			// 
			this.lblB.AutoSize = true;
			this.lblB.Location = new System.Drawing.Point(54, 53);
			this.lblB.Name = "lblB";
			this.lblB.Size = new System.Drawing.Size(14, 13);
			this.lblB.TabIndex = 1;
			this.lblB.Text = "B";
			this.lblB.Click += new System.EventHandler(this.label1_Click);
			// 
			// txtA
			// 
			this.txtA.Location = new System.Drawing.Point(74, 22);
			this.txtA.Name = "txtA";
			this.txtA.Size = new System.Drawing.Size(100, 20);
			this.txtA.TabIndex = 2;
			// 
			// txtB
			// 
			this.txtB.Location = new System.Drawing.Point(74, 50);
			this.txtB.Name = "txtB";
			this.txtB.Size = new System.Drawing.Size(100, 20);
			this.txtB.TabIndex = 3;
			// 
			// Form1
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(600, 450);
			this.Controls.Add(this.txtB);
			this.Controls.Add(this.txtA);
			this.Controls.Add(this.lblB);
			this.Controls.Add(this.lblA);
			this.Name = "Form1";
			this.Text = "Form1";
			this.Load += new System.EventHandler(this.Form1_Load);
			this.ResumeLayout(false);
			this.PerformLayout();

		}

		#endregion

		private System.Windows.Forms.Label lblA;
		private System.Windows.Forms.Label lblB;
		private System.Windows.Forms.TextBox txtA;
		private System.Windows.Forms.TextBox txtB;
	}
}

