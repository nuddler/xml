package pkck;
import java.awt.EventQueue;
import javax.swing.JScrollPane;

public class Test {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				MyFrame myFrame = new MyFrame();
			}
		});
	}
}