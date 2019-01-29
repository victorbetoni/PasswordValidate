import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class ValidadorDeSenha {
	
	public static boolean hasNumber = false;
	public static boolean hasSpecialDigit = false;
	public static boolean hasSpace = false;
	
	public static void main(String[] args) {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Enter a password:");
		JPasswordField pass = new JPasswordField(10);
		panel.add(label);
		panel.add(pass);
		String pword = "";
		String[] options = new String[] { "OK", "Cancel" };
		int option = JOptionPane.showOptionDialog(null, panel, "Password", JOptionPane.NO_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
		if (option == 0) {
			char[] password = pass.getPassword();
			for(int i = 0;i<password.length;i++) {
				pword += password[i];
			}if(pword.length() < 5 || pword.length() > 10) {
				System.out.println("Tamanho invalido. Tamanho minimo: 5. Tamanho maximo: 10");
				System.exit(0);
			}
			if(ValidadorDeSenha.isValid(pword)) {
				System.out.println("Senha validada!");
			}else {
				System.out.println("Senha invalida.");
			}
		}
	}
	
	public static boolean isValid(String pass) {
		boolean valid = false;
		
		Character[] chars = new Character[pass.length()];
		for(int i = 0; i<pass.length();i++) {
			chars[i] = pass.charAt(i);
		}
		
		for(int i = 0; i<chars.length; i++){
			if( !Character.isAlphabetic(chars[i]) && !Character.isDigit(chars[i]) ){
				hasSpecialDigit = true;

			}
			if(Character.isDigit(chars[i])){
				hasNumber = true;
			}
			if(chars[i] == ' '){
				hasSpace = true;
			}
		}
		if(hasNumber) {
			if(hasSpecialDigit) {
				if(!(hasSpace)) {
					valid = true;
				}else {
					System.out.println("Sua senha nao pode conter espaços.");
				}
			}else {
				System.out.println("Sua senha precisa conter ao menos um caractere especial.");
			}
		}else {
			System.out.println("Sua senha precisa conter ao menos um número.");
		}
		return valid;
	}
}
