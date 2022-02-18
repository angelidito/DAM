using CapaEntidad;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;


namespace CapaDatos
{
	public class CD_Usuario
	{
		public List<Usuario> Listar()
		{
			List<Usuario> lista = new List<Usuario>();
			using (SqlConnection oconexion = new SqlConnection(Conexion.cadena))
			{
				try
				{
					// string query = "select IdUsuario, Documento, NombreCompleto, Correo, Clave, Estado from usuario";
					string query = "select * from usuario";
					SqlCommand cmd = new SqlCommand(query, oconexion);
					cmd.CommandType = CommandType.Text;

					oconexion.Open();

					using (SqlDataReader dr = cmd.ExecuteReader())
					{
						while (dr.Read())
						{
							lista.Add(new Usuario()
							{
								IdUsuario = Convert.ToInt32(dr["IdUsuario"]),
								Documento = dr["Documento"].ToString(),
								NombreCompleto = dr["NombreCompleto"].ToString(),
								Correo = dr["Correo"].ToString(),
								Clave = dr["Clave"].ToString(),
								Estado = Convert.ToBoolean(dr["Estado"]),
								oRol = new Rol() { IdRol = Convert.ToInt32(dr["IdRol"]) },
								// Descripcion = dr["Descripcion"]
							});

						}
					}
				}
				catch (Exception ex)
				{
					lista = new List<Usuario>();
				}
			}
			return lista;
		}


		public int Registrar(Usuario obj, out string Mensaje)
		{
			int idusuariogenerado = 0;
			Mensaje = string.Empty;

			using (SqlConnection oconexion = new SqlConnection(Conexion.cadena))
			{
				try
				{
					SqlCommand cmd = new SqlCommand("SP_REGISTRARUSUARIO", oconexion);
					cmd.Parameters.AddWithValue("Documento", obj.Documento);
					cmd.Parameters.AddWithValue("NombreCompleto", obj.NombreCompleto);
					cmd.Parameters.AddWithValue("Correo", obj.Correo);
					cmd.Parameters.AddWithValue("Clave", obj.Clave);
					cmd.Parameters.AddWithValue("IdRol", obj.oRol.IdRol);
					cmd.Parameters.AddWithValue("Estado", obj.Estado);
					cmd.Parameters.Add("IdUsuarioResltado", SqlDbType.Int).Direction = ParameterDirection.Output;
					cmd.Parameters.Add("Mensaje", SqlDbType.VarChar).Direction = ParameterDirection.Output;
					cmd.CommandType = CommandType.StoredProcedure;

					oconexion.Open();

					cmd.ExecuteNonQuery();

					idusuariogenerado = Convert.ToInt32(cmd.Parameters["IdUsuarioResultado"].Value);
					Mensaje = cmd.Parameters["Mensaje"].Value.ToString();
				}
				catch (Exception ex)
				{
					idusuariogenerado = 0;
					Mensaje = ex.Message;
				}
			}

			return idusuariogenerado;

		}


		public bool Editar(Usuario obj, out string Mensaje)
		{
			bool respuesta = true;
			Mensaje = string.Empty;

			using (SqlConnection oconexion = new SqlConnection(Conexion.cadena))
			{
				try
				{
					SqlCommand cmd = new SqlCommand("SP_EDITARUSUARIO", oconexion);
					cmd.Parameters.AddWithValue("IdUsuario", obj.IdUsuario);
					cmd.Parameters.AddWithValue("Documento", obj.Documento);
					cmd.Parameters.AddWithValue("NombreCompleto", obj.NombreCompleto);
					cmd.Parameters.AddWithValue("Correo", obj.Correo);
					cmd.Parameters.AddWithValue("Clave", obj.Clave);
					cmd.Parameters.AddWithValue("IdRol", obj.oRol.IdRol);
					cmd.Parameters.AddWithValue("Estado", obj.Estado);
					cmd.Parameters.Add("IdUsuarioResltado", SqlDbType.Int).Direction = ParameterDirection.Output;
					cmd.Parameters.Add("Mensaje", SqlDbType.VarChar).Direction = ParameterDirection.Output;
					cmd.CommandType = CommandType.StoredProcedure;

					oconexion.Open();

					cmd.ExecuteNonQuery();

					respuesta = Convert.ToBoolean(cmd.Parameters["Respuesta"].Value);
					Mensaje = cmd.Parameters["Mensaje"].Value.ToString();
				}
				catch (Exception ex)
				{
					respuesta = false;
					Mensaje = ex.Message;
				}
			}

			return respuesta;

		}



		public bool Eliminar(Usuario obj, out string Mensaje)
		{
			bool respuesta = true;
			Mensaje = string.Empty;

			using (SqlConnection oconexion = new SqlConnection(Conexion.cadena))
			{
				try
				{
					SqlCommand cmd = new SqlCommand("SP_ELIMINARUSUARIO", oconexion);
					cmd.Parameters.AddWithValue("Documento", obj.Documento);
					cmd.Parameters.AddWithValue("NombreCompleto", obj.NombreCompleto);
					cmd.Parameters.AddWithValue("Correo", obj.Correo);
					cmd.Parameters.AddWithValue("Clave", obj.Clave);
					cmd.Parameters.AddWithValue("IdRol", obj.oRol.IdRol);
					cmd.Parameters.AddWithValue("Estado", obj.Estado);
					cmd.Parameters.Add("IdUsuarioResltado", SqlDbType.Int).Direction = ParameterDirection.Output;
					cmd.Parameters.Add("Mensaje", SqlDbType.VarChar).Direction = ParameterDirection.Output;
					cmd.CommandType = CommandType.StoredProcedure;

					oconexion.Open();

					cmd.ExecuteNonQuery();

					respuesta = Convert.ToBoolean(cmd.Parameters["Respuesta"].Value);
					Mensaje = cmd.Parameters["Mensaje"].Value.ToString();
				}
				catch (Exception ex)
				{
					respuesta = false;
					Mensaje = ex.Message;
				}
			}

			return respuesta;

		}
	}
}