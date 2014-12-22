package pkck.dataModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "autor", namespace="http://www.pkck.com")
@XmlAccessorType(XmlAccessType.FIELD)
public class Autor {

	@XmlElement(name= "imię_autora", namespace="http://www.pkck.com")
	private String imieAutora;
	
	@XmlElement(name="nazwisko_autora", namespace="http://www.pkck.com")
	private String nazwiskoAutora;
	
	@XmlElement(name= "nr_indeksu", namespace="http://www.pkck.com")
	private String numerIndeksu;

	@Override
	public String toString() {
		return "Autor [imieAutora=" + imieAutora + ", nazwiskoAutora="
				+ nazwiskoAutora + ", numerIndeksu=" + numerIndeksu + "]";
	}

	public String getImieAutora() {
		return imieAutora;
	}

	public void setImieAutora(String imieAutora) {
		this.imieAutora = imieAutora;
	}

	public String getNazwiskoAutora() {
		return nazwiskoAutora;
	}

	public void setNazwiskoAutora(String nazwiskoAutora) {
		this.nazwiskoAutora = nazwiskoAutora;
	}

	public String getNumerIndeksu() {
		return numerIndeksu;
	}

	public void setNumerIndeksu(String numerIndeksu) {
		this.numerIndeksu = numerIndeksu;
	}
}
