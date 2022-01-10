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

    static final String JAXP_SCHEMA_LANGUAGE =
        "http://java.sun.com/xml/jaxp/properties/schemaLanguage";

    static final String W3C_XML_SCHEMA =
        "http://www.w3.org/2001/XMLSchema";

    static final String JAXP_SCHEMA_SOURCE =
        "http://java.sun.com/xml/jaxp/properties/schemaSource";

    public static void main(String[] args) {
        try {
            //Files
        	URL urlXSD = new URL("https://raw.githubusercontent.com/Gian-Marco-Del-Freo/XML-parsers/main/inputs/template.xsd");
            URL urlXML = new URL("https://raw.githubusercontent.com/Gian-Marco-Del-Freo/XML-parsers/main/inputs/example.xml");
            //Source xmlFile = new StreamSource(urlXML.openStream());
            Source xmlFile = new StreamSource("src/source/example.xml");
            //Source xsdFile = new StreamSource("src/source/template.xsd");

            
            //Creazione SaxParser
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setNamespaceAware(true);
            factory.setValidating(true);
            SAXParser saxParser = factory.newSAXParser();
            saxParser.setProperty(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
            //saxParser.setProperty(JAXP_SCHEMA_SOURCE, "https://raw.githubusercontent.com/Gian-Marco-Del-Freo/XML-parsers/main/inputs/template.xsd");
            saxParser.setProperty(JAXP_SCHEMA_SOURCE, new File("src/source/template.xsd"));
            MySAXHandler handler = new MySAXHandler();
            //saxParser.parse(urlXML.openStream(), handler);
            saxParser.parse("src/source/example.xml", handler);
        } catch (SAXException | IOException | ParserConfigurationException e) {
            System.out.println("⚠️ E' avvenuto un errore durante il parsing ⚠️: " + e);
        }


    }

}