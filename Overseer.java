package src.cont;

import src.mod.Direction;
import src.mod.Maze;
import src.mod.Minotaur;
import src.mod.Player;
import src.mod.Rat;
import src.mod.Sword;
import src.view.StringMap;
import src.view.Window;

public class Overseer {

    //INSTANCE VARIABLES
    private String[] sizes = new String[] { "10x10", "15x15", "20x20", "10x15", "15x20" };
    public Player _p;
    public Minotaur _m;
    public Rat _r1;
    public Rat _r2;
    public Rat _r3;
    public Sword _v;
    public Maze _z;
    public StringMap _s;
    public Window _w;
    public static final String[] BUTTONS = new String[] { "UP", "DOWN", "RIGHT", "LEFT", "EXIT", "HELP" };

    //CONSTRUCTOR
    public Overseer() {
        this._z = new Maze();
        this._p = new Player(this._z);
        this._m = new Minotaur(this._z);
        this._r1 = new Rat(this._z);
        this._r2 = new Rat(this._z, this._r1);
        this._r3 = new Rat(this._z, this._r1, this._r2);
        this._v = new Sword(this._z);
        this._w = new Window();
        this._s = new StringMap();
    }

    /*
     *Asks the player which direction they want to move in and returns the direction as an int.
     */
    public int getPlayerMovement() {
        int x = this._w.option(BUTTONS, this._s.updateMap(this._p, this._m, this._r1, this._r2, this._r3, this._v, this._z));
        return x;
    }

    /*
     *Gets the direction the player wants to move in using getPlayerMovement nad checks if that direction
     * is valid. If it is not, then the player is told that they cannot perform that movement. If it is
     * valid, then the player is moved accordingly, along with all of the other entities in the maze.
     */
    public void move(int x) {
        if (x == 5) {
            getPlayerDirection(x);
        } else if (!this._p.move(getPlayerDirection(x), this._z)) {
            this._w.msg("YOU CAN'T MOVE IN THAT DIRECTION!");
        } else {
            this._m.move(this._z, this._p);
            this._r1.move(this._z);
            this._r2.move(this._z);
            this._r3.move(this._z);
        }
    }

    /*
     *Checks if any of the entities in the maze should be killed. If the player dies, then the game ends
     * and the player has the option of seeing all of the moves performed. If the player does not die,
     * then any other entities in the maze that should be killed are labeled as dead and do not show up in the
     * maze anymore.
     */
    public void gamecheck() {
        String[] ops = { "Dislay Moves", "Exit" };
        if ((this._p.getPosition().getRow() == this._m.getPos().getRow() && this._p.getPosition().getCol() == this._m.getPos().getCol()) || (this._p.getPosition().getRow() == this._r1.getPosition().getRow() && this._p.getPosition().getCol() == this._r1.getPosition().getCol()) || (this._p.getPosition().getRow() == this._r2.getPosition().getRow() && this._p.getPosition().getCol() == this._r2.getPosition().getCol()) || (this._p.getPosition().getRow() == this._r3.getPosition().getRow() && this._p.getPosition().getCol() == this._r3.getPosition().getCol() && !this._v.isHeld)) {
            this._p.killPlayer();
            int y = this._w.option(ops, "You just died. Wow. I cannot believe you managed to fuck up something that my quadriplegic grandmother could do. \n Well, now your soul belongs to Trevor. Good luck with that.");
            if (y == 0) {
                displayMoves();
            } else {
                System.exit(0);
            }
        } else if (this._p.getPosition().getRow() == this._m.getPos().getRow() && this._p.getPosition().getCol() == this._m.getPos().getCol() && this._v.isHeld) {
            this._m.killMin();
            this._v.useSword();
        } else if (this._p.getPosition().getRow() == this._r1.getPosition().getRow() && this._p.getPosition().getCol() == this._r1.getPosition().getCol() && this._v.isHeld) {
            this._r1.killRat();
            this._v.useSword();
        } else if (this._p.getPosition().getRow() == this._r2.getPosition().getRow() && this._p.getPosition().getCol() == this._r2.getPosition().getCol() && this._v.isHeld) {
            this._r2.killRat();
            this._v.useSword();
        } else if (this._p.getPosition().getRow() == this._r3.getPosition().getRow() && this._p.getPosition().getCol() == this._r3.getPosition().getCol() && this._v.isHeld) {
            this._r3.killRat();
            this._v.useSword();
        }
        if (this._p.getPosition().getRow() == this._z.getEnd().getRow() && this._p.getPosition().getCol() == this._z.getEnd().getCol()) {
            this._p.killPlayer();
            int y = this._w.option(ops, "You made it out of the maze! The Almighty Council of Trevor now pardons you of all past transgressions. \n So apparently you aren't terrible at everything... Good to know.");
            if (y == 0) {
                displayMoves();
            } else {
                System.exit(0);
            }
        }
    }

    /*
     *Displays the maze at each turn in the game, starting at the beginning. Gives the player the option
     * of displaying the turn after or the turn before the one currently shown. The player may exit at
     * any time, which stops the program.
     */
    public void displayMoves() {
        int cnt = 1;
        String curTurn = "";
        for (int i = 0; i < this._s.allTurns.size(); i++) {
            String[] replayOps = { "Prev Turn", "Next Turn", "Exit" };
            curTurn = "Turn " + cnt + ":\n";
            curTurn = curTurn + curTurn + "\n";
            int x = this._w.option(replayOps, curTurn);
            if (x == 0) {
                i--;
                cnt--;
                if (i < 0)
                    i = 0;
                if (cnt < 1)
                    cnt = 1;
            } else if (x == 1) {
                i++;
                cnt++;
                if (i >= this._s.allTurns.size())
                    i = this._s.allTurns.size() - 1;
                if (cnt > this._s.allTurns.size())
                    cnt = this._s.allTurns.size();
            } else {
                System.exit(0);
            }
        }
        System.exit(0);
    }

    /*
     *Determines the direction the player wants to move in and shows the help screen if the player
     * chooses to have it displayed.
     */
    public Direction getPlayerDirection(int x) {
        if (x == 0)
            return Direction.Up;
        if (x == 1)
            return Direction.Down;
        if (x == 2)
            return Direction.Right;
        if (x == 3)
            return Direction.Left;
        if (x == 4) {
            System.exit(0);
            return null;
        }
        this._w.msg(" W is a wall that cannot be moved through \n \n : : is a space that you can move through \n \n P is your location \n \n M is the location of the minotaur that chases you \n \n R is the location of a rat that patrols horizontally \n \n E is the location of the exit. You win if you get there \n \n Press EXIT to stop playing \n \n To move, press the button of the direction you want to move in \n \n You only die if ou and an enemy move to the same space at the same time");
        return null;
    }
}
