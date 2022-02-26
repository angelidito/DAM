
namespace CapaPresentacion
{
    partial class frmCategoria
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
            this.btnbuscar = new FontAwesome.Sharp.IconButton();
            this.btnlimpiarbuscador = new FontAwesome.Sharp.IconButton();
            this.label11 = new System.Windows.Forms.Label();
            this.txtId = new System.Windows.Forms.Label();
            this.dgvdata = new System.Windows.Forms.DataGridView();
            this.btnSeleccionar = new System.Windows.Forms.DataGridViewButtonColumn();
            this.IdCategoria = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Descripcion = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.EstadoValor = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Estado = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.btneliminar = new FontAwesome.Sharp.IconButton();
            this.btnlimpiar = new FontAwesome.Sharp.IconButton();
            this.btnguardar = new FontAwesome.Sharp.IconButton();
            this.cboestado = new System.Windows.Forms.ComboBox();
            this.cbobusqueda = new System.Windows.Forms.ComboBox();
            this.txtdescripcion = new System.Windows.Forms.TextBox();
            this.label9 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label12 = new System.Windows.Forms.Label();
            this.label10 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.txtIndice = new System.Windows.Forms.Label();
            this.txtbusqueda = new System.Windows.Forms.TextBox();
            this.btnBusca = new FontAwesome.Sharp.IconButton();
            ((System.ComponentModel.ISupportInitialize)(this.dgvdata)).BeginInit();
            this.SuspendLayout();
            // 
            // btnbuscar
            // 
            this.btnbuscar.BackColor = System.Drawing.Color.White;
            this.btnbuscar.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnbuscar.IconChar = FontAwesome.Sharp.IconChar.Search;
            this.btnbuscar.IconColor = System.Drawing.Color.Black;
            this.btnbuscar.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.btnbuscar.IconSize = 18;
            this.btnbuscar.Location = new System.Drawing.Point(787, -175);
            this.btnbuscar.Margin = new System.Windows.Forms.Padding(0);
            this.btnbuscar.Name = "btnbuscar";
            this.btnbuscar.RightToLeft = System.Windows.Forms.RightToLeft.No;
            this.btnbuscar.Size = new System.Drawing.Size(19, 20);
            this.btnbuscar.TabIndex = 39;
            this.btnbuscar.UseVisualStyleBackColor = false;
            // 
            // btnlimpiarbuscador
            // 
            this.btnlimpiarbuscador.BackColor = System.Drawing.Color.White;
            this.btnlimpiarbuscador.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnlimpiarbuscador.IconChar = FontAwesome.Sharp.IconChar.Broom;
            this.btnlimpiarbuscador.IconColor = System.Drawing.Color.Black;
            this.btnlimpiarbuscador.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.btnlimpiarbuscador.IconSize = 18;
            this.btnlimpiarbuscador.Location = new System.Drawing.Point(761, 16);
            this.btnlimpiarbuscador.Margin = new System.Windows.Forms.Padding(0);
            this.btnlimpiarbuscador.Name = "btnlimpiarbuscador";
            this.btnlimpiarbuscador.Size = new System.Drawing.Size(19, 20);
            this.btnlimpiarbuscador.TabIndex = 38;
            this.btnlimpiarbuscador.UseVisualStyleBackColor = false;
            this.btnlimpiarbuscador.Click += new System.EventHandler(this.btnlimpiarbuscador_Click);
            // 
            // label11
            // 
            this.label11.AutoSize = true;
            this.label11.BackColor = System.Drawing.Color.White;
            this.label11.Location = new System.Drawing.Point(387, 18);
            this.label11.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label11.Name = "label11";
            this.label11.Size = new System.Drawing.Size(61, 13);
            this.label11.TabIndex = 37;
            this.label11.Text = "Buscar por:";
            // 
            // txtId
            // 
            this.txtId.AutoSize = true;
            this.txtId.Location = new System.Drawing.Point(92, 49);
            this.txtId.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.txtId.Name = "txtId";
            this.txtId.Size = new System.Drawing.Size(13, 13);
            this.txtId.TabIndex = 36;
            this.txtId.Text = "0";
            // 
            // dgvdata
            // 
            this.dgvdata.AllowUserToAddRows = false;
            this.dgvdata.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvdata.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.btnSeleccionar,
            this.IdCategoria,
            this.Descripcion,
            this.EstadoValor,
            this.Estado});
            this.dgvdata.Location = new System.Drawing.Point(179, 66);
            this.dgvdata.Margin = new System.Windows.Forms.Padding(2);
            this.dgvdata.Name = "dgvdata";
            this.dgvdata.RowHeadersWidth = 51;
            this.dgvdata.RowTemplate.Height = 24;
            this.dgvdata.Size = new System.Drawing.Size(655, 257);
            this.dgvdata.TabIndex = 35;
            this.dgvdata.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dgvdata_CellContentClick);
            this.dgvdata.CellPainting += new System.Windows.Forms.DataGridViewCellPaintingEventHandler(this.dgvdata_CellPainting);
            // 
            // btnSeleccionar
            // 
            this.btnSeleccionar.HeaderText = "";
            this.btnSeleccionar.MinimumWidth = 6;
            this.btnSeleccionar.Name = "btnSeleccionar";
            this.btnSeleccionar.Resizable = System.Windows.Forms.DataGridViewTriState.True;
            this.btnSeleccionar.SortMode = System.Windows.Forms.DataGridViewColumnSortMode.Automatic;
            this.btnSeleccionar.Width = 30;
            // 
            // IdCategoria
            // 
            this.IdCategoria.HeaderText = "IdCategoria";
            this.IdCategoria.MinimumWidth = 6;
            this.IdCategoria.Name = "IdCategoria";
            this.IdCategoria.Visible = false;
            this.IdCategoria.Width = 150;
            // 
            // Descripcion
            // 
            this.Descripcion.HeaderText = "Descripcion";
            this.Descripcion.MinimumWidth = 6;
            this.Descripcion.Name = "Descripcion";
            this.Descripcion.Width = 150;
            // 
            // EstadoValor
            // 
            this.EstadoValor.HeaderText = "EstadoValor";
            this.EstadoValor.MinimumWidth = 6;
            this.EstadoValor.Name = "EstadoValor";
            this.EstadoValor.Visible = false;
            this.EstadoValor.Width = 125;
            // 
            // Estado
            // 
            this.Estado.HeaderText = "Estado";
            this.Estado.MinimumWidth = 6;
            this.Estado.Name = "Estado";
            this.Estado.Width = 125;
            // 
            // btneliminar
            // 
            this.btneliminar.BackColor = System.Drawing.Color.Firebrick;
            this.btneliminar.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btneliminar.FlatAppearance.BorderColor = System.Drawing.Color.Black;
            this.btneliminar.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btneliminar.ForeColor = System.Drawing.Color.White;
            this.btneliminar.IconChar = FontAwesome.Sharp.IconChar.TrashAlt;
            this.btneliminar.IconColor = System.Drawing.Color.White;
            this.btneliminar.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.btneliminar.IconSize = 18;
            this.btneliminar.Location = new System.Drawing.Point(14, 196);
            this.btneliminar.Margin = new System.Windows.Forms.Padding(0);
            this.btneliminar.Name = "btneliminar";
            this.btneliminar.Size = new System.Drawing.Size(131, 23);
            this.btneliminar.TabIndex = 34;
            this.btneliminar.Text = "Eliminar";
            this.btneliminar.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.btneliminar.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText;
            this.btneliminar.UseVisualStyleBackColor = false;
            this.btneliminar.Click += new System.EventHandler(this.btneliminar_Click);
            // 
            // btnlimpiar
            // 
            this.btnlimpiar.BackColor = System.Drawing.Color.RoyalBlue;
            this.btnlimpiar.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnlimpiar.FlatAppearance.BorderColor = System.Drawing.Color.Black;
            this.btnlimpiar.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnlimpiar.ForeColor = System.Drawing.Color.White;
            this.btnlimpiar.IconChar = FontAwesome.Sharp.IconChar.Broom;
            this.btnlimpiar.IconColor = System.Drawing.Color.White;
            this.btnlimpiar.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.btnlimpiar.IconSize = 18;
            this.btnlimpiar.Location = new System.Drawing.Point(14, 170);
            this.btnlimpiar.Margin = new System.Windows.Forms.Padding(0);
            this.btnlimpiar.Name = "btnlimpiar";
            this.btnlimpiar.Size = new System.Drawing.Size(131, 23);
            this.btnlimpiar.TabIndex = 33;
            this.btnlimpiar.Text = "Limpiar";
            this.btnlimpiar.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.btnlimpiar.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText;
            this.btnlimpiar.UseVisualStyleBackColor = false;
            this.btnlimpiar.Click += new System.EventHandler(this.btnlimpiar_Click);
            // 
            // btnguardar
            // 
            this.btnguardar.BackColor = System.Drawing.Color.ForestGreen;
            this.btnguardar.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnguardar.FlatAppearance.BorderColor = System.Drawing.Color.Black;
            this.btnguardar.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnguardar.ForeColor = System.Drawing.Color.White;
            this.btnguardar.IconChar = FontAwesome.Sharp.IconChar.Save;
            this.btnguardar.IconColor = System.Drawing.Color.White;
            this.btnguardar.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.btnguardar.IconSize = 18;
            this.btnguardar.Location = new System.Drawing.Point(14, 144);
            this.btnguardar.Margin = new System.Windows.Forms.Padding(0);
            this.btnguardar.Name = "btnguardar";
            this.btnguardar.Size = new System.Drawing.Size(131, 23);
            this.btnguardar.TabIndex = 32;
            this.btnguardar.Text = "Guardar";
            this.btnguardar.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.btnguardar.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText;
            this.btnguardar.UseVisualStyleBackColor = false;
            this.btnguardar.Click += new System.EventHandler(this.btnguardar_Click);
            // 
            // cboestado
            // 
            this.cboestado.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cboestado.FormattingEnabled = true;
            this.cboestado.Location = new System.Drawing.Point(12, 114);
            this.cboestado.Margin = new System.Windows.Forms.Padding(2);
            this.cboestado.Name = "cboestado";
            this.cboestado.Size = new System.Drawing.Size(134, 21);
            this.cboestado.TabIndex = 31;
            // 
            // cbobusqueda
            // 
            this.cbobusqueda.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbobusqueda.FormattingEnabled = true;
            this.cbobusqueda.Location = new System.Drawing.Point(452, 15);
            this.cbobusqueda.Margin = new System.Windows.Forms.Padding(2);
            this.cbobusqueda.Name = "cbobusqueda";
            this.cbobusqueda.Size = new System.Drawing.Size(161, 21);
            this.cbobusqueda.TabIndex = 30;
            // 
            // txtdescripcion
            // 
            this.txtdescripcion.Location = new System.Drawing.Point(11, 66);
            this.txtdescripcion.Margin = new System.Windows.Forms.Padding(2);
            this.txtdescripcion.Name = "txtdescripcion";
            this.txtdescripcion.Size = new System.Drawing.Size(134, 20);
            this.txtdescripcion.TabIndex = 24;
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.BackColor = System.Drawing.Color.White;
            this.label9.Location = new System.Drawing.Point(10, 98);
            this.label9.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(40, 13);
            this.label9.TabIndex = 23;
            this.label9.Text = "Estado";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.BackColor = System.Drawing.Color.White;
            this.label3.Location = new System.Drawing.Point(9, 49);
            this.label3.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(63, 13);
            this.label3.TabIndex = 17;
            this.label3.Text = "Descripcion";
            // 
            // label12
            // 
            this.label12.AutoSize = true;
            this.label12.BackColor = System.Drawing.Color.White;
            this.label12.Font = new System.Drawing.Font("Microsoft Sans Serif", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label12.Location = new System.Drawing.Point(197, 13);
            this.label12.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label12.Name = "label12";
            this.label12.Size = new System.Drawing.Size(186, 25);
            this.label12.TabIndex = 15;
            this.label12.Text = "Lista de Categorias:";
            // 
            // label10
            // 
            this.label10.BackColor = System.Drawing.Color.White;
            this.label10.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.label10.Font = new System.Drawing.Font("Microsoft Sans Serif", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label10.Location = new System.Drawing.Point(179, 5);
            this.label10.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label10.Name = "label10";
            this.label10.Size = new System.Drawing.Size(655, 42);
            this.label10.TabIndex = 14;
            this.label10.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.BackColor = System.Drawing.Color.White;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(5, 14);
            this.label1.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(162, 25);
            this.label1.TabIndex = 13;
            this.label1.Text = "Detalle Categoría";
            // 
            // txtIndice
            // 
            this.txtIndice.AutoSize = true;
            this.txtIndice.Location = new System.Drawing.Point(118, 49);
            this.txtIndice.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.txtIndice.Name = "txtIndice";
            this.txtIndice.Size = new System.Drawing.Size(16, 13);
            this.txtIndice.TabIndex = 41;
            this.txtIndice.Text = "-1";
            // 
            // txtbusqueda
            // 
            this.txtbusqueda.Location = new System.Drawing.Point(617, 16);
            this.txtbusqueda.Margin = new System.Windows.Forms.Padding(2);
            this.txtbusqueda.Name = "txtbusqueda";
            this.txtbusqueda.Size = new System.Drawing.Size(123, 20);
            this.txtbusqueda.TabIndex = 43;
            // 
            // btnBusca
            // 
            this.btnBusca.BackColor = System.Drawing.Color.White;
            this.btnBusca.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnBusca.IconChar = FontAwesome.Sharp.IconChar.Search;
            this.btnBusca.IconColor = System.Drawing.Color.Black;
            this.btnBusca.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.btnBusca.IconSize = 18;
            this.btnBusca.Location = new System.Drawing.Point(742, 16);
            this.btnBusca.Margin = new System.Windows.Forms.Padding(0);
            this.btnBusca.Name = "btnBusca";
            this.btnBusca.RightToLeft = System.Windows.Forms.RightToLeft.No;
            this.btnBusca.Size = new System.Drawing.Size(19, 20);
            this.btnBusca.TabIndex = 42;
            this.btnBusca.UseVisualStyleBackColor = false;
            this.btnBusca.Click += new System.EventHandler(this.btnBuscarC_Click);
            // 
            // frmCategoria
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(861, 334);
            this.Controls.Add(this.txtbusqueda);
            this.Controls.Add(this.btnBusca);
            this.Controls.Add(this.txtIndice);
            this.Controls.Add(this.btnbuscar);
            this.Controls.Add(this.btnlimpiarbuscador);
            this.Controls.Add(this.label11);
            this.Controls.Add(this.txtId);
            this.Controls.Add(this.dgvdata);
            this.Controls.Add(this.btneliminar);
            this.Controls.Add(this.btnlimpiar);
            this.Controls.Add(this.btnguardar);
            this.Controls.Add(this.cboestado);
            this.Controls.Add(this.cbobusqueda);
            this.Controls.Add(this.txtdescripcion);
            this.Controls.Add(this.label9);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label12);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.label10);
            this.Name = "frmCategoria";
            this.Text = "frmCategoria";
            this.Load += new System.EventHandler(this.frmCategoria_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dgvdata)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private FontAwesome.Sharp.IconButton btnbuscar;
        private FontAwesome.Sharp.IconButton btnlimpiarbuscador;
        private System.Windows.Forms.Label label11;
        private System.Windows.Forms.Label txtId;
        private System.Windows.Forms.DataGridView dgvdata;
        private FontAwesome.Sharp.IconButton btneliminar;
        private FontAwesome.Sharp.IconButton btnlimpiar;
        private FontAwesome.Sharp.IconButton btnguardar;
        private System.Windows.Forms.ComboBox cboestado;
        private System.Windows.Forms.ComboBox cbobusqueda;
        private System.Windows.Forms.TextBox txtdescripcion;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label12;
        private System.Windows.Forms.Label label10;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label txtIndice;
        private System.Windows.Forms.TextBox txtbusqueda;
        private FontAwesome.Sharp.IconButton btnBusca;
        private System.Windows.Forms.DataGridViewButtonColumn btnSeleccionar;
        private System.Windows.Forms.DataGridViewTextBoxColumn IdCategoria;
        private System.Windows.Forms.DataGridViewTextBoxColumn Descripcion;
        private System.Windows.Forms.DataGridViewTextBoxColumn EstadoValor;
        private System.Windows.Forms.DataGridViewTextBoxColumn Estado;
    }
}