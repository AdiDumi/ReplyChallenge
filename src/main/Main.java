package main;

import common.PersonFactory;

import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Person getFistAvailable(char type, List<Person> managers, List<Person> developers) {
        if (type == '_') {
            for (int i = 0; i < developers.size(); ++i) {
                if (!developers.get(i).isUsed()) {
                    return developers.get(i);
                }
            }
        } else {
            for (int i = 0; i < managers.size(); ++i) {
                if (!managers.get(i).isUsed()) {
                    return managers.get(i);
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        String in, out;
        in = "/home/adi/Documents/ReplyChallenge/in/a_solar.txt";
        out = "/home/adi/Documents/ReplyChallenge/out.txt";
        GameInputLoader gameInputLoader = new GameInputLoader(in, out);
        GameInput gameInput = gameInputLoader.load();

        List<Person> allDevs = new ArrayList<>();
        List<Person> allPMs = new ArrayList<>();
        int nrDevs, nrPMs;
        nrDevs = gameInput.getNrDev();
        nrPMs = gameInput.getNrPM();
        List<String> allOffice = gameInput.getMallOffice();
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


        Office office = Office.getInstance(gameInput.getRows(), gameInput.getColumns());
        for (int i = 0; i < gameInput.getRows(); ++i) {
            office.addLine(allOffice.get(i));
        }

        int l = 0;
        for (int i = 0; i < nrDevs; ++i) {
            allDevs.add(PersonFactory.getPerson("dev"));
            for (int j = 0; j < allDevNrSkill.get(i); ++i) {
                devSkills.add(allDevSkills.get(l));
            }
            allDevs.get(i).initDev(i, allDevCompany.get(i), allDevBonus.get(i), devSkills);
            devSkills.clear();
        }

        for (int i = 0; i < nrPMs; ++i) {
            allPMs.add(PersonFactory.getPerson("man"));
            allPMs.get(i).initMan(i, allPMCompany.get(i), allPMBonus.get(i));
        }

        List<Person> managers = allPMs;
        List<Person> developers = allDevs;

        int nrDevsNeed = office.getNrDevelopers();
        int nrMngsNeed = office.getNrManagers();
        int n = office.getN();
        int m = office.getM();

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (!office.isBusy(i, j)) {
                    Queue<Person> people = new LinkedList<Person>();
                    Person firstPerson = getFistAvailable(office.getPositionType(i, j), managers, developers);

                    if (firstPerson == null) {
                        continue;
                    }

                    firstPerson.setX(i);
                    firstPerson.setY(j);
                    firstPerson.setUsed(true);

                    people.add(firstPerson);

                    while (!people.isEmpty()) {
                        Person person = people.peek();
                        office.placePerson(person, person.getX(), person.getY());
                        people.remove();

                        int coordX[] = {0, 0, 1, -1};
                        int coordY[] = {1, -1, 0, 0};

                        for (int k = 0; k <= 3; ++k) {
                            if (!office.isBusy(person.getX() + coordX[k], person.getY() + coordY[k])) {
                                Person bestPerson = null;
                                if (office.getPositionType(person.getX() + coordX[k], person.getY() + coordY[k]) == '_') {
                                    bestPerson = person.getBest(developers);
                                } else if (office.getPositionType(person.getX() + coordX[k], person.getY() + coordY[k]) == 'M') {
                                    bestPerson = person.getBest(managers);
                                }

                                if (bestPerson != null) {
                                    bestPerson.setX(person.getX() + coordX[k]);
                                    bestPerson.setY(person.getY() + coordY[k]);
                                    bestPerson.setUsed(true);
                                    people.add(bestPerson);
                                }
                            }
                        }
                    }
                }
            }
        }

        try {
            FileWriter fileWriter = new FileWriter(out);
            for (int i = 0; i < developers.size(); ++i) {
                if (developers.get(i).isUsed()) {
                    fileWriter.write(developers.get(i).getX() + " " + developers.get(i).getY());
                } else {
                    fileWriter.write("X");
                }
            }

            for (int i = 0; i < managers.size(); ++i) {
                if (managers.get(i).isUsed()) {
                    fileWriter.write(managers.get(i).getX() + " " + managers.get(i).getY());
                } else {
                    fileWriter.write("X");
                }
            }

            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
