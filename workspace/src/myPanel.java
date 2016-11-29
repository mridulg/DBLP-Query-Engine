/**
 *
 * @author Mridul Gupta | Divyanshu Talwar
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class myPanel {
	private JPanel panel = new JPanel(new GridBagLayout()), panel2, panel3;
	private myQuery1Panel q1p;
	private GridBagConstraints gbc = new GridBagConstraints();
	private JComboBox queryCombo;
	public static JLabel statusBar =  new JLabel("Welcome!!");
	
	public myPanel() {
		panel.setOpaque(false);
		// gbc.insets= new Insets(20,20,20,20);
		q1p = new myQuery1Panel();
		panel2 = q1p.panel2;
		myQuery2Panel p3 = new myQuery2Panel();
		panel3 = p3.getPanel();
		final DefaultComboBoxModel<String> typeOfQuery = new DefaultComboBoxModel();
		typeOfQuery.addElement("Query");
		typeOfQuery.addElement("Query1");
		typeOfQuery.addElement("Query2");
		queryCombo = new JComboBox(typeOfQuery);
		queryCombo.setFont(new Font("Arial", Font.BOLD, 12));
		queryCombo.setSelectedIndex(0);
		queryCombo.setPreferredSize(new Dimension(100, 25));
//		queryCombo.setBackground(Color.cyan);
		gbc.gridx = 0;
		gbc.gridy = 0;
		// gbc.fill= GridBagConstraints.HORIZONTAL;
		panel.add(queryCombo, gbc);

		queryCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				Object temp = queryCombo.getSelectedIndex();
				if (temp.equals(1)) {
					panel2.setVisible(true);
					panel3.setVisible(false);
				} else if (temp.equals(2)) {
					panel2.setVisible(false);
					panel3.setVisible(true);
				} else {
					panel2.setVisible(false);
					panel3.setVisible(false);
				}
			}
		});
		workingOfButtons();

		gbc.gridx = 0;
		gbc.gridy = 1;
		// gbc.weighty=4;
		panel.add(panel2, gbc);
		panel.add(panel3, gbc);
		panel2.setVisible(false);
		panel3.setVisible(false);
	}

	public void workingOfButtons() {
		q1p.resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				q1p.toTextField.setText("");
				q1p.sinceYearTextField.setText("");
				q1p.nameTitleTextField.setText("");
				q1p.fromTextField.setText("");
			}
		});

		q1p.searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String searchBy = String.valueOf(q1p.searchByCombo.getSelectedItem());
				String name_title = q1p.nameTitleTextField.getText();
				if(name_title.equals("")){
					JOptionPane.showMessageDialog(null, "Please enter a valid name","Name field empty",JOptionPane.WARNING_MESSAGE);
				}
				String yearSelect = String.valueOf(q1p.yearCombo.getSelectedItem());
				// System.out.println(searchBy+" "+name_title+" "+yearSelect);
				int from=0, to=0;
				if (yearSelect.charAt(0) == 'S') {
//					if(q1p.sinceYearTextField.getText().equals("")){
//						JOptionPane.showMessageDialog(null, "Please enter a valid year","From field empty",JOptionPane.WARNING_MESSAGE);
//					}
					try{
						from = Integer.parseInt(q1p.sinceYearTextField.getText());
					}
					catch(NumberFormatException t){
						JOptionPane.showMessageDialog(null, "Please enter a valid 'from' year","Year not a Number",JOptionPane.WARNING_MESSAGE);
						from = 9999;
					}
					to = 9999;
				} else {
//					if(q1p.fromTextField.getText().equals("")){
//						JOptionPane.showMessageDialog(null, "Please enter a valid 'from' year","From field empty",JOptionPane.WARNING_MESSAGE);
//					}
					try{
						from = Integer.parseInt(q1p.fromTextField.getText());
					}
					catch(NumberFormatException t){
						JOptionPane.showMessageDialog(null, "Please enter a valid 'from' year","Year not a Number",JOptionPane.WARNING_MESSAGE);
						from = 9999;
					}
//					if(q1p.toTextField.getText().equals("")){
//						JOptionPane.showMessageDialog(null, "Please enter a valid 'from' year","From field empty",JOptionPane.WARNING_MESSAGE);
//					}
					try{
						to = Integer.parseInt(q1p.toTextField.getText());
					}
					catch(NumberFormatException t){
						JOptionPane.showMessageDialog(null, "Please enter a valid 'to' year","Year not a Number",JOptionPane.WARNING_MESSAGE);
						to = 9999;
					}
					finally{
						if(from > to){
							JOptionPane.showMessageDialog(null, "Please make sure that 'from' is less than 'to' ","From field greater than To empty",JOptionPane.WARNING_MESSAGE);

						}
					}
					
				}
				if (searchBy.charAt(0) == 'N') {
					if(q1p.sort.getSelectedCheckbox()==null){
						JOptionPane.showMessageDialog(null, "Please make sure that one of the radio buttons is checked ","Radio button not checked",JOptionPane.WARNING_MESSAGE);
					}
					else if (q1p.sort.getSelectedCheckbox().toString().charAt(26) == '0') {
						Query1Handler q1 = new Query1Handler(name_title, 1, from, to);
						q1.doWork(true);
						statusBarUpdate();
					}
					else {
						Query1Handler q1 = new Query1Handler(name_title, 2, from, to);
						q1.doWork(true);
						statusBarUpdate();
					}
				}
				if (searchBy.charAt(0) == 'T') {
					if(q1p.sort.getSelectedCheckbox().toString().equals("")){
						JOptionPane.showMessageDialog(null, "Please make sure that one of the radio buttons is checked ","Radio button not checked",JOptionPane.WARNING_MESSAGE);
					}
					else if (q1p.sort.getSelectedCheckbox().toString().charAt(26) == '0') {
						Query1Handler q1 = new Query1Handler(name_title, 1, from, to);
						q1.doWork(false);
						statusBarUpdate();
					}
					else{
						Query1Handler q1 = new Query1Handler(name_title, 2, from, to);
						q1.doWork(false);
						statusBarUpdate();
					}

				}

			}
		});
	}
	
	public static void statusBarUpdate(){
		if(Database.resultCount == 0){
//			System.out.println("i am here");
	        statusBar.setForeground(Color.RED);
	        statusBar.setText("No results to display!!");
		}
		else{
//			System.out.println("i am here");
	        statusBar.setForeground(Color.BLACK);
	        statusBar.setText("Result Count : " + Database.resultCount);
		}

	}

	public JPanel getPanel() {
		return panel;
	}
}
