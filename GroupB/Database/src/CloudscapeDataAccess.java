// Fig. 8.36: CloudscapeDataAccess.java
// An implementation of interface AddressBookDataAccess that 
// performs database operations with PreparedStatements.

// Java core packages
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;

public class CloudscapeDataAccess implements AddressBookDataAccess {

   public CloudscapeDataAccess() { }  // end CloudscapeDataAccess constructor
   

   // Locate specified person. Method returns AddressBookEntry
   // containing information.
   public AddressBookEntry findPerson( String lastName )
   {
      try {
         // set query parameter and execute query
         sqlFind.setString( 1, lastName );
         ResultSet resultSet = sqlFind.executeQuery();

         // if no records found, return immediately
         if ( !resultSet.next() )
            return null;

         // create new AddressBookEntry
         AddressBookEntry person = new AddressBookEntry(
            resultSet.getInt( 1 ) );

         // set AddressBookEntry properties
         person.setFirstName( resultSet.getString( 2 ) );
         person.setLastName( resultSet.getString( 3 ) );

         person.setAddressID( resultSet.getInt( 4 ) );
         person.setAddress1( resultSet.getString( 5 ) );
         person.setAddress2( resultSet.getString( 6 ) );
         person.setCity( resultSet.getString( 7 ) );
         person.setState( resultSet.getString( 8 ) );
         person.setZipcode( resultSet.getString( 9 ) );

         person.setPhoneID( resultSet.getInt( 10 ) );
         person.setPhoneNumber( resultSet.getString( 11 ) );

         person.setEmailID( resultSet.getInt( 12 ) );
         person.setEmailAddress( resultSet.getString( 13 ) );

         // return AddressBookEntry
         return person;
      }

      // catch SQLException
      catch ( SQLException sqlException ) {
         return null;
      }
   }  // end method findPerson
   
   // Update an entry. Method returns boolean indicating 
   // success or failure.
   public boolean savePerson( AddressBookEntry person )
   {
      // update person in database
      try {
         int result;
         
         // update names table
         sqlUpdateName.setString( 1, person.getFirstName() );
         sqlUpdateName.setString( 2, person.getLastName() );
         sqlUpdateName.setInt( 3, person.getPersonID() );
         result = sqlUpdateName.executeUpdate();

         // if update fails, rollback and discontinue 
         if ( result == 0 ) {
            connection.rollback(); // rollback update
            return false;          // update unsuccessful
         }      
         
         // update addresses table
         sqlUpdateAddress.setString( 1, person.getAddress1() );
         sqlUpdateAddress.setString( 2, person.getAddress2() );
         sqlUpdateAddress.setString( 3, person.getCity() );
         sqlUpdateAddress.setString( 4, person.getState() );
         sqlUpdateAddress.setString( 5, person.getZipcode() );
         sqlUpdateAddress.setInt( 6, person.getAddressID() );
         result = sqlUpdateAddress.executeUpdate();
         
         // if update fails, rollback and discontinue 
         if ( result == 0 ) {
            connection.rollback(); // rollback update
            return false;          // update unsuccessful
         }      
         
         // update phoneNumbers table
         sqlUpdatePhone.setString( 1, person.getPhoneNumber() );
         sqlUpdatePhone.setInt( 2, person.getPhoneID() );
         result = sqlUpdatePhone.executeUpdate();
         
         // if update fails, rollback and discontinue 
         if ( result == 0 ) {
            connection.rollback(); // rollback update
            return false;          // update unsuccessful
         }      
         
         // update emailAddresses table
         sqlUpdateEmail.setString( 1, person.getEmailAddress() );
         sqlUpdateEmail.setInt( 2, person.getEmailID() );
         result = sqlUpdateEmail.executeUpdate();

         // if update fails, rollback and discontinue 
         if ( result == 0 ) {
            connection.rollback(); // rollback update
            return false;          // update unsuccessful
         }      
         
         connection.commit();   // commit update
         return true;           // update successful
      }  // end try
      
      // detect problems updating database
      catch ( SQLException sqlException ) {
      
         // rollback transaction
         try {
            connection.rollback(); // rollback update
            return false;          // update unsuccessful
         }
         
         // handle exception rolling back transaction
         catch ( SQLException exception ) {
            throw new DataAccessException( exception );
         }
      }
   }  // end method savePerson

