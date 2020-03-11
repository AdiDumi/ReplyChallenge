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
        List<String> allTerrains = new ArrayList<>();
        List<String> playerOrder = new ArrayList<>();
        List<String> allMoves = new ArrayList<>();
        List<Integer> allPositions = new ArrayList<>();
        List<Integer> nrAngels = new ArrayList<>();
        List<String> allAngels = new ArrayList<>();
        List<Integer> initAngels = new ArrayList<>();
        int rounds = 0;
        int nrPlayers = 0;
        int rows = 0;
        int columns = 0;
        String angel;
        int len;

        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);

            rows = fs.nextInt();
            columns = fs.nextInt();

            for (int i = 0; i < rows; ++i) {
                allTerrains.add(fs.nextWord());
            }


            nrPlayers = fs.nextInt();

            for (int i = 0; i < nrPlayers; ++i) {
                playerOrder.add(fs.nextWord());
                allPositions.add(fs.nextInt());
                allPositions.add(fs.nextInt());
            }

            rounds = fs.nextInt();

            int j;
            for (int i = 0; i < rounds; ++i) {
                allMoves.add(fs.nextWord());
            }

            for (int i = 0; i < rounds; ++i) {
                j = fs.nextInt();
                if (j == 0) {
                    nrAngels.add(0);
                } else {
                    nrAngels.add(j);
                    for (int k = 0; k < j; ++k) {
                        angel = fs.nextWord();
                        len = angel.length();
                        initAngels.add(Integer.parseInt((angel.substring(len
                                - 3, len - 2)).trim()));
                        initAngels.add(Integer.parseInt((angel.substring(len
                                - 1, len)).trim()));
                        allAngels.add(angel.substring(0, len - 4));
                    }
                }
            }
            fs.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return new GameInput(rounds, rows, columns, nrPlayers,
                allTerrains, playerOrder, allMoves, allPositions, allAngels, initAngels, nrAngels);
    }
}