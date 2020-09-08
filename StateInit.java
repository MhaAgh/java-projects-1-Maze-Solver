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
public class StateInit extends State {

    public StateInit(StateContext s) {
        state = s;
    }

    @Override
    public void nextState() {
        maze.init();
        state.setState(state.getNewState());
        state.nextState();
    }
}
