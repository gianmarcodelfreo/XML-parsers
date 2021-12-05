import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
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

    // Metodo che viene richiamato ogni volta che viene incontrato uno spazio ignorabile
    @Override
    public void ignorableWhitespace(char ch[], int start, int length)
    throws SAXException {
        System.out.println(tabber + "Spazio ignorabile");
    }


    // Metodo che viene richiamato ogni volta che viene incontrato un PI
    @Override
    public void processingInstruction(String target, String data)
    throws SAXException {
        System.out.println(tabber + "Istruzione di processamento (Target,Data): " + target + "," + data);
    }

    // Metodo che viene richiamato ogni volta che avviene un warning da parte del parser
    @Override
    public void warning(SAXParseException e)
    throws SAXException {
        throw e;
    }

    // Metodo che viene richiamato ogni volta che avviene un error da parte del parser
    @Override
    public void error(SAXParseException e)
    throws SAXException {
        throw e;
    }

    // Metodo che viene richiamato ogni volta che avviene un fatal error da parte del parser
    @Override
    public void fatalError(SAXParseException e)
    throws SAXException {
        throw e;
    }

    // Metodo che risolve un entità trovata.
    @Override
    public InputSource resolveEntity(String publicId, String systemId)
    throws IOException, SAXException {
        System.out.println("Entità trovata con public ID " + publicId + " e system ID " + systemId);

        //Controlla se l'entità trovata ha un systemId uguale a quello dell'XML che va parsato.
        if (systemId.equals("https://raw.githubusercontent.com/Gian-Marco-Del-Freo/XML-parsers/main/inputs/example.xml")) {
            System.out.println("Risoluzione dell'entità");
            return new InputSource("https://raw.githubusercontent.com/Gian-Marco-Del-Freo/XML-parsers/main/inputs/example.xml");
        }

        //Controlla se l'entità trovata ha un systemId uguale a quello dell'XSD che viene utilizzato per validare.
        if (systemId.equals("https://raw.githubusercontent.com/Gian-Marco-Del-Freo/XML-parsers/main/inputs/template.xsd")) {
            System.out.println("Risoluzione dell'entità");
            return new InputSource("https://raw.githubusercontent.com/Gian-Marco-Del-Freo/XML-parsers/main/inputs/template.xsd");
        }

        // Usa il comportamento di default
        return null;

    }

}