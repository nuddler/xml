package pkck;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import pkck.dataModel.Hurtownia;
import pkck.dataModel.Zamowienie;

public class Main {

	public static void main(String[] args) throws JAXBException, SAXException  {
		 SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		 Schema schema = sf.newSchema(new File("src/hurtownia.xsd"));
		 
		
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Hurtownia.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		jaxbUnmarshaller.setSchema(schema);
		
		
		
		Hurtownia hurtownia = (Hurtownia) jaxbUnmarshaller.unmarshal(new File("src/hurtownia.xml"));
		System.out.println(hurtownia.toString());
		Zamowienie zamowienie=new Zamowienie();
		zamowienie.setLiczbaSztuk(50);
		//hurtownia.dodajZamowienie(zamowienie);
		System.out.println(hurtownia);
		Marshaller jaxbMarshaller=jaxbContext.createMarshaller();
		jaxbMarshaller.marshal( hurtownia, new File( "src/wygenerowany.xml" ) );
	}
}
