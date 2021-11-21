import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class SAXParser_example {	

    private static final String FILEXML = "src/input/input.xml";

    public static void main(String[] args) {
    	try {
    		
    		//Validazione con XSD
    		URL url = new URL("https://raw.githubusercontent.com/Tommaso-Parenti/Test/main/input.xsd");
    		Source xmlFile = new StreamSource(new File(FILEXML));
    		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	        Schema schema = schemaFactory.newSchema(url);
	        Validator validator = schema.newValidator();
	        validator.validate(xmlFile);
	        
	        //Creazione SaxParser
	        SAXParserFactory factory = SAXParserFactory.newInstance();
	        SAXParser saxParser = factory.newSAXParser();
	        factory.setNamespaceAware(true);
	        factory.setValidating(true);
            DefaultHandler_example handler = new DefaultHandler_example();
            saxParser.parse(FILEXML, handler);
        } catch (SAXException | IOException | ParserConfigurationException e) {
            System.out.println("⚠️ E' avvenuto un errore durante il parsing ⚠️: " + e);
        }


    }

}