package amdantas.util;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;
/**
 * 
 * @author Mini10
 *
 */
public class Util {

	public static String lerEntrada(String msg) {
		return showInputDialog(null, "" + msg);
	}
	
	public static void exibirMsg(String msg) {
		showMessageDialog(null, msg);
	}
	
	public static boolean seForInteiro (String s) {
		
		return true;
	}
	
}
