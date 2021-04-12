/**
 * This class implement a new vote.
 */

import static java.lang.CharSequence.compare;

public class Vote {

    private Person person;
    private String date;

    //constructor
    Vote(Person person, String date)
    {
        this.person = person;
        this.date = date;
    }


    /**
     * @return the date of creation of the vote
     */
    public String getDate() {

        return date;
    }

    /**
     * @return the voter of current vote
     */
    public Person getPerson() {
        return person;
    }

    // Overriding equals() to compare two Complex objects
    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }
        /* Check if o is an instance of Vote or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Vote)) {
            return false;
        }
        // typecast o to Vote so that we can compare data members
        Vote c = (Vote) o;
        // Compare the data members and return accordingly
        return compare(person.toString() , c.person.toString()) == 0 && compare(date, c.date) == 0;
    }

    @Override
    public int hashCode() {
        return this.person.toString().hashCode();
    }
}
