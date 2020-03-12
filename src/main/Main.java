package main;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //      TESTING FOR UNION + INTERSECTION
        ArrayList<String> skills1 = new ArrayList<String>();
        skills1.add("frumos");
        skills1.add("destept");
        ArrayList<String> skills2 = new ArrayList<String>();
        skills2.add("urat");
        skills2.add("destept");
        Developer p1 = new Developer(skills1);
        Developer p2 = new Developer(skills2);
        p1.workPotential(p2);


    }

}
