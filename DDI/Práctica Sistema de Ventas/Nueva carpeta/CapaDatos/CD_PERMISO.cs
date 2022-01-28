using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using System.Data;
using System.Data.SqlClient;
using CapaEntidad;

namespace CapaDatos
{
	class CD_PERMISO
	{
		public List<Permiso> Listar(int idUsuadio)
		{
			List<Permiso> lista = new List<Permiso>();
			SqlConnection oconexion = new SqlConnection(Conexion.cadena);
		}
	}
}
