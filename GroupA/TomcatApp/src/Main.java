//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//
//public class Main {
//    public static void main(String[] args) {
//        // Code to find customer in database
//        URL link = new URL("http://localhost:8080/"+"FindCustomer");
//        setMessageLabel("Processing request ...");
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
//        oos.writeObject(lastName);
//
//        ObjectInputStream ois = new ObjectInputStream(urlconnection.getInputStream());
//        while(true)
//        {
//            Customer c = (Customer)ois.readObject();
//            if(c.id.length() == 0)  // empty id indicates last customer
//                break;
//            else
//            {
//                // UPDATE GUI WITH DATA FROM >>>> c.id,c.firstName,c.lastName,c.address1,c.address2,c.city,c.state,c.zip,c.phone, c.email
//            }
//        }
//        oos.close();
//        ois.close();
//
//        //-------------------------------------------------------------------------------------------------------------------------
//
//        URL link = new URL("http://localhost:8080/"+"DeleteCustomer");
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
//        oos.writeObject(ID);  // send the id
//
//        ObjectInputStream ois = new ObjectInputStream(urlconnection.getInputStream());
//        int count = ois.readInt();  // read back the number of row deleted
//        oos.close();
//        ois.close();
//
//        //-----------------------------------------------------------------------------------------------------------------------------
//
//        // Add customer to data base
//        // need to access data(firstname, last name ....) from user
//        // create a new Custumer with the data obtained
//        // Customer c = new Customer(id, lastname, firstname .........);
//        Customer c = new Customer(); //Test
//        try {
//            URL linkAdd = new URL("http://localhost:8080/TomcatServer_war_exploded/"+"AddCustomer");
//            HttpURLConnection urlconnectionAdd = (HttpURLConnection) linkAdd.openConnection();
//            urlconnection.setDoOutput(true);
//            urlconnection.setDoInput(true);
//            urlconnection.setUseCaches (false);
//            urlconnection.setDefaultUseCaches (false);
//            // Specify the content type that we will send binary data
//            urlconnection.setRequestProperty ("Content-Type", "application/octet-stream");
//            ObjectOutputStream oosAdd = new ObjectOutputStream(urlconnection.getOutputStream());
//            oosAdd.writeObject(c);  // send the customer
//            oos.flush();
//
//            ObjectInputStream oisAdd = new ObjectInputStream(urlconnection.getInputStream());
//            int result = ois.readInt();
//            // If result = 0 // =>failure ...
//            oos.close();
//            ois.close();
//
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//
//
//
//        ---------------------------------------------------------------------------------
//                Customer c = new Customer(FILL IN THE FIELDS);
//
//        URL link = new URL("http://localhost:8080/"+"UpdateCustomer");
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
//        --------------------------------------------------------------------------------------
//
//
//    }
//
//
//}
