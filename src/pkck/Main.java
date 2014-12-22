package pkck;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import pkck.dataModel.Hurtownia;
import pkck.dataModel.Zamowienie;

public class Main {

	public static void main(String[] args) throws JAXBException  {
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Hurtownia.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
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
