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
	private JLabel messageLabel = null;
	private JPanel contentPane = null;
	private JButton startButton = null;
	private JTextPane questionPane = null;
	private InitPanel initP = null;
	
	public void setMessageLabel(String answer) {
		this.messageLabel.setText(answer);
	}
	
	public void setEnableOfStartButton(boolean what) {
		this.startButton.setEnabled(what);
	}
	
	public void setQuestionPane(String text) {
		this.questionPane.setText(text);
	}
	
	public GameFrame(ActionListener actionListener) { 
		
		this.messageLabel = new JLabel("answerLabel");
		messageLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		this.startButton = new JButton("Start");
		this.startButton.addActionListener(actionListener);
		
		this.questionPane = new JTextPane();
		this.questionPane.setEditable(false);
		this.questionPane.setFont(new Font("Tahoma", Font.PLAIN, 18));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 280);
		contentPane = PanelFactory.createJPanel(messageLabel,startButton,questionPane);
		initP = new InitPanel();
		initP.addButtonListener(this);
		setContentPane(initP);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		initP.saveVegs();
		getContentPane().setVisible(false);
		setContentPane(contentPane);
		getContentPane().repaint();
	}
	
	

}
