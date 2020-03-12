package main;

import common.PersonFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();

        List<Person> allDevs = new ArrayList<>();
        List<Person> allPMs = new ArrayList<>();
        int nrDevs, nrPMs;
        nrDevs = gameInput.getNrDev();
        nrPMs = gameInput.getNrPM();
        List<String> allOffice = new ArrayList<>();
        List<String> allDevCompany;
        List<String> allDevSkills;
        List<Integer> allPMBonus;
        List<Integer> allDevBonus;
        List<String> allPMCompany;
        List<Integer> allDevNrSkill;
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
