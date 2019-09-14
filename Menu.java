/**
 *
 *
 * @author Elizaveta Makarova
 * @version 1.0
 * This is class which visualize the main menu of the program
 */
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;



public class Menu extends JFrame
{

    private JButton small, medium, large, exit;
    private File myFile;
    private JPanel gLay,sLay;
    private JLabel logo;
    private JTextArea note;

    /**
     * Constructor for objects of class Menu
     */
    public Menu() throws IOException
    {
        super("Menu");
        myFile = new File("data.txt");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 200);
        setLayout(new BoxLayout(getContentPane(),BoxLayout.X_AXIS));
        gLay = new JPanel();
        sLay = new JPanel();
        gLay.setLayout(new GridLayout(3,1));
        sLay.setLayout(new GridLayout(2,1));

        note = new JTextArea("Select the size of bar");
        note.setEditable(false);
        note.setSize(200, 120);

        small = new JButton("Small");
        small.addActionListener(new Action());

        medium = new JButton("Medium");
        medium.addActionListener(new Action());

        large = new JButton("Large");
        large.addActionListener(new Action());

        exit = new JButton("Exit");
        exit.addActionListener(new Action());

        ImageIcon img = new ImageIcon(this.getClass().getResource("chomp.jpg"));

        logo = new JLabel();
        logo.setIcon(img);
        logo.setPreferredSize( new Dimension(200, 80));




        gLay.add(small);
        gLay.add(medium);
        gLay.add(large);
        gLay.add(exit);
        sLay.add(logo);
        sLay.add(note);

        //add(logo);


        add(gLay);
        add(sLay);
        setResizable(false);



        setVisible(true);
    }

    public class Action implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==exit)
            {
                System.exit(0);
            }
            if(e.getSource()==small)
            {
                try {
                    ButtonGrid v= new ButtonGrid(6);



                }
                catch(Exception ex) {
                    JOptionPane.showMessageDialog(null,"Something is wrong");
                }

            }
            if(e.getSource()==medium)
            {
                try {
                    ButtonGrid v= new ButtonGrid(9);



                }
                catch(Exception ex) {
                    JOptionPane.showMessageDialog(null,"Something is wrong");
                }

            }
            if(e.getSource()==large)
            {
                try {
                    ButtonGrid v= new ButtonGrid(12);


                }
                catch(Exception ex) {
                    JOptionPane.showMessageDialog(null,"Something is wrong");
                }

            }
        }
    }
}
