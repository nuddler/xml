package pkck.dataModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dzial", namespace = "http://www.pkck.com")
@XmlAccessorType(XmlAccessType.FIELD)
public class Dzial {

	@XmlID
	@XmlAttribute(name = "nazwa_działu")
	private String nazwaDzialu;

	@XmlElement(name = "opis_działu", namespace = "http://www.pkck.com")
	private String opisDzialu;

	public String getNazwaDzialu() {
		return nazwaDzialu;
	}

	public void setNazwaDzialu(String nazwaDzialu) {
		this.nazwaDzialu = nazwaDzialu;
	}

	public String getOpisDzialu() {
		return opisDzialu;
	}

	public void setOpisDzialu(String opisDzialu) {
		this.opisDzialu = opisDzialu;
	}

	@Override
	public String toString() {
		return "Dzial [nazwaDzialu=" + nazwaDzialu + ", opisDzialu="
				+ opisDzialu + "]";
	}

}
