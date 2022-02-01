using CapaEntidad;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Text;

namespace CapaDatos
{
	public class CD_Permiso
	{
		public List<Permiso> Listar(int idUsuadio)
		{
			List<Permiso> lista = new List<Permiso>();
			SqlConnection oconexion = new SqlConnection(Conexion.cadena);

			try
			{
				StringBuilder query = new StringBuilder();
				query.AppendLine("select p.IdRol, p.NombreMenu");
				query.AppendLine("from USUARIO u inner join ROL r on u.IdRol = r.IdRol");
				query.AppendLine("inner join PERMISO p on r.IdRol = p.IdRol");
				query.AppendLine("where u.IdUsuario = @idusuario");

				SqlCommand cmd = new SqlCommand(query.ToString(), oconexion);
				cmd.Parameters.AddWithValue("@idusuario", idUsuadio);
				cmd.CommandType = CommandType.Text;

				oconexion.Open();

				using (SqlDataReader dr = cmd.ExecuteReader())
				{
					while (dr.Read())
					{
						lista.Add(new Permiso()
						{
							oRol = new Rol() { IdRol = System.Convert.ToInt32(dr["IdRol"]) },
							NombreMenu = dr["NombreMenu"].ToString()
						});
					}
				}
			} catch (Exception ex)
			{

			}



			return lista;
		}
	}
}
