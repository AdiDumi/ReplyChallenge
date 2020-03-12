package main;

import common.PersonFactory;

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

        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();

        List<Person> allDevs = new ArrayList<>();
        List<Person> allPMs = new ArrayList<>();
        int nrDevs, nrPMs;
        nrDevs = gameInput.getNrDev();
        nrPMs = gameInput.getNrPM();
        List<String> allOffice = new ArrayList<>();
        List<String> allDevCompany = new ArrayList<>();
        List<String> allDevSkills = new ArrayList<>();
        List<Integer> allPMBonus = new ArrayList<>();
        List<Integer> allDevBonus = new ArrayList<>();
        List<String> allPMCompany = new ArrayList<>();
        List<Integer> allDevNrSkill = new ArrayList<>();
        allDevCompany = gameInput.getMallDevCompany();
        allDevBonus = gameInput.getMallDevBonus();
        allDevNrSkill = gameInput.getMallDevNrSkill();
        allDevSkills = gameInput.getMallDevSkill();
        ArrayList<String> devSkills = new ArrayList<>();
        allPMCompany = gameInput.getMallPMCompany();
        allPMBonus = gameInput.getMallPMBonus();

        int k = 0;
        for (int i = 0; i < nrDevs; ++i) {
            allDevs.add(PersonFactory.getPerson("dev"));
            for (int j = 0; j < allDevNrSkill.get(i); ++i) {
                devSkills.add(allDevSkills.get(k));
            }
            allDevs.get(i).initDev(i, allDevCompany.get(i), allDevBonus.get(i), devSkills);
            devSkills.clear();
        }

        for (int i = 0; i < nrPMs; ++i) {
            allPMs.add(PersonFactory.getPerson("man"));
            allPMs.get(i).initMan(i, allPMCompany.get(i), allPMBonus.get(i));
        }
    }

}
