package gui;

import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;

public final class PanelFactory {
	/**
	 * @wbp.factory
	 * @wbp.factory.parameter.source comp lblAnswerlabel
	 */
	public static JPanel createJPanel(Component comp1, Component comp2, Component comp3) {
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(comp1, BorderLayout.SOUTH);
		panel.add(comp2, BorderLayout.NORTH);
		panel.add(comp3, BorderLayout.CENTER);
		return panel;
	}
}