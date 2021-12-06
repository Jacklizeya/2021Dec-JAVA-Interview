public class Mayan extends Language {

    public Mayan (String name, int numSpeaker) {
        super(name, numSpeaker, "Central America", "verb-object-subject");
    }

    @Override
    public void getInfo() {
        System.out.println(this.name + " is spoken by " + this.numSpeaker + " people mainly in " + this.regionsSpoken + ".");
        System.out.println("The language follows the word order: " + this.wordOrder);
        System.out.println("Fun fact: " + this.name + " ");
    }

}
