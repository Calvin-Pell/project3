package src.cont;

import src.view.Window;

public class Main {

    /*
     *Uses JOptionPane to display the intro message for the player, then shows them the maze and allows
     * them to move throughout the maze until they either get to the exit or they run into an enemy and
     * lose the game.
     */
    public static void main(String[] args) {
        Window w = new Window();
        w.msg("The Almighty Council of Trevor has just found you guilty of committing crimes against Skyrim and her people. \n \n They used their quantum entanglement technology to imprison you(in fortnite) in a vast maze. \n \n They have summoned the silent Minotaur, known only as \"The Pipe\" that will chase you unerringly, as well as the three ratlike Hartogs, who patrol the halls. \n \n However, your boy Jonah smuggled in a sword for you to use, though it's a cheap ass sword so it'll only work once. Thanks, Obama! \n \n All you need to do is make it to the exit of the maze, and the Almighty Council of Trevor will pardon your crimes since you've demonstrated your epicness. \n \n Now don't fuck this up, or Trevor and Ronald will absorb your soul.");
        Overseer _o = new Overseer();
        _o._s.updateMap(_o._p, _o._m, _o._r1, _o._r2, _o._r3, _o._v, _o._z);
        while (_o._p.checkAlive()) {
            _o.move(_o.getPlayerMovement());
            _o._s.updateMap(_o._p, _o._m, _o._r1, _o._r2, _o._r3, _o._v, _o._z);
            _o.gamecheck();
        }
    }
}