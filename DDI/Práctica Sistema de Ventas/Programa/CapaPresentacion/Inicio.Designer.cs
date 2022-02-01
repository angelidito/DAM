
namespace CapaPresentacion
{
    partial class Inicio
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
			this.menu = new System.Windows.Forms.MenuStrip();
			this.iconUsuarios = new FontAwesome.Sharp.IconMenuItem();
			this.iconMantenedor = new FontAwesome.Sharp.IconMenuItem();
			this.submenucategoria = new FontAwesome.Sharp.IconMenuItem();
			this.submenuproducto = new FontAwesome.Sharp.IconMenuItem();
			this.iconVentas = new FontAwesome.Sharp.IconMenuItem();
			this.submenuregistraventa = new FontAwesome.Sharp.IconMenuItem();
			this.submenudetalleventa = new FontAwesome.Sharp.IconMenuItem();
			this.iconCompras = new FontAwesome.Sharp.IconMenuItem();
			this.submenuregistracompra = new FontAwesome.Sharp.IconMenuItem();
			this.submenudetallecompra = new FontAwesome.Sharp.IconMenuItem();
			this.iconClientes = new FontAwesome.Sharp.IconMenuItem();
			this.iconProveedores = new FontAwesome.Sharp.IconMenuItem();
			this.iconReportes = new FontAwesome.Sharp.IconMenuItem();
			this.iconAcercade = new FontAwesome.Sharp.IconMenuItem();
			this.menuTitulo = new System.Windows.Forms.MenuStrip();
			this.label1 = new System.Windows.Forms.Label();
			this.lblUsuario = new System.Windows.Forms.Label();
			this.lblUsuario1 = new System.Windows.Forms.Label();
			this.contenedor = new System.Windows.Forms.Panel();
			this.menu.SuspendLayout();
			this.SuspendLayout();
			// 
			// menu
			// 
			this.menu.BackColor = System.Drawing.Color.White;
			this.menu.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.iconUsuarios,
            this.iconMantenedor,
            this.iconVentas,
            this.iconCompras,
            this.iconClientes,
            this.iconProveedores,
            this.iconReportes,
            this.iconAcercade});
			this.menu.Location = new System.Drawing.Point(0, 59);
			this.menu.Name = "menu";
			this.menu.Size = new System.Drawing.Size(800, 73);
			this.menu.TabIndex = 0;
			this.menu.Text = "menuStrip1";
			// 
			// iconUsuarios
			// 
			this.iconUsuarios.AutoSize = false;
			this.iconUsuarios.BackColor = System.Drawing.Color.White;
			this.iconUsuarios.IconChar = FontAwesome.Sharp.IconChar.UsersCog;
			this.iconUsuarios.IconColor = System.Drawing.Color.Black;
			this.iconUsuarios.IconFont = FontAwesome.Sharp.IconFont.Auto;
			this.iconUsuarios.IconSize = 50;
			this.iconUsuarios.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
			this.iconUsuarios.Name = "iconUsuarios";
			this.iconUsuarios.Size = new System.Drawing.Size(80, 69);
			this.iconUsuarios.Text = "Usuarios";
			this.iconUsuarios.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageAboveText;
			this.iconUsuarios.Click += new System.EventHandler(this.iconUsuarios_Click);
			// 
			// iconMantenedor
			// 
			this.iconMantenedor.AutoSize = false;
			this.iconMantenedor.BackColor = System.Drawing.Color.White;
			this.iconMantenedor.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.submenucategoria,
            this.submenuproducto});
			this.iconMantenedor.IconChar = FontAwesome.Sharp.IconChar.Tools;
			this.iconMantenedor.IconColor = System.Drawing.Color.Black;
			this.iconMantenedor.IconFont = FontAwesome.Sharp.IconFont.Auto;
			this.iconMantenedor.IconSize = 50;
			this.iconMantenedor.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
			this.iconMantenedor.Name = "iconMantenedor";
			this.iconMantenedor.Size = new System.Drawing.Size(122, 69);
			this.iconMantenedor.Text = "Admin";
			this.iconMantenedor.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageAboveText;
			// 
			// submenucategoria
			// 
			this.submenucategoria.IconChar = FontAwesome.Sharp.IconChar.None;
			this.submenucategoria.IconColor = System.Drawing.Color.Black;
			this.submenucategoria.IconFont = FontAwesome.Sharp.IconFont.Auto;
			this.submenucategoria.Name = "submenucategoria";
			this.submenucategoria.Size = new System.Drawing.Size(180, 22);
			this.submenucategoria.Text = "Categoria";
			this.submenucategoria.Click += new System.EventHandler(this.submenucategoria_Click);
			// 
			// submenuproducto
			// 
			this.submenuproducto.IconChar = FontAwesome.Sharp.IconChar.None;
			this.submenuproducto.IconColor = System.Drawing.Color.Black;
			this.submenuproducto.IconFont = FontAwesome.Sharp.IconFont.Auto;
			this.submenuproducto.Name = "submenuproducto";
			this.submenuproducto.Size = new System.Drawing.Size(180, 22);
			this.submenuproducto.Text = "Producto";
			this.submenuproducto.Click += new System.EventHandler(this.submenuproducto_Click);
			// 
			// iconVentas
			// 
			this.iconVentas.AutoSize = false;
			this.iconVentas.BackColor = System.Drawing.Color.White;
			this.iconVentas.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.submenuregistraventa,
            this.submenudetalleventa});
			this.iconVentas.IconChar = FontAwesome.Sharp.IconChar.Tags;
			this.iconVentas.IconColor = System.Drawing.Color.Black;
			this.iconVentas.IconFont = FontAwesome.Sharp.IconFont.Auto;
			this.iconVentas.IconSize = 50;
			this.iconVentas.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
			this.iconVentas.Name = "iconVentas";
			this.iconVentas.Size = new System.Drawing.Size(80, 69);
			this.iconVentas.Text = "Ventas";
			this.iconVentas.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageAboveText;
			// 
			// submenuregistraventa
			// 
			this.submenuregistraventa.IconChar = FontAwesome.Sharp.IconChar.None;
			this.submenuregistraventa.IconColor = System.Drawing.Color.Black;
			this.submenuregistraventa.IconFont = FontAwesome.Sharp.IconFont.Auto;
			this.submenuregistraventa.Name = "submenuregistraventa";
			this.submenuregistraventa.Size = new System.Drawing.Size(180, 22);
			this.submenuregistraventa.Text = "Nueva Venta";
			this.submenuregistraventa.Click += new System.EventHandler(this.submenuregistraventa_Click);
			// 
			// submenudetalleventa
			// 
			this.submenudetalleventa.IconChar = FontAwesome.Sharp.IconChar.None;
			this.submenudetalleventa.IconColor = System.Drawing.Color.Black;
			this.submenudetalleventa.IconFont = FontAwesome.Sharp.IconFont.Auto;
			this.submenudetalleventa.Name = "submenudetalleventa";
			this.submenudetalleventa.Size = new System.Drawing.Size(180, 22);
			this.submenudetalleventa.Text = "Ver detalle";
			this.submenudetalleventa.Click += new System.EventHandler(this.submenudetalleventa_Click);
			// 
			// iconCompras
			// 
			this.iconCompras.AutoSize = false;
			this.iconCompras.BackColor = System.Drawing.Color.White;
			this.iconCompras.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.submenuregistracompra,
            this.submenudetallecompra});
			this.iconCompras.IconChar = FontAwesome.Sharp.IconChar.DollyFlatbed;
			this.iconCompras.IconColor = System.Drawing.Color.Black;
			this.iconCompras.IconFont = FontAwesome.Sharp.IconFont.Auto;
			this.iconCompras.IconSize = 50;
			this.iconCompras.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
			this.iconCompras.Name = "iconCompras";
			this.iconCompras.Size = new System.Drawing.Size(80, 69);
			this.iconCompras.Text = "Compras";
			this.iconCompras.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageAboveText;
			// 
			// submenuregistracompra
			// 
			this.submenuregistracompra.IconChar = FontAwesome.Sharp.IconChar.None;
			this.submenuregistracompra.IconColor = System.Drawing.Color.Black;
			this.submenuregistracompra.IconFont = FontAwesome.Sharp.IconFont.Auto;
			this.submenuregistracompra.Name = "submenuregistracompra";
			this.submenuregistracompra.Size = new System.Drawing.Size(180, 22);
			this.submenuregistracompra.Text = "Nueva Compra";
			this.submenuregistracompra.Click += new System.EventHandler(this.submenuregistracompra_Click);
			// 
			// submenudetallecompra
			// 
			this.submenudetallecompra.IconChar = FontAwesome.Sharp.IconChar.None;
			this.submenudetallecompra.IconColor = System.Drawing.Color.Black;
			this.submenudetallecompra.IconFont = FontAwesome.Sharp.IconFont.Auto;
			this.submenudetallecompra.Name = "submenudetallecompra";
			this.submenudetallecompra.Size = new System.Drawing.Size(180, 22);
			this.submenudetallecompra.Text = "Ver detalle";
			this.submenudetallecompra.Click += new System.EventHandler(this.submenudetallecompra_Click);
			// 
			// iconClientes
			// 
			this.iconClientes.AutoSize = false;
			this.iconClientes.BackColor = System.Drawing.Color.White;
			this.iconClientes.IconChar = FontAwesome.Sharp.IconChar.UserFriends;
			this.iconClientes.IconColor = System.Drawing.Color.Black;
			this.iconClientes.IconFont = FontAwesome.Sharp.IconFont.Auto;
			this.iconClientes.IconSize = 50;
			this.iconClientes.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
			this.iconClientes.Name = "iconClientes";
			this.iconClientes.Size = new System.Drawing.Size(80, 69);
			this.iconClientes.Text = "Clientes";
			this.iconClientes.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageAboveText;
			this.iconClientes.Click += new System.EventHandler(this.iconClientes_Click);
			// 
			// iconProveedores
			// 
			this.iconProveedores.AutoSize = false;
			this.iconProveedores.BackColor = System.Drawing.Color.White;
			this.iconProveedores.IconChar = FontAwesome.Sharp.IconChar.AddressCard;
			this.iconProveedores.IconColor = System.Drawing.Color.Black;
			this.iconProveedores.IconFont = FontAwesome.Sharp.IconFont.Auto;
			this.iconProveedores.IconSize = 50;
			this.iconProveedores.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
			this.iconProveedores.Name = "iconProveedores";
			this.iconProveedores.Size = new System.Drawing.Size(80, 69);
			this.iconProveedores.Text = "Proveedores";
			this.iconProveedores.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageAboveText;
			this.iconProveedores.Click += new System.EventHandler(this.iconProveedores_Click);
			// 
			// iconReportes
			// 
			this.iconReportes.AutoSize = false;
			this.iconReportes.BackColor = System.Drawing.Color.White;
			this.iconReportes.IconChar = FontAwesome.Sharp.IconChar.ChartBar;
			this.iconReportes.IconColor = System.Drawing.Color.Black;
			this.iconReportes.IconFont = FontAwesome.Sharp.IconFont.Auto;
			this.iconReportes.IconSize = 50;
			this.iconReportes.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
			this.iconReportes.Name = "iconReportes";
			this.iconReportes.Size = new System.Drawing.Size(122, 69);
			this.iconReportes.Text = "Reportes";
			this.iconReportes.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageAboveText;
			this.iconReportes.Click += new System.EventHandler(this.iconReportes_Click);
			// 
			// iconAcercade
			// 
			this.iconAcercade.AutoSize = false;
			this.iconAcercade.BackColor = System.Drawing.Color.White;
			this.iconAcercade.IconChar = FontAwesome.Sharp.IconChar.InfoCircle;
			this.iconAcercade.IconColor = System.Drawing.Color.Black;
			this.iconAcercade.IconFont = FontAwesome.Sharp.IconFont.Auto;
			this.iconAcercade.IconSize = 50;
			this.iconAcercade.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
			this.iconAcercade.Name = "iconAcercade";
			this.iconAcercade.Size = new System.Drawing.Size(80, 69);
			this.iconAcercade.Text = "Acerca de";
			this.iconAcercade.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageAboveText;
			// 
			// menuTitulo
			// 
			this.menuTitulo.AutoSize = false;
			this.menuTitulo.BackColor = System.Drawing.Color.SteelBlue;
			this.menuTitulo.Location = new System.Drawing.Point(0, 0);
			this.menuTitulo.Name = "menuTitulo";
			this.menuTitulo.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
			this.menuTitulo.Size = new System.Drawing.Size(800, 59);
			this.menuTitulo.TabIndex = 1;
			this.menuTitulo.Text = "menuStrip2";
			// 
			// label1
			// 
			this.label1.AutoSize = true;
			this.label1.BackColor = System.Drawing.Color.SteelBlue;
			this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 20F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.label1.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
			this.label1.Location = new System.Drawing.Point(13, 13);
			this.label1.Name = "label1";
			this.label1.Size = new System.Drawing.Size(237, 31);
			this.label1.TabIndex = 2;
			this.label1.Text = "Sistema de ventas";
			// 
			// lblUsuario
			// 
			this.lblUsuario.AutoSize = true;
			this.lblUsuario.BackColor = System.Drawing.Color.SteelBlue;
			this.lblUsuario.Font = new System.Drawing.Font("Microsoft Sans Serif", 8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.lblUsuario.ForeColor = System.Drawing.Color.White;
			this.lblUsuario.Location = new System.Drawing.Point(600, 28);
			this.lblUsuario.Name = "lblUsuario";
			this.lblUsuario.Size = new System.Drawing.Size(35, 13);
			this.lblUsuario.TabIndex = 3;
			this.lblUsuario.Text = "label2";
			// 
			// lblUsuario1
			// 
			this.lblUsuario1.AutoSize = true;
			this.lblUsuario1.BackColor = System.Drawing.Color.SteelBlue;
			this.lblUsuario1.Font = new System.Drawing.Font("Microsoft Sans Serif", 8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.lblUsuario1.ForeColor = System.Drawing.Color.White;
			this.lblUsuario1.Location = new System.Drawing.Point(524, 28);
			this.lblUsuario1.Name = "lblUsuario1";
			this.lblUsuario1.Size = new System.Drawing.Size(43, 13);
			this.lblUsuario1.TabIndex = 4;
			this.lblUsuario1.Text = "Usuario";
			// 
			// contenedor
			// 
			this.contenedor.Dock = System.Windows.Forms.DockStyle.Fill;
			this.contenedor.Location = new System.Drawing.Point(0, 132);
			this.contenedor.Name = "contenedor";
			this.contenedor.Size = new System.Drawing.Size(800, 318);
			this.contenedor.TabIndex = 5;
			// 
			// Inicio
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(800, 450);
			this.Controls.Add(this.contenedor);
			this.Controls.Add(this.lblUsuario1);
			this.Controls.Add(this.lblUsuario);
			this.Controls.Add(this.label1);
			this.Controls.Add(this.menu);
			this.Controls.Add(this.menuTitulo);
			this.MainMenuStrip = this.menu;
			this.Name = "Inicio";
			this.Text = "Inicio";
			this.Load += new System.EventHandler(this.Inicio_Load);
			this.menu.ResumeLayout(false);
			this.menu.PerformLayout();
			this.ResumeLayout(false);
			this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menu;
        private System.Windows.Forms.MenuStrip menuTitulo;
        private System.Windows.Forms.Label label1;
        private FontAwesome.Sharp.IconMenuItem iconUsuarios;
        private FontAwesome.Sharp.IconMenuItem iconMantenedor;
        private FontAwesome.Sharp.IconMenuItem iconVentas;
        private FontAwesome.Sharp.IconMenuItem iconCompras;
        private FontAwesome.Sharp.IconMenuItem iconClientes;
        private FontAwesome.Sharp.IconMenuItem iconProveedores;
        private FontAwesome.Sharp.IconMenuItem iconReportes;
        private FontAwesome.Sharp.IconMenuItem iconAcercade;
		private System.Windows.Forms.Label lblUsuario;
		private System.Windows.Forms.Label lblUsuario1;
		private FontAwesome.Sharp.IconMenuItem submenuregistraventa;
		private FontAwesome.Sharp.IconMenuItem submenucategoria;
		private FontAwesome.Sharp.IconMenuItem submenuproducto;
		private FontAwesome.Sharp.IconMenuItem submenudetalleventa;
		private FontAwesome.Sharp.IconMenuItem submenuregistracompra;
		private FontAwesome.Sharp.IconMenuItem submenudetallecompra;
		private System.Windows.Forms.Panel contenedor;
	}
}

