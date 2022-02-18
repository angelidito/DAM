using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using CapaDatos;
using CapaEntidad;

namespace CapaNegocio
{
    public class CN_Persona
    {
        private CD_Persona objcd_usuario = new CD_Persona();

        public List<Usuario> Listar()
        {
            return objcd_usuario.Listar();
        }

    }
}
