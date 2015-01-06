package pkck.dataModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "płatność", namespace = "http://www.pkck.com")
@XmlAccessorType(XmlAccessType.FIELD)
public class Platnosc {

	@XmlAttribute(name = "kanał")
	private String kanal;

	@XmlAttribute(name = "raty")
	private String raty;

	public String getKanal() {
		return kanal;
	}

	public void setKanal(String kanal) {
		this.kanal = kanal;
	}

	public String getRaty() {
		return raty;
	}

	public void setRaty(String raty) {
		this.raty = raty;
	}

	@Override
	public String toString() {
		return "Platnosc [kanal=" + kanal + ", raty=" + raty + "]";
	}
	
	public String toTable() {
		return "kanal=" + kanal + ", raty=" + raty;
	}

}
