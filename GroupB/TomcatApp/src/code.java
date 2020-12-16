import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class code {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        URL link = new URL("http://localhost:8080/TomcatServer_war_exploded/" + "FindCustomer");

        HttpURLConnection urlconnection = (HttpURLConnection) link.openConnection();

        urlconnection.setDoOutput(true);
        urlconnection.setDoInput(true);
        urlconnection.setUseCaches(false);
        urlconnection.setDefaultUseCaches(false);

        // Specify the content type that we will send binary data
        urlconnection.setRequestProperty("Content-Type", "application/octet-stream");

        ObjectOutputStream oos = new ObjectOutputStream(urlconnection.getOutputStream());
        oos.writeObject("murray");
        oos.flush();

        ObjectInputStream ois = new ObjectInputStream(urlconnection.getInputStream());
        while (true) {
            Customer c = (Customer) ois.readObject();
            if (c.id.length() == 0)  // empty id indicates last customer
                break;
            else {
                System.out.println(c);
                // UPDATE GUI WITH DATA FROM >>>> c.id,c.firstName,c.lastName,c.address1,c.address2,c.city,c.state,c.zip,c.phone, c.email
            }
        }
        oos.close();
        ois.close();
//        ------------------------------------------------------------------------

//        URL link = new URL("http://localhost:8080/TomcatServer_war_exploded/" + "DeleteCustomer");
//        HttpURLConnection urlconnection = (HttpURLConnection) link.openConnection();
//
//        urlconnection.setDoOutput(true);
//        urlconnection.setDoInput(true);
//        urlconnection.setUseCaches(false);
//        urlconnection.setDefaultUseCaches(false);
//
//        // Specify the content type that we will send binary data
//        urlconnection.setRequestProperty("Content-Type", "application/octet-stream");
//
//        ObjectOutputStream oos = new ObjectOutputStream(urlconnection.getOutputStream());
//        oos.writeObject("1");  // send the id
//
//        ObjectInputStream ois = new ObjectInputStream(urlconnection.getInputStream());
//        int count = ois.readInt();  // read back the number of row deleted
//        System.out.println(count);
//        oos.close();
//        ois.close();

//        -----------------------------------------------------------------------------
//     Fill the customer class with data from your GUI
//        Customer c = new Customer("1","murray","michael","add1","add2","city","state","1232345","999");
////
//
//        URL link = new URL("http://localhost:8080/TomcatServer_war_exploded/" + "AddCustomer");
//
//        HttpURLConnection urlconnection = (HttpURLConnection) link.openConnection();
//
//        urlconnection.setDoOutput(true);
//        urlconnection.setDoInput(true);
//        urlconnection.setUseCaches(false);
//        urlconnection.setDefaultUseCaches(false);
//
//        // Specify the content type that we will send binary data
//        urlconnection.setRequestProperty("Content-Type", "application/octet-stream");
//
//        ObjectOutputStream oos = new ObjectOutputStream(urlconnection.getOutputStream());
//        oos.writeObject(c);  // send the customer
//        oos.flush();
//
//        ObjectInputStream ois = new ObjectInputStream(urlconnection.getInputStream());
//        int result = ois.readInt();
//        // do something with result 0 => failure  1 => OK
//        oos.close();
//        ois.close();

//        ---------------------------------------------------------------------------------
//        Customer c = new Customer("xxx","murray","michael","add1","add2","city","state","1232345","1111111999");
//
//        URL link = new URL("http://localhost:8080/TomcatServer_war_exploded/" + "UpdateCustomer");
//
//        HttpURLConnection urlconnection = (HttpURLConnection) link.openConnection();
//
//        urlconnection.setDoOutput(true);
//        urlconnection.setDoInput(true);
//        urlconnection.setUseCaches(false);
//        urlconnection.setDefaultUseCaches(false);
//
//        // Specify the content type that we will send binary data
//        urlconnection.setRequestProperty("Content-Type", "application/octet-stream");
//
//        ObjectOutputStream oos = new ObjectOutputStream(urlconnection.getOutputStream());
//        oos.writeObject(c);  // send the customer
//        oos.flush();
//
//        ObjectInputStream ois = new ObjectInputStream(urlconnection.getInputStream());
//        int count = ois.readInt();
//        System.out.println(count);
//        oos.close();
//        ois.close();
//        --------------------------------------------------------------------------------------


    }

}