--
-- Application Schema SQL DDL Script
-- Generated with Matisse Schema Definition Language 9.1.12 
--
-- Generation date: Mon Feb 10 12:47:49 2020
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
    INVERSE Zona.estaen
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
  climalite BOOLEAN
);

CREATE TABLE IF NOT EXISTS Cliente (
  dni STRING,
  nombre STRING,
  apellidos STRING
);

--
-- Commit the Application Schema Updates
--
COMMIT;

