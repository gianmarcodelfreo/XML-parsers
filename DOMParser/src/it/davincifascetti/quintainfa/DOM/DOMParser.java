package it.davincifascetti.quintainfa.DOM;


import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMParser {

	//File XML
	private static final String FILEXML="https://raw.githubusercontent.com/Gian-Marco-Del-Freo/XML-parsers/main/inputs/example.min.xml";
	
	//File XML Output
	private static final String FILEXMLOUTPUT="./src/Outputs_file/exampleOutput.xml";
	
	//File XSD
	private static final String FILEXSD="https://raw.githubusercontent.com/Gian-Marco-Del-Freo/XML-parsers/main/inputs/template.xsd";
	
	private static void parserDOM(String path) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		
		//Creiamo un oggetto di tipo URL che contiene il percorso del file XML
		URL url = new URL(path);
		
		//Definiamo un'istanza di URLConnection che permette di aprire una comunicazione attraverso il link
		URLConnection urlConnection = url.openConnection();
		
		//Si definisce uno spazio di memoria attraverso la comunicazione stabilita con urlConnection
		InputStream in = new BufferedInputStream(urlConnection.getInputStream());
		
		//Creazione di un'istanza di DocumentBuilderFactory attraverso il metodo statico newInstance()
		DocumentBuilderFactory factoryDOM = DocumentBuilderFactory.newInstance();
		
		//Creazione di un'istanza di DocumentBuilder
		DocumentBuilder documentBuilder = factoryDOM.newDocumentBuilder();
		
		//Settiamo il valore dell'ErrorHandler a null in modo da utilizzare quello di default
		documentBuilder.setErrorHandler(null);
		
		//Dichiarazione di un elemento Document a cui verrà assegnato il risultato del parser del file XML
		Document document = documentBuilder.parse(in);
		
		//Si prende il primo elemento del documento e si eliminano eventuali accenti, apostrofi ecc...
		document.getDocumentElement().normalize();
		
		//Stampa a video del nome del root element
		System.out.println("Root Element: " + document.getDocumentElement().getNodeName());
		
		//Si inserisce in una lista di nodi, gli elementi class
		NodeList nodeListclass = document.getDocumentElement().getElementsByTagName("class"),
				nodeListstudent=null;
		
		//Si dichiarano due nodi
		Node nodeclass = null, nodestudent = null;
		
		//Si scorre l'intero contenuto della lista di nodi antipasti
		for (int i=0; i<nodeListclass.getLength(); i++) {
			
			//Si inserisce l'intero contenuto di ogni elemento in un nodo
			nodeclass = nodeListclass.item(i);
			
			//Si inserisce in un nodo il contenuto dei nodi figli
			nodeListstudent = nodeclass.getChildNodes();
			
			/*
			Element createdstudent = document.createElement("student");
			Element creatednome = document.createElement("name");
			Element createdsurname = document.createElement("surname");
			Element createdage = document.createElement("age");
			Element createdgender = document.createElement("gender");
			Element createddateOfBirth = document.createElement("dateOfBirth");
			creatednome.setTextContent("Mario");
			createdsurname.setTextContent("Rossi");
			createdage.setTextContent("17");
			createdgender.setTextContent("Uomo");
			createddateOfBirth.setTextContent("2004-07-15");
			
			createdstudent.appendChild(creatednome);
			createdstudent.appendChild(createdsurname);
			createdstudent.appendChild(createdage);
			createdstudent.appendChild(createdgender);
			createdstudent.appendChild(createddateOfBirth);
	
			nodeclass.appendChild(createdstudent);*/
			
			System.out.println("-------------------------------------------");
			
			//Stampa a video del valore dell'elemento class
			System.out.println("	Element: " + nodeclass.getNodeName());
			
			
			//Si verifica se sono presenti altri elementi all'interno di un elemento class
			if (nodeclass.getNodeType() == Node.ELEMENT_NODE) {
				
				//Si scorre l'intero contenuto della lista di nodi student
				for (int j=0; j<nodeListstudent.getLength(); j++) {
					
					//Si inserisce l'intero contenuto di ogni elemento in un nodo
					nodestudent = nodeListstudent.item(j);
					System.out.println("-------------------------------------------");
					
					//Stampa a video del valore dell'elemento student
					System.out.println("		Element: " + nodestudent.getNodeName());
					
					//Si verifica se sono presenti altri elementi all'interno di un elemento student
					if (nodestudent.getNodeType() == Node.ELEMENT_NODE) {
						
						//Si crea un elemento a cui viene assegnato il valore del contenuto del nodo student
						Element element = (Element) nodestudent;
						
						//Si inserisce in una stringa il valore dell'elemento name
						String name = element.getElementsByTagName("name").item(0).getTextContent();
						
						//Si inserisce in una stringa il valore dell'elemento surname
						String surname = element.getElementsByTagName("surname").item(0).getTextContent();
						
						//Si inserisce in una stringa il valore dell'elemento age
						String age = element.getElementsByTagName("age").item(0).getTextContent();
						
						//Si inserisce in una stringa il valore dell'elemento gender
						String gender = element.getElementsByTagName("gender").item(0).getTextContent();
						
						//Si inserisce in una stringa il valore dell'elemento dateOfBirth
						String dateOfBirth = element.getElementsByTagName("dateOfBirth").item(0).getTextContent();
						
						//Stampa a video del valore dell'elemento name
						System.out.println("		name: " + name);
						
						//Stampa a video del valore dell'elemento surname
						System.out.println("		surname: " + surname);
						
						//Stampa a video del valore dell'elemento age
						System.out.println("		age: " + age);
						
						//Stampa a video del valore dell'elemento gender
						System.out.println("		gender: " + gender);
						
						//Stampa a video del valore dell'elemento dateOfBirth
						System.out.println("		dateOfBirth: " + dateOfBirth);
					}
				}
			}
		}
		
		/*
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
	    Transformer transformer = transformerFactory.newTransformer();
	    DOMSource source = new DOMSource(document);

	    StreamResult result = new StreamResult(DOMParser.FILEXMLOUTPUT);
	    transformer.transform(source, result);*/
		
	}
	
	public static void main(String[] args) {
		
		try {
			//Si fornisce il link del file XSD
			URL schemaFile = new URL(DOMParser.FILEXSD);
			
			//Si fornisce il file XML attraverso il percorso statico
			Source xmlFile = new StreamSource(DOMParser.FILEXML);
			
			//Si crea un'istanza di SchemaFactory con il namespace standard di schema 
			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			
			//Viene parsato lo specifico file presente in schemafile
			Schema schema = schemaFactory.newSchema(schemaFile);
			
			//Viene creata un'istanza di un validatore basato sul file schema precedente
			Validator validator = schema.newValidator();
			
			//Viene validato il file XML 
			validator.validate(xmlFile);
			
			//Stampa a video dell'effettiva validazione
			System.out.println("✅ Documento valido ✅");
			
			System.out.println("-------------------------------------------");
			
			//Si richiama la funzione che effettua il parsing, specificando il valore di una variabile statica che rappresenta il percorso del file da analizzare
			DOMParser.parserDOM(DOMParser.FILEXML);
			
		//Eccezioni che si possono sollevare
		} catch(ParserConfigurationException | SAXException | IOException | TransformerException e) {
			//Stampa a video un messaggio d'errore
			System.out.println("⚠️ E' avvenuto un errore durante il parsing ⚠️" + e);
		} 
	}

}