package main;

public class Person {
    String company;
    int bonus;

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
        return (this.getBonus() * employee.getBonus());
    }
}
