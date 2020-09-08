/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazeslover;

import java.util.ArrayList;

/**
 *
 * @author MahaAg
 */
public class MementoOriginator {

    private State state;

    public void set(State state) {
        this.state = state;

    }

    public Memento saveToMemento() {
        return new Memento(state);
    }

    public State restoreFromMemento(Memento m) {
        state = m.getSavedState();
        return state;
    }

}

