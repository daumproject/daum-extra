/**
 * Created with IntelliJ IDEA.
 * User: jed
 * Date: 21/11/12
 * Time: 11:06
 * To change this template use File | Settings | File Templates.
 */

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.IOException;
import java.io.InputStream;

public class Tester {



    private static String url = "http://localhost:8080/";

    public static int with=  500;

    public static void main(String[] args) {
        // Create an instance of HttpClient.
        HttpClient client = new HttpClient();
      for(int x=0;x<with;x++)
      {
          for(int y=0;y<with;y++)
          {
             for(int zoom=0;zoom<17;zoom++)
             {

               //http://localhost:8080/10/507/357.png

                String cURL = url+zoom+"/"+x+"/"+y+".png";
                 System.out.println(cURL);
                 // Create a method instance.
                 GetMethod method = new GetMethod(url);


                 try {
                     // Execute the method.
                     int statusCode = client.executeMethod(method);

                     if (statusCode != HttpStatus.SC_OK) {
                         System.err.println("Method failed: " + method.getStatusLine());
                     }

                     // Read the response body.
                     InputStream responseBody = method.getResponseBodyAsStream();

                     // Deal with the response.
                     // Use caution: ensure correct character encoding and is not binary data
                     //     System.out.println(new String(responseBody));

                 } catch (HttpException e) {
                     System.err.println("Fatal protocol violation: " + e.getMessage());
                     e.printStackTrace();
                 } catch (IOException e) {
                     System.err.println("Fatal transport error: " + e.getMessage());
                     e.printStackTrace();
                 } finally {
                     // Release the connection.
                     method.releaseConnection();
                 }

             }
          }

      }

    }
}
