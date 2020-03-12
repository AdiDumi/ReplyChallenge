package main;

import java.util.ArrayList;

public class Developer extends Person {
    ArrayList<String> skills;

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }
}
