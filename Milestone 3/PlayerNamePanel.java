import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.sun.prism.Image;

public class PlayerNamePanel extends JPanel implements ActionListener{
	private MainFrame mainFrame;
	
	private JLabel p1l;
	private JTextField p1t;
	private String player1name;
	
	private JLabel p2l;
	private JTextField p2t;
	private String player2name;
	
	private JButton start;
	
	
	public PlayerNamePanel(MainFrame mainFrame){
		this.mainFrame = mainFrame;
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(mainFrame.getWidth(),mainFrame.getHeight());
		setBackground(new Color(150,0,0));
		
		
		//		CREAT PLAYE NAME PANel
		this.setLayout(null);
		this.setVisible(true);		

		//	Creating First Player Fields
		p1l = new JLabel("Player 1: ");
		p1l.setBounds(50,50,80,25);
		this.add(p1l);
		p1t = new JTextField();
		p1t.setBounds(110,50,150,25);
		this.add(p1t);
		
		//	Creating Second Player Fields
		p2l = new JLabel("Player 2: ");
		p2l.setBounds(430,50,80,25);
		this.add(p2l);
		p2t = new JTextField();
		p2t.setBounds(490,50,150,25);
		this.add(p2t);
		
		//	Creating Start Button
		start = new JButton("Start >>"+this.getWidth());
		start.setBounds(280,100,150,50);
		start.addActionListener(this);
		this.add(start);

	}
	public MainFrame getMainFrame() {
		return mainFrame;
	}
	public JTextField getP1t() {
		return p1t;
	}
	public String getPlayer1name() {
		return player1name;
	}
	public JTextField getP2t() {
		return p2t;
	}
	public String getPlayer2name() {
		return player2name;
	}
	public JButton getStart() {
		return start;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()== start){
			if(p1t.getText().equals("")||p2t.getText().equals("")){
				JOptionPane.showMessageDialog(this, "Please enter name for Players");
			}
		}
		else{
			player1name = p1t.getText();	player2name = p2t.getText();
			mainFrame.switchToChampSelect(player1name, player2name);
		}
	}
}
