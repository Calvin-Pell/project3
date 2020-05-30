package src.mod;

public class Player {

    //INSTANCE VARIABLES
    private Position _curPos;
    private boolean _isAlive = true;

    //GETTERS
    public Position getPosition() { return this._curPos; }
    public boolean checkAlive() { return this._isAlive; }

    //SETTERS
    public void setPosition(Position p) { this._curPos = p; }

    //CONSTRUCTOR
    public Player(Maze z) {
        this._curPos = new Position(z.getPlayerStart().getRow(), z.getPlayerStart().getCol());
    }

    /*
     *Simulates the player dying by setting isAlive to false.
     */
    public void killPlayer() {
        this._isAlive = false;
    }

    /*
     *Checks if the user can move in the direction selected. If the move is valid, it moves the
     * player 1 space in the direction selected and returns true. If the move is invalid, then
     * false is returned and the user's position is unchanged.
     */
    public boolean move(Direction d, Maze z) {
        if (d == Direction.Up) {
            if (this._curPos.getRow() - 1 >= 0 && !z.getMaze()[this._curPos.getRow() - 1][this._curPos.getCol()]) {
                this._curPos = new Position(this._curPos.getRow() - 1, this._curPos.getCol());
                return true;
            }
        } else if (d == Direction.Down) {
            if (this._curPos.getRow() + 1 < (z.getMaze()).length && !z.getMaze()[this._curPos.getRow() + 1][this._curPos.getCol()]) {
                this._curPos = new Position(this._curPos.getRow() + 1, this._curPos.getCol());
                return true;
            }
        } else if (d == Direction.Right) {
            if (this._curPos.getCol() + 1 < (z.getMaze()[this._curPos.getRow()]).length &&
                    !z.getMaze()[this._curPos.getRow()][this._curPos.getCol() + 1]) {
                this._curPos = new Position(this._curPos.getRow(), this._curPos.getCol() + 1);
                return true;
            }
        } else if (this._curPos.getCol() - 1 >= 0 && !z.getMaze()[this._curPos.getRow()][this._curPos.getCol() - 1]) {
            this._curPos = new Position(this._curPos.getRow(), this._curPos.getCol() - 1);
            return true;
        }
        return false;
    }
}
