package main;

import java.util.ArrayList;
import java.util.List;


public class Office  {
    private int m = 0;
    private int n = 0;
    ArrayList<ArrayList<Character>> matrix;
    Person [][] matrixPerson;
    private int nrManagers;
    private int nrDevelopers;

    private static Office instance = null;

    private Office(int n, int m) {
        this.n = n;
        this.m = m;

        matrixPerson = new Person[n][m];
        for (int i = 0; i < n; ++i) {
            matrixPerson[i] = new Person[m];
        }

        matrix = new ArrayList<>();
    }

    public static Office getInstance(int n, int m) {
        if (instance == null) {
            instance = new Office(n, m);
        }

        return instance;
    }

    public static Office getInstance() {
        if (instance == null) {
            instance = new Office(0, 0);
        }
        int pula;
        return instance;
    }

    public void addLine(String line) {
        ArrayList<Character> list = new ArrayList<Character>();
        for (int i = 0; i < line.length(); ++i) {
            switch (line.charAt(i)) {
                case 'M':
                    nrManagers++;
                    break;
                case '_':
                    nrDevelopers++;
                    break;
            }

            list.add(line.charAt(i));
        }

        matrix.add(list);
    }

    public char getPositionType(int x, int y) {
        if (x >= n || y >= m || x < 0 || y < 0) {
            return 0;
        } else {
            return matrix.get(x).get(y);
        }
    }

    public Person getPerson(int x, int y) {
        return matrixPerson[x][y];
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getNrManagers() {
        return nrManagers;
    }

    public void setNrManagers(int nrManagers) {
        this.nrManagers = nrManagers;
    }

    public int getNrDevelopers() {
        return nrDevelopers;
    }

    public void setNrDevelopers(int nrDevelopers) {
        this.nrDevelopers = nrDevelopers;
    }

    public boolean isBusy(int x, int y) {
        if (x >= n || y >= m || x < 0 || y < 0) {
            return true;
        }

        return matrix.get(x).get(y) == '#' || matrixPerson[x][y] != null;
    }

    public void placePerson(Person person, int x, int y) {
        matrixPerson[x][y] = person;
    }
}
