
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/FindCustomer"})
public class FindCustomer extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {


        response.setContentType("application/octet-stream");
        InputStream in = request.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(in);
        OutputStream outstr = response.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(outstr);

         try {
            //response.setContentType("application/x-java-serialized-object");
            System.out.println(" BK1");
           String lastName = (String) ois.readObject();


             System.out.println(lastName);
             if(lastName == null)
                lastName = "";  // default to all

            Class.forName( "com.mysql.cj.jdbc.Driver" );
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/simpleaddressbook", "root", "root");
            PreparedStatement find = con.prepareStatement("select * from Customers where Last_Name like ?");
          //  find.setString(1, lastName);
//            ResultSet rs = find.executeQuery();
//            while(rs.next())  {
//             Customer c = new Customer(rs.getString(1), rs.getString(3),rs.getString(2),rs.getString(4),
//                               rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8), rs.getString(9));
//
//             oos.writeObject(c);
//            }
           // rs.close();
             Customer c = null;
             for (int i= 0; i < 5; i++) {
                  c = new Customer(String.valueOf(i) ,"murray","michael","add1","add2","city","state","123","12345567");
                 oos.writeObject(c);
             }

            find.close();
            con.close();
          }
         catch(Exception ex) {
           System.out.println(ex.toString());
         }
         finally{
            Customer last = new Customer();
            oos.writeObject(last);  // customer with a blank id indicates the last one
            oos.flush();
	        oos.close();
         }
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
