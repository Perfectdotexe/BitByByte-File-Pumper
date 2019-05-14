      // File pumper
      //*Perfect.exe
      //*Austin Tapia
      //*https://github.com/Perfectdotexe
      //*Website: https://ewhitehat.com/
      //*Cybersecurity student
      
// Important Java utilities necessary for program to function.
import java.util.Scanner; // A simple text scanner which can parse primitive types and strings using regular expressions.
import java.io.OutputStream; // This abstract class is the superclass of all classes representing an output stream of bytes. An output stream accepts output bytes and sends them to some sink. 
import javax.swing.*; // Open entire javax.swing library for the GUI.
import java.awt.Font; // The Font class represents fonts, which are used to render text in a visible way.
import java.awt.Color; // The Color class is used to encapsulate colors in the default sRGB color space or colors in arbitrary color spaces identified by a ColorSpace.
import java.awt.BorderLayout; // A border layout lays out a container, arranging and resizing its components to fit in five regions: north, south, east, west, and center.
import java.awt.FlowLayout; // Flow layouts are typically used to arrange buttons in a panel. It arranges buttons horizontally until no more buttons fit on the same line.
import java.awt.event.*; // Opens entire java.awt.event library. Imported for MouseAdapter, MouseEvent, and ActionListener.
import java.awt.GridLayout; // The GridLayout class is a layout manager that lays out a container's components in a rectangular grid.
import java.awt.GridBagLayout; // The GridBagLayout class is a flexible layout manager that aligns components vertically, horizontally or along their baseline without requiring that the components be of the same size.
import java.awt.Component; // A component is an object having a graphical representation that can be displayed on the screen and that can interact with the user.
import java.awt.Dimension; // The Dimension class encapsulates the width and height of a component (in integer precision) in a single object.
import javax.swing.JRadioButton; // An implementation of a radio button -- an item that can be selected or deselected, and which displays its state to the user.

//Define object
public class filePumper // Class head
   {
      public static void main(String[] args) // Main method
         {
            
            Scanner keyboard = new Scanner(System.in); // Creates a Scanner object for keyboard input.
            
            // === *** Graphical User Interface *** ===
            JFrame mainWindow = new JFrame("BitByByte"); // Creates new window with the title "BitByByte"
            mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit the program on close of the frame.
            ImageIcon icon = new ImageIcon("faucet.jpg"); // Creates new ImageIcon object.
            mainWindow.setIconImage(icon.getImage()); // Sets icon from ImageIcon object value.
            mainWindow.setResizable(false); // Disables re-sizing.
            mainWindow.setLocationRelativeTo(null); // Center JFrame window.
            
            // *** Text Box ***
            JTextField textBox = new JTextField(" Input file directory here or click \"Choose file\"..."); // Creates new text box with "Choose a file.." as the default text.
            textBox.setBorder(javax.swing.BorderFactory.createEmptyBorder()); // Removes blue border around text box.
            textBox.setPreferredSize(new Dimension(500,25)); // Resizes text box, so they user can see the file directory.
            textBox.addMouseListener(new MouseAdapter() { // Adds listener to the mouse.
            @Override // Overrides parent class.
            public void mouseClicked(MouseEvent e) { // Declares mouse event "e" when mouse is clicked.
            textBox.setText(""); // Sets text value to blank.
               }
            });
            
            // *** File open button ***
            JPanel openPanel = new JPanel();
            openPanel.setLayout(new BorderLayout());
            
            JButton opnButt = new JButton("Open");
            opnButt.setBorderPainted(false); // Removes border paint.
            opnButt.setFocusPainted(false); // Removes blue focus ring around the button.
            opnButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
               JFileChooser openFile = new JFileChooser();
                  openFile.showOpenDialog(null);
               }
            });
            
            // *** Panel declarations ***
            JPanel texty = new JPanel(); // Creates new JPanel for grid
            
            JPanel butty = new JPanel(); // Creates new JPanel for grid
            
            JPanel bytePoints = new JPanel(); // Creates new JPanel for grid
            
            // *** RADIO BUTTONS ***
            JRadioButton kiloByte = new JRadioButton ("Kilobyte(s)");
            JRadioButton megaByte = new JRadioButton ("Megabyte(s)");
            JRadioButton gigaByte = new JRadioButton ("Gigabyte(s)");
            JRadioButton teraByte = new JRadioButton ("Terabyte(s)");

            JPanel radioList = new JPanel();
            radioList.add(kiloByte);
            radioList.add(megaByte);
            radioList.add(gigaByte);
            radioList.add(teraByte);
            
            // *** Graphical User Interface Buttons/Textbox ***
            JButton buttonPump = new JButton("Pump those hexidecimals baby! (Please check only one radio button)"); // Creates button.
            buttonPump.setBorderPainted(false); // Removes border paint.
            buttonPump.setFocusPainted(false); // Removes blue focus ring around the button.
            
            texty.add(textBox); // Adds panel to textBox.
            mainWindow.getContentPane().add(texty, BorderLayout.NORTH); // Attaches the texty JPanel mainwindow.
            
            butty.add(opnButt); // Adds opnButt to butty Panel.
            butty.add(buttonPump); // Adds buttonPump to butty Panel.
            mainWindow.getContentPane().add(butty, BorderLayout.SOUTH); // Attaches the butty JPanel mainwindow.
            
            mainWindow.getContentPane().add(radioList, BorderLayout.CENTER); // Attaches the butty JPanel mainwindow.
            
            mainWindow.pack(); // Sizes the frame so that all its contents are at or above their preferred sizes.
            
            // === *** GUI VISUAL SETTINGS *** ===
            mainWindow.setSize(600, 200); // Size of the window (Width by height)
            
            kiloByte.setBackground(Color.black); // Sets kiloByte radio background to black.
            kiloByte.setForeground(Color.white); // Sets kiloByte radio text to white.
            
            megaByte.setBackground(Color.black); // Sets megaByte radio background to black.
            megaByte.setForeground(Color.white); // Sets megaByte radio text to white.
            
            gigaByte.setBackground(Color.black); // Sets gigaByte radio background to black.
            gigaByte.setForeground(Color.white); // Sets gigaByte radio text to white.
            
            teraByte.setBackground(Color.black); // Sets teraByte radio background to black.
            teraByte.setForeground(Color.white); // Sets terabyte radio text to white.
            
            radioList.setBackground(Color.black); // Sets JPanel butty background to black.
            
            butty.setBackground(Color.black); // Sets JPanel butty background to black.
            
            buttonPump.setBackground(Color.gray); // Sets button background color to gray. (Contrasting colors)
            buttonPump.setForeground(Color.white); // Sets button text color to white. (Contrasting colors)
            
            opnButt.setBackground(Color.gray); // Sets button background color to gray. (Contrasting colors)
            opnButt.setForeground(Color.white); // Sets button text color to white. (Contrasting colors)
            
            texty.setBackground(Color.black); // Sets JPanel texty background to black.
            
            mainWindow.getContentPane().setBackground(Color.black); // Sets Jframe butty background to black.
            
            butty.requestFocusInWindow(); // Sets focus on button to avoid focus on textField, because it will include "Choose a file..." if user types without clicking the textField.
            
            mainWindow.setVisible(true); // Make the frame visisble on the screen via execution.
            
            textBox.setFont(new Font("Arial", Font.ITALIC, 15)); // Changes textBox font to Arial, Italic, and to size 15.
            buttonPump.setFont(new Font("Arial", Font.BOLD, 13)); // Changes buttonPump font to Arial, Bold, and to size 13.
         }
}
