/*
 * Initializes a JOptionPane and runs BCGuesser
 */

import javax.swing.JOptionPane;
public class Main {
    public static void main (String[] args)
    {
        BullsAndCows app = new BullsAndCows();
        app.createAppForm();

        app.setVisible(true);

    }
}
