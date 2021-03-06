CREATE PROC SP_REGISTRARUSUARIO (
@Documento varchar(50),
@NombreCompleto varchar(50),
@Clave varchar(50),
@IdRol int,
@Estado bit,
@Correo varchar(50),
@idUsuarioResultado int output,
@Mensaje varchar(500) output)

AS
BEGIN
	SET @idUsuarioResultado=0
	SET @Mensaje=''
	IF NOT EXISTS (SELECT * FROM USUARIO WHERE Documento=@Documento)
	BEGIN
		INSERT INTO USUARIO (Documento,NombreCompleto,Clave,IdRol,Estado,correo)
		VALUES
		(@Documento, @NombreCompleto,@Clave, @IdRol,@Estado, @Correo)
		SET @idUsuarioResultado=SCOPE_IDENTITY()
	END
	ELSE
		SET @Mensaje='Este usuario ya existe, no se puede repetir'
END
