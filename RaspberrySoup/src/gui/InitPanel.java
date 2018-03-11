package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import runtime.KeyToVegMap;

public class InitPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtSpace;
	private JTextField txtControl;
	private JTextField txtUp;
	private JTextField txtDown;
	private JTextField txtLeft;
	private JTextField txtRight;
	
	private JButton btnSalva = null;

	/**
	 * Create the panel.
	 */
	public InitPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{113, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 39, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel spaceLabel = new JLabel("SPACE");
		GridBagConstraints gbc_spaceLabel = new GridBagConstraints();
		gbc_spaceLabel.insets = new Insets(0, 0, 5, 5);
		gbc_spaceLabel.anchor = GridBagConstraints.EAST;
		gbc_spaceLabel.gridx = 0;
		gbc_spaceLabel.gridy = 0;
		add(spaceLabel, gbc_spaceLabel);
		
		txtSpace = new JTextField();
		txtSpace.setText("Peperone");
		GridBagConstraints gbc_txtPeperone = new GridBagConstraints();
		gbc_txtPeperone.insets = new Insets(0, 0, 5, 0);
		gbc_txtPeperone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPeperone.gridx = 1;
		gbc_txtPeperone.gridy = 0;
		add(txtSpace, gbc_txtPeperone);
		txtSpace.setColumns(10);
		
		JLabel ctrlLabel = new JLabel("CTRL");
		GridBagConstraints gbc_ctrlLabel = new GridBagConstraints();
		gbc_ctrlLabel.anchor = GridBagConstraints.EAST;
		gbc_ctrlLabel.insets = new Insets(0, 0, 5, 5);
		gbc_ctrlLabel.gridx = 0;
		gbc_ctrlLabel.gridy = 1;
		add(ctrlLabel, gbc_ctrlLabel);
		
		txtControl = new JTextField();
		txtControl.setText("Carota");
		txtControl.setColumns(10);
		GridBagConstraints gbc_txtCarota = new GridBagConstraints();
		gbc_txtCarota.insets = new Insets(0, 0, 5, 0);
		gbc_txtCarota.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCarota.gridx = 1;
		gbc_txtCarota.gridy = 1;
		add(txtControl, gbc_txtCarota);
		
		JLabel upLabel = new JLabel("UP");
		GridBagConstraints gbc_upLabel = new GridBagConstraints();
		gbc_upLabel.anchor = GridBagConstraints.EAST;
		gbc_upLabel.insets = new Insets(0, 0, 5, 5);
		gbc_upLabel.gridx = 0;
		gbc_upLabel.gridy = 2;
		add(upLabel, gbc_upLabel);
		
		txtUp = new JTextField();
		txtUp.setText("Scalogno");
		txtUp.setColumns(10);
		GridBagConstraints gbc_txtScalogno = new GridBagConstraints();
		gbc_txtScalogno.insets = new Insets(0, 0, 5, 0);
		gbc_txtScalogno.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtScalogno.gridx = 1;
		gbc_txtScalogno.gridy = 2;
		add(txtUp, gbc_txtScalogno);
		
		JLabel downLabel = new JLabel("DOWN");
		GridBagConstraints gbc_downLabel = new GridBagConstraints();
		gbc_downLabel.anchor = GridBagConstraints.EAST;
		gbc_downLabel.insets = new Insets(0, 0, 5, 5);
		gbc_downLabel.gridx = 0;
		gbc_downLabel.gridy = 3;
		add(downLabel, gbc_downLabel);
		
		txtDown = new JTextField();
		txtDown.setText("Finocchio");
		txtDown.setColumns(10);
		GridBagConstraints gbc_txtFinocchio = new GridBagConstraints();
		gbc_txtFinocchio.insets = new Insets(0, 0, 5, 0);
		gbc_txtFinocchio.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFinocchio.gridx = 1;
		gbc_txtFinocchio.gridy = 3;
		add(txtDown, gbc_txtFinocchio);
		
		JLabel leftLabel = new JLabel("LEFT");
		GridBagConstraints gbc_leftLabel = new GridBagConstraints();
		gbc_leftLabel.anchor = GridBagConstraints.EAST;
		gbc_leftLabel.insets = new Insets(0, 0, 5, 5);
		gbc_leftLabel.gridx = 0;
		gbc_leftLabel.gridy = 4;
		add(leftLabel, gbc_leftLabel);
		
		txtLeft = new JTextField();
		txtLeft.setText("Broccolo");
		txtLeft.setColumns(10);
		GridBagConstraints gbc_txtBroccolo = new GridBagConstraints();
		gbc_txtBroccolo.insets = new Insets(0, 0, 5, 0);
		gbc_txtBroccolo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBroccolo.gridx = 1;
		gbc_txtBroccolo.gridy = 4;
		add(txtLeft, gbc_txtBroccolo);
		
		JLabel rightLabel = new JLabel("RIGHT");
		GridBagConstraints gbc_rightLabel = new GridBagConstraints();
		gbc_rightLabel.anchor = GridBagConstraints.EAST;
		gbc_rightLabel.insets = new Insets(0, 0, 5, 5);
		gbc_rightLabel.gridx = 0;
		gbc_rightLabel.gridy = 5;
		add(rightLabel, gbc_rightLabel);
		
		txtRight = new JTextField();
		txtRight.setText("Patata");
		txtRight.setColumns(10);
		GridBagConstraints gbc_txtPatata = new GridBagConstraints();
		gbc_txtPatata.insets = new Insets(0, 0, 5, 0);
		gbc_txtPatata.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPatata.gridx = 1;
		gbc_txtPatata.gridy = 5;
		add(txtRight, gbc_txtPatata);
		
		JLabel lblPremiInvioPer = new JLabel("Assegna ad ogni tasto un ortaggio.");
		GridBagConstraints gbc_lblPremiInvioPer = new GridBagConstraints();
		gbc_lblPremiInvioPer.insets = new Insets(0, 0, 5, 0);
		gbc_lblPremiInvioPer.gridx = 1;
		gbc_lblPremiInvioPer.gridy = 6;
		add(lblPremiInvioPer, gbc_lblPremiInvioPer);
		
		btnSalva = new JButton("SALVA");
		GridBagConstraints gbc_btnSalva = new GridBagConstraints();
		gbc_btnSalva.gridx = 1;
		gbc_btnSalva.gridy = 7;
		add(btnSalva, gbc_btnSalva);

	}
	
	public void addButtonListener(ActionListener listener) {
		btnSalva.addActionListener(listener);
	}

	public void saveVegs() {
		KeyToVegMap.setSpace(txtSpace.getText());
		KeyToVegMap.setControl(txtControl.getText());
		KeyToVegMap.setUp(txtUp.getText());
		KeyToVegMap.setDown(txtDown.getText());
		KeyToVegMap.setLeft(txtLeft.getText());
		KeyToVegMap.setRight(txtRight.getText());
	}

}
