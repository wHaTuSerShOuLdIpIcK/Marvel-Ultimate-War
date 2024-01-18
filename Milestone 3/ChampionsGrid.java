
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ChampionsGrid extends JPanel implements ActionListener{
	
	private JPanel p1;
	gui mainView;

	private JButton[][] buttons;
	
    public ChampionsGrid(gui mainView) {
//        p1.setSize(1000, 400);
        this.setLayout(new GridLayout( 5, 3));
//        p1.setBounds(660,93,500-330,400);
//        p1.setVisible(true);
        buttons = new JButton[5][3];
        
        for(int i=0; i<buttons.length;i++){
        	for(int j=0; j<3;j++){
            	buttons[i][j] = new JButton(i+","+j);
            	buttons[i][j].addActionListener(this);
            	this.add(buttons[i][j]);
            }
        }
    }

     

    public static void main(String args[]) {
    	
    }



	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
