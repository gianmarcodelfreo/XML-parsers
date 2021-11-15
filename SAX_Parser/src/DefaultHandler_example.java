import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class DefaultHandler_example extends DefaultHandler {

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

      System.out.println("Inizio dell'elemento : " + qName);

      if (qName.equalsIgnoreCase("section")) {
          String section = attributes.getValue("section");
          System.out.println("Sezione : " + section);
      }

      if (qName.equalsIgnoreCase("specialization")) {
          String specialization = attributes.getValue("specialization");
          System.out.println("Specializzazione : " + specialization);
      }

  }

  // Metodo che viene richiamato alla fine di un elemento
  @Override
  public void endElement(String uri,
                         String localName,
                         String qName) {

      System.out.println("Fine dell'elemento : " + qName);

      if (qName.equalsIgnoreCase("name")) {
          System.out.println("name : " + currentValue.toString());
      }

      if (qName.equalsIgnoreCase("surname")) {
          System.out.println("surname : " + currentValue.toString());
      }

      if (qName.equalsIgnoreCase("age")) {
          System.out.println("age : " + currentValue.toString());
      }

      if (qName.equalsIgnoreCase("gender")) {
          System.out.println("gender : " + currentValue.toString());
      }
      
      if (qName.equalsIgnoreCase("dataOfBirth")) {
          System.out.println("dataOfBirth : " + currentValue.toString());
      }

  }

  // Metodo che viene richiamato ogni volta che viene incontrato un carattere di testo
  @Override
  public void characters(char ch[], int start, int length) {
      currentValue.append(ch, start, length);
  }

}