--
-- Application Schema SQL DDL Script
-- Generated with Matisse Schema Definition Language 9.1.12 
--
-- Generation date: Thu Feb 17 11:37:51 2022
-- Generated from database 'PAREJAS@AULA205-EQUIPO7'
--


CREATE NAMESPACE IF NOT EXISTS PAREJAS;

SET CURRENT_NAMESPACE PAREJAS;

--
-- Classes Definitions
--

CREATE TABLE IF NOT EXISTS Hombre (
  id_hombre INTEGER,
  nombre_hombre STRING,
  edad_hombre INTEGER,
  salario INTEGER,
  num_pagas INTEGER,
  retencion INTEGER,
  tieneMujer REFERENCES SET (Mujer) 
    INVERSE Mujer.tieneMarido
);

CREATE TABLE IF NOT EXISTS Mujer (
  id_mujer INTEGER,
  nombre_mujer STRING,
  edad_mujer INTEGER,
  tieneMarido REFERENCES (Hombre) 
    CARDINALITY (0, 1)
    INVERSE Hombre.tieneMujer
);

--
-- Commit the Application Schema Updates
--
COMMIT;

