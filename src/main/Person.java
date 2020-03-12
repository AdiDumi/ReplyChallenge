package main;


public abstract class Person {
    int ID;
    String company;
    int bonus;
    Boolean isUsed;

    public int getID() {
        return ID;
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

    public int bonusPotential(Person employee) {
        if (this.getCompany().equals(employee.getCompany())) {
            return (this.getBonus() * employee.getBonus());
        } else {
            return 0;
        }
    }
}
