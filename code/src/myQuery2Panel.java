/**
 * Query 2 = Give number of publications of an author
 * GUI Panel
 * @author Mridul Gupta | Divyanshu Talwar
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class myQuery2Panel
{
    private JButton resetButton; /**< Button to Reset */
    private JButton searchButton; /**< Button to Start search */
    private JPanel panel3=new JPanel(new GridBagLayout()); /**< New GridBag layout for Query2 Panel */
    private GridBagConstraints panel3gbc= new GridBagConstraints(); /**< New GridBag Constraints */ 
    private JTextField field= new JTextField(); /**< JTextField for "Threshold" of Publications */ 
    private JLabel text= new JLabel("Threshold"); /**< JLabel for "Threshold" of Publications */ 
    
    /**
	 * Constructor. Setting up GUI. Preparing buttons
	 */
    public myQuery2Panel()
    {
        panel3gbc.insets= new Insets(10,10,10,10);
        prepareGui();
//        colorize();
        buttonWorking();
    }

//    private void colorize()
//    {
//        text.setForeground(Color.cyan);
//        text.setBackground(Color.gray);
//        resetButton.setBackground(Color.cyan);
//        searchButton.setBackground(Color.cyan);
//        panel3.setBackground(Color.gray);
//    }

    /**
	 * Preparing buttons and texts and shizz
	 */
    public void prepareGui()
    {
       
        panel3gbc.gridx=0;
        panel3gbc.gridy=0;
        text.setPreferredSize(new Dimension(100,25));
        text.setFont(new Font("Arial", Font.BOLD, 15));
        panel3.add(text,panel3gbc);
        
        panel3gbc.gridx=0;
        panel3gbc.gridy=1;
        panel3gbc.fill= GridBagConstraints.HORIZONTAL;
        field.setFont(new Font("Arial", Font.BOLD, 12));
        panel3.add(field,panel3gbc);
//        JLabel l1=new JLabel("      ");
//        JLabel l2=new JLabel("      ");
//        panel3gbc.gridy=2;
//        panel3.add(l1,panel3gbc);
//        panel3gbc.gridy=3;
//        panel3.add(l2,panel3gbc);
        resetButton=new JButton("Reset");
//        resetButton.setBackground(Color.gray);
        resetButton.setFont(new Font("Arial", Font.BOLD, 12));
        resetButton.setPreferredSize(new Dimension(100,25));
        searchButton=new JButton("Search");
//        searchButton.setBackground(Color.gray);
		searchButton.setFont(new Font("Arial", Font.BOLD, 12));
        searchButton.setPreferredSize(new Dimension(100,25));
        panel3gbc.gridx=0;
        panel3gbc.gridy=4;
        panel3.add(searchButton,panel3gbc);
        panel3gbc.gridx=1;
        panel3gbc.gridy=4;
        panel3.add(resetButton,panel3gbc);
    }
    
    /**
     * Adds ActionListener to the Search and Reset buttons
     */
    public void buttonWorking()
    {
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText("");
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                Query2Handler q2= new Query2Handler(Integer.parseInt(field.getText()));
                try{
	                Query2Handler q2= new Query2Handler(Integer.parseInt(field.getText()));
	                myPanel.statusBarUpdate();
				}
				catch(NumberFormatException t){
					JOptionPane.showMessageDialog(null, "Please enter a valid threshold","Threshold not a Number",JOptionPane.WARNING_MESSAGE);
				}
            }
        });
    }
    
    /**
	 * Returns the Panel for Query 2
	 * 
	 * @return JPanel panel3
	 */
    public JPanel getPanel()
    {
        return panel3;
    }
}
