
ALTER CLASS Autor
  ADD RELATIONSHIP escribe
     RELATIONSHIP set ( Obra )
    
    INVERSE Obra.escrito_por;



ALTER CLASS Obra
  ADD RELATIONSHIP escrito_por
     RELATIONSHIP set ( Autor )
    
    INVERSE Autor.escribe;
