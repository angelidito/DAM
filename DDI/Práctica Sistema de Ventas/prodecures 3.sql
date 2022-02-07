use BDSISTEMAVENTAS
go
create proc SP_ACTUALIZARUSUARIO (
	@IdUsuario int,
	@Documento varchar(50),
	@NombreCompleto varchar(50),
	@Clave varchar(50),
	@IDRol int,
	@Estado bit,
	@Correo varchar(50),
	@Resultado bit output,
	@Mensaje varchar(500) output
)
as
begin

	set @Resultado = 1
	set @Mensaje = ''

	if not exists (select * from usuario where Documento = @Documento and IdUsuario = @IdUsuario)
		begin
			update USUARIO 
				set
				Documento = @Documento,
				NombreCompleto = @NombreCompleto,
				Clave = @Clave,
				IDRol = @IDRol,
				Estado = @Estado,
				Correo = @Correo 

				set @Resultado = 0
		end
	else
		set @Mensaje = 'No se ha podido actualizar el usuario, ya existe ese documento.'
end