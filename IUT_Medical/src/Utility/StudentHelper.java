package Utility;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class StudentHelper {
    public static String[] firstNames = {
            "Aarav", "Aditya", "Ananya", "Anik", "Arjun", "Arya", "Ayesha", "Bipasha", "Deb", "Debanjan",
            "Dipti", "Eshan", "Gargi", "Ishaan", "Ishita", "Jaya", "Kabir", "Kamal", "Kartik", "Kavita",
            "Koushik", "Lina", "Madhur", "Maya", "Meera", "Nabendu", "Naina", "Neha", "Nihar", "Nikita",
            "Oishani", "Partha", "Piyali", "Pradeep", "Priya", "Rajat", "Rajesh", "Rakesh", "Ranjan", "Ria",
            "Rimi", "Ritika", "Rohan", "Rupak", "Sagar", "Sahil", "Sakshi", "Sandeep", "Sangita", "Sanjana",
            "Santanu", "Sayan", "Seema", "Shantanu", "Shashi", "Sohini", "Sourav", "Subham", "Sudip", "Sujata",
            "Sumit", "Sushmita", "Tanisha", "Tanmay", "Tapan", "Tara", "Tarun", "Tulika", "Vijay", "Vikram",
            "Vinay", "Vipul", "Vishal", "Yash", "Yashika", "Yuvraj", "Zarina", "Zoya", "Arif", "Amin"
    };

    public static String[] lastNames = {
            "Banerjee", "Barman", "Basu", "Bhattacharya", "Biswas", "Chakraborty", "Chandra", "Chatterjee",
            "Das", "Dasgupta", "Datta", "Deb", "Dey", "Ganguly", "Ghosh", "Ghoshal", "Guha", "Halder",
            "Jana", "Jash", "Karmakar", "Khan", "Lahiri", "Majumdar", "Malakar", "Mandal", "Mukherjee",
            "Nag", "Nandi", "Pal", "Panja", "Panja", "Roy", "Roychowdhury", "Saha", "Sarkar", "Sen",
            "Sengupta", "Singh", "Sinha", "Sur", "Tagore", "Thakur", "Bagchi", "Bhattacharjee", "Chakrabarti",
            "Goswami", "Mazumder", "Bhattacharjee", "Ghatak", "Dhar", "Datta", "Chakravarti", "Mitra",
            "Niyogi", "Samanta", "Ray", "Sarangi", "Laskar", "Gorai", "Hossain", "Joarder", "Karim",
            "Khatun", "Mollah", "Mondal", "Munsi", "Patel", "Paul", "Rai", "Sharma", "Sheikh", "Singha",
            "Talukdar", "Uddin", "Barua", "Barman", "Dutta", "Hazra"
    };

    public static String[] depts = {"CSE", "EEE", "BTM", "CEE", "MPE"};

    public static List<String> getUniqueNames(int count) {
        if (count > firstNames.length * lastNames.length) {
            throw new IllegalArgumentException("Count is too large to generate unique names.");
        }

        List<String> uniqueNames = new ArrayList<>();
        HashSet<String> usedNames = new HashSet<>();
        Random random = new Random();

        while (uniqueNames.size() < count) {
            String firstName = firstNames[random.nextInt(firstNames.length)];
            String lastName = lastNames[random.nextInt(lastNames.length)];
            String fullName = firstName + " " + lastName;

            if (!usedNames.contains(fullName)) {
                usedNames.add(fullName);
                uniqueNames.add(fullName);
            }
        }

        return uniqueNames;
    }

    public static List<String> getEmails(List<String> names) {
        List<String> emails = new ArrayList<>();

        for (String name : names) {
            String processedName = name.replaceAll(" ", "").toLowerCase();
            String email = processedName + "@iut-dhaka.edu";
            emails.add(email);
        }

        return emails;
    }
}
