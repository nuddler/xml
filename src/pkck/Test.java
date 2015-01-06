package pkck;
import java.awt.EventQueue;

import javax.swing.JScrollPane;
import javax.xml.bind.JAXBException;

import org.xml.sax.SAXException;

public class Test {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
	                MyFrame myFrame = new MyFrame();
                } catch (JAXBException | SAXException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
                }
			}
		});
	}
}