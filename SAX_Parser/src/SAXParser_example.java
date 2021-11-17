import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SAXParser_example {

	//Percorso del file XML
    private static final String FILEXML = "src/input/input.xml";

    public static void main(String[] args) {

    	//Si crea un'istanza di SAXParserFactory
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
        	//Si crea un'istanza di SAXParserFactory
            SAXParser saxParser = factory.newSAXParser();
            
            //Si crea un oggetto di tipo DefaultHandler_example
            DefaultHandler_example handler = new DefaultHandler_example();
            
            //Si indica il file da parsare e l'handler
            saxParser.parse(FILEXML, handler);
            
            //Errori che si possono verificare
        } catch (SAXException | ParserConfigurationException | IOException e) {
            System.out.println("⚠️ E' avvenuto un errore durante il parsing ⚠️");
        }

    }

}