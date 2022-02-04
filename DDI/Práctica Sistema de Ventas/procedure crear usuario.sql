use BDSISTEMAVENTAS
go
create proc SP_REGISTRARUSUARIO (
	@Documento varchar(50),
	@NombreCompleto varchar(50),
	@Clave varchar(50),
	@IDRol int,
	@Estado bit,
	@Correo varchar(50),
	@IdUsuarioResultado int output,
	@Mensaje varchar(500) output
)
as
begin
	set @IdUsuarioResultado = 0
	set @Mensaje = ''
	if not exists (select * from usuario where Documento = @Documento)
		begin
			insert into USUARIO 
				(Documento, NombreCompleto, Clave, IdRol, Estado, Correo)
			values
				(@Documento, @NombreCompleto, @Clave, @IdRol, @Estado, @Correo)
			set @IdUsuarioResultado = SCOPE_IDENTITY()
		end
	else
		set @Mensaje = 'Este usuario ya existe, no se puede repetir. Introduzca otro distinto'
end


