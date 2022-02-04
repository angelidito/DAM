use BDSISTEMAVENTAS
go
create proc SP_ELIMINARUSUARIO (
	@IdUsuario int,
	@Documento varchar(50),
	@Correo varchar(50),
	@Respuesta bit output,
	@Mensaje varchar(500) output
)
as 
begin
	set @Respuesta = 0
	set @Mensaje = ''
	
	if exists (select * from COMPRA where COMPRA.IdUsuario =  @IdUsuario)
	begin
		set @Respuesta = 1
		set @Mensaje = 'No se puede eliminar el usuario porque tiene operaciones de compra.\n'
	end
	if exists (select * from VENTA where VENTA.IdUsuario =  @IdUsuario)
	begin
		set @Respuesta = 1
		set @Mensaje = @Mensaje + 'No se puede eliminar el usuario porque tiene operaciones de venta.\n'
	end
	if (@Respuesta = 0)
		delete usuario where IdUsuario = @IdUsuario
	
end