package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame  implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JLabel _messageLabel;
	private JPanel _contentPane;
	private JButton _startButton;
	private JTextPane _questionPane;
	private InitPanel _initPanel;
	
	public void setMessageLabel(String answer) {
		_messageLabel.setText(answer);
	}
	
	public void setEnableOfStartButton(boolean what) {
		_startButton.setEnabled(what);
	}
	
	public void setQuestionPane(String text) {
		_questionPane.setText(text);
	}
	
	public GameFrame(ActionListener actionListener) { 
		// message label
		_messageLabel = new JLabel("");
		_messageLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		// start button
		_startButton = new JButton("Start");
		_startButton.addActionListener(actionListener);
		// question pane
		_questionPane = new JTextPane();
		_questionPane.setEditable(false);
		_questionPane.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// make window
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 750, 280);
		_contentPane = PanelFactory.createJPanel(_messageLabel,_startButton,_questionPane);
		// make init panel
		_initPanel = new InitPanel();
		_initPanel.addButtonListener(this);
		setContentPane(_initPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		_initPanel.saveVegs();
		this.getContentPane().setVisible(false);
		this.setContentPane(_contentPane);
		this.getContentPane().repaint();
	}
	
	

}
