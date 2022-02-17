/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import POJOs_mujeres_hombres_hibernate.*;
import parejas.*;
import javax.xml.bind.*;
import java.io.File;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

    public static void main(String[] args) throws Exception {
        File file = new File("src/data/PAREJAS.xml");
        PAREJAS parejas = null;

        parejas = abrir_XML_JAXB(file, parejas);
        if (parejas != null) {
            //Crea una lista con objetos de tipo libro.
            List<PAREJAS.PAREJA> listaParejas = parejas.getPAREJA();
            //Trata la lista para ingresar los datos en Hibernate.
            tratarDatos(listaParejas);
        }

        System.out.println("FIN");
    }

    public static PAREJAS abrir_XML_JAXB(File fichero, PAREJAS parejas) {
        JAXBContext contexto;
        try {
            // Crea una instancia JAXB
            contexto = JAXBContext.newInstance(PAREJAS.class);
            // Crea un objeto Unmarsheller.
            Unmarshaller u = contexto.createUnmarshaller();
            // Deserializa (unmarshal) el fichero 
            parejas = (PAREJAS) u.unmarshal(fichero);
            return parejas;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private static void tratarDatos(List<PAREJAS.PAREJA> listaParejas) {
        Transaction tx;
        Session session;

        session = MHHibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        for (PAREJAS.PAREJA p : listaParejas) {
            if (p.getEdadHombre() < 50) {
                Hombre h;
                Mujer m;

                h = new Hombre(p.getIdHombre());
                h.setNombreHombre(p.getNombreHombre());
                h.setEdadHombre((int) p.getEdadHombre());
                h.setSalario((int) p.getSalario());
                h.setNumPagas((int) p.getNumPagas());
                h.setRetencion((int) p.getRetencion());

                m = new Mujer(p.getIdMujer());
                m.setNombreMujer(p.getNombreMujer());
                m.setEdadMujer((int) p.getEdadMujer());
                m.setHombre(h);
                h.getMujers().add(m);

                session.save(h);
                session.save(m);
            }
        }

        tx.commit();
        session.close();
    }
}
