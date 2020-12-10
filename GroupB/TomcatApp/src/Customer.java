

import java.io.Serializable;


public class Customer implements Serializable{
    String id = "";
    String lastName = "";
    String firstName = "";
    String address1 = "";
    String address2 = "";
    String city = "";
    String state = "";
    String zip = "";
    String phone = "";
    /**
     * 
     *  Default constructor
     */
    public Customer()
    {
        
    }

    /**
     * Converts object to a string
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    /**
     *  working constructor
     * @param i ID
     * @param l last name
     * @param f first name
     * @param a1 address 1
     * @param a2 address 2
     * @param c city
     * @param s state
     * @param z zip
     * @param p phone
     */
    public Customer(String i, String l, String f, String a1, String a2, String c, String s, String z, String p)  {
     id = i;
     lastName = l;
     firstName = f;
     address1 = a1;
     address2 = a2;
     city = c;
     state = s;
     zip = z;
     phone = p;           
    }
}
