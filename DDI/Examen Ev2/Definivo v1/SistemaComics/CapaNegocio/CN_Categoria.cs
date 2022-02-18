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
        
    }
}
