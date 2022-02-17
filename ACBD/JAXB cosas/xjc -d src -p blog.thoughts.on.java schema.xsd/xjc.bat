@CHCP 65001 > NUL
@echo off
REM las lineas que empiezar por rem son comentarios

echo.
echo.
echo Directorio actual:
echo %cd%
echo.
echo Este archivo debe situarse en la carpeta raiz de su proyecto de JAXB
echo Si no es así, no va a funcionar. 
pause


SET /p paqueteDestino=Nombre del paquete de destino: 
SET /p rutaArchivoXSD=Ruta del archivo XSD:


REM Escriba en PATH la ruta a la carpeta bin del su version de Java
SET PATH=\RUTA\A\JAVA1.8\bin
SET CLASSPATH=bin
SET JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8


xjc -p %paqueteDestino% %rutaArchivoXSD%

REM SET comandoAEjecutar=xjc -p %paqueteDestino% %rutaArchivoXSD%
REM %comandoAEjecutar%

