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

//Define object
public class filePumper // Class head

   {
      public static void main(String[] args) // Main method
         {

            Scanner keyboard = new Scanner(System.in); // Creates a Scanner object for keyboard input.
            
            // === *** Graphical User Interface *** ===
            JFrame mainWindow = new JFrame("BitByByte"); // Creates new window with the title "BitByByte"
            mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit the program on close of the frame.
            ImageIcon img = new ImageIcon("faucet.jpg"); // Creates new ImageIcon object.
            mainWindow.setIconImage(img.getImage()); // Sets icon from ImageIcon object value.
            mainWindow.setResizable(false); // Disables re-sizing.
            
            // *** Text Box ***
            JTextField textBox = new JTextField("Choose a file..."); // Creates new text box with "Choose a file.." as the default text.
            textBox.addMouseListener(new MouseAdapter() { // Adds listener to the mouse.
            @Override // Overrides parent class.
            public void mouseClicked(MouseEvent e) { // Declares mouse event "e" when mouse is clicked.
            textBox.setText(""); // Sets text value to blank.
               }
            });
            
            // *** Resizing ***
            JPanel texty = new JPanel(); // Creates new JPanel for grid
            texty.setPreferredSize(new Dimension(60, 40)); // Sets Jpanel to a certain dimensions (Width by height)
            JPanel butty = new JPanel(); // Creates new JPanel for grid
            butty.setPreferredSize(new Dimension(60, 40)); // Sets Jpanel to a certain dimensions (Width by height)
            
            // *** Layout ***
            
            // *** Graphical User Interface Buttons/Textbox ***
            JButton buttonPump = new JButton("Pump those hexidecimals baby!"); // Creates button.
            texty.add(textBox); // Adds panel to textBox.
            mainWindow.getContentPane().add(texty, BorderLayout.NORTH); // Attaches the texty JPanel mainwindow.
            butty.add(buttonPump); // Adds panel to buttonPump.
            mainWindow.getContentPane().add(butty, BorderLayout.SOUTH); // Attaches the butty JPanel mainwindow.
            
            butty.setBackground(Color.black); // Sets JPanel butty background to black.
            texty.setBackground(Color.black); // Sets JPanel texty background to black.
            mainWindow.setBackground(Color.black); // Sets JFrame mainWindow background to black.
            
            mainWindow.pack(); // Sizes the frame so that all its contents are at or above their preferred sizes.
            
            // === *** GUI VISUAL SETTINGS *** ===
            mainWindow.setSize(600, 200); // Size of the window (Width by height)
            mainWindow.setVisible(true); // Make the frame visisble on the screen via execution.
            textBox.setFont(new Font("Arial", Font.ITALIC, 10)); // Changes textBox font to Arial, Italic, and to size 10.
         }
}
