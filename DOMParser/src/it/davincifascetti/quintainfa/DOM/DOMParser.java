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
		
		DocumentBuilderFactory factoryDOM = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factoryDOM.newDocumentBuilder();
		File fileXML = new File (path);
		
		Document document = documentBuilder.parse(fileXML);
		document.getDocumentElement().normalize();
		
		System.out.println("Root Element: " + document.getDocumentElement().getNodeName());
		
		NodeList nodeListAntipasti = document.getDocumentElement().getElementsByTagName("antipasti"), 
				nodeListAntipasto = document.getDocumentElement().getElementsByTagName("antipasto");
		Node nodeAntipasti = null, nodeAntipasto = null;
		for (int i=0; i<nodeListAntipasti.getLength(); i++) {
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
			System.out.println("	Element: " + nodeAntipasti.getNodeName());
			if (nodeAntipasti.getNodeType() == Node.ELEMENT_NODE) {
				for (int j=0; j<nodeListAntipasto.getLength(); j++) {
					nodeAntipasto = nodeListAntipasto.item(j);
					System.out.println("-------------------------------------------");
					System.out.println("		Element: " + nodeAntipasto.getNodeName());
					if (nodeAntipasto.getNodeType() == Node.ELEMENT_NODE) {
						Element element = (Element) nodeAntipasto;
						//element.getElementsByTagName("nome").item(0).setTextContent("pesce");
						String name = element.getElementsByTagName("nome").item(0).getTextContent();
						String price = element.getElementsByTagName("prezzo").item(0).getTextContent();
						System.out.println("		nome: " + name);
						System.out.println("		prezzo: " + price);
					}
				}
			}
		}
		
		NodeList nodeListPrimi = document.getDocumentElement().getElementsByTagName("primi"),
				nodeListPrimo = document.getDocumentElement().getElementsByTagName("primo");
		Node nodePrimi = null, nodePrimo = null;
		for (int i=0; i<nodeListPrimi.getLength(); i++) {
			nodePrimi = nodeListPrimi.item(i);
			System.out.println("-------------------------------------------");
			System.out.println("	Element: " + nodePrimi.getNodeName());
			if (nodePrimi.getNodeType() == Node.ELEMENT_NODE) {
				for (int j=0; j<nodeListPrimo.getLength(); j++) {
					nodePrimo = nodeListPrimo.item(j);
					System.out.println("-------------------------------------------");
					System.out.println("		Element: " + nodePrimo.getNodeName());
					if (nodePrimo.getNodeType() == Node.ELEMENT_NODE) {
						Element element = (Element) nodePrimo;
						String name = element.getElementsByTagName("nome").item(0).getTextContent();
						String price = element.getElementsByTagName("prezzo").item(0).getTextContent();
						System.out.println("		nome: " + name);
						System.out.println("		prezzo: " + price);
					}
				}
			}
		}
		
		NodeList nodeListSecondi = document.getDocumentElement().getElementsByTagName("secondi"),
				nodeListSecondo = document.getDocumentElement().getElementsByTagName("secondo");
		Node nodeSecondi= null, nodeSecondo = null;
		for (int i=0; i<nodeListSecondi.getLength(); i++) {
			nodeSecondi = nodeListSecondi.item(i);
			System.out.println("-------------------------------------------");
			System.out.println("	Element: " + nodeSecondi.getNodeName());
			if (nodeSecondi.getNodeType() == Node.ELEMENT_NODE) {
				for (int j=0; j<nodeListSecondo.getLength(); j++) {
					nodeSecondo = nodeListSecondo.item(j);
					System.out.println("-------------------------------------------");
					System.out.println("		Element: " + nodeSecondo.getNodeName());
					if (nodeSecondo.getNodeType() == Node.ELEMENT_NODE) {
						Element element = (Element) nodeSecondo;
						String name = element.getElementsByTagName("nome").item(0).getTextContent();
						String price = element.getElementsByTagName("prezzo").item(0).getTextContent();
						System.out.println("		nome: " + name);
						System.out.println("		prezzo: " + price);
					}
				}
			}
		}
		
		NodeList nodeListDolci = document.getDocumentElement().getElementsByTagName("dolci"),
				nodeListDolce = document.getDocumentElement().getElementsByTagName("dolce");
		Node nodeDolci= null, nodeDolce = null;
		for (int i=0; i<nodeListDolci.getLength(); i++) {
			nodeDolci = nodeListDolci.item(i);
			System.out.println("-------------------------------------------");
			System.out.println("	Element: " + nodeDolci.getNodeName());
			if (nodeDolci.getNodeType() == Node.ELEMENT_NODE) {
				for (int j=0; j<nodeListDolce.getLength(); j++) {
					nodeDolce = nodeListDolce.item(j);
					System.out.println("-------------------------------------------");
					System.out.println("		Element: " + nodeDolce.getNodeName());
					if (nodeDolce.getNodeType() == Node.ELEMENT_NODE) {
						Element element = (Element) nodeDolce;
						String name = element.getElementsByTagName("nome").item(0).getTextContent();
						String price = element.getElementsByTagName("prezzo").item(0).getTextContent();
						System.out.println("		nome: " + name);
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
			DOMParser.parserDOM(DOMParser.path);
		} catch(ParserConfigurationException | SAXException | IOException | TransformerException e) {
			System.out.println("ERROR");
		} 
	}

}