using CapaDatos;
using CapaEntidad;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CapaNegocio
{
    public class CN_Categoria
    {
        private CD_Categoria object_Categoria = new CD_Categoria();
        public List<Categoria> Listar()
        {
            return object_Categoria.Listar();
        }
        public int Registrar(Categoria obj, out string Mensaje)
        {
            Mensaje = string.Empty;

            if (obj.Descripcion == "")
            {
                Mensaje += "Es necesario la descripcion de la categoria \n";
            }
            if (Mensaje != string.Empty)
            {
                return 0;
            }
            else
            {
                return object_Categoria.Registrar(obj, out Mensaje);
            }
        }
        public bool Editar(Categoria obj, out string Mensaje)
        {
            Mensaje = string.Empty;

            if (obj.Descripcion == "")
            {
                Mensaje += "Es necesario la descripcion de la categoria \n";
            }
            if (Mensaje != string.Empty)
            {
                return false;
            }
            else
            {
                return object_Categoria.Editar(obj, out Mensaje);
            }
        }

        public bool Eliminar(Categoria obj, out string Mensaje)
        {
            return object_Categoria.Eliminar(obj, out Mensaje);
        }
    }
}
