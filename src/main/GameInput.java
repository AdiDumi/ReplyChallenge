package main;

import java.util.List;

public class GameInput {

    private final List<String> mallOffice;
    private final List<Integer> mallDevNrSkill;
    private final List<Integer> mallDevBonus;
    private final int rows;
    private final int columns;
    private final List<String> mallDevCompany;
    private final List<Integer> mallPMBonus;
    private final int nrDev;
    private final List<String> mallPMCompany;
    private final int nrPM;
    private final List<String> mallDevSkill;

    public GameInput() {
        rows = 0;
        columns = 0;
        nrDev = 0;
        mallOffice = null;
        mallDevBonus= null;
        mallDevCompany = null;
        mallDevNrSkill = null;
        nrPM = 0;
        mallPMBonus= null;
        mallPMCompany = null;
        mallDevSkill = null;
    }

    public GameInput(final int rows, final int columns, final int nrDev, final int nrPM,
                     final List<String> allOffice, final List<String> allDevCompany,
                     final List<String> allDevSkill, final List<Integer> allDevBonus,
                     final List<Integer> allDevNrSkill,  final List<Integer> allPMBonus,
                     final List<String> allPMCompany) {

        mallDevSkill = allDevSkill;
        mallPMBonus = allPMBonus;
        this.rows = rows;
        this.columns = columns;
        this.nrDev = nrDev;
        this.nrPM = nrPM;
        mallDevNrSkill = allDevNrSkill;
        mallOffice = allOffice;
        mallDevCompany = allDevCompany;
        mallDevBonus = allDevBonus;
        mallPMCompany = allPMCompany;
    }

    public List<String> getMallOffice() {
        return mallOffice;
    }

    public List<Integer> getMallDevNrSkill() {
        return mallDevNrSkill;
    }

    public List<Integer> getMallDevBonus() {
        return mallDevBonus;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public List<String> getMallDevCompany() {
        return mallDevCompany;
    }

    public List<Integer> getMallPMBonus() {
        return mallPMBonus;
    }

    public int getNrDev() {
        return nrDev;
    }

    public List<String> getMallPMCompany() {
        return mallPMCompany;
    }

    public int getNrPM() {
        return nrPM;
    }

    public List<String> getMallDevSkill() {
        return mallDevSkill;
    }

}
