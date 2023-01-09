import javax.swing.*;
import java.awt.*;

public class windowManagement {
	listener listen;
	
	public JPanel createPanel(JPanel panel, int x, int y, int width, int height, Color col) {
		panel = new JPanel();
		panel.setBounds(x, y, width, height);
		panel.setBackground(col);
		panel.setLayout(null);
		return panel;
	}
	
	public JButton createButton(JButton button, String name, int x, int y, int width, int height, Color col) {
		button = new JButton(name);
		button.setBounds(x, y, width, height);
		button.setBackground(col);
		listen = new listener(button);
		return button;
	}
	
	public  JLabel createLabel(JLabel label, String str, Font font, int x, int y, int width, int height, Color col) {
		label = new JLabel(str);
		label.setFont(font);
		label.setForeground(col);
		label.setBounds(x, y, width, height);
		return label;
	}
	
	public JRadioButton createRB(JRadioButton button, String str, int x, int y, int width, int height) {
		button = new JRadioButton(str);
		button.setBounds(x, y, width, height);
		return button;
	}
	
	public JPanel createBorder(JPanel panel) {
		panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		return panel;
	}
	
	public JTabbedPane createTPane(JTabbedPane pane, int x, int y, int width, int height) {
		pane = new JTabbedPane();
		pane.setBounds(x, y, width, height);
		return pane;
	}
}