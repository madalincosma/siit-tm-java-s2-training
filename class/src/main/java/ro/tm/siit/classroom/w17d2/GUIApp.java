package ro.tm.siit.classroom.w17d2;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * GUIApp class shows GUI creation with Swing technology.It creates an window
 * with a text field, a button and a label and handles clicking the button.
 * 
 * @author mco
 *
 */
public class GUIApp {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {

		JFrame window = new JFrame("Demo");
		window.setSize(600, 400);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		window.getContentPane().setLayout(new GridLayout(3, 1));

		JTextField field = new JTextField(" ");
		window.add(field);
		JButton button = new JButton("OK");
		window.add(button);
		JLabel label = new JLabel(" ");
		window.add(label);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText(field.getText()); // set label with same text

				field.setEnabled(false); // disable input field
				button.setEnabled(false); // disable button

			}
		});

		window.setVisible(true);

	}

}
