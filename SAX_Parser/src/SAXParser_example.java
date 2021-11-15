import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SAXParser_example {

    private static final String FILEXML = "input/input.xml";

    public static void main(String[] args) {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler_example handler = new DefaultHandler_example();
            saxParser.parse(FILEXML, handler);
        } catch (SAXException | ParserConfigurationException | IOException e) {
           	System.out.println("⚠️ E' avvenuto un errore durante il parsing ⚠️");
        }

    }

}