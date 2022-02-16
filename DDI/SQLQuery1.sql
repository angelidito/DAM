CREATE PROC SP_EDITARUSUARIO (
@Idusuario int,
@Documento varchar(50),
@NombreCompleto varchar(50),
@Clave varchar(50),
@IdRol int,
@Estado bit,
@Correo varchar(50),
@Resultado bit output,
@Mensaje varchar(500) output)

AS
BEGIN
	SET @Resultado=1
	SET @Mensaje=''
	IF NOT EXISTS (SELECT * FROM USUARIO WHERE Documento=@Documento and IdUsuario!=@Idusuario)
	BEGIN
		UPDATE USUARIO SET 
		Documento=@Documento,
		NombreCompleto=@NombreCompleto,
		Clave=@Clave,
		IdRol=@IdRol,
		Estado=@Estado,
		correo=@Correo
		WHERE IdUsuario=@Idusuario

		SET @Resultado=0
	END
		
	ELSE
		SET @Mensaje='No se ha podido actualizar el usuario, ya existe ese documento'
END
