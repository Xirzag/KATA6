package kata6;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class KATA6 {

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        String nameFile = "emails.txt";
        ArrayList<Person> peopleMailList = MailListReader.readFromFile(nameFile);
        ArrayList<Person1> peopleList = PersonLoader.read();
        
        HistogramBuilder<Person> builder = new HistogramBuilder(peopleMailList);
        HistogramBuilder<Person1> builder1 = new HistogramBuilder(peopleList);

        Histogram<String> domains = builder.build(new Attribute<Person, String>() {

            @Override
            public String get(Person item) {
                return item.getMail().split("@")[1];
            }
        });

        Histogram<Character> letters = builder.build(new Attribute<Person, Character>() {

            @Override
            public Character get(Person item) {
                return item.getMail().charAt(0);
            }
        });

        Histogram<String> domains1 = builder1.build(new Attribute<Person1, String>() {

            @Override
            public String get(Person1 item) {
                return item.getMail().split("@")[1];
            }
        });

        Histogram<Float> pesos = builder1.build(new Attribute<Person1, Float>() {

            @Override
            public Float get(Person1 item) {
                return item.getWeight();
            }
        });

        new HistogramDisplay(domains, "DOMINIOS").execute();
        new HistogramDisplay(letters, "CARÁCTER").execute();
        new HistogramDisplay(domains1, "DOMINIOS").execute();
        new HistogramDisplay(pesos, "PESOS").execute();
    }
}