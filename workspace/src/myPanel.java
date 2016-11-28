import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class myPanel {
	private JPanel panel = new JPanel(new GridBagLayout()), panel2, panel3;
	private myQuery1Panel q1p;
	private GridBagConstraints gbc = new GridBagConstraints();
	private JComboBox queryCombo;

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
				String yearSelect = String.valueOf(q1p.yearCombo.getSelectedItem());
				// System.out.println(searchBy+" "+name_title+" "+yearSelect);
				int from, to;
				if (yearSelect.charAt(0) == 'S') {
					from = Integer.parseInt(q1p.sinceYearTextField.getText());
					to = 9999;
				} else {
					from = Integer.parseInt(q1p.fromTextField.getText());
					to = Integer.parseInt(q1p.toTextField.getText());
				}
				if (searchBy.charAt(0) == 'N') {
					if (q1p.sort.getSelectedCheckbox().toString().charAt(26) == '0') {
						Query1Handler q1 = new Query1Handler(name_title, 1, from, to);
						q1.doWork(true);
					}
					else{
						Query1Handler q1 = new Query1Handler(name_title, 2, from, to);
						q1.doWork(true);						
					}
				}
				if (searchBy.charAt(0) == 'T') {
					if (q1p.sort.getSelectedCheckbox().toString().charAt(26) == '0') {
						Query1Handler q1 = new Query1Handler(name_title, 1, from, to);
						q1.doWork(false);
					}
					else{
						Query1Handler q1 = new Query1Handler(name_title, 2, from, to);
						q1.doWork(false);						
					}

				}

			}
		});
	}

	public JPanel getPanel() {
		return panel;
	}
}
