      // File pumper
      //*@Perfect.exe
      //*Austin Tapia
      //*https://github.com/Perfectdotexe
      //*Website: https://ewhitehat.com/
      //*Cybersecurity student
      
// Important Java utilities necessary for program to function.
import java.util.Scanner; // Open scanner library.
import java.io.OutputStream; // Open OutputStream libary to edit hexadecimal values.
import javax.swing.*; // Imports entire javax.swing GUI library.
import java.awt.Color; // Imports Java Color class for JFrame colors.

//Define object
public class filePumper extends JFrame // Class head
   {
      public static void main(String[] args) // Main method
         {

            Scanner keyboard = new Scanner(System.in); // Creates a Scanner object for keyboard input.
            
            // === *** Graphical User Interface *** ===
            JFrame mainWindow = new JFrame("BitByByte"); // Creates new window with the title "BitByByte"
            mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit the program on close of the frame.
            mainWindow.setLocationRelativeTo(null); // Center window
            ImageIcon img = new ImageIcon("faucet.jpg"); // Creates new ImageIcon object.
            mainWindow.setIconImage(img.getImage()); // Sets icon from ImageIcon object value.
            
            // *** Graphical User Interface Buttons ***
            JButton buttonPump = new JButton("Pump those hexidecimals baby!"); // Creates button.
            JPanel panelPump = new JPanel(); // Creates Panel for buttonPump.
            panelPump.add(buttonPump); // Adds panel to buttonPump.
            mainWindow.getContentPane().add(panelPump); // Add panelPump to JFrame mainwindow.
            mainWindow.pack(); // Sizes the frame so that all its contents are at or above their preferred sizes.
            
            // === *** GUI VISUAL SETTINGS *** ===
            mainWindow.setSize(600, 200); // Size of the window (Width by height)
            mainWindow.setVisible(true); // Make the frame visisble on the screen via execution.
            
         }
}