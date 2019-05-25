/*
Program: File pumper
Description: Increases the size of a file by adding null hexadecimal values (00) to the end depending on the amount the user wants in KB, MB, GB, or TB.
Last modified: 5/24/19
Alias: Perfect.exe
Name: Austin Tapia
Github: https://github.com/Perfectdotexe
Blog: https://ewhitehat.com/
*Cybersecurity student
*/

package filePumper;

//Important Java utilities necessary for program to function.
import javax.swing.*; // Open entire javax.swing library for the GUI.
import java.awt.Font; // The Font class represents fonts, which are used to render text in a visible way.
import java.awt.Color; // The Color class is used to encapsulate colors in the default sRGB color space or colors in arbitrary color spaces identified by a ColorSpace.
import java.awt.BorderLayout; // A border layout lays out a container, arranging and resizing its components to fit in five regions: north, south, east, west, and center.
import java.awt.event.*; // Opens entire java.awt.event library. Imported for MouseAdapter, MouseEvent, and ActionListener.
import java.awt.Dimension; // The Dimension class encapsulates the width and height of a component (in integer precision) in a single object.
import javax.swing.JRadioButton; // An implementation of a radio button -- an item that can be selected or deselected, and which displays its state to the user.
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.DataOutputStream;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.UIManager;

//Define object
public class filePumper // Class head
{
   public static void main(String[] args) throws IOException, FileNotFoundException // Main method
      {
         
         String currentUser = System.getProperty("user.name"); // Declares string currentUser with the initialization of the current Windows user.
        
         // === *** Graphical User Interface *** ===
         JFrame mainWindow = new JFrame("BitByByte"); // Creates new window with the title "BitByByte"
         mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit the program on close of the frame.
         ImageIcon iconFaucet = new ImageIcon("faucet.jpg"); // Creates new ImageIcon object.
         mainWindow.setIconImage(iconFaucet.getImage()); // Sets icon from ImageIcon object value.
         mainWindow.setResizable(false); // Disables re-sizing.
         mainWindow.setLocationRelativeTo(null); // Center JFrame window.
         
         // *** Text Box ***
         JTextField textBox = new JTextField("Input a valid file here or click \"Open File\"..."); // Creates new text box with "Choose a file.." as the default text.
         textBox.setHorizontalAlignment(JTextField.CENTER);
         textBox.setBorder(javax.swing.BorderFactory.createEmptyBorder()); // Removes blue border around text box.
         textBox.setPreferredSize(new Dimension(500,25)); // Resizes text box, so they user can see the file directory.
         textBox.addMouseListener(new MouseAdapter() { // Adds listener to the mouse.
         @Override // Overrides parent class.
         public void mouseClicked(MouseEvent e) { // Declares mouse event "e" when mouse is clicked.
         textBox.setText(""); // Sets text value to blank.
         textBox.setHorizontalAlignment(JTextField.LEFT);
            }
         });
         
         // *** Text box for value ***
         JSpinner valueBox = new JSpinner();
         valueBox.setPreferredSize(new Dimension(114,25));
         valueBox.setBorder(javax.swing.BorderFactory.createEmptyBorder());
         valueBox.setModel(new javax.swing.SpinnerNumberModel(1, 1, 999, 1)); // Initial = 1, Minimum= 1, Maximum = 999, and Size per step = 1.
         valueBox.addChangeListener(new ChangeListener() {
        	 @Override
        	 public void stateChanged(ChangeEvent e) {
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
	         UIManager.put("OptionPane.background", Color.black);
	         UIManager.put("Panel.background", Color.black);
	         UIManager.put("OptionPane.messageForeground", Color.white);
            JFileChooser openFile = new JFileChooser();
            openFile.setCurrentDirectory(new java.io.File("C:\\Users\\" + currentUser));
            openFile.setDialogTitle("Select a Valid File"); // Changes title of Open File
            openFile.setFileSelectionMode(JFileChooser.FILES_ONLY);
            if (openFile.showOpenDialog(opnButt) == JFileChooser.APPROVE_OPTION){
            textBox.setHorizontalAlignment(JTextField.LEFT);
            textBox.setText(openFile.getSelectedFile().getAbsolutePath());
             }
            }
         });
         
         
         // *** Panel declarations ***
         JPanel texty = new JPanel(); // Creates new JPanel for grid
         
         JPanel butty = new JPanel(); // Creates new JPanel for grid
         
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
         JButton buttonPump = new JButton("Pump those hexidecimals!"); // Creates button.
         buttonPump.setBorderPainted(false); // Removes border paint.
         buttonPump.setFocusPainted(false); // Removes blue focus ring around the button.
         buttonPump.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(java.awt.event.ActionEvent evt) {
            	 int valueUserMain = (Integer) valueBox.getValue();
            	 byte[] nullValue = new byte [1073741824];
            	 System.out.println(valueUserMain);
            	 System.out.println(nullValue);
              	 DataOutputStream dataOutputStream = null;
    			try {
    				dataOutputStream = new DataOutputStream(new FileOutputStream("C:\\Users\\Perfectdotexe\\Desktop\\grumpycat.jpg", true));
    			} catch (FileNotFoundException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
             	try {
    				dataOutputStream.write(nullValue);
    			} catch (IOException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
    			try {
    		         UIManager.put("OptionPane.background", Color.black);
    		         UIManager.put("Panel.background", Color.black);
    		         UIManager.put("OptionPane.messageForeground", Color.white);
    				JOptionPane.showMessageDialog(null, "File has been pumped", "Completed!", JOptionPane.PLAIN_MESSAGE);
    				dataOutputStream.close();
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
                 }
                 });
         
         JButton buttonInfo = new JButton("More information"); // Creates button.
         buttonInfo.setBorderPainted(false); // Removes border paint.
         buttonInfo.setFocusPainted(false); // Removes blue focus ring around the button.
         buttonInfo.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(java.awt.event.ActionEvent evt) {
		         UIManager.put("OptionPane.background", Color.black);
		         UIManager.put("Panel.background", Color.black);
		         UIManager.put("OptionPane.messageForeground", Color.white);
                 JOptionPane.showMessageDialog(null, "Data Measurement Chart*"
                 		+ "\n8 BITS = 1 BYTE" + "\n1000 BYTE = 1 KB" + "\n1000 KB = 1 MB" + "\n1000 MB = 1 GB" + "\n1000 GB = 1 TB"
                		 + "\nExample: Step increment of 1 input value = 1 KB" + "\n* Minimum: 1 and the Maximum: 999 for input value."
                 		+ "\nMade by: https://github.com/Perfectdotexe", "How to use BitByByte", JOptionPane.INFORMATION_MESSAGE);
             }
         });
         
         
         texty.add(textBox); // Adds textBox to panel.
         mainWindow.getContentPane().add(texty, BorderLayout.NORTH); // Attaches the texty JPanel mainwindow.
         
