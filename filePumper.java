/*
Program: File pumper
Description: Increases the size of a file by adding null hexadecimal values (00) to the end depending on the amount the user wants in KB, MB, GB, or TB.
Last modified: 5/14/19
Alias: Perfect.exe
Name: Austin Tapia
Github: https://github.com/Perfectdotexe
Blog: https://ewhitehat.com/
*Cybersecurity student
*/

package filePumper;

//Important Java utilities necessary for program to function.
import java.util.Scanner; // A simple text scanner which can parse primitive types and strings using regular expressions.
import java.io.OutputStream; // This abstract class is the superclass of all classes representing an output stream of bytes. An output stream accepts output bytes and sends them to some sink. 
import java.io.FileOutputStream;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.awt.*;

//Define object
public class filePumper // Class head
{
   public static void main(String[] args) // Main method
      {
         
         String currentUser = System.getProperty("user.name"); // Declares string currentUser with the initialization of the current Windows user.
         byte[] nullHex = {00};
        
         // === *** Graphical User Interface *** ===
         JFrame mainWindow = new JFrame("BitByByte"); // Creates new window with the title "BitByByte"
         mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit the program on close of the frame.
         ImageIcon icon = new ImageIcon("faucet.jpg"); // Creates new ImageIcon object.
         mainWindow.setIconImage(icon.getImage()); // Sets icon from ImageIcon object value.
         mainWindow.setResizable(false); // Disables re-sizing.
         mainWindow.setLocationRelativeTo(null); // Center JFrame window.

         // *** Text Box ***
         JTextField textBox = new JTextField(" Input file directory here or click \"Open File\"... (Note: 1000KB = 1MB and so forth)"); // Creates new text box with "Choose a file.." as the default text.
         textBox.setBorder(javax.swing.BorderFactory.createEmptyBorder()); // Removes blue border around text box.
         textBox.setPreferredSize(new Dimension(500,25)); // Resizes text box, so they user can see the file directory.
         textBox.addMouseListener(new MouseAdapter() { // Adds listener to the mouse.
         @Override // Overrides parent class.
         public void mouseClicked(MouseEvent e) { // Declares mouse event "e" when mouse is clicked.
         textBox.setText(""); // Sets text value to blank.
            }
         });
         
         // *** Text box for value ***
         JTextField valueBox = new JTextField("Value increment");
         valueBox.setHorizontalAlignment(JTextField.CENTER);
         valueBox.setBorder(javax.swing.BorderFactory.createEmptyBorder());
         valueBox.setPreferredSize(new Dimension(100,25));
         valueBox.addMouseListener(new MouseAdapter() {
             @Override
             public void mouseClicked(MouseEvent e) {
             valueBox.setText("");
                }
             });
         
         // *** File open button ***
         JPanel openPanel = new JPanel();
         openPanel.setLayout(new BorderLayout());
         
         JButton opnButt = new JButton("Open File");
         opnButt.setBorderPainted(false); // Removes border paint.
         opnButt.setFocusPainted(false); // Removes blue focus ring around the button.
         opnButt.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            JFileChooser openFile = new JFileChooser();
            openFile.setCurrentDirectory(new java.io.File("C:\\Users\\" + currentUser));
            openFile.setDialogTitle("Set a Valid File Pathway"); // Changes title of Open File
            openFile.setFileSelectionMode(JFileChooser.FILES_ONLY);
            if (openFile.showOpenDialog(opnButt) == JFileChooser.APPROVE_OPTION){
            textBox.setText(openFile.getSelectedFile().getAbsolutePath());
             }
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

         ButtonGroup groupButton = new ButtonGroup(); // Groups radio buttons which allows only one selection.
         groupButton.add(kiloByte);
         groupButton.add(megaByte);
         groupButton.add(gigaByte);
         groupButton.add(teraByte);
         
         JPanel radioList = new JPanel(); // Creates JPanel for GUI.
         radioList.add(valueBox);
         radioList.add(kiloByte);
         radioList.add(megaByte);
         radioList.add(gigaByte);
         radioList.add(teraByte);
         
         // *** Graphical User Interface Buttons/Textbox ***
         JButton buttonPump = new JButton("Pump those hexidecimals baby!"); // Creates button.
         buttonPump.setBorderPainted(false); // Removes border paint.
         buttonPump.setFocusPainted(false); // Removes blue focus ring around the button.
         
         texty.add(textBox); // Adds textBox to panel.
         mainWindow.getContentPane().add(texty, BorderLayout.NORTH); // Attaches the texty JPanel mainwindow.
         
         butty.add(opnButt); // Adds opnButt to butty Panel.
         butty.add(buttonPump); // Adds buttonPump to butty Panel.
         
         mainWindow.getContentPane().add(butty, BorderLayout.SOUTH); // Attaches the butty JPanel mainwindow.
         
         mainWindow.getContentPane().add(radioList, BorderLayout.CENTER); // Attaches the butty JPanel mainwindow.
         
         mainWindow.pack(); // Sizes the frame so that all its contents are at or above their preferred sizes.
         
         // === *** GUI VISUAL SETTINGS *** ===
         mainWindow.setSize(600, 150); // Size of the window (Width by height)
         
         kiloByte.setBackground(Color.black); // Sets kiloByte radio background to black.
         kiloByte.setForeground(Color.white); // Sets kiloByte radio text to white.
         
         megaByte.setBackground(Color.black); // Sets megaByte radio background to black.
         megaByte.setForeground(Color.white); // Sets megaByte radio text to white.
         
         gigaByte.setBackground(Color.black); // Sets gigaByte radio background to black.
         gigaByte.setForeground(Color.white); // Sets gigaByte radio text to white.
         
         teraByte.setBackground(Color.black); // Sets teraByte radio background to black.
         teraByte.setForeground(Color.white); // Sets terabyte radio text to white.
         
         radioList.setBackground(Color.black); // Sets JPanel radioList background to black.
         
         butty.setBackground(Color.black); // Sets JPanel butty background to black.
         
         buttonPump.setBackground(Color.gray); // Sets button background color to gray. (Contrasting colors)
         buttonPump.setForeground(Color.white); // Sets button text color to white. (Contrasting colors)
         
         opnButt.setBackground(Color.gray); // Sets button background color to gray. (Contrasting colors)
         opnButt.setForeground(Color.white); // Sets button text color to white. (Contrasting colors)
         
         texty.setBackground(Color.black); // Sets JPanel texty background to black.
         
         mainWindow.getContentPane().setBackground(Color.black); // Sets Jframe butty background to black.
         
         butty.requestFocusInWindow(); // Sets focus on button to avoid focus on textField, because it will include "Choose a file..." if user types without clicking the textField.
         
         mainWindow.setVisible(true); // Make the frame visisble on the screen via execution.
         
         opnButt.setFont(new Font("Arial", Font.BOLD, 13)); // Changes opnButt font to Arial, Italic, and to size 15.
         textBox.setFont(new Font("Arial", Font.ITALIC, 13)); // Changes textBox font to Arial, Italic, and to size 15.
         valueBox.setFont(new Font("Arial", Font.ITALIC, 13)); // Changes valueBox font to Arial, Italic, and to size 15.
         buttonPump.setFont(new Font("Arial", Font.BOLD, 13)); // Changes buttonPump font to Arial, Bold, and to size 13.
         
      }
   }
