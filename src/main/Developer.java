package main;

import common.Common;
import java.util.ArrayList;
import java.util.List;

public class Developer extends Person {
    public Developer() {
        used = false;
        this.skills = skills;
    }

    public Developer(ArrayList<String> skills) {
        used = false;
        this.skills = skills;
    }

    public void initDev(int ID, String company, Integer bonus, ArrayList<String> skills) {
        this.ID = ID;
        this.company = company;
        this.bonus = bonus;
        this.skills = skills;
    }

    public void initMan(int ID, String company, Integer bonus){

    }

    public int workPotential(Person dev) {
        ArrayList<String> union = (ArrayList<String>) Common.union(this.getSkills(), dev.getSkills());
        ArrayList<String> intersection = (ArrayList<String>) Common.intersection(this.getSkills(), dev.getSkills());

        return intersection.size() * (union.size() - intersection.size());
    }
}
