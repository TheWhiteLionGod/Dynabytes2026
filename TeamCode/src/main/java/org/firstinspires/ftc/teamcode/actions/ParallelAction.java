package org.firstinspires.ftc.teamcode.actions;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;

public class ParallelAction implements Action {
    private final ArrayList<Action> actions;
    public ParallelAction(@NonNull Action... actions) {
        this.actions = new ArrayList<>();
        Collections.addAll(this.actions, actions);
    }

    @Override
    public boolean run() {
        // RemoveIf Will Call Each Action and Remove It If Finished
        actions.removeIf(Action::run);
        // If All Actions Are Done, Array Will Be Empty
        return actions.isEmpty();
    }

    @Override
    public void interrupt() {
        for (Action action : actions) {
            action.interrupt();
        }
    }
}
