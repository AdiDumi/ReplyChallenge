package main;

import common.Common;
import java.util.ArrayList;

public class Developer extends Person {
    ArrayList<String> skills;

    public Developer() {
        isUsed = false;
    }

    public Developer(ArrayList<String> skills) {
        isUsed = false;
        this.skills = skills;
    }

    public void initDev(int ID, String company, int bonus, ArrayList<String> skills) {
        this.ID = ID;
        this.company = company;
        this.bonus = bonus;
        this.skills = skills;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }


    public int workPotential(Developer dev) {
        ArrayList<String> union = (ArrayList<String>) Common.union(this.getSkills(), dev.getSkills());
        ArrayList<String> intersection = (ArrayList<String>) Common.intersection(this.getSkills(), dev.getSkills());

        System.out.println("EXCLUSIVE UNION IS");
        for (String s : union) {
            System.out.println(s);
        }

        System.out.println("INTERSECTION IS");
        for (String s : intersection) {
            System.out.println(s);
        }

        return intersection.size() * (union.size() - intersection.size());
    }
}
