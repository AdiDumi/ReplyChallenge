package common;

import main.Developer;
import main.Manager;
import main.Person;

public class PersonFactory {
    public static Person getPerson(String persType) {
        switch (persType) {
            case "dev":
                return new Developer();
            case "man":
                return new Manager();
        }
        return null;
    }
}
