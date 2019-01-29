import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class ValidadorDeSenha {
	
	public static void main(String[] args) {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Enter a password:");
		JPasswordField pass = new JPasswordField(10);
		panel.add(label);
		panel.add(pass);
		String[] options = new String[] { "OK", "Cancel" };
		int option = JOptionPane.showOptionDialog(null, panel, "Password", JOptionPane.NO_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
		if (option == 0) {
			char[] password = pass.getPassword();
			if(isValid(password)) {
				System.out.println("Senha validada!");
			}else {
				System.out.println("Senha invalida.");
			}
		}
	}
	
	public static boolean isValid(char[] pass) {
		
		boolean hasNumber = false;
		boolean hasSpecialDigit = false;
		boolean hasSpace = false;
		
		for(char ch : pass) {
			if(!Character.isAlphabetic(ch) && !Character.isDigit(ch) ){
				hasSpecialDigit = true;
			}
			if(Character.isDigit(ch)){
				hasNumber = true;
			}
			if(ch == ' '){
				hasSpace = true;
			}
		}
		return hasNumber && hasSpecialDigit && !hasSpace;
	}
}
