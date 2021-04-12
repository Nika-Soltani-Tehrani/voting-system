/**
 * This class implement a new voter
 */
public class Person {

    String firstName;
    String lastName;

    //constructor
    Person(String firstName,String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * @return the first name of the voter
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * @return the last name of the voter
     */
    public String getLastName()
    {
        return lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
