package Controller;

import Utility.TestHelper;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class TestController extends Controller{
    @Override
    public void create() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Creating a Test");

        System.out.println("Test Name:");
        String name = sc.nextLine();
        System.out.println("Test Price:");
        int price = sc.nextInt();
        System.out.println("Is it Available? (true/false)");
        String available = sc.next();
        Boolean av;
        if(available.equals("true")){
            av = true;
        }else{
            av = false;
        }

        Model.Test test = new Model.Test(name, price, av);
        test.save();

        System.out.println("--- Test created successfully ---");

    }

    @Override
    public void details(){

    }

    public void update(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Test ID:");
        int testID = sc.nextInt();

        Model.Test test = new Model.Test(testID);

        System.out.println("Enter the new Test Name:");
        String testName = sc.nextLine();
        System.out.println("Enter the new Test Price:");
        int testPrice = sc.nextInt();
        System.out.println("Is it Available? (true/false)");
        String available = sc.next();
        int av;
        if(available.equals("true")){
            av = 1;
        }else{
            av = 0;
        }

        test.name = testName;
        test.price = testPrice;
        test.Availablity = av;

        test.update();

        System.out.println("--- Test updated successfully ---");
    }

    public void delete(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Test ID:");
        int testID = sc.nextInt();

        Model.Test test = new Model.Test(testID);
        test.delete();

        System.out.println("--- Test deleted successfully ---");
    }

    public void populate(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of tests to populate:");
        int count = sc.nextInt();

        List<String> testNames = TestHelper.getRandomNames(count);

        for(int i=0; i<count; i++){
            Random rand = new Random();
            int price = rand.nextInt(1000);
            Boolean available = rand.nextBoolean();

            Model.Test test = new Model.Test(testNames.get(i), price, available);
            test.save();
        }

        System.out.println("--- Tests populated successfully ---");
    }
}
