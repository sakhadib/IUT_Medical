package Controller;

import Model.Model;

import java.util.List;
import java.util.ArrayList;

public abstract class Controller {

    public void show(List<Model> models){
        for(Model m : models){
            m.printSignature();
            break;
        }
        for (Model m : models) {
            System.out.println(m.toString());
        }
    }

    public abstract void create();
    public abstract void details();

}
