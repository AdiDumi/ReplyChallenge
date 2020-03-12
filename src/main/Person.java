package main;

<<<<<<< HEAD
abstract class Person {
    int ID;
=======
public class Person {
>>>>>>> fc327079bed5ecb3d961d4ea64ff1a7225af308c
    String company;
    int bonus;

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

<<<<<<< HEAD
    // abstract void workPotential(Person p2);
=======
    public int bonusPotential(Person employee) {
        if (this.getCompany().equals(employee.getCompany())) {
            return (this.getBonus() * employee.getBonus());
        } else {
            return 0;
        }
    }
>>>>>>> fc327079bed5ecb3d961d4ea64ff1a7225af308c
}
