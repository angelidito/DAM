
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
			System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Inicio));
			this.MenuTitulo = new System.Windows.Forms.MenuStrip();
			this.label1 = new System.Windows.Forms.Label();
			this.menuproductos = new FontAwesome.Sharp.IconMenuItem();
			this.menuventas = new FontAwesome.Sharp.IconMenuItem();
			this.submenuregistrarventa = new FontAwesome.Sharp.IconMenuItem();
			this.submenudetalleventa = new FontAwesome.Sharp.IconMenuItem();
			this.menucompras = new FontAwesome.Sharp.IconMenuItem();
			this.submenuregistracompra = new FontAwesome.Sharp.IconMenuItem();
			this.submenudetallecompra = new FontAwesome.Sharp.IconMenuItem();
			this.menuclientes = new FontAwesome.Sharp.IconMenuItem();
			this.menuproveedores = new FontAwesome.Sharp.IconMenuItem();
			this.menuinformes = new FontAwesome.Sharp.IconMenuItem();
			this.menuacercade = new FontAwesome.Sharp.IconMenuItem();
			this.Menu = new System.Windows.Forms.MenuStrip();
			this.menuMantenedor = new FontAwesome.Sharp.IconMenuItem();
			this.salirbtn = new FontAwesome.Sharp.IconMenuItem();
			this.lblUsuario = new System.Windows.Forms.Label();
			this.contenedor = new System.Windows.Forms.Panel();
			this.Menu.SuspendLayout();
			this.SuspendLayout();
			// 
			// MenuTitulo
			// 
			this.MenuTitulo.AutoSize = false;
			this.MenuTitulo.BackColor = System.Drawing.Color.SteelBlue;
			this.MenuTitulo.ImageScalingSize = new System.Drawing.Size(20, 20);
			this.MenuTitulo.Location = new System.Drawing.Point(0, 0);
			this.MenuTitulo.Name = "MenuTitulo";
			this.MenuTitulo.Padding = new System.Windows.Forms.Padding(4, 2, 0, 2);
			this.MenuTitulo.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
			this.MenuTitulo.Size = new System.Drawing.Size(1028, 44);
			this.MenuTitulo.TabIndex = 1;
			this.MenuTitulo.Text = "Sistema de Ventas";
			this.MenuTitulo.ItemClicked += new System.Windows.Forms.ToolStripItemClickedEventHandler(this.MenuTitulo_ItemClicked);
			// 
			// label1
			// 
			this.label1.AutoSize = true;
			this.label1.BackColor = System.Drawing.Color.SteelBlue;
			this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 20F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.label1.ForeColor = System.Drawing.SystemColors.ControlLightLight;
			this.label1.Location = new System.Drawing.Point(9, 7);
			this.label1.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
			this.label1.Name = "label1";
			this.label1.Size = new System.Drawing.Size(375, 31);
			this.label1.TabIndex = 2;
			this.label1.Text = "TPV COMICS MRS. LÓPEZ";
			// 
			// menuproductos
			// 
			this.menuproductos.AutoSize = false;
			this.menuproductos.BackColor = System.Drawing.Color.White;
			this.menuproductos.IconChar = FontAwesome.Sharp.IconChar.BookDead;
			this.menuproductos.IconColor = System.Drawing.Color.Black;
			this.menuproductos.IconFont = FontAwesome.Sharp.IconFont.Auto;
			this.menuproductos.IconSize = 50;
			this.menuproductos.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
			this.menuproductos.Name = "menuproductos";
			this.menuproductos.Size = new System.Drawing.Size(90, 69);
			this.menuproductos.Text = "Producto";
			this.menuproductos.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageAboveText;
			this.menuproductos.Click += new System.EventHandler(this.menuusarios_Click);
			// 
			// menuventas
			// 
			this.menuventas.AutoSize = false;
			this.menuventas.BackColor = System.Drawing.Color.White;
			this.menuventas.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.submenuregistrarventa,
            this.submenudetalleventa});
			this.menuventas.IconChar = FontAwesome.Sharp.IconChar.Tags;
			this.menuventas.IconColor = System.Drawing.Color.Black;
			this.menuventas.IconFont = FontAwesome.Sharp.IconFont.Auto;
			this.menuventas.IconSize = 50;
			this.menuventas.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
			this.menuventas.Name = "menuventas";
			this.menuventas.Size = new System.Drawing.Size(90, 69);
			this.menuventas.Text = "Ventas";
			this.menuventas.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageAboveText;
			// 
			// submenuregistrarventa
			// 
			this.submenuregistrarventa.BackColor = System.Drawing.Color.White;
			this.submenuregistrarventa.IconChar = FontAwesome.Sharp.IconChar.None;
			this.submenuregistrarventa.IconColor = System.Drawing.Color.Black;
			this.submenuregistrarventa.IconFont = FontAwesome.Sharp.IconFont.Auto;
			this.submenuregistrarventa.Name = "submenuregistrarventa";
			this.submenuregistrarventa.Size = new System.Drawing.Size(140, 22);
			this.submenuregistrarventa.Text = "Nueva Venta";
			this.submenuregistrarventa.Click += new System.EventHandler(this.submenuregistrarventa_Click);
			// 
			// submenudetalleventa
			// 
			this.submenudetalleventa.BackColor = System.Drawing.Color.White;
			this.submenudetalleventa.IconChar = FontAwesome.Sharp.IconChar.None;
			this.submenudetalleventa.IconColor = System.Drawing.Color.Black;
			this.submenudetalleventa.IconFont = FontAwesome.Sharp.IconFont.Auto;
			this.submenudetalleventa.Name = "submenudetalleventa";
			this.submenudetalleventa.Size = new System.Drawing.Size(140, 22);
			this.submenudetalleventa.Text = "Ver Detalle";
			this.submenudetalleventa.Click += new System.EventHandler(this.submenudetalleventa_Click);
			// 
			// menucompras
			// 
			this.menucompras.AutoSize = false;
			this.menucompras.BackColor = System.Drawing.Color.White;
			this.menucompras.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.submenuregistracompra,
            this.submenudetallecompra});
			this.menucompras.IconChar = FontAwesome.Sharp.IconChar.DollyFlatbed;
			this.menucompras.IconColor = System.Drawing.Color.Black;
			this.menucompras.IconFont = FontAwesome.Sharp.IconFont.Auto;
			this.menucompras.IconSize = 50;
			this.menucompras.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
			this.menucompras.Name = "menucompras";
			this.menucompras.Size = new System.Drawing.Size(90, 69);
			this.menucompras.Text = "Compras";
			this.menucompras.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageAboveText;
			// 
			// submenuregistracompra
			// 
			this.submenuregistracompra.BackColor = System.Drawing.Color.White;
			this.submenuregistracompra.IconChar = FontAwesome.Sharp.IconChar.None;
			this.submenuregistracompra.IconColor = System.Drawing.Color.Black;
			this.submenuregistracompra.IconFont = FontAwesome.Sharp.IconFont.Auto;
			this.submenuregistracompra.Name = "submenuregistracompra";
			this.submenuregistracompra.Size = new System.Drawing.Size(154, 22);
			this.submenuregistracompra.Text = "Nueva Compra";
			this.submenuregistracompra.Click += new System.EventHandler(this.submenuregistracompra_Click);
			// 
			// submenudetallecompra
			// 
			this.submenudetallecompra.BackColor = System.Drawing.Color.White;
			this.submenudetallecompra.IconChar = FontAwesome.Sharp.IconChar.None;
			this.submenudetallecompra.IconColor = System.Drawing.Color.Black;
			this.submenudetallecompra.IconFont = FontAwesome.Sharp.IconFont.Auto;
			this.submenudetallecompra.Name = "submenudetallecompra";
			this.submenudetallecompra.Size = new System.Drawing.Size(154, 22);
			this.submenudetallecompra.Text = "Ver Detalle";
			this.submenudetallecompra.Click += new System.EventHandler(this.submenudetallecompra_Click);
			// 
			// menuclientes
			// 
			this.menuclientes.AutoSize = false;
			this.menuclientes.BackColor = System.Drawing.Color.White;
			this.menuclientes.IconChar = FontAwesome.Sharp.IconChar.UserCog;
			this.menuclientes.IconColor = System.Drawing.Color.Black;
			this.menuclientes.IconFont = FontAwesome.Sharp.IconFont.Auto;
			this.menuclientes.IconSize = 50;
			this.menuclientes.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
			this.menuclientes.Name = "menuclientes";
			this.menuclientes.Size = new System.Drawing.Size(90, 69);
			this.menuclientes.Text = "Clientes";
			this.menuclientes.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageAboveText;
			this.menuclientes.Click += new System.EventHandler(this.menuclientes_Click);
			// 
			// menuproveedores
			// 
			this.menuproveedores.AutoSize = false;
			this.menuproveedores.BackColor = System.Drawing.Color.White;
			this.menuproveedores.IconChar = FontAwesome.Sharp.IconChar.AddressCard;
			this.menuproveedores.IconColor = System.Drawing.Color.Black;
			this.menuproveedores.IconFont = FontAwesome.Sharp.IconFont.Auto;
			this.menuproveedores.IconSize = 50;
			this.menuproveedores.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
			this.menuproveedores.Name = "menuproveedores";
			this.menuproveedores.Padding = new System.Windows.Forms.Padding(0);
			this.menuproveedores.Size = new System.Drawing.Size(90, 69);
			this.menuproveedores.Text = "Proveedores";
			this.menuproveedores.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageAboveText;
			this.menuproveedores.Click += new System.EventHandler(this.menuproveedores_Click);
			// 
			// menuinformes
			// 
			this.menuinformes.AutoSize = false;
			this.menuinformes.BackColor = System.Drawing.Color.White;
			this.menuinformes.IconChar = FontAwesome.Sharp.IconChar.ChartBar;
			this.menuinformes.IconColor = System.Drawing.Color.Black;
			this.menuinformes.IconFont = FontAwesome.Sharp.IconFont.Auto;
			this.menuinformes.IconSize = 50;
			this.menuinformes.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
			this.menuinformes.Name = "menuinformes";
			this.menuinformes.Padding = new System.Windows.Forms.Padding(0);
			this.menuinformes.Size = new System.Drawing.Size(90, 69);
			this.menuinformes.Text = "Informes";
			this.menuinformes.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageAboveText;
			this.menuinformes.Click += new System.EventHandler(this.menuinformes_Click);
			// 
			// menuacercade
			// 
			this.menuacercade.AutoSize = false;
			this.menuacercade.BackColor = System.Drawing.Color.White;
			this.menuacercade.IconChar = FontAwesome.Sharp.IconChar.InfoCircle;
			this.menuacercade.IconColor = System.Drawing.Color.Black;
			this.menuacercade.IconFont = FontAwesome.Sharp.IconFont.Auto;
			this.menuacercade.IconSize = 50;
			this.menuacercade.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
			this.menuacercade.Name = "menuacercade";
			this.menuacercade.Size = new System.Drawing.Size(90, 69);
			this.menuacercade.Text = "Acerca de";
			this.menuacercade.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageAboveText;
			// 
			// Menu
			// 
			this.Menu.ImageScalingSize = new System.Drawing.Size(20, 20);
			this.Menu.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.menuproductos,
            this.menuventas,
            this.menucompras,
            this.menuclientes,
            this.menuproveedores,
            this.menuinformes,
            this.menuMantenedor,
            this.menuacercade,
            this.salirbtn});
			this.Menu.Location = new System.Drawing.Point(0, 44);
			this.Menu.Name = "Menu";
			this.Menu.Padding = new System.Windows.Forms.Padding(4, 2, 0, 2);
			this.Menu.Size = new System.Drawing.Size(1028, 73);
			this.Menu.Stretch = false;
			this.Menu.TabIndex = 0;
			this.Menu.Text = "menuStrip1";
			// 
			// menuMantenedor
			// 
			this.menuMantenedor.AutoSize = false;
			this.menuMantenedor.BackColor = System.Drawing.Color.White;
			this.menuMantenedor.IconChar = FontAwesome.Sharp.IconChar.Tools;
			this.menuMantenedor.IconColor = System.Drawing.Color.Black;
			this.menuMantenedor.IconFont = FontAwesome.Sharp.IconFont.Auto;
			this.menuMantenedor.IconSize = 50;
			this.menuMantenedor.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
			this.menuMantenedor.Name = "menuMantenedor";
			this.menuMantenedor.Size = new System.Drawing.Size(90, 69);
			this.menuMantenedor.Text = "Admin";
			this.menuMantenedor.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageAboveText;
			// 
			// salirbtn
			// 
			this.salirbtn.AutoSize = false;
			this.salirbtn.BackColor = System.Drawing.Color.White;
			this.salirbtn.IconChar = FontAwesome.Sharp.IconChar.DoorOpen;
			this.salirbtn.IconColor = System.Drawing.Color.Black;
			this.salirbtn.IconFont = FontAwesome.Sharp.IconFont.Auto;
			this.salirbtn.IconSize = 50;
			this.salirbtn.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
			this.salirbtn.Name = "salirbtn";
			this.salirbtn.Size = new System.Drawing.Size(90, 69);
			this.salirbtn.Text = "Salir";
			this.salirbtn.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageAboveText;
			// 
			// lblUsuario
			// 
			this.lblUsuario.AutoSize = true;
			this.lblUsuario.BackColor = System.Drawing.Color.SteelBlue;
			this.lblUsuario.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.lblUsuario.ForeColor = System.Drawing.Color.White;
			this.lblUsuario.Location = new System.Drawing.Point(843, 9);
			this.lblUsuario.Name = "lblUsuario";
			this.lblUsuario.Size = new System.Drawing.Size(0, 15);
			this.lblUsuario.TabIndex = 4;
			// 
			// contenedor
			// 
			this.contenedor.Dock = System.Windows.Forms.DockStyle.Fill;
			this.contenedor.Location = new System.Drawing.Point(0, 117);
			this.contenedor.Name = "contenedor";
			this.contenedor.Size = new System.Drawing.Size(1028, 419);
			this.contenedor.TabIndex = 5;
			this.contenedor.Paint += new System.Windows.Forms.PaintEventHandler(this.contenedor_Paint);
			// 
			// Inicio
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(1028, 536);
			this.Controls.Add(this.contenedor);
			this.Controls.Add(this.lblUsuario);
			this.Controls.Add(this.label1);
			this.Controls.Add(this.Menu);
			this.Controls.Add(this.MenuTitulo);
			this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
			this.MainMenuStrip = this.Menu;
			this.Margin = new System.Windows.Forms.Padding(2);
			this.Name = "Inicio";
			this.Text = "Inicio";
			this.Load += new System.EventHandler(this.Inicio_Load);
			this.Menu.ResumeLayout(false);
			this.Menu.PerformLayout();
			this.ResumeLayout(false);
			this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.MenuStrip MenuTitulo;
        private System.Windows.Forms.Label label1;
        private FontAwesome.Sharp.IconMenuItem menuproductos;
        private FontAwesome.Sharp.IconMenuItem menuventas;
        private FontAwesome.Sharp.IconMenuItem menucompras;
        private FontAwesome.Sharp.IconMenuItem menuclientes;
        private FontAwesome.Sharp.IconMenuItem menuproveedores;
        private FontAwesome.Sharp.IconMenuItem menuinformes;
        private FontAwesome.Sharp.IconMenuItem menuacercade;
        private System.Windows.Forms.MenuStrip Menu;
        private FontAwesome.Sharp.IconMenuItem menuMantenedor;
        private System.Windows.Forms.Label lblUsuario;
        private FontAwesome.Sharp.IconMenuItem submenuregistrarventa;
        private FontAwesome.Sharp.IconMenuItem submenudetalleventa;
        private FontAwesome.Sharp.IconMenuItem submenuregistracompra;
        private FontAwesome.Sharp.IconMenuItem submenudetallecompra;
        private System.Windows.Forms.Panel contenedor;
		private FontAwesome.Sharp.IconMenuItem salirbtn;
	}
}

