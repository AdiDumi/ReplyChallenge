package main;

import java.util.ArrayList;

public class Manager extends Person {
    public Manager() {
        used = false;
        this.skills = null;
    }

    public int workPotential(Person p) {
        return 0;
    }

    public void initMan(int ID, String company, Integer bonus) {
        this.ID = ID;
        this.company = company;
        this.bonus = bonus;
    }

    public void initDev(int i, String s, Integer integer, ArrayList<String> devSkills) {

    }

}
