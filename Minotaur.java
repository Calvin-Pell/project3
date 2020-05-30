package src.mod;

public class Minotaur {

    //INSTANCE VARIABLES
    private boolean _isAlive = true;
    private Position _curPos;

    //GETTERS
    public Position getPos() { return this._curPos; }
    public boolean checkAlive() { return this._isAlive; }

    //SETTERS
    public void setPos(Position pos) { this._curPos = pos; }

    //CONSTRUCTOR
    public Minotaur(Maze z) {
        this._curPos = z.getMinStart();
    }

    /*
     *Uses the differences of the column of the minotaur minus the column of the player and the
     * row of the minotaur minus the row of the player to determine which direction to move in.
     * Then checks if it is possible to move in that direction. If it is, then it moves the
     * minotaur in that direction. If not, then it checks the next best direction until
     * a valid direction is found and then moves in that direction.
     */
    public void move(Maze z, Player p) {
        int distRow = this._curPos.getRow() - p.getPosition().getRow();
        int distCol = this._curPos.getCol() - p.getPosition().getCol();
        if (distRow > 0) {
            if (!z.getMaze()[this._curPos.getRow() - 1][this._curPos.getCol()]) {
                setPos(new Position(this._curPos.getRow() - 1, this._curPos.getCol()));
            } else if (distCol > 0 && !z.getMaze()[this._curPos.getRow()][this._curPos.getCol() - 1]) {
                setPos(new Position(this._curPos.getRow(), this._curPos.getCol() - 1));
            } else if (!z.getMaze()[this._curPos.getRow()][this._curPos.getCol() + 1]) {
                setPos(new Position(this._curPos.getRow(), this._curPos.getCol() + 1));
            } else if (!z.getMaze()[this._curPos.getRow()][this._curPos.getCol() - 1]) {
                setPos(new Position(this._curPos.getRow(), this._curPos.getCol() - 1));
            } else {
                setPos(new Position(this._curPos.getRow() + 1, this._curPos.getCol()));
            }
        } else if (distRow == 0) {
            if (distCol > 0 && !z.getMaze()[this._curPos.getRow()][this._curPos.getCol() - 1]) {
                setPos(new Position(this._curPos.getRow(), this._curPos.getCol() - 1));
            } else if (!z.getMaze()[this._curPos.getRow()][this._curPos.getCol() + 1]) {
                setPos(new Position(this._curPos.getRow(), this._curPos.getCol() + 1));
            } else if (!z.getMaze()[this._curPos.getRow() + 1][this._curPos.getCol()]) {
                setPos(new Position(this._curPos.getRow() + 1, this._curPos.getCol()));
            } else if (!z.getMaze()[this._curPos.getRow() - 1][this._curPos.getCol()]) {
                setPos(new Position(this._curPos.getRow() - 1, this._curPos.getCol()));
            } else {
                setPos(new Position(this._curPos.getRow(), this._curPos.getCol() - 1));
            }
        } else if (!z.getMaze()[this._curPos.getRow() + 1][this._curPos.getCol()]) {
            setPos(new Position(this._curPos.getRow() + 1, this._curPos.getCol()));
        } else if (distCol > 0 && !z.getMaze()[this._curPos.getRow()][this._curPos.getCol() - 1]) {
            setPos(new Position(this._curPos.getRow(), this._curPos.getCol() - 1));
        } else if (!z.getMaze()[this._curPos.getRow()][this._curPos.getCol() + 1]) {
            setPos(new Position(this._curPos.getRow(), this._curPos.getCol() + 1));
        } else if (!z.getMaze()[this._curPos.getRow()][this._curPos.getCol() - 1]) {
            setPos(new Position(this._curPos.getRow(), this._curPos.getCol() - 1));
        } else {
            setPos(new Position(this._curPos.getRow() - 1, this._curPos.getCol()));
        }
    }

    /*
     *Simulates the minotaur dying by setting isAlive to false.
     */
    public void killMin() {
        this._isAlive = false;
    }

}