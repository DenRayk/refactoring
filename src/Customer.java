
import java.lang.*;
import java.util.*;

public class Customer
{
    private String name;
    private Vector rentals = new Vector();

    public Customer(String newname)
    {
        name = newname;
    }


    public void addRental(Rental arg)
    {
        rentals.addElement(arg);
    }


    public String getName()
    {
        return name;
    }

    ;

    public String statement()
    {
        Enumeration enum_rentals = rentals.elements();
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements())
        {
            Rental each = (Rental) enum_rentals.nextElement();

            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + "\t" + each.getDaysRented() + "\t" + each.getCharge() + "\n";
        }
        //add footer lines
        result += "Amount owed is " + getTotalCharge() + "\n";
        result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";
        return result;
    }


    private double getTotalCharge()
    {
        double result = 0;
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements())
        {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints(){
        int result = 0;
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

}
    