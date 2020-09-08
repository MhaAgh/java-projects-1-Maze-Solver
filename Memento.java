/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazeslover;

/**
 *
 * @author MahaAg
 */
public class Memento {

    private State state;

    public Memento(State stateToSave) {
        state = stateToSave;
    }

    public State getSavedState() {
        return state;
    }

}
