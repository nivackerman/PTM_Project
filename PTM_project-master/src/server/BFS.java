package server;

import java.util.*;

public class BFS extends CommonSearcher {

    @Override
    public Backtrace search(Searchable<State> searchable) {
        Queue<State> q = new LinkedList<>();
        q.add(searchable.startState());
        visited.add(searchable.startState());

        while(!q.isEmpty()) {
            State currentState = q.remove();
            if(searchable.isGoal(currentState)) {
                return currentState.backtrace();
            }
            List<State> nextNeighbors =
                    searchable.getPossibleNeighbors(currentState);

            for(State child: nextNeighbors) {
                if(!visited.contains(child)) {
                    q.add(child);
                    visited.add(child);
                }
            }
        }
        return null;
    }
}
