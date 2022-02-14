--
-- Application Schema SQL DDL Script
-- Generated with Matisse Schema Definition Language 9.1.12 
--
-- Generation date: Wed Feb 09 13:19:46 2022
-- Generated from database 'RAMA@AULA205-EQUIPO7'
--


CREATE NAMESPACE IF NOT EXISTS biblioteca;

SET CURRENT_NAMESPACE biblioteca;

--
-- Classes Definitions
--

CREATE TABLE IF NOT EXISTS Autor (
  nombre STRING,
  apellidos STRING,
  edad INTEGER,
  escribe REFERENCES SET (Obra) 
    INVERSE Obra.escrito_por
);

CREATE TABLE IF NOT EXISTS Obra (
  titulo STRING,
  paginas INTEGER,
  escrito_por REFERENCES SET (Autor) 
    INVERSE Autor.escribe
);

CREATE TABLE IF NOT EXISTS Articulo UNDER Obra (
  revista STRING
);

--
-- Commit the Application Schema Updates
--
COMMIT;

