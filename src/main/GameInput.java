package main;

import java.util.List;

public class GameInput {

    private final List<String> mallAngels;
    private final List<Integer> minitAngels;
    private final List<Integer> mnrAngels;
    private final int rows;
    private final int columns;
    private final List<String> mTerrains;
    private final List<Integer> initPosition;
    private final int nrPlayers;
    private final List<String> mPlayersOrder;
    private int mRounds;
    private final List<String> mMoves;

    public GameInput() {
        rows = 0;
        columns = 0;
        nrPlayers = 0;
        mTerrains = null;
        mPlayersOrder = null;
        initPosition = null;
        mMoves = null;
        mRounds = 0;
        mallAngels = null;
        minitAngels = null;
        mnrAngels = null;
    }

    public GameInput(final int rounds, final int rows, final int columns, final int nrPlayers,
                     final List<String> assets, final List<String> players,
                     final List<String> moves, final List<Integer> positions,
                     final List<String> allAngels,  final List<Integer> initAngels,
                     final List<Integer> nrAngels) {
        mTerrains = assets;
        mPlayersOrder = players;
        mRounds = rounds;
        this.rows = rows;
        this.columns = columns;
        this.nrPlayers = nrPlayers;
        mMoves = moves;
        initPosition = positions;
        mallAngels = allAngels;
        minitAngels = initAngels;
        mnrAngels = nrAngels;
    }

    public final List<Integer> getInitPosition() {
        return initPosition;
    }

    public final List<String> getTerrains() {
        return mTerrains;
    }

    public final List<String> getPlayerNames() {
        return mPlayersOrder;
    }

    public final List<String>  getMoves() {
        return  mMoves;
    }

    public final int getRounds() {
        return mRounds;
    }

    public final int getNrPlayers() {
        return nrPlayers;
    }

    public final int getRows() {
        return rows;
    }

    public final int getColumns() {
        return columns;
    }

    public final List<String> getAllAngels() {
        return mallAngels;
    }

    public final List<Integer> getInitAngels() {
        return minitAngels;
    }

    public final List<Integer> getNrAngels() {
        return mnrAngels;
    }

    public final boolean isValidInput() {
        boolean membersInstantiated = mTerrains != null && mPlayersOrder != null && mMoves != null
                && initPosition != null;
        boolean listsNotEmpty = mTerrains.size() > 0 && mPlayersOrder.size() > 0
                && mMoves.size() > 0 && initPosition.size() > 0 && mallAngels.size() > 0
                && minitAngels.size() > 0 && mnrAngels.size() > 0;
        boolean numbersNotEmpty = rows > 0 && columns > 0 && nrPlayers > 0 && mRounds > 0;
        return membersInstantiated && listsNotEmpty && numbersNotEmpty;
    }
}