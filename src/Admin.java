
/**
 * Admin class is for the Librarian to manage the library system.
 * This can add remove and update books in the library.
 * Basically all the functions couble be done by the Librarian
 * 
 * 
 * choice(String cmd): only recive the command and responce use Routes class to
 * make the changes in Library.
 * 
 * Here will we can add , remove and update the books in the library.
 * As a Admin we can do anything with the databases of the books and we can have
 * multiple books so We can manage the tansactions of the number of books.
 * 
 * 
 */

import routes.Routes;

public class Admin {
    Routes routes;

    public Admin() {
        routes = new Routes();
    }
    // choice(String cmd): only recive the command and responce
    // use Routes class to make the changes in Library.
    // Here will we can add , remove and update the books in the library.

}
