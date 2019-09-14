/**
 *
 *
 * @author Elizaveta Makarova
 * @version 1.0
 * This is a game class
 */
import javax.swing.*;

import java.awt.*;
import java.awt.GridLayout; //imports GridLayout library
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.util.Pair;

import java.util.*;



public class ButtonGrid extends JFrame {

    JFrame frame = new JFrame();
    JPanel active = new JPanel();
    JButton[][] grid;
    private JTextArea note;
    int moves = 0;
    int fin = 0;
    int sizeM;



    ArrayList<Pair<Integer, Integer>> l = new ArrayList<Pair<Integer, Integer>>();

    /**
     * Constructor for objects of class ButtonGrid
     */

    public ButtonGrid(int size) {

        frame.setSize(1350, 800);

        frame.setLocationRelativeTo(null);

        frame.setLayout(new FlowLayout());



        note = new JTextArea("0,0 is poisoned!!");
        note.setEditable(false);
        sizeM=size;
        active.setLayout(new GridLayout(size, size)); //set layout
        grid = new JButton[size][size]; //allocate the size of grid
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                grid[x][y] = new JButton();

                grid[x][y].addActionListener(new Action());
                grid[x][y].setBackground(Color.gray);
                grid[x][y].setOpaque(true);
                active.add(grid[x][y]); //adds button to grid
            }
        }

        fillIt(size);
        Random myRand=new Random();


        int num = 1 + myRand.nextInt(140);
        if (num%2==1 && moves==0 ){
            makeMove();
        }


        frame.add(note);
        frame.add(active);



        frame.setVisible(true);




    }
    /**
     * Computer make move
     */

    public void makeMove(){

        Random random=new Random();
        int r = random.nextInt(grid.length);
        int c = random.nextInt(grid.length);

        while (grid[c][r].getText().equals("") || (c==0 && r==0)) {
            r = random.nextInt(grid.length);
            c = random.nextInt(grid.length);
        }
        if ((c==1 && r==0) || (c==0 && r==1)){
            fin-=1;
            if (fin<0){
                fin=0;
            }
            if (fin==2){
                JOptionPane.showMessageDialog(null,"I lost");
                playAgain();}

        }
        JOptionPane.showMessageDialog(null,"My move:"+c+","+r);


        deleteItems(c,r);



    }


    public class Action implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String i = e.getActionCommand();

            int col1 = Integer.parseInt(i.substring(1, 2) );
            int row1 = Integer.parseInt(i.substring(3, 4) );


            deleteItems(col1,row1);
            makeMove();


        }

    }
    /**
     * Delete selected and check if lost
     */
    public void deleteItems(int col1, int row1) {
        if (col1 >= 0 || row1 >=  0) {


            for (int col = 0; col < grid.length; col++) {
                for (int row = 0; row < grid.length; row++) {
                    if (col >= row1 && row >= col1) {
                        grid[row][col].setText("");
                        grid[row][col].setEnabled( false );
                        moves+=1;
                    }


                }
            }


        }
        if ((col1==1 && row1==0) || (col1==0 && row1==1)){
            fin+=1;
            if (fin==2){
            JOptionPane.showMessageDialog(null,"I lost");
                playAgain();

            }

        }
        if  (col1== 0 && row1 == 0){
            JOptionPane.showMessageDialog(null,"You lost");
            playAgain();

        }

    }
    /**
     * Ask to play again
     */
    public void playAgain(){

        if (JOptionPane.showConfirmDialog(null, "Do you want to play again?", "WARNING",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            fin=0;
            moves=0;

            fillIt(sizeM);


        } else {
            System.exit(0);
        }
    }
    /**
     * Fills the grid
     */
   public void fillIt(int size){
       ImageIcon photo = new ImageIcon(this.getClass().getResource("choco.png"));
       for (int y = 0; y < size; y++) {
           for (int x = 0; x < size; x++) {
               grid[x][y].setText("(" + x + "," + y + ")"); //creates new button
               grid[x][y].setIcon(photo);
               grid[x][y].setEnabled( true );
               grid[x][y].setPreferredSize( new Dimension(50, 60));

           }
       }




   }


    }

