USE [BDSISTEMAVENTAS17]
GO

DECLARE	@return_value int,
		@idUsuarioResultado int,
		@Mensaje varchar(500)

EXEC	@return_value = [dbo].[SP_REGISTRARUSUARIO2]
		@Documento = N'505050',
		@NombreCompleto = N'Hola',
		@Clave = N'12345',
		@IdRol = 1,
		@Estado = 0,
		@Correo = N'si@gmail.com',
		@idUsuarioResultado = @idUsuarioResultado OUTPUT,
		@Mensaje = @Mensaje OUTPUT

SELECT	@idUsuarioResultado as N'@idUsuarioResultado',
		@Mensaje as N'@Mensaje'

SELECT	'Return Value' = @return_value

GO
