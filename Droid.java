public class Droid {
  String name;
  int batteryLevel;
  // constructor
  public Droid (String droidName) {
    name = droidName;
    batteryLevel = 100;
  }

  public String toString() {
    return "Hello, I'm the droid: " + name;
  }

  public void performTask(String task) {
    System.out.println(name + " is performing task: " + task);
    batteryLevel = batteryLevel - 10;
  }

  public void energyReport() {
    System.out.println(batteryLevel);
  }

  public void energyTransfer(Droid anotherDroid, int energyAmount) {
    batteryLevel -= energyAmount;
    anotherDroid.batteryLevel += energyAmount;
  }

  public static void main(String[] args) {
    Droid jack = new Droid("Jack");
    jack.performTask("dancing");
    System.out.println(jack);
    Droid other = new Droid("other");
    jack.energyReport();
    jack.energyTransfer(other, 20);
    jack.energyReport();
  }
}
