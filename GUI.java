import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GUI extends JFrame {
    // private static final long serialVersionUID = 3688148253476601561L;

    private DecimalFormat df = new DecimalFormat("0.00");
    private JComboBox<String> pageType;
    private JPanel output;
    private JScrollPane outputScrollPane;
    private String currentPage;
    Container contentPane = this.getContentPane();

    public GUI() {
        super();
        currentPage = "GPA Calculator";
        loadPage(currentPage);
    }

    public void loadPage(String page){
        // clear frame
        contentPane.removeAll();

        // create top part
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(new Dimension(800, 600));
        this.setTitle("School Thing");
        this.pageType = new JComboBox<String>(new String[] { "GPA Calculator", "Final Grade Calculator" });
        
        contentPane.setLayout(new BorderLayout());
        
        contentPane.add(pageType, BorderLayout.NORTH);

        this.output = new JPanel();
        this.output.setLayout(new BoxLayout(this.output, BoxLayout.Y_AXIS));
        
        // add action listener to the drop down menu
        pageType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(pageType.getSelectedItem().toString() != currentPage){
                    currentPage = pageType.getSelectedItem().toString();
                    loadPage(currentPage);
                }
            }
        });
        
        // customize for each
        JPanel output = new JPanel();
        output.setLayout(new BoxLayout(output, BoxLayout.Y_AXIS));
        
        if(page == "GPA Calculator"){
            // Label for each grade
            JLabel aCredsText = new JLabel("\"A\" Credit Hours:");
            JLabel bCredsText = new JLabel("\"B\" Credit Hours:");
            JLabel cCredsText = new JLabel("\"C\" Credit Hours:");
            JLabel dCredsText = new JLabel("\"D\" Credit Hours:");
            JLabel fCredsText = new JLabel("\"F\" Credit Hours:");

            // Text boxes for each grade
            JTextField aCredsTF = new JTextField();
            JTextField bCredsTF = new JTextField();
            JTextField cCredsTF = new JTextField();
            JTextField dCredsTF = new JTextField();
            JTextField fCredsTF = new JTextField();

            // Calculate button
            JButton calculateButton = new JButton("Calculate");
            
            calculateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String messageString = "";
                    int aCred = aCredsTF.getText().equals("") ? 0 : Integer.parseInt(aCredsTF.getText());
                    int bCred = bCredsTF.getText().equals("") ? 0 : Integer.parseInt(bCredsTF.getText()); 
                    int cCred = cCredsTF.getText().equals("") ? 0 : Integer.parseInt(cCredsTF.getText()); 
                    int dCred = dCredsTF.getText().equals("") ? 0 : Integer.parseInt(dCredsTF.getText()); 
                    int fCred = fCredsTF.getText().equals("") ? 0 : Integer.parseInt(fCredsTF.getText()); 
                    
                    int totalCreds = aCred+bCred+cCred+dCred+fCred;
                    if(totalCreds > 0 ){
                        float GPA = GradeManager.calculateGPA(aCred,bCred,cCred,dCred,fCred);
                        messageString = "Your GPA is " + df.format(GPA);
                    }
                    else{
                        messageString = "Please enter at least 1 credit hour.";
                    }
                    // pop up
                    JOptionPane.showMessageDialog(null, messageString);
                }
            });
            
            aCredsText.setSize(120, 40);
            aCredsText.setLocation(55, 110);
            bCredsText.setSize(120, 40);
            bCredsText.setLocation(205, 110);
            cCredsText.setSize(120, 40);
            cCredsText.setLocation(355, 110);
            dCredsText.setSize(120, 40);
            dCredsText.setLocation(505, 110);
            fCredsText.setSize(120, 40);
            fCredsText.setLocation(655, 110);
            
            aCredsTF.setSize(120, 40);
            aCredsTF.setLocation(50, 150);
            bCredsTF.setSize(120, 40);
            bCredsTF.setLocation(200, 150);
            cCredsTF.setSize(120, 40);
            cCredsTF.setLocation(350, 150);
            dCredsTF.setSize(120, 40);
            dCredsTF.setLocation(500, 150);
            fCredsTF.setSize(120, 40);
            fCredsTF.setLocation(650, 150);
            
            calculateButton.setSize(120, 50);
            calculateButton.setLocation(350, 200);
            
            contentPane.add(aCredsText);
            contentPane.add(bCredsText);
            contentPane.add(cCredsText);
            contentPane.add(dCredsText);
            contentPane.add(fCredsText);
            
            contentPane.add(aCredsTF);
            contentPane.add(bCredsTF);
            contentPane.add(cCredsTF);
            contentPane.add(dCredsTF);
            contentPane.add(fCredsTF);

            contentPane.add(calculateButton);

        }
        else if(page == "Final Grade Calculator"){
            JLabel currentText = new JLabel("Current Grade (%):");
            JLabel goalText = new JLabel("Wanted Grade (%):");
            JLabel finalWeightText = new JLabel("Final Weight (%):");

            JTextField currentTF = new JTextField();
            JTextField goalTF = new JTextField();
            JTextField finalWeightTF = new JTextField();

            // Calculate button
            JButton calculateButton = new JButton("Calculate");
            
            calculateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String messageString = "";
                    if(currentTF.getText().equals("") || goalTF.getText().equals("") || finalWeightTF.getText().equals("")){
                        messageString = "Please fill in all of the boxes.";
                    }
                    else{
                        float required = GradeManager.calculateRequired(Float.parseFloat(currentTF.getText()), Float.parseFloat(goalTF.getText()), Float.parseFloat(finalWeightTF.getText()));
                        messageString = "You need a " + df.format(required) + "% to get a " + Float.parseFloat(goalTF.getText());
                    }     
                    // pop up
                    JOptionPane.showMessageDialog(null, messageString);
                }
            });
            
            
            currentText.setSize(120, 40);
            currentText.setLocation(75, 110);
            goalText.setSize(120, 40);
            goalText.setLocation(275, 110);
            currentTF.setSize(120, 40);
            finalWeightText.setLocation(475, 110);
            finalWeightText.setSize(120, 40);
            
            currentTF.setSize(120, 40);
            currentTF.setLocation(75, 150);
            goalTF.setSize(120, 40);
            goalTF.setLocation(275, 150);
            finalWeightTF.setSize(120, 40);
            finalWeightTF.setLocation(475, 150);
            
            calculateButton.setSize(120, 50);
            calculateButton.setLocation(275, 200);
            
            contentPane.add(currentText);
            contentPane.add(goalText);
            contentPane.add(finalWeightText);
            
            contentPane.add(currentTF);
            contentPane.add(goalTF);
            contentPane.add(finalWeightTF);

            contentPane.add(calculateButton);

        }
        contentPane.add(output, BorderLayout.CENTER);
        
        // add changes to frame
        contentPane.revalidate();
        contentPane.repaint();
        pageType.setSelectedItem(currentPage);
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        GUI frame = new GUI();
        frame.validate();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
