import javax.swing.*;

public class sterictask {
    public static void main(String[] args) {

        String correctPassword = "12345"; // set your password

        JPasswordField pf = new JPasswordField();

        int option = JOptionPane.showConfirmDialog(
                null,
                pf,
                "Enter Password",
                JOptionPane.OK_CANCEL_OPTION
        );

        if (option == JOptionPane.OK_OPTION) {

            char[] input = pf.getPassword();
            String enteredPassword = new String(input);

            if (enteredPassword.equals(correctPassword)) {
                JOptionPane.showMessageDialog(null, "Access Granted ✅");
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect Password ❌");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Cancelled");
        }
    }
}