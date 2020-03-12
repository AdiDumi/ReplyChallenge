package main;

public class Manager extends Person {
    public Manager() {
        isUsed = false;
    }

    public void initMan(int ID, String company, int bonus) {
        this.ID = ID;
        this.company = company;
        this.bonus = bonus;
    }
}
