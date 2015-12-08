package kata6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MailListReader {
     
    public static ArrayList<Person> readFromFile(String name) throws FileNotFoundException, IOException {
        
        
        ArrayList<Person> mailList = new ArrayList<>();
        BufferedReader fileRead = new BufferedReader(new FileReader(new File(name)));

        int id = 0;
        String mail;
        while((mail = fileRead.readLine())!= null) 
            if(mail.contains("@")) mailList.add(new Person(id++, mail));
                
        return mailList;
    }

    
}
