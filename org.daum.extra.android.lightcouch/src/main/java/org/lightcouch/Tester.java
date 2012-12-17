package org.lightcouch;



import org.lightcouch.pojo.Victime;

import java.net.MalformedURLException;
import java.util.Date;


/**
 * Created with IntelliJ IDEA.
 * User: jed
 * Date: 18/07/12
 * Time: 09:26
 * To change this template use File | Settings | File Templates.
 */
public class Tester {

    public static void  main (String argv[]) throws MalformedURLException, InterruptedException {


        long duree,start;
        // public CouchDbClient(java.lang.String dbName, boolean createDbIfNotExist, java.lang.String protocol, java.lang.String host, int port, java.lang.String username, java.lang.String password) { /* compiled code */ }
        Victime t = new Victime();
        t.state = Victime.STATES.ALIVE;
        t.date = new Date();
        t.prenom = "jean-emile";
        t.nom = "DARTOIS";





                CouchDbClient android = new CouchDbClient("jed2",true,"http","192.168.1.121",8888,"","");

        CouchDbClient java = new CouchDbClient("jed2",true,"http","192.168.1.107",8888,"","");



        Victime t2 =  null;


        int nb = 1;
        int counter = 0;

        start= System.currentTimeMillis();
        for(int i=0;i<nb;i++){

            t.prenom = "jean-emile "+i;
            System.out.println("save "+android.getDBUri());
            Response c =        java.save(t);

            do {
                try
                {
                    System.out.println("looking in "+java.getDBUri());
                    t2 = android.find(Victime.class,c.getId());

                }catch (Exception e){
                    //ignore
                    Thread.sleep(1000);
                }
            }  while (t2 == null) ;


            if(t2.prenom.equals(t.prenom)){
                counter++;
                System.out.println("OK "+t2.get_id());
            }

            System.out.println("remove in "+android.getDBUri());
             /*
            java.remove(t2);

            do {
                try
                {
                    t2 = null;
                    System.out.println("wait delete "+t2.get_id());
                    t2 = android.find(Victime.class,t2.get_id());

                }catch (Exception e){
                    //ignore
                    Thread.sleep(1000);
                }
            }  while (t2 != null) ;

           */
        }

        System.out.println(counter);


        duree = (System.currentTimeMillis() - start)  / 1000;
        System.out.println("Duree ="+duree);




    }



}
