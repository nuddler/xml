package pkck;

import javax.swing.JOptionPane;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

public class MyValidationEventHandlerOutput implements ValidationEventHandler {

	@Override
	public boolean handleEvent(ValidationEvent event) {
		 JOptionPane.showMessageDialog(null, "Blad walidacji na dokumencie wyjsciowym");
		return false;
	}

}
