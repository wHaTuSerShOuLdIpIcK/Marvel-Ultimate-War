import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class BoardPanel extends JPanel implements ActionListener {
	private MainFrame mainView;
	private JButton[][] buttons;
	
	public BoardPanel(MainFrame mainView){
		this.mainView = mainView;
		
		this.setLayout(new GridLayout(5,5));
		buttons = new JButton[5][5];
		for (int i=0; i<buttons.length;i++){
			for (int j=0; j<buttons.length;j++){
				buttons[i][j] = new JButton(i+","+j);
				buttons[i][j].addActionListener(this);
				this.add(buttons[i][j]);
			}
		}
	}

}
