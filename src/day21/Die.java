package day21;

public abstract class Die {

    int rolls = 0;

    abstract int roll();

    protected void incrementRolls() {
        this.rolls++;
    }

    public int getRolls() {
        return rolls;
    }
}
