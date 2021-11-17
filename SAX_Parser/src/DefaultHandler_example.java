import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class DefaultHandler_example extends DefaultHandler {
	private String tabber = "";
    private StringBuilder currentValue = new StringBuilder();

    // Metodo che viene richiamato all'inizio del documento  
    @Override
    public void startDocument() {
        System.out.println("Inizio del documento");
    }

    // Metodo che viene richiamato alla fine del documento  
    @Override
    public void endDocument() {
        System.out.println("Fine del documento");
    }

    // Metodo che viene richiamato all'inizio di un elemento
    @Override
    public void startElement(
        String uri,
        String localName,
        String qName,
        Attributes attributes) {

        //Utile ad azzerare il valore corrente
        currentValue.setLength(0);

        System.out.println("\n" + tabber + "Inizio dell'elemento : " + qName);

        if (qName.equalsIgnoreCase("section")) {
            String section = attributes.getValue("section");
            System.out.println(tabber + "Sezione : " + section);
        }

        if (qName.equalsIgnoreCase("specialization")) {
            String specialization = attributes.getValue("specialization");
            System.out.println(tabber + "Specializzazione : " + specialization);
        }
        this.tabber += "\t";
    }

    // Metodo che viene richiamato alla fine di un elemento
    @Override
    public void endElement(String uri,
        String localName,
        String qName) {
    	
        if (qName.equalsIgnoreCase("name")) {
            System.out.println(tabber + "name : " + currentValue.toString());
        }

        if (qName.equalsIgnoreCase("surname")) {
            System.out.println(tabber + "surname : " + currentValue.toString());
        }

        if (qName.equalsIgnoreCase("age")) {
            System.out.println(tabber + "age : " + currentValue.toString());
        }

        if (qName.equalsIgnoreCase("gender")) {
            System.out.println(tabber + "gender : " + currentValue.toString());
        }

        if (qName.equalsIgnoreCase("dataOfBirth")) {
            System.out.println(tabber + "dataOfBirth : " + currentValue.toString());
        }
        
        this.tabber = this.tabber.replaceFirst("\t", "");
        
        System.out.println(tabber + "Fine dell'elemento : " + qName + "\n");
    }

    // Metodo che viene richiamato ogni volta che viene incontrato un carattere di testo
    @Override
    public void characters(char ch[], int start, int length) {
        currentValue.append(ch, start, length);
    }

    //Riceve la notifica di uno spazio ingorabile
    @Override
    public void ignorableWhitespace(char ch[], int start, int length)
    throws SAXException {
        System.out.println(tabber + "Spazio ignorabile");
    }

    //Riceve la notifica di una PI.
    @Override
    public void processingInstruction(String target, String data)
    throws SAXException {
        System.out.println(tabber + "Istruzione di processamento (Target,Data): " + target + "," + data);
    }

}