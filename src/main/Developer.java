package main;

<<<<<<< HEAD
import common.Common;

=======
>>>>>>> fc327079bed5ecb3d961d4ea64ff1a7225af308c
import java.util.ArrayList;

public class Developer extends Person {
    ArrayList<String> skills;

    Developer(ArrayList<String> skills) {
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
