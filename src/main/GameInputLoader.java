package main;

import java.util.ArrayList;
import java.util.List;

import fileio.FileSystem;

public final class GameInputLoader {
    private final String mInputPath;
    private final String mOutputPath;

    GameInputLoader(final String inputPath, final String outputPath) {
        mInputPath = inputPath;
        mOutputPath = outputPath;
    }

    public GameInput load() {
        /*
        initializez variabilele unde urmeaza sa stochez datele de intrare
         */
        List<String> allOffice = new ArrayList<>();
        List<String> allDevCompany = new ArrayList<>();
        List<String> allDevSkills = new ArrayList<>();
        List<Integer> allPMBonus = new ArrayList<>();
        List<Integer> allDevBonus = new ArrayList<>();
        List<String> allPMCompany = new ArrayList<>();
        List<Integer> allDevNrSkill = new ArrayList<>();
        int nrDev = 0;
        int columns = 0;
        int nrPM = 0;
        int rows = 0;

        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);

            rows = fs.nextInt();
            columns = fs.nextInt();

            for (int i = 0; i < rows; ++i) {
                allOffice.add(fs.nextWord());
            }


            nrDev = fs.nextInt();

            for (int i = 0; i < nrDev; ++i) {
                allDevCompany.add(fs.nextWord());
                allDevBonus.add(fs.nextInt());
                allDevNrSkill.add(fs.nextInt());
                for (int j = 0; j < allDevNrSkill.get(i); ++i) {
                    allDevSkills.add(fs.nextWord());
                }
            }

            nrPM = fs.nextInt();

            for (int i = 0; i < nrPM; ++i) {
                allPMCompany.add(fs.nextWord());
                allPMBonus.add(fs.nextInt());
            }
            fs.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return new GameInput(rows, columns, nrDev, nrPM, allOffice, allDevCompany, allDevSkills, allDevBonus, allDevNrSkill, allPMBonus, allPMCompany);
    }
}
