using CapaDatos;
using CapaEntidad;
using System.Collections.Generic;

namespace CapaNegocio
{
    public class CN_Producto
    {
        private CD_Producto objcd_Producto = new CD_Producto();

        public List<Producto> Listar()
        {
            return objcd_Producto.Listar();
        }

        public int Registrar(Producto obj, out string Mensaje)
        {
            Mensaje = string.Empty;

            if (obj.Codigo == "")
                Mensaje += "Escriba un código para el producto\n";

            if (obj.Nombre == "")
                Mensaje += "Escriba un nombre para el producto\n";

            if (obj.Descripcion == "")
                Mensaje += "Escriba una descripción para el producto\n";

            if (Mensaje == string.Empty)
                return objcd_Producto.Registrar(obj, out Mensaje);
            else
                return 0;
        }

        public bool Editar(Producto obj, out string Mensaje)
        {
            Mensaje = string.Empty;

            if (obj.Codigo == "")
                Mensaje += "Escriba un código para el producto\n";

            if (obj.Nombre == "")
                Mensaje += "Escriba un nombre para el producto\n";

            if (obj.Descripcion == "")
                Mensaje += "Escriba una descripción para el producto\n";

            if (Mensaje == string.Empty)
                return objcd_Producto.Editar(obj, out Mensaje);
            else
                return false;
        }

        public bool Eliminar(Producto obj, out string Mensaje)
        {
            return objcd_Producto.Eliminar(obj, out Mensaje);
        }
    }
}
