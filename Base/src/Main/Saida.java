package Main;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class Saida {

	public void printDouble(double num, String msg) {
		DecimalFormat df = new DecimalFormat("###,##0.00");
		JOptionPane.showMessageDialog(null, msg + ": " + df.format(num));
	}

	public void printString(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}

	public void printInt(int n, String msg) {
		JOptionPane.showMessageDialog(null, msg + " : " + n);
	}

	public void printFiveInt(int n1, int n2, int n3, int n4, int n5, String msg) {
		JOptionPane.showMessageDialog(null, msg + " : " + n1 + ", " + n2 + ", " + n3 + ", " + n4 + ", " + n5);
	}

}
