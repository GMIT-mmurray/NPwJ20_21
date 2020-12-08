import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
//        // Code to find customer in database
//       // URL link = null;

       try {
          URL link = new URL("http://localhost:8080/TomcatServer_war_exploded/"+"FindCustomer");
          HttpURLConnection urlconnection = (HttpURLConnection) link.openConnection();
          urlconnection.setDoOutput(true);
          urlconnection.setUseCaches (false);
          urlconnection.setDefaultUseCaches (false);
          urlconnection.setDoInput(true);
           // Specify the content type that we will send binary data
          urlconnection.setRequestProperty ("Content-Type", "application/octet-stream");
          urlconnection.setRequestMethod("GET");
          ObjectOutputStream oos = new ObjectOutputStream(urlconnection.getOutputStream());

          oos.writeObject("murray");  // send the customer
          oos.flush();
          ObjectInputStream ois = new ObjectInputStream(urlconnection.getInputStream());
           while (true) {
                Customer c = (Customer) ois.readObject();
                if (c.id.length() == 0)  // empty id indicates last customer
                    break;
                else {
                    // UPDATE GUI WITH DATA FROM >>>> c.id,c.firstName,c.lastName,c.address1,c.address2,c.city,c.state,c.zip,c.phone, c.email
                    System.out.println(c);
                }
            }
            oos.close();
            ois.close();

        } catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }


//        //-------------------------------------------------------------------------------------------------------------------------
//
//        URL link = new URL("http://localhost:8080/TomcatServer_war_exploded/"+"DeleteCustomer");
//        HttpURLConnection urlconnection = (HttpURLConnection) link.openConnection();
//
//        urlconnection.setDoOutput(true);
//        urlconnection.setDoInput(true);
//        urlconnection.setUseCaches (false);
//        urlconnection.setDefaultUseCaches (false);
//
//        // Specify the content type that we will send binary data
//        urlconnection.setRequestProperty ("Content-Type", "application/octet-stream");
//
//        ObjectOutputStream oos = new ObjectOutputStream(urlconnection.getOutputStream());
//        oos.writeObject("0");  // send the id
//
//        ObjectInputStream ois = new ObjectInputStream(urlconnection.getInputStream());
//        int count = ois.readInt();  // read back the number of row deleted
//        oos.close();
//        ois.close();

//        //-----------------------------------------------------------------------------------------------------------------------------
//
        // Add customer to data base
        // need to access data(firstname, last name ....) from user
        // create a new Customer with the data obtained
        // Customer c = new Customer(id, lastname, firstname .........);
//        Customer c = new Customer("1","murray","michael","add1","add2","city","state","123","12345567"); //Test
//        try {
//            URL link = new URL("http://localhost:8080/TomcatServer_war_exploded/"+"AddCustomer");
//            HttpURLConnection urlconnection = (HttpURLConnection) link.openConnection();
//            urlconnection.setDoOutput(true);
//            urlconnection.setDoInput(true);
//            urlconnection.setUseCaches (false);
//            urlconnection.setDefaultUseCaches (false);
//            // Specify the content type that we will send binary data
//            urlconnection.setRequestProperty ("Content-Type", "application/octet-stream");
//            ObjectOutputStream oos = new ObjectOutputStream(urlconnection.getOutputStream());
//            oos.writeObject(c);  // send the customer
//            oos.flush();
//
//            ObjectInputStream ois = new ObjectInputStream(urlconnection.getInputStream());
//            int result = ois.readInt();
//            // If result = 0 // =>failure ...
//            oos.close();
//            ois.close();
//            urlconnection.disconnect();
//
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//////
////
//
//
//        //---------------------------------------------------------------------------------
//                Customer c = new Customer("1","murray","michael","add1","add2","city","state","123","12345567"); //Test
//
//        URL link = new URL("http://localhost:8080/TomcatServer_war_exploded/"+"UpdateCustomer");
//
//        HttpURLConnection urlconnection = (HttpURLConnection) link.openConnection();
//
//        urlconnection.setDoOutput(true);
//        urlconnection.setDoInput(true);
//        urlconnection.setUseCaches (false);
//        urlconnection.setDefaultUseCaches (false);
//
//        // Specify the content type that we will send binary data
//        urlconnection.setRequestProperty ("Content-Type", "application/octet-stream");
//
//        ObjectOutputStream oos = new ObjectOutputStream(urlconnection.getOutputStream());
//        oos.writeObject(c);  // send the customer
//        oos.flush();
//
//        ObjectInputStream ois = new ObjectInputStream(urlconnection.getInputStream());
//        int count = ois.readInt();
//        oos.close();
//        ois.close();
//       // --------------------------------------------------------------------------------------


    }
}
