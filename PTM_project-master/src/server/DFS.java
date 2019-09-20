package server;

import java.util.*;

public class DFS extends CommonSearcher {

    @Override
    public Backtrace search(Searchable<State> searchable) {
        Stack<State> s = new Stack<>();
        s.push(searchable.startState());
        visited.add(searchable.startState());
        while(!s.isEmpty()) {
            State currentState = s.pop();
            if(searchable.isGoal(currentState)) {
                return currentState.backtrace();
            }
            List<State> nextNeighbors =
                    searchable.getPossibleNeighbors(currentState);

            for(State child: nextNeighbors) {
                if(!visited.contains(child)) {
                    s.add(child);
                    visited.add(child);
                }
            }
        }
        return null;
    }
}
