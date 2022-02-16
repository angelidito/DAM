--
-- Application Schema SQL DDL Script
-- Generated with Matisse Schema Definition Language 9.1.12 
--
-- Generation date: Mon Feb 17 14:28:10 2020
-- Generated from database 'inmobiliaria@205dam04'
--


CREATE NAMESPACE IF NOT EXISTS inmobiliaria;

SET CURRENT_NAMESPACE inmobiliaria;

--
-- Classes Definitions
--

CREATE TABLE IF NOT EXISTS Vivienda (
  piso INTEGER,
  letra STRING,
  metros INTEGER,
  direccion STRING,
  situadaen REFERENCES SET (Zona) 
    INVERSE Zona.estaen,
  tieneVentana REFERENCES SET (Ventana) 
    INVERSE Ventana.perteneceA,
  propiedadDe REFERENCES SET (Cliente) 
    INVERSE Cliente.tieneVivienda
);

CREATE TABLE IF NOT EXISTS Zona (
  nombre STRING,
  valorxmetro INTEGER,
  indicerevalorizacion INTEGER,
  estaen REFERENCES SET (Vivienda) 
    INVERSE Vivienda.situadaen
);

CREATE TABLE IF NOT EXISTS Ventana (
  dimensiones INTEGER,
  orientacion STRING,
  climalite BOOLEAN,
  perteneceA REFERENCES SET (Vivienda) 
    INVERSE Vivienda.tieneVentana
);

CREATE TABLE IF NOT EXISTS Cliente (
  dni STRING,
  nombre STRING,
  apellidos STRING,
  tieneVivienda REFERENCES SET (Vivienda) 
    INVERSE Vivienda.propiedadDe
);

--
-- Methods Definition
--

SET CURRENT_NAMESPACE inmobiliaria;

CREATE METHOD calcularPrecio()
RETURNS Float
FOR Vivienda
--
-- Describe your method here
--
BEGIN
  return 0;
END;

SET CURRENT_NAMESPACE inmobiliaria;

CREATE METHOD calcularLuminosidad()
RETURNS Float
FOR Vivienda
BEGIN
   return 0;
END;

SET CURRENT_NAMESPACE inmobiliaria;

CREATE METHOD calcularAislamiento()
RETURNS Float
FOR Vivienda
BEGIN
   return 0;
END;

SET CURRENT_NAMESPACE inmobiliaria;

CREATE METHOD calcularPrecioEspecial()
RETURNS Float
FOR Vivienda
BEGIN
   return 0;
END;

SET CURRENT_NAMESPACE inmobiliaria;

CREATE METHOD calcularMediaPorZona()
RETURNS Float
FOR Zona
BEGIN
return 0;
END;

SET CURRENT_NAMESPACE inmobiliaria;

CREATE METHOD calcularDescuento()
RETURNS FLoat
FOR "inmobiliaria"."Cliente"
--
-- Describe your method here
--
BEGIN
  return 0;
END;

--
-- Recompile methods to resolve dependencies
--
COMPILE ALL;

--
-- Commit the Application Schema Updates
--
COMMIT;