   // Insert new entry.
   // Method returns boolean indicating success or failure.
   public boolean newPerson( AddressBookEntry person ) throws IOException {
      // insert person in database
      URL link = new URL("http://localhost:8080/TomcatServer_war_exploded/" + "AddCustomer");

        HttpURLConnection urlconnection = (HttpURLConnection) link.openConnection();

        urlconnection.setDoOutput(true);
        urlconnection.setDoInput(true);
        urlconnection.setUseCaches(false);
        urlconnection.setDefaultUseCaches(false);

        // Specify the content type that we will send binary data
        urlconnection.setRequestProperty("Content-Type", "application/octet-stream");

        ObjectOutputStream oos = new ObjectOutputStream(urlconnection.getOutputStream());
        oos.writeObject(c);  // send the customer
        oos.flush();

        ObjectInputStream ois = new ObjectInputStream(urlconnection.getInputStream());
        int result = ois.readInt();
        // do something with result 0 => failure  1 => OK
        oos.close();
        ois.close();

   }  // end method newPerson




      
   // Delete an entry. Method returns boolean indicating 
   // success or failure.
   public boolean deletePerson( AddressBookEntry person )
      throws DataAccessException
   {
      // delete a person from database
      try {
         int result;

         // delete address from addresses table
         sqlDeleteAddress.setInt( 1, person.getPersonID() );
         result = sqlDeleteAddress.executeUpdate();

         // if delete fails, rollback and discontinue
         if ( result == 0 ) {
            connection.rollback(); // rollback delete
            return false;          // delete unsuccessful
         }

         // delete phone number from phoneNumbers table
         sqlDeletePhone.setInt( 1, person.getPersonID() );
         result = sqlDeletePhone.executeUpdate();

         // if delete fails, rollback and discontinue
         if ( result == 0 ) {
            connection.rollback(); // rollback delete
            return false;          // delete unsuccessful
         }

         // delete email address from emailAddresses table
         sqlDeleteEmail.setInt( 1, person.getPersonID() );
         result = sqlDeleteEmail.executeUpdate();

         // if delete fails, rollback and discontinue
         if ( result == 0 ) {
            connection.rollback(); // rollback delete
            return false;          // delete unsuccessful
         }

         // delete name from names table
         sqlDeleteName.setInt( 1, person.getPersonID() );
         result = sqlDeleteName.executeUpdate();

         // if delete fails, rollback and discontinue
         if ( result == 0 ) {
            connection.rollback(); // rollback delete
            return false;          // delete unsuccessful
         }

         connection.commit();   // commit delete
         return true;           // delete successful
      }  // end try

      // detect problems updating database
      catch ( SQLException sqlException ) {
         // rollback transaction
         try {
            connection.rollback(); // rollback update
            return false;          // update unsuccessful
         }

         // handle exception rolling back transaction
         catch ( SQLException exception ) {
            throw new DataAccessException( exception );
         }
      }
   }  // end method deletePerson

   // method to close statements and database connection
   public void close()
   {
      // close database connection
      try {
         sqlFind.close();
         sqlPersonID.close();
         sqlInsertName.close();
         sqlInsertAddress.close();
         sqlInsertPhone.close();
         sqlInsertEmail.close();
         sqlUpdateName.close();
         sqlUpdateAddress.close();
         sqlUpdatePhone.close();
         sqlUpdateEmail.close();
         sqlDeleteName.close();
         sqlDeleteAddress.close();
         sqlDeletePhone.close();
         sqlDeleteEmail.close();
         connection.close();
      }  // end try
      
      // detect problems closing statements and connection
      catch ( SQLException sqlException ) {
         sqlException.printStackTrace();
      }
   }  // end method close

   // Method to clean up database connection. Provided in case
   // CloudscapeDataAccess object is garbage collected.
   protected void finalize()
   {
      close();
   }
}  // end class CloudscapeDataAccess


