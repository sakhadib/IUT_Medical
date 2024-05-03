package Controller;

import Model.Model;

import java.util.List;
import java.util.ArrayList;

public abstract class Controller {
    public abstract void save();
    public abstract void update();
    public abstract void delete();
    public abstract void select();

    public void Show(List<Model> models){
        for (Model m : models) {
            System.out.println(m.toString());
        }
    }
}
