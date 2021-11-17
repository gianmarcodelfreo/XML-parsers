package it.davincifascetti.quintainfa.DOM;


import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMParser {

	private static final String path="./src/FileXML/FileXMLRistorante.xml";
	
	private static void parserDOM(String path) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		//Creazione di un'istanza di DocumentBuilderFactory attraverso il metodo statico newInstance()
		DocumentBuilderFactory factoryDOM = DocumentBuilderFactory.newInstance();
		
		//Creazione di un'istanza di DocumentBuilder
		DocumentBuilder documentBuilder = factoryDOM.newDocumentBuilder();
		
		//Creazione di un oggetto di tipo file con uno specifico percorso (Il file coincide con quello da parsare)
		File fileXML = new File (path);
		
		//Dichiarazione di un elemento Document a cui verrà assegnato il risultato del parser del file XML
		Document document = documentBuilder.parse(fileXML);
		
		//Si prende il primo elemento del documento e si eleminano eventuali accenti, apostrofi ecc...
		document.getDocumentElement().normalize();
		
		//Stampa a video del nome del root element
		System.out.println("Root Element: " + document.getDocumentElement().getNodeName());
		
		//Si inserisce in una lista di nodi, gli elementi antipasti e antipasto
		NodeList nodeListAntipasti = document.getDocumentElement().getElementsByTagName("antipasti"), 
				nodeListAntipasto = document.getDocumentElement().getElementsByTagName("antipasto");
		
		//Si dichiarano due nodi.
		Node nodeAntipasti = null, nodeAntipasto = null;
		
		//Si scorre l'intero contenuto della lista di nodi antipasti
		for (int i=0; i<nodeListAntipasti.getLength(); i++) {
			
			//Si inserisce l'intero contenuto di ogni elemento in un nodo
			nodeAntipasti = nodeListAntipasti.item(i);
			
			/*
			Element createdantipasto = document.createElement("antipasto");
			Element creatednome = document.createElement("nome");
			Element createdprice = document.createElement("prezzo");
			creatednome.setTextContent("Crostini salsiccia e stracchino");
			createdprice.setTextContent("5.50");
			createdantipasto.appendChild(creatednome);
			createdantipasto.appendChild(createdprice);
			nodeAntipasti.appendChild(createdantipasto);*/
			
			System.out.println("-------------------------------------------");
			
			//Stampa a video del valore dell'elemento antipasti
			System.out.println("	Element: " + nodeAntipasti.getNodeName());
			
			//Si verifica se sono presenti altri elementi all'interno di un elemento antipasti
			if (nodeAntipasti.getNodeType() == Node.ELEMENT_NODE) {
				
				//Si scorre l'intero contenuto della lista di nodi antipasto
				for (int j=0; j<nodeListAntipasto.getLength(); j++) {
					
					//Si inserisce l'intero contenuto di ogni elemento in un nodo
					nodeAntipasto = nodeListAntipasto.item(j);
					System.out.println("-------------------------------------------");
					
					//Stampa a video del valore dell'elemento antipasto
					System.out.println("		Element: " + nodeAntipasto.getNodeName());
					
					//Si verifica se sono presenti altri elementi all'interno di un elemento antipasto
					if (nodeAntipasto.getNodeType() == Node.ELEMENT_NODE) {
						
						//Si crea un elemento a cui viene assegnato il valore del contenuto del nodo antipasto
						Element element = (Element) nodeAntipasto;
						
						//Si inserisce in una stringa il valore dell'elemento nome
						String name = element.getElementsByTagName("nome").item(0).getTextContent();
						
						//Si inserisce in una stringa il valore dell'elemento prezzo
						String price = element.getElementsByTagName("prezzo").item(0).getTextContent();
						
						//Stampa a video del valore dell'elemento nome
						System.out.println("		nome: " + name);
						
						//Stampa a video del valore dell'elemento prezzo
						System.out.println("		prezzo: " + price);
					}
				}
			}
		}
		
		//Si inserisce in una lista di nodi, gli elementi primi e primo
		NodeList nodeListPrimi = document.getDocumentElement().getElementsByTagName("primi"),
				nodeListPrimo = document.getDocumentElement().getElementsByTagName("primo");
		
		//Si dichiarano due nodi
		Node nodePrimi = null, nodePrimo = null;
		
		//Si scorre l'intero contenuto della lista di nodi primi
		for (int i=0; i<nodeListPrimi.getLength(); i++) {
			
			//Si inserisce l'intero contenuto di ogni elemento in un nodo
			nodePrimi = nodeListPrimi.item(i);
			
			System.out.println("-------------------------------------------");
			
			//Stampa a video del valore dell'elemento primi
			System.out.println("	Element: " + nodePrimi.getNodeName());
			
			//Si verifica se sono presenti altri elementi all'interno di un elemento primi
			if (nodePrimi.getNodeType() == Node.ELEMENT_NODE) {
				
				//Si scorre l'intero contenuto della lista di nodi primo
				for (int j=0; j<nodeListPrimo.getLength(); j++) {
					
					//Si inserisce l'intero contenuto di ogni elemento in un nodo
					nodePrimo = nodeListPrimo.item(j);
					
					System.out.println("-------------------------------------------");
					
					//Stampa a video del valore dell'elemento primo
					System.out.println("		Element: " + nodePrimo.getNodeName());
					
					//Si verifica se sono presenti altri elementi all'interno di un elemento primo
					if (nodePrimo.getNodeType() == Node.ELEMENT_NODE) {
						
						//Si crea un elemento a cui viene assegnato il valore del contenuto del nodo primo
						Element element = (Element) nodePrimo;
						
						//Si inserisce in una stringa il valore dell'elemento nome
						String name = element.getElementsByTagName("nome").item(0).getTextContent();
						
						//Si inserisce in una stringa il valore dell'elemento prezzo
						String price = element.getElementsByTagName("prezzo").item(0).getTextContent();
						
						//Stampa a video del valore dell'elemento nome
						System.out.println("		nome: " + name);
						
						//Stampa a video del valore dell'elemento prezzo
						System.out.println("		prezzo: " + price);
					}
				}
			}
		}
		
		//Si inserisce in una lista di nodi, gli elementi secondi e secondo
		NodeList nodeListSecondi = document.getDocumentElement().getElementsByTagName("secondi"),
				nodeListSecondo = document.getDocumentElement().getElementsByTagName("secondo");
		
		//Si dichiarano due nodi
		Node nodeSecondi= null, nodeSecondo = null;
		
		//Si scorre l'intero contenuto della lista di nodi secondi
		for (int i=0; i<nodeListSecondi.getLength(); i++) {
			
			//Si inserisce l'intero contenuto di ogni elemento in un nodo
			nodeSecondi = nodeListSecondi.item(i);
			
			System.out.println("-------------------------------------------");
			
			//Stampa a video del valore dell'elemento secondi
			System.out.println("	Element: " + nodeSecondi.getNodeName());
			
			//Si verifica se sono presenti altri elementi all'interno di un elemento secondi
			if (nodeSecondi.getNodeType() == Node.ELEMENT_NODE) {
				
				//Si scorre l'intero contenuto della lista di nodi secondo
				for (int j=0; j<nodeListSecondo.getLength(); j++) {
					
					//Si inserisce l'intero contenuto di ogni elemento in un nodo
					nodeSecondo = nodeListSecondo.item(j);
					
					System.out.println("-------------------------------------------");
					
					//Stampa a video del valore dell'elemento secondo
					System.out.println("		Element: " + nodeSecondo.getNodeName());
					
					//Si verifica se sono presenti altri elementi all'interno di un elemento secondo
					if (nodeSecondo.getNodeType() == Node.ELEMENT_NODE) {
						
						//Si crea un elemento a cui viene assegnato il valore del contenuto del nodo secondo
						Element element = (Element) nodeSecondo;
						
						//Si inserisce in una stringa il valore dell'elemento nome
						String name = element.getElementsByTagName("nome").item(0).getTextContent();
						
						//Si inserisce in una stringa il valore dell'elemento prezzo
						String price = element.getElementsByTagName("prezzo").item(0).getTextContent();
						
						//Stampa a video del valore dell'elemento nome
						System.out.println("		nome: " + name);
						
						//Stampa a video del valore dell'elemento prezzo
						System.out.println("		prezzo: " + price);
					}
				}
			}
		}
		
		//Si inserisce in una lista di nodi, gli elementi dolci e dolce
		NodeList nodeListDolci = document.getDocumentElement().getElementsByTagName("dolci"),
				nodeListDolce = document.getDocumentElement().getElementsByTagName("dolce");
		
		//Si dichiarano due nodi
		Node nodeDolci= null, nodeDolce = null;
		
		//Si scorre l'intero contenuto della lista di nodi dolci
		for (int i=0; i<nodeListDolci.getLength(); i++) {
			
			//Si inserisce l'intero contenuto di ogni elemento in un nodo
			nodeDolci = nodeListDolci.item(i);
			
			System.out.println("-------------------------------------------");
			
			//Stampa a video del valore dell'elemento dolci
			System.out.println("	Element: " + nodeDolci.getNodeName());
			
			//Si verifica se sono presenti altri elementi all'interno di un elemento dolci
			if (nodeDolci.getNodeType() == Node.ELEMENT_NODE) {
				
				//Si scorre l'intero contenuto della lista di nodi dolce
				for (int j=0; j<nodeListDolce.getLength(); j++) {
					
					//Si inserisce l'intero contenuto di ogni elemento in un nodo
					nodeDolce = nodeListDolce.item(j);
					
					System.out.println("-------------------------------------------");
					
					//Stampa a video del valore dell'elemento dolce
					System.out.println("		Element: " + nodeDolce.getNodeName());
					
					//Si verifica se sono presenti altri elementi all'interno di un elemento dolce
					if (nodeDolce.getNodeType() == Node.ELEMENT_NODE) {
						
						//Si crea un elemento a cui viene assegnato il valore del contenuto del nodo dolce
						Element element = (Element) nodeDolce;
						
						//Si inserisce in una stringa il valore dell'elemento nome
						String name = element.getElementsByTagName("nome").item(0).getTextContent();
						
						//Si inserisce in una stringa il valore dell'elemento prezzo
						String price = element.getElementsByTagName("prezzo").item(0).getTextContent();
						
						//Stampa a video del valore dell'elemento nome
						System.out.println("		nome: " + name);
						
						//Stampa a video del valore dell'elemento prezzo
						System.out.println("		prezzo: " + price);
					}
				}
			}
		}
		
		/*TransformerFactory transformerFactory = TransformerFactory.newInstance();
	    Transformer transformer = transformerFactory.newTransformer();
	    DOMSource source = new DOMSource(document);

	    StreamResult result = new StreamResult("./src/FileXML/FileXMLRistoranteOutput.xml");
	    transformer.transform(source, result);*/
		
	}
	
	public static void main(String[] args) {
		
		try {
			//Si richiama la funzione che effettua il parsing, specificando il valore di una variabile statica che rappresenta il percorso del file da analizzare
			DOMParser.parserDOM(DOMParser.path);
			
		//Eccezioni che si possono sollevare
		} catch(ParserConfigurationException | SAXException | IOException | TransformerException e) {
			
			//Stampa a video un messaggio d'errore
			System.out.println("⚠️ E' avvenuto un errore durante il parsing ⚠️");
		} 
	}

}