package src.view;

import java.util.ArrayList;
import src.mod.Maze;
import src.mod.Minotaur;
import src.mod.Player;
import src.mod.Rat;
import src.mod.Sword;

public class StringMap {

    //INSTANCE VARIABLES
    private String _map;
    public ArrayList<String> allTurns = new ArrayList<>();
    int cnt;

    //GETTERS
    public String getMap() { return this._map; }

    //CONSTRUCTOR
    public StringMap() {
        this.cnt = 0;
        this._map = "";
    }

    /*
     *Updates the String representation of the maze with the new positions of all of the entities
     * in the maze. Any entities that are dead are not added.
     */
    public String updateMap(Player p, Minotaur m, Rat r1, Rat r2, Rat r3, Sword v, Maze z) {
        if (this.cnt != 0)
            this.allTurns.add(this._map);
        this._map = "";
        for (int r = 0; r < (z.getMaze()).length; r++) {
            for (int c = 0; c < (z.getMaze()[r]).length; c++) {
                if (z.getMaze()[r][c]) {
                    this._map += "W";
                    if (c != (z.getMaze()[r]).length - 1)
                        this._map += "  ";
                } else if (p.checkAlive() && r == p.getPosition().getRow() && c == p.getPosition().getCol()) {
                    this._map += "P";
                    if (c != (z.getMaze()[r]).length - 1)
                        this._map += "  ";
                } else if (m.checkAlive() && r == m.getPos().getRow() && c == m.getPos().getCol()) {
                    this._map += "M";
                    if (c != (z.getMaze()[r]).length - 1)
                        this._map += "  ";
                } else if (r == z.getEnd().getRow() && c == z.getEnd().getCol()) {
                    this._map += "E";
                    if (c != (z.getMaze()[r]).length - 1)
                        this._map += "  ";
                } else if ((r1.checkAlive() && r == r1.getPosition().getRow() && c == r1.getPosition().getCol()) || (r2.checkAlive() && r == r2.getPosition().getRow() && c == r2.getPosition().getCol()) || (r3.checkAlive() && r == r3.getPosition().getRow() && c == r3.getPosition().getCol())) {
                    this._map += "R";
                    if (c != (z.getMaze()[r]).length - 1)
                        this._map += "  ";
                } else if (!v.isHeld && r == v.getPosition().getRow() && c == v.getPosition().getCol()) {
                    this._map += "S";
                    if (c != (z.getMaze()[r]).length - 1)
                        this._map += "  ";
                } else {
                    this._map += ": :";
                    if (c != (z.getMaze()[r]).length - 1)
                        this._map += "  ";
                }
            }
            this._map += "\n";
        }
        this.cnt++;
        return this._map;
    }

}