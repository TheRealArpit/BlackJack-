import java.util.Scanner;
import java.util.Random;
public class Player {
    private String name;
    private int currentDrawnValue;
    private int CurrentValue;

    public Player(String name){
        this.name = name;
    }

    public void introduction(){
        System.out.println(toString());
    }

    @Override
    public String toString(){
        return name + " Drew " + currentDrawnValue + " and currently has " + CurrentValue;
    }

    public String getName(){
        return name;
    }
    public int getCurrentValue(){
        return CurrentValue;
    }

    public void setCurrentValue(int value){
        CurrentValue = value;
    }

    public void updateCurrentValue(int addValue){
        CurrentValue += addValue;
    }

    public void setCurrentDrawnValue(int curr){
        currentDrawnValue = curr;
    }
    public int getCurrentDrawnValue(){
        return currentDrawnValue ;
    }
}
