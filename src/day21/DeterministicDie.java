package day21;

public class DeterministicDie extends Die {

    private int currentRollValue = 0;

    public int checkRollValue(int rollValue) {
        while (rollValue > 100) {
            rollValue -= 100;
        }
        return rollValue;
    }

    @Override
    public int roll() {
        incrementRolls();
        currentRollValue++;
        return checkRollValue(currentRollValue);
    }
}