         butty.add(opnButt); // Adds opnButt to butty Panel.
         butty.add(buttonPump); // Adds buttonPump to butty Panel.
         butty.add(buttonInfo); // Adds buttonInfo to butty Panel.
         
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
         
         buttonInfo.setBackground(Color.gray); // Sets button background color to gray. (Contrasting colors)
         buttonInfo.setForeground(Color.white); // Sets button text color to white. (Contrasting colors)
         
         texty.setBackground(Color.black); // Sets JPanel texty background to black.
         
         mainWindow.getContentPane().setBackground(Color.black); // Sets Jframe butty background to black.
         
         butty.requestFocusInWindow(); // Sets focus on button to avoid focus on textField, because it will include "Choose a file..." if user types without clicking the textField.
         
         mainWindow.setVisible(true); // Make the frame visisble on the screen via execution.
        
         opnButt.setFont(new Font("Arial", Font.BOLD, 13)); // Changes opnButt font to Arial, Italic, and to size 15.
         buttonInfo.setFont(new Font("Arial", Font.BOLD, 13)); // Changes opnButt font to Arial, Italic, and to size 15.
         textBox.setFont(new Font("Arial", Font.ITALIC, 13)); // Changes textBox font to Arial, Italic, and to size 15.
         valueBox.setFont(new Font("Arial", Font.ITALIC, 13)); // Changes valueBox font to Arial, Italic, and to size 15.
         buttonPump.setFont(new Font("Arial", Font.BOLD, 13)); // Changes buttonPump font to Arial, Bold, and to size 13.
         
      }
   }
