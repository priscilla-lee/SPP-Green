/* *****************************************************************************
 *  Name:
 *  NetID:
 *  Precept:
 *
 *  Description:  A program that uses a linked list to store countries in order
 *  of their first COVID occurrences.
 *
 * Example:
 * > java-introcs CovidCountries < covid_data.txt
 * 2019-12-31      China
 * 2020-01-13      Thailand
 * 2020-01-15      Japan
 * 2020-01-20      SouthKorea
 * 2020-01-21      Taiwan
 * ...
 *
 **************************************************************************** */

public class CovidCountries {
    // structure of items in list
    private class Country {
        String name;  // name of country
        String date;  // date of first occurence
        Country next; // link to next country

        // constructor for country
        private Country(String name, String date) {
            this.name = name;
            this.date = date;
            this.next = null;
        }
    }

    private Country first; // beginning of the list, initially empty

    // constructor
    public CovidCountries() {
        first = null;
    }

    // print the name and date for every country in the list
    public void printAll() {
        // one possible approach: use a while loop
        Country current = first; // start at beginning

        // if current isn't past the last country,
        while (_____________________) {
            // print the current country's date and name; then repeat w/ next
            __________________(current.date + "\t" + current.name);
            _________________________________;
        }
    }

    // adds a new country to the end of the list
    public void add(String name, String date) {
        // if the list is empty, make it the only country in the list
        if (first == null) {
            first = new Country(name, date);
        }

        // otherwise, add it to the end
        else {
            _________________________________
            _________________________________
            _________________________________
            _________________________________
        }
    }

    public static void main(String[] args) {
        StdIn.readLine(); // don't store the headers

        CovidCountries list = new CovidCountries();

        while (!StdIn.isEmpty()) {
            // read a row in the text file
            String countryName = StdIn.readString();
            String date = StdIn.readString();
            int totalCases = StdIn.readInt();
            int newCases = StdIn.readInt();

            // if we find a first occurrence, add the country to the list
            if (totalCases == newCases && totalCases != 0) {
                list.add(countryName, date);
            }
        }

        // print the countries in order of first occurence
        list.printAll();
    }

}
