package games.eightPuzzleGame;

import com.sun.javafx.scene.paint.GradientUtils;
import javafx.scene.effect.Light;
import server.Searchable;
import server.State;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PuzzleSearchable implements Searchable<State<Puzzle>> {
    Puzzle puzzle;
    Point position;


    @Override
    public State<Puzzle> startState() {
        return new State<Puzzle>(puzzle,puzzle.data[position.x][position.y]);
    }

    @Override
    public Boolean isGoal(State<Puzzle> state) {
        return puzzle.getPossibleGoals().equals(state.getData());
    }

    @Override
    public List<State<Puzzle>> getPossibleNeighbors(State<Puzzle> state) {
        List<State<Puzzle>> result=new ArrayList<>();
        puzzle.getPossibleMoves();
        return null;
    }
}
