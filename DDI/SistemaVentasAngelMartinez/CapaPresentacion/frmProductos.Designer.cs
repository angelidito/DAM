
namespace CapaPresentacion
{
    partial class frmProductos
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
			this.components = new System.ComponentModel.Container();
			this.label2 = new System.Windows.Forms.Label();
			this.label3 = new System.Windows.Forms.Label();
			this.label1 = new System.Windows.Forms.Label();
			this.Nombre = new System.Windows.Forms.Label();
			this.txtcodigo = new System.Windows.Forms.TextBox();
			this.txtnombre = new System.Windows.Forms.TextBox();
			this.txtdescripcion = new System.Windows.Forms.TextBox();
			this.label8 = new System.Windows.Forms.Label();
			this.cbocategoria = new System.Windows.Forms.ComboBox();
			this.label4 = new System.Windows.Forms.Label();
			this.cboestado = new System.Windows.Forms.ComboBox();
			this.btnguardar = new FontAwesome.Sharp.IconButton();
			this.btnlimpiar = new FontAwesome.Sharp.IconButton();
			this.btneliminar = new FontAwesome.Sharp.IconButton();
			this.dgvdata = new System.Windows.Forms.DataGridView();
			this.btnSeleccionar = new System.Windows.Forms.DataGridViewButtonColumn();
			this.Id = new System.Windows.Forms.DataGridViewTextBoxColumn();
			this.Codigo = new System.Windows.Forms.DataGridViewTextBoxColumn();
			this.NombreCompleto = new System.Windows.Forms.DataGridViewTextBoxColumn();
			this.Descripcion = new System.Windows.Forms.DataGridViewTextBoxColumn();
			this.IdCategoria = new System.Windows.Forms.DataGridViewTextBoxColumn();
			this.Categoria = new System.Windows.Forms.DataGridViewTextBoxColumn();
			this.EstadoValor = new System.Windows.Forms.DataGridViewTextBoxColumn();
			this.Estado = new System.Windows.Forms.DataGridViewTextBoxColumn();
			this.Stock = new System.Windows.Forms.DataGridViewTextBoxColumn();
			this.PrecioCompra = new System.Windows.Forms.DataGridViewTextBoxColumn();
			this.PrecioVenta = new System.Windows.Forms.DataGridViewTextBoxColumn();
			this.label5 = new System.Windows.Forms.Label();
			this.label10 = new System.Windows.Forms.Label();
			this.label12 = new System.Windows.Forms.Label();
			this.label11 = new System.Windows.Forms.Label();
			this.cbobusqueda = new System.Windows.Forms.ComboBox();
			this.txtbusqueda = new System.Windows.Forms.Label();
			this.btnbuscar = new FontAwesome.Sharp.IconButton();
			this.btnlimpiarbuscador = new FontAwesome.Sharp.IconButton();
			this.contextMenuStrip1 = new System.Windows.Forms.ContextMenuStrip(this.components);
			this.txtId = new System.Windows.Forms.Label();
			this.txtIndice = new System.Windows.Forms.Label();
			((System.ComponentModel.ISupportInitialize)(this.dgvdata)).BeginInit();
			this.SuspendLayout();
			// 
			// label2
			// 
			this.label2.BackColor = System.Drawing.Color.White;
			this.label2.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
			this.label2.Dock = System.Windows.Forms.DockStyle.Left;
			this.label2.Location = new System.Drawing.Point(0, 0);
			this.label2.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
			this.label2.Name = "label2";
			this.label2.Size = new System.Drawing.Size(174, 424);
			this.label2.TabIndex = 2;
			// 
			// label3
			// 
			this.label3.AutoSize = true;
			this.label3.BackColor = System.Drawing.Color.White;
			this.label3.Location = new System.Drawing.Point(19, 46);
			this.label3.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
			this.label3.Name = "label3";
			this.label3.Size = new System.Drawing.Size(43, 13);
			this.label3.TabIndex = 3;
			this.label3.Text = "Codigo:";
			// 
			// label1
			// 
			this.label1.AutoSize = true;
			this.label1.BackColor = System.Drawing.Color.White;
			this.label1.Location = new System.Drawing.Point(19, 138);
			this.label1.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
			this.label1.Name = "label1";
			this.label1.Size = new System.Drawing.Size(66, 13);
			this.label1.TabIndex = 4;
			this.label1.Text = "Descripcion:";
			// 
			// Nombre
			// 
			this.Nombre.AutoSize = true;
			this.Nombre.BackColor = System.Drawing.Color.White;
			this.Nombre.Location = new System.Drawing.Point(19, 92);
			this.Nombre.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
			this.Nombre.Name = "Nombre";
			this.Nombre.Size = new System.Drawing.Size(47, 13);
			this.Nombre.TabIndex = 5;
			this.Nombre.Text = "Nombre:";
			// 
			// txtcodigo
			// 
			this.txtcodigo.Location = new System.Drawing.Point(18, 61);
			this.txtcodigo.Margin = new System.Windows.Forms.Padding(2);
			this.txtcodigo.Name = "txtcodigo";
			this.txtcodigo.Size = new System.Drawing.Size(134, 20);
			this.txtcodigo.TabIndex = 6;
			// 
			// txtnombre
			// 
			this.txtnombre.Location = new System.Drawing.Point(18, 107);
			this.txtnombre.Margin = new System.Windows.Forms.Padding(2);
			this.txtnombre.Name = "txtnombre";
			this.txtnombre.Size = new System.Drawing.Size(134, 20);
			this.txtnombre.TabIndex = 7;
			// 
			// txtdescripcion
			// 
			this.txtdescripcion.Location = new System.Drawing.Point(18, 153);
			this.txtdescripcion.Margin = new System.Windows.Forms.Padding(2);
			this.txtdescripcion.Name = "txtdescripcion";
			this.txtdescripcion.Size = new System.Drawing.Size(134, 20);
			this.txtdescripcion.TabIndex = 8;
			// 
			// label8
			// 
			this.label8.AutoSize = true;
			this.label8.BackColor = System.Drawing.Color.White;
			this.label8.Location = new System.Drawing.Point(19, 187);
			this.label8.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
			this.label8.Name = "label8";
			this.label8.Size = new System.Drawing.Size(54, 13);
			this.label8.TabIndex = 9;
			this.label8.Text = "Categoría";
			// 
			// cbocategoria
			// 
			this.cbocategoria.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
			this.cbocategoria.FormattingEnabled = true;
			this.cbocategoria.Location = new System.Drawing.Point(18, 202);
			this.cbocategoria.Margin = new System.Windows.Forms.Padding(2);
			this.cbocategoria.Name = "cbocategoria";
			this.cbocategoria.Size = new System.Drawing.Size(134, 21);
			this.cbocategoria.TabIndex = 10;
			// 
			// label4
			// 
			this.label4.AutoSize = true;
			this.label4.BackColor = System.Drawing.Color.White;
			this.label4.Location = new System.Drawing.Point(19, 234);
			this.label4.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
			this.label4.Name = "label4";
			this.label4.Size = new System.Drawing.Size(40, 13);
			this.label4.TabIndex = 11;
			this.label4.Text = "Estado";
			// 
			// cboestado
			// 
			this.cboestado.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
			this.cboestado.FormattingEnabled = true;
			this.cboestado.Location = new System.Drawing.Point(18, 249);
			this.cboestado.Margin = new System.Windows.Forms.Padding(2);
			this.cboestado.Name = "cboestado";
			this.cboestado.Size = new System.Drawing.Size(134, 21);
			this.cboestado.TabIndex = 12;
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
			this.btnguardar.Location = new System.Drawing.Point(18, 283);
			this.btnguardar.Margin = new System.Windows.Forms.Padding(0);
			this.btnguardar.Name = "btnguardar";
			this.btnguardar.Size = new System.Drawing.Size(134, 23);
			this.btnguardar.TabIndex = 13;
			this.btnguardar.Text = "Guardar";
			this.btnguardar.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
			this.btnguardar.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText;
			this.btnguardar.UseVisualStyleBackColor = false;
			this.btnguardar.Click += new System.EventHandler(this.btnguardar_Click);
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
			this.btnlimpiar.Location = new System.Drawing.Point(18, 315);
			this.btnlimpiar.Margin = new System.Windows.Forms.Padding(0);
			this.btnlimpiar.Name = "btnlimpiar";
			this.btnlimpiar.Size = new System.Drawing.Size(134, 23);
			this.btnlimpiar.TabIndex = 14;
			this.btnlimpiar.Text = "Limpiar";
			this.btnlimpiar.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
			this.btnlimpiar.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText;
			this.btnlimpiar.UseVisualStyleBackColor = false;
			this.btnlimpiar.Click += new System.EventHandler(this.btnlimpiar_Click);
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
			this.btneliminar.Location = new System.Drawing.Point(18, 347);
			this.btneliminar.Margin = new System.Windows.Forms.Padding(0);
			this.btneliminar.Name = "btneliminar";
			this.btneliminar.Size = new System.Drawing.Size(134, 23);
			this.btneliminar.TabIndex = 15;
			this.btneliminar.Text = "Eliminar";
			this.btneliminar.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
			this.btneliminar.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText;
			this.btneliminar.UseVisualStyleBackColor = false;
			this.btneliminar.Click += new System.EventHandler(this.btneliminar_Click);
			// 
			// dgvdata
			// 
			this.dgvdata.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
			this.dgvdata.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.btnSeleccionar,
            this.Id,
            this.Codigo,
            this.NombreCompleto,
            this.Descripcion,
            this.IdCategoria,
            this.Categoria,
            this.EstadoValor,
            this.Estado,
            this.Stock,
            this.PrecioCompra,
            this.PrecioVenta});
			this.dgvdata.Location = new System.Drawing.Point(190, 61);
			this.dgvdata.Name = "dgvdata";
			this.dgvdata.Size = new System.Drawing.Size(822, 345);
			this.dgvdata.TabIndex = 16;
			this.dgvdata.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dgvdata_CellContentClick);
			this.dgvdata.CellPainting += new System.Windows.Forms.DataGridViewCellPaintingEventHandler(this.dgvdata_CellPainting);
			// 
			// btnSeleccionar
			// 
			this.btnSeleccionar.Frozen = true;
			this.btnSeleccionar.HeaderText = "";
			this.btnSeleccionar.Name = "btnSeleccionar";
			this.btnSeleccionar.Width = 25;
			// 
			// Id
			// 
			this.Id.HeaderText = "Id";
			this.Id.Name = "Id";
			this.Id.Visible = false;
			this.Id.Width = 50;
			// 
			// Codigo
			// 
			this.Codigo.HeaderText = "Codigo";
			this.Codigo.Name = "Codigo";
			this.Codigo.Width = 50;
			// 
			// NombreCompleto
			// 
			this.NombreCompleto.HeaderText = "Nombre";
			this.NombreCompleto.Name = "NombreCompleto";
			// 
			// Descripcion
			// 
			this.Descripcion.HeaderText = "Descripcion";
			this.Descripcion.Name = "Descripcion";
			this.Descripcion.Width = 150;
			// 
			// IdCategoria
			// 
			this.IdCategoria.HeaderText = "IdCategoria";
			this.IdCategoria.Name = "IdCategoria";
			this.IdCategoria.Visible = false;
			this.IdCategoria.Width = 25;
			// 
			// Categoria
			// 
			this.Categoria.HeaderText = "Categoria";
			this.Categoria.Name = "Categoria";
			this.Categoria.Width = 150;
			// 
			// EstadoValor
			// 
			this.EstadoValor.HeaderText = "EstadoValor";
			this.EstadoValor.Name = "EstadoValor";
			this.EstadoValor.Visible = false;
			// 
			// Estado
			// 
			this.Estado.HeaderText = "Estado";
			this.Estado.Name = "Estado";
			this.Estado.Width = 75;
			// 
			// Stock
			// 
			this.Stock.HeaderText = "Stock";
			this.Stock.Name = "Stock";
			this.Stock.Width = 75;
			// 
			// PrecioCompra
			// 
			this.PrecioCompra.HeaderText = "Precio Compra";
			this.PrecioCompra.Name = "PrecioCompra";
			this.PrecioCompra.Width = 75;
			// 
			// PrecioVenta
			// 
			this.PrecioVenta.HeaderText = "Precio Venta";
			this.PrecioVenta.Name = "PrecioVenta";
			this.PrecioVenta.Width = 75;
			// 
			// label5
			// 
			this.label5.AutoSize = true;
			this.label5.BackColor = System.Drawing.Color.White;
			this.label5.Font = new System.Drawing.Font("Microsoft Sans Serif", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.label5.Location = new System.Drawing.Point(13, 9);
			this.label5.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
			this.label5.Name = "label5";
			this.label5.Size = new System.Drawing.Size(155, 25);
			this.label5.TabIndex = 17;
			this.label5.Text = "Detalle Producto";
			// 
			// label10
			// 
			this.label10.BackColor = System.Drawing.Color.White;
			this.label10.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
			this.label10.Font = new System.Drawing.Font("Microsoft Sans Serif", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.label10.Location = new System.Drawing.Point(190, 9);
			this.label10.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
			this.label10.Name = "label10";
			this.label10.Size = new System.Drawing.Size(822, 42);
			this.label10.TabIndex = 18;
			this.label10.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
			// 
			// label12
			// 
			this.label12.AutoSize = true;
			this.label12.BackColor = System.Drawing.Color.White;
			this.label12.Font = new System.Drawing.Font("Microsoft Sans Serif", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.label12.Location = new System.Drawing.Point(208, 18);
			this.label12.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
			this.label12.Name = "label12";
			this.label12.Size = new System.Drawing.Size(179, 25);
			this.label12.TabIndex = 19;
			this.label12.Text = "Lista de Productos:";
			// 
			// label11
			// 
			this.label11.AutoSize = true;
			this.label11.BackColor = System.Drawing.Color.White;
			this.label11.Location = new System.Drawing.Point(404, 22);
			this.label11.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
			this.label11.Name = "label11";
			this.label11.Size = new System.Drawing.Size(61, 13);
			this.label11.TabIndex = 20;
			this.label11.Text = "Buscar por:";
			// 
			// cbobusqueda
			// 
			this.cbobusqueda.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
			this.cbobusqueda.FormattingEnabled = true;
			this.cbobusqueda.Location = new System.Drawing.Point(469, 18);
			this.cbobusqueda.Margin = new System.Windows.Forms.Padding(2);
			this.cbobusqueda.Name = "cbobusqueda";
			this.cbobusqueda.Size = new System.Drawing.Size(161, 21);
			this.cbobusqueda.TabIndex = 21;
			// 
			// txtbusqueda
			// 
			this.txtbusqueda.BackColor = System.Drawing.Color.White;
			this.txtbusqueda.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
			this.txtbusqueda.Location = new System.Drawing.Point(634, 18);
			this.txtbusqueda.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
			this.txtbusqueda.Name = "txtbusqueda";
			this.txtbusqueda.Size = new System.Drawing.Size(124, 21);
			this.txtbusqueda.TabIndex = 22;
			// 
			// btnbuscar
			// 
			this.btnbuscar.BackColor = System.Drawing.Color.White;
			this.btnbuscar.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
			this.btnbuscar.IconChar = FontAwesome.Sharp.IconChar.Search;
			this.btnbuscar.IconColor = System.Drawing.Color.Black;
			this.btnbuscar.IconFont = FontAwesome.Sharp.IconFont.Auto;
			this.btnbuscar.IconSize = 18;
			this.btnbuscar.Location = new System.Drawing.Point(760, 19);
			this.btnbuscar.Margin = new System.Windows.Forms.Padding(0);
			this.btnbuscar.Name = "btnbuscar";
			this.btnbuscar.RightToLeft = System.Windows.Forms.RightToLeft.No;
			this.btnbuscar.Size = new System.Drawing.Size(19, 20);
			this.btnbuscar.TabIndex = 23;
			this.btnbuscar.UseVisualStyleBackColor = false;
			this.btnbuscar.Click += new System.EventHandler(this.btnbuscar_Click);
			// 
			// btnlimpiarbuscador
			// 
			this.btnlimpiarbuscador.BackColor = System.Drawing.Color.White;
			this.btnlimpiarbuscador.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
			this.btnlimpiarbuscador.IconChar = FontAwesome.Sharp.IconChar.Broom;
			this.btnlimpiarbuscador.IconColor = System.Drawing.Color.Black;
			this.btnlimpiarbuscador.IconFont = FontAwesome.Sharp.IconFont.Auto;
			this.btnlimpiarbuscador.IconSize = 18;
			this.btnlimpiarbuscador.Location = new System.Drawing.Point(788, 19);
			this.btnlimpiarbuscador.Margin = new System.Windows.Forms.Padding(0);
			this.btnlimpiarbuscador.Name = "btnlimpiarbuscador";
			this.btnlimpiarbuscador.Size = new System.Drawing.Size(19, 20);
			this.btnlimpiarbuscador.TabIndex = 24;
			this.btnlimpiarbuscador.UseVisualStyleBackColor = false;
			this.btnlimpiarbuscador.Click += new System.EventHandler(this.btnlimpiarbuscador_Click);
			// 
			// contextMenuStrip1
			// 
			this.contextMenuStrip1.Name = "contextMenuStrip1";
			this.contextMenuStrip1.Size = new System.Drawing.Size(61, 4);
			// 
			// txtId
			// 
			this.txtId.AutoSize = true;
			this.txtId.Location = new System.Drawing.Point(108, 38);
			this.txtId.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
			this.txtId.Name = "txtId";
			this.txtId.Size = new System.Drawing.Size(13, 13);
			this.txtId.TabIndex = 26;
			this.txtId.Text = "0";
			this.txtId.Visible = false;
			// 
			// txtIndice
			// 
			this.txtIndice.AutoSize = true;
			this.txtIndice.Location = new System.Drawing.Point(136, 38);
			this.txtIndice.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
			this.txtIndice.Name = "txtIndice";
			this.txtIndice.Size = new System.Drawing.Size(16, 13);
			this.txtIndice.TabIndex = 27;
			this.txtIndice.Text = "-1";
			this.txtIndice.Visible = false;
			// 
			// frmProductos
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(1024, 424);
			this.Controls.Add(this.txtIndice);
			this.Controls.Add(this.txtId);
			this.Controls.Add(this.btnlimpiarbuscador);
			this.Controls.Add(this.btnbuscar);
			this.Controls.Add(this.txtbusqueda);
			this.Controls.Add(this.cbobusqueda);
			this.Controls.Add(this.label11);
			this.Controls.Add(this.label12);
			this.Controls.Add(this.label10);
			this.Controls.Add(this.label5);
			this.Controls.Add(this.dgvdata);
			this.Controls.Add(this.btneliminar);
			this.Controls.Add(this.btnlimpiar);
			this.Controls.Add(this.btnguardar);
			this.Controls.Add(this.cboestado);
			this.Controls.Add(this.label4);
			this.Controls.Add(this.cbocategoria);
			this.Controls.Add(this.label8);
			this.Controls.Add(this.txtdescripcion);
			this.Controls.Add(this.txtnombre);
			this.Controls.Add(this.txtcodigo);
			this.Controls.Add(this.Nombre);
			this.Controls.Add(this.label1);
			this.Controls.Add(this.label3);
			this.Controls.Add(this.label2);
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
			this.Name = "frmProductos";
			this.Text = "Form1";
			this.Load += new System.EventHandler(this.frmProductos_Load);
			((System.ComponentModel.ISupportInitialize)(this.dgvdata)).EndInit();
			this.ResumeLayout(false);
			this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label Nombre;
        private System.Windows.Forms.TextBox txtcodigo;
        private System.Windows.Forms.TextBox txtnombre;
        private System.Windows.Forms.TextBox txtdescripcion;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.ComboBox cbocategoria;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.ComboBox cboestado;
        private FontAwesome.Sharp.IconButton btnguardar;
        private FontAwesome.Sharp.IconButton btnlimpiar;
        private FontAwesome.Sharp.IconButton btneliminar;
        private System.Windows.Forms.DataGridView dgvdata;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label10;
        private System.Windows.Forms.Label label12;
        private System.Windows.Forms.Label label11;
        private System.Windows.Forms.ComboBox cbobusqueda;
        private System.Windows.Forms.Label txtbusqueda;
        private FontAwesome.Sharp.IconButton btnbuscar;
        private FontAwesome.Sharp.IconButton btnlimpiarbuscador;
        private System.Windows.Forms.ContextMenuStrip contextMenuStrip1;
        private System.Windows.Forms.Label txtId;
        private System.Windows.Forms.Label txtIndice;
		private System.Windows.Forms.DataGridViewButtonColumn btnSeleccionar;
		private System.Windows.Forms.DataGridViewTextBoxColumn Id;
		private System.Windows.Forms.DataGridViewTextBoxColumn Codigo;
		private System.Windows.Forms.DataGridViewTextBoxColumn NombreCompleto;
		private System.Windows.Forms.DataGridViewTextBoxColumn Descripcion;
		private System.Windows.Forms.DataGridViewTextBoxColumn IdCategoria;
		private System.Windows.Forms.DataGridViewTextBoxColumn Categoria;
		private System.Windows.Forms.DataGridViewTextBoxColumn EstadoValor;
		private System.Windows.Forms.DataGridViewTextBoxColumn Estado;
		private System.Windows.Forms.DataGridViewTextBoxColumn Stock;
		private System.Windows.Forms.DataGridViewTextBoxColumn PrecioCompra;
		private System.Windows.Forms.DataGridViewTextBoxColumn PrecioVenta;
	}
}