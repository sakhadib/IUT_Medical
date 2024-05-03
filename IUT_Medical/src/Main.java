import Model.*;

import javax.print.Doc;

public class Main {
    public static void main(String[] args) {
//        Student student = new Student("210042106", "Adib Sakhawat", "adib@gmail,com", "CSE");
//        student.save();

//        Doctor doctor = new Doctor("Doc-01", "Salma Ahmed", "salma@gmail,com", "Cardiology");
//        doctor.save();

        Visit visit = new Visit("210042106", "Doc-01");
        visit.save();
    }
}