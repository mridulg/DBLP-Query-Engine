import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by skwow on 10/27/2016.
 */
public class myQuery3Panel
{
    private JButton resetButton,searchButton;
    private JPanel panel4 =new JPanel(new GridBagLayout());
    private GridBagConstraints panel4gbc = new GridBagConstraints();
    private JTextField ThrasholdField = new JTextField();
    private JLabel thresholdText = new JLabel("Till Year");
    private JTextField nameField = new JTextField();
    private JLabel nameText= new JLabel("Name");

    public myQuery3Panel()
    {
        panel4gbc.insets= new Insets(10,10,10,10);
        prepareGui();
        colorize();
        buttonWorking();
    }

    private void colorize()
    {
        thresholdText.setForeground(Color.cyan);
        thresholdText.setBackground(Color.gray);
        nameText.setForeground(Color.cyan);
        nameText.setBackground(Color.gray);
        resetButton.setBackground(Color.cyan);
        searchButton.setBackground(Color.cyan);
        panel4.setBackground(Color.gray);
    }


    public void prepareGui()
    {
        ThrasholdField.setPreferredSize(new Dimension(200,50));
        thresholdText.setPreferredSize(new Dimension(200,50));
        thresholdText.setFont(new Font("Serif", Font.BOLD, 30));
        ThrasholdField.setFont(new Font("Serif", Font.BOLD, 30));
        panel4gbc.gridx=0;
        panel4gbc.gridy=0;
        panel4.add(thresholdText, panel4gbc);
        panel4gbc.gridx=0;
        panel4gbc.gridy=1;
        panel4.add(ThrasholdField, panel4gbc);
        JLabel l1=new JLabel("      ");
        JLabel l2=new JLabel("      ");
        panel4gbc.gridy=2;
        panel4.add(l1, panel4gbc);
        panel4gbc.gridy=3;
        panel4.add(l2, panel4gbc);
        resetButton=new JButton("Reset");
        resetButton.setBackground(Color.gray);
        resetButton.setFont(new Font("Serif", Font.BOLD, 30));
        resetButton.setPreferredSize(new Dimension(200,50));
        searchButton=new JButton("Search");
        searchButton.setBackground(Color.gray);
        searchButton.setFont(new Font("Serif", Font.BOLD, 30));
        searchButton.setPreferredSize(new Dimension(200,50));
        panel4gbc.gridx=0;
        panel4gbc.gridy=4;
        panel4.add(searchButton, panel4gbc);
        panel4gbc.gridx=1;
        panel4gbc.gridy=4;
        panel4.add(resetButton, panel4gbc);
    }

    public void buttonWorking()
    {
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ThrasholdField.setText("");
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //query2Handler q2= new query2Handler(Integer.parseInt(ThrasholdField.getText()));
            }
        });
    }

    public JPanel getPanel()
    {
        return panel4;
    }
}