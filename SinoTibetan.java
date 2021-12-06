public class SinoTibetan extends Language {

    public SinoTibetan (String name, int numSpeaker) {
        super(name, numSpeaker, "Asia", "subject-object-verb");
        if (this.name.contains("Chinese")) {
            this.wordOrder = "subject-verb-object";
        }
    }

    @Override
    public void getInfo() {
        System.out.println(this.name + " is spoken by " + this.numSpeaker + " people mainly in " + this.regionsSpoken + ".");
        System.out.println("The language follows the word order: " + this.wordOrder);
        System.out.println("Fun fact: " + this.name + " ");
    }

}
