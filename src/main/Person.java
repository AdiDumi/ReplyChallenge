package main;


import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Person {
    int ID;
    String company;
    int bonus;
    boolean used;
    int x;
    int y;
    ArrayList<String> skills;
<<<<<<< HEAD
=======

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }
>>>>>>> 10347daa42d91e9b3bf4ee50386a6363b0f18764

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public int getID() {
        return ID;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    protected abstract ArrayList<String> getSkills();

    public int bonusPotential(Person employee) {
        if (this.getCompany().equals(employee.getCompany())) {
            return (this.getBonus() * employee.getBonus());
        } else {
            return 0;
        }
    }

    public abstract void initDev(int i, String s, Integer integer, ArrayList<String> devSkills);

    public abstract void initMan(int i, String s, Integer integer);

    public abstract int workPotential(Person p);





}
