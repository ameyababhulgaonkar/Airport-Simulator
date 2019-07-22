import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JSeparator;

public class AirportSimulatorGUI implements ActionListener {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private int NF1=0,NF2=0,NF3=0,BT1=0,BT2=0,BT3=0,RT1=0,RT2=0,RT3=0;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTable table;
	public AirportSimulatorGUI() {
		initialize();
	}
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(200, 200, 600, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter number of planes/day at peak time for plane 1 : ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(24, 70, 363, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter boarding time (BT1) :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(24, 113, 197, 32);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblEnterRunwaytimert = new JLabel("Enter runwaytime (RT1) :");
		lblEnterRunwaytimert.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblEnterRunwaytimert.setBounds(332, 117, 183, 24);
		frame.getContentPane().add(lblEnterRunwaytimert);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBackground(UIManager.getColor("MenuItem.selectionBackground"));
		
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(208, 468, 113, 32);
		frame.getContentPane().add(btnNewButton);

		btnNewButton.addActionListener(this);
		
		textField = new JTextField();
		textField.setBounds(407, 76, 49, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(246, 119, 49, 24);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(525, 119, 49, 24);
		frame.getContentPane().add(textField_2);
		
		JLabel lblEnterNumberOf = new JLabel("Enter number of planes/day at peak time for plane 2 : ");
		lblEnterNumberOf.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblEnterNumberOf.setBounds(24, 201, 363, 32);
		frame.getContentPane().add(lblEnterNumberOf);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(407, 207, 49, 24);
		frame.getContentPane().add(textField_3);
		
		JLabel lblEnterBoardingTime = new JLabel("Enter boarding time (BT2) :");
		lblEnterBoardingTime.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblEnterBoardingTime.setBounds(24, 244, 197, 32);
		frame.getContentPane().add(lblEnterBoardingTime);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(246, 250, 49, 24);
		frame.getContentPane().add(textField_4);
		
		JLabel lblEnterRunwaytimert_1 = new JLabel("Enter runwaytime (RT2) :");
		lblEnterRunwaytimert_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblEnterRunwaytimert_1.setBounds(332, 248, 183, 24);
		frame.getContentPane().add(lblEnterRunwaytimert_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(525, 244, 49, 24);
		frame.getContentPane().add(textField_5);
		
		JLabel lblEnterNumberOf_1 = new JLabel("Enter number of planes/day at peak time for plane 3: ");
		lblEnterNumberOf_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblEnterNumberOf_1.setBounds(24, 336, 363, 32);
		frame.getContentPane().add(lblEnterNumberOf_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(407, 342, 49, 24);
		frame.getContentPane().add(textField_6);
		
		JLabel lblEnterBoardingTime_1 = new JLabel("Enter boarding time (BT3) :");
		lblEnterBoardingTime_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblEnterBoardingTime_1.setBounds(24, 379, 197, 32);
		frame.getContentPane().add(lblEnterBoardingTime_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(246, 385, 49, 24);
		frame.getContentPane().add(textField_7);
		
		JLabel lblEnterRunwaytimert_2 = new JLabel("Enter runwaytime (RT3) :");
		lblEnterRunwaytimert_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblEnterRunwaytimert_2.setBounds(332, 379, 183, 24);
		frame.getContentPane().add(lblEnterRunwaytimert_2);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(525, 385, 49, 24);
		frame.getContentPane().add(textField_8);
		
		table = new JTable();
		table.setBounds(206, 144, 1, 1);
		frame.getContentPane().add(table);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.LIGHT_GRAY);
		separator.setBounds(0, 168, 584, 1);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(0, 312, 584, 1);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBackground(Color.LIGHT_GRAY);
		separator_2.setBounds(0, 44, 584, 1);
		frame.getContentPane().add(separator_2);
		
		JLabel lblAirportSimulator = new JLabel("AIRPORT SIMULATOR");
		lblAirportSimulator.setBackground(UIManager.getColor("RadioButtonMenuItem.selectionBackground"));
		lblAirportSimulator.setForeground(Color.BLACK);
		lblAirportSimulator.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblAirportSimulator.setBounds(143, 11, 348, 24);
		frame.getContentPane().add(lblAirportSimulator);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int NF1=0,NF2=0,NF3=0,BT1=0,BT2=0,BT3=0,RT1=0,RT2=0,RT3=0;
		try {
				NF1=Integer.parseInt(textField.getText());
				BT1=Integer.parseInt(textField_1.getText());
				RT1=Integer.parseInt(textField_2.getText());
				NF2=Integer.parseInt(textField_3.getText());
				BT2=Integer.parseInt(textField_4.getText());
				RT2=Integer.parseInt(textField_5.getText());
				NF3=Integer.parseInt(textField_6.getText());
				BT3=Integer.parseInt(textField_7.getText());
				RT3=Integer.parseInt(textField_8.getText());
				if(NF1>0&&NF2>0&&NF3>0&&BT1>0&&BT2>0&&BT3>0&&RT1>0&&RT2>0&&RT3>0)
					;
				else
					throw new Exception("");			
			setValues(NF1,NF2,NF3,BT1,BT2,BT3,RT1,RT2,RT3);
			synchronized(AirportSimulatorGUI.this) 
			{
				this.notify();
			}
			frame.dispose();
		}
		catch(Exception e1)
		{
				JOptionPane.showMessageDialog(null, "Enter Valid Positive Integer");
		}	
	}
	public void setValues(int NF1,int NF2,int NF3,int BT1,int BT2,int BT3,int RT1,int RT2,int RT3) {
		this.NF1=NF1;
		this.NF2=NF2;
		this.NF3=NF3;
		this.BT1=BT1;
		this.BT2=BT2;
		this.BT3=BT3;
		this.RT1=RT1;
		this.RT2=RT2;
		this.RT3=RT3;
	}
	public int getNF1()
	{
		return NF1;
	}
	public int getNF2()
	{
		return NF2;
	}
	public int getNF3()
	{
		return NF3;
	}
	public int getBT1()
	{
		return BT1;
	}
	public int getBT2()
	{
		return BT2;
	}
	public int getBT3()
	{
		return BT3;
	}
	public int getRT1()
	{
		return RT1;
	}
	public int getRT2()
	{
		return RT2;
	}
	public int getRT3()
	{
		return RT3;
	}
}
