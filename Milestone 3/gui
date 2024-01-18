import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class gui extends JFrame implements ActionListener{
	private JButton button1;
	private JButton button2;
	
	JLabel label1;
	JLabel label2;	
	JTextField field;
	
	JFormattedTextField ffield;
	
	JTextArea area1;
	
	JRadioButton r1;
	boolean r1Toggled = false;
	JRadioButton r2;
	boolean r2Toggled = false;
	JRadioButton r3;
	boolean r3Toggled = false;
	
	ButtonGroup group1;
	
	JComboBox<String> c1;
	
	JList<String> list1;
	
	public gui(){
		this.setSize(1500,500);
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Marvel Ultimate War");
		
		button1 = new JButton("Next");
		button1.setBounds(200,400,100,30);
		button1.addActionListener(this);
		this.getContentPane().add(button1);
		
		button2 = new JButton("Start");
		button2.setBounds(400,400,100,30);
		button2.addActionListener(this);
		this.getContentPane().add(button2);
		
		label1 = new JLabel("Player name");
		label1.setBounds(80,93,90,20);
		label1.setFont(new Font("Arial",Font.BOLD,15));
		this.getContentPane().add(label1);
		
		field = new JTextField("Player Name");
		field.setBounds(180,90,190,30);
		field.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		field.addActionListener(this);
		this.getContentPane().add(field);
		
		ffield = new JFormattedTextField();
		
		area1 = new JTextArea();
		area1.setBounds(this.getWidth()-320,90,220,150);
		area1.setBackground(Color.GRAY);
		this.getContentPane().add(area1);
		
		r1 = new JRadioButton("The Leader");
		r1.setBounds(80,115,90,20);
		r1.addActionListener(this);
		this.getContentPane().add(r1);
		
		r2 = new JRadioButton("The 2nd Leader");
		r2.setBounds(70,135,150,20);
		r2.addActionListener(this);
		this.getContentPane().add(r2);
		
		r3 = new JRadioButton("The Leader");
		r3.setBounds(70,155,90,20);
		r3.setSelected(true);
		r3.addActionListener(this);
		this.getContentPane().add(r3);
		
		group1 = new ButtonGroup();
		group1.add(r1);	group1.add(r2);	group1.add(r3);
		
		String[] x = {"Select Champion","Cap","Loki","Thor","Hulk"};
		c1 = new JComboBox<String>(x);
		c1.setBounds(270,235,190,20);
		this.getContentPane().add(c1);
		
		String[] y = {"Ironman","Cap","Loki","Thor","Hulk"};
		list1 = new JList<String>(y);
		list1.setBounds(470,235,190,30);
		list1.setVisibleRowCount(2);
        JScrollPane scrollPane2 = new JScrollPane(list1);
        scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.getContentPane().add(list1);
		
       // 
      //  datumList.setPrototypeCellValue(new Datum("XXXXXXXXXXX", 200));
		
		this.validate();this.repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button1){
			if(field.getText().equals("")){
				JOptionPane.showMessageDialog(this,"Please, enter a valid name", "Error", JOptionPane.INFORMATION_MESSAGE);;
			}
			else if(!(r1.isSelected()||r2.isSelected()||r3.isSelected())){
				JOptionPane.showMessageDialog(this,"Please select leader","ERROR",JOptionPane.ERROR_MESSAGE);
			}
			else if(c1.getSelectedItem().equals("Select Champion")){
				JOptionPane.showMessageDialog(this, "Please select champion","ERROE",JOptionPane.ERROR_MESSAGE);
			}
			else if(list1.isSelectionEmpty()){
				JOptionPane.showMessageDialog(this, "Please select champion\nfrom both lists","ERROE",JOptionPane.ERROR_MESSAGE);
			}
			else{
				System.out.println("Successful operation");
			}
		}
		else if(e.getSource()==button2)
			System.out.println("Start");
		else if(e.getSource()==r1 && !r1Toggled){		
			System.out.println("yes leader");
			r1Toggled = !r1Toggled;
			}
		else{
			System.out.println("not leader");
			r1Toggled = !r1Toggled;
		}
		
	}
	public static void main (String[]ags){
		gui g1 = new gui();
	}
}
