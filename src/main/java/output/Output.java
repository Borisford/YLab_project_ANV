package output;

public abstract class Output {
    public abstract void mainMenu();
    public abstract void varInput(int maxVar);
    public abstract void strInput(String name);
    public abstract void outputString(String str);
    public abstract void operationMenu();
    public abstract void outputBalance(String name, float balance);
    public abstract void nameNotUnique();
}
