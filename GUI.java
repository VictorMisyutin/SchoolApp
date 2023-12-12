import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

/**
 * 
 * Display a book search.
 * 
 * @author Stephen Checkoway
 * @author Adam Eck
 * @version 2023-11-12
 *
 */
public class GUI extends JFrame {
    // private static final long serialVersionUID = 3688148253476601561L;

    private JComboBox<String> pageType;
    // private JTextField query;
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
        // cleare frame
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
        
        // this.outputScrollPane = new JScrollPane(this.output);
        // contentPane.add(this.outputScrollPane, BorderLayout.CENTER);

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
            // text boxes for each grade
            JTextField aCredsTF = new JTextField();
            JTextField bCredsTF = new JTextField();
            JTextField cCredsTF = new JTextField();
            JTextField dCredsTF = new JTextField();
            JTextField fCredsTF = new JTextField();

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
            
            contentPane.add(aCredsTF,BorderLayout.CENTER);
            contentPane.add(bCredsTF,BorderLayout.CENTER);
            contentPane.add(cCredsTF,BorderLayout.CENTER);
            contentPane.add(dCredsTF,BorderLayout.CENTER);
            contentPane.add(fCredsTF,BorderLayout.CENTER);

        }
        else if(page == "Final Grade Calculator"){
            
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
