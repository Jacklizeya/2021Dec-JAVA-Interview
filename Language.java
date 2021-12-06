public class Language {
    protected String name;
    protected int numSpeaker;
    protected String regionsSpoken;
    protected String wordOrder;
   
    // the constructor function
    public Language (String name, int numSpeaker, String regionSpoken, String wordOrder) {
        this.name = name;
        this.numSpeaker = numSpeaker;
        this.regionsSpoken = regionSpoken;
        this.wordOrder = wordOrder;
    }

    // the getInfo function
    public void getInfo() {
        System.out.println(this.name + " is spoken by " + this.numSpeaker + " people mainly in " + this.regionsSpoken + ".");
        System.out.println("The language follows the word order: " + this.wordOrder);
    }
    public static void main (String[] args) {
        Language spanish = new Language("Spanish", 555000000, "Spain, Latin America, and Equatorial Guinea", "subject-verb-object");
        spanish.getInfo();

        Mayan mayan1 = new Mayan("manyan1", 3200);
        mayan1.getInfo();

        SinoTibetan chinese = new SinoTibetan("mandarin Chinese", 5000);
        chinese.getInfo();

        SinoTibetan nonChinese = new SinoTibetan("Burmese", 1000);
        nonChinese.getInfo();
    }
  }
