using CapaEntidad;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Text;


namespace CapaDatos
{
	public class CD_Persona
	{
		public List<Usuario> Listar()
		{
			List<Usuario> list = new List<Usuario>();
			using (SqlConnection oconexion = new SqlConnection(Conexion.cadena))
			{
				try
				{
					StringBuilder query = new StringBuilder();
					query.AppendLine("SELECT u.IdPersona, u.Documento, u.NombreCompleto, u.Correo, u.Clave, u.Estado");
					query.AppendLine("FROM PERSONA u ");
					//query.AppendLine("select * from PERSONA");

					SqlCommand cmd = new SqlCommand(query.ToString(), oconexion);
					cmd.CommandType = CommandType.Text;

					oconexion.Open();

					using (SqlDataReader dr = cmd.ExecuteReader())
					{
						while (dr.Read())
						{
							Usuario usuario = new Usuario()
							{
								IdUsuario = Convert.ToInt32(dr["IdPersona"]),
								Documento = dr["Documento"].ToString(),
								NombreCompleto = dr["NombreCompleto"].ToString(),
								Correo = dr["Correo"].ToString(),
								Clave = dr["Clave"].ToString(),
								Estado = true
							};

							list.Add(usuario);

						}
					}
				}
				catch (Exception ex)
				{
					Console.WriteLine(ex.StackTrace);
					list = new List<Usuario>();
				}
				//oconexion.Close();
			}
			return list;
		}

		//public int Registrar(Usuario obj, out String Mensaje)
		//{
		//    int idusuariogenerado = 0;
		//    Mensaje = string.Empty;

		//    try
		//    {
		//        using (SqlConnection oconexion = new SqlConnection(Conexion.cadena))
		//        {
		//            SqlCommand cmd = new SqlCommand("SP_REGISTRARUsuario", oconexion);
		//            cmd.Parameters.AddWithValue("Documento", obj.Documento);
		//            cmd.Parameters.AddWithValue("NombreCompleto", obj.NombreCompleto);
		//            cmd.Parameters.AddWithValue("Correo", obj.Correo);
		//            cmd.Parameters.AddWithValue("Clave", obj.Clave);
		//            cmd.Parameters.AddWithValue("IdTipoPersona", obj.oRol.IdTipoPersona);
		//            cmd.Parameters.AddWithValue("Estado", obj.Estado);
		//            cmd.Parameters.Add("IdUsuarioResultado", SqlDbType.Int).Direction = ParameterDirection.Output;
		//            cmd.Parameters.Add("Mensaje", SqlDbType.VarChar, 500).Direction = ParameterDirection.Output;
		//            cmd.CommandType = CommandType.StoredProcedure;

		//            oconexion.Open();

		//            cmd.ExecuteNonQuery();

		//            idusuariogenerado = Convert.ToInt32(cmd.Parameters["IdUsuarioResultado"].Value);
		//            Mensaje = cmd.Parameters["Mensaje"].Value.ToString();
		//        }
		//    }
		//    catch (Exception ex)
		//    {
		//        idusuariogenerado = 0;
		//        Mensaje = ex.Message;
		//    }
		//    return idusuariogenerado;
		//}

		//public bool Editar(Usuario obj, out String Mensaje)
		//{
		//    bool respuesta = false;
		//    Mensaje = string.Empty;

		//    try
		//    {
		//        using (SqlConnection oconexion = new SqlConnection(Conexion.cadena))
		//        {
		//            SqlCommand cmd = new SqlCommand("SP_EDITARUsuario", oconexion);
		//            cmd.Parameters.AddWithValue("IdUsuario", obj.IdUsuario);
		//            cmd.Parameters.AddWithValue("Documento", obj.Documento);
		//            cmd.Parameters.AddWithValue("NombreCompleto", obj.NombreCompleto);
		//            cmd.Parameters.AddWithValue("Correo", obj.Correo);
		//            cmd.Parameters.AddWithValue("Clave", obj.Clave);
		//            cmd.Parameters.AddWithValue("IdTipoPersona", obj.oRol.IdTipoPersona);
		//            cmd.Parameters.AddWithValue("Estado", obj.Estado);
		//            cmd.Parameters.Add("Respuesta", SqlDbType.Int).Direction = ParameterDirection.Output;
		//            cmd.Parameters.Add("Mensaje", SqlDbType.VarChar, 500).Direction = ParameterDirection.Output;
		//            cmd.CommandType = CommandType.StoredProcedure;

		//            oconexion.Open();

		//            cmd.ExecuteNonQuery();

		//            respuesta = Convert.ToBoolean(cmd.Parameters["Respuesta"].Value);
		//            Mensaje = cmd.Parameters["Mensaje"].Value.ToString();
		//        }
		//    }
		//    catch (Exception ex)
		//    {
		//        respuesta = false;
		//        Mensaje = ex.Message;
		//    }
		//    return respuesta;
		//}

		//public bool Eliminar(Usuario obj, out String Mensaje)
		//{
		//    bool respuesta = false;
		//    Mensaje = string.Empty;

		//    try
		//    {
		//        using (SqlConnection oconexion = new SqlConnection(Conexion.cadena))
		//        {
		//            SqlCommand cmd = new SqlCommand("SP_ELIMINARUsuario", oconexion);
		//            cmd.Parameters.AddWithValue("IdUsuario", obj.IdUsuario);
		//            cmd.Parameters.Add("Respuesta", SqlDbType.Int).Direction = ParameterDirection.Output;
		//            cmd.Parameters.Add("Mensaje", SqlDbType.VarChar, 500).Direction = ParameterDirection.Output;
		//            cmd.CommandType = CommandType.StoredProcedure;

		//            oconexion.Open();

		//            cmd.ExecuteNonQuery();

		//            respuesta = Convert.ToBoolean(cmd.Parameters["Respuesta"].Value);
		//            Mensaje = cmd.Parameters["Mensaje"].Value.ToString();
		//        }
		//    }
		//    catch (Exception ex)
		//    {
		//        respuesta = false;
		//        Mensaje = ex.Message;
		//    }
		//    return respuesta;
		//}
	}
}