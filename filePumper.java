      // File pumper
      //*Perfect.exe
      //*Austin Tapia
      //*https://github.com/Perfectdotexe
      //*Website: https://ewhitehat.com/
      //*Cybersecurity student
      
// Important Java utilities necessary for program to function.
import java.util.Scanner; // Open scanner library.
import java.io.OutputStream; // Open OutputStream libary to edit hexadecimal values.
import javax.swing.*; // Open entire javax.swing GUI library.
import java.awt.Color; // Imports Java Color for JFrame colors.
import java.awt.BorderLayout; // Imports Border Layout for buttons.
import java.awt.FlowLayout; // Imports Flow Layout for buttons.
import java.awt.event.*; // Imports ActionListener.

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
            
            // *** Text Box ***
            JTextField textBox = new JTextField("Choose a file...");
            textBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            textBox.setText("");
               }
            });
            
            // *** Graphical User Interface Buttons ***
            JButton buttonPump = new JButton("Pump those hexidecimals baby!"); // Creates button.
            JPanel panelPump = new JPanel(); // Creates Panel for buttonPump.
            panelPump.add(buttonPump, textBox); // Adds panels to buttonPump.
            mainWindow.getContentPane().add(panelPump); // Add panelPump to JFrame mainwindow.
            mainWindow.getContentPane().add(textBox); // Add textBox to JFrame mainwindow.
            mainWindow.pack(); // Sizes the frame so that all its contents are at or above their preferred sizes.
            
            // *** Layout ***
            panelPump.setLayout(new BorderLayout());
            panelPump.add(buttonPump,BorderLayout.SOUTH);
            
            // === *** GUI VISUAL SETTINGS *** ===
            panelPump.setBackground(Color.black);
            mainWindow.setSize(600, 200); // Size of the window (Width by height)
            mainWindow.setVisible(true); // Make the frame visisble on the screen via execution.
            
         }
}
