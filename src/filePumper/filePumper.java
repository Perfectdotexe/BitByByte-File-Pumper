/*
Program: File pumper
Description: Increases the size of a file by adding null hexadecimal values (00) to the end depending on the amount the user wants in KB, MB, GB, or TB.
Last modified: 6/10/19
Alias: Perfect.exe
Name: Austin Tapia
Github: https://github.com/Perfectdotexe
Blog: https://ewhitehat.com/
*Cybersecurity student
*/

package filePumper; // Package for program.

//Important Java utilities necessary for program to function.
import javax.swing.*; // Open entire javax.swing library for the GUI.
import java.awt.Font; // The Font class represents fonts, which are used to render text in a visible way.
import java.awt.Color; // The Color class is used to encapsulate colors in the default sRGB color space or colors in arbitrary color spaces identified by a ColorSpace.
import java.awt.BorderLayout; // A border layout lays out a container, arranging and resizing its components to fit in five regions: north, south, east, west, and center.
import java.awt.event.*; // Opens entire java.awt.event library. Imported for MouseAdapter, MouseEvent, and ActionListener.
import java.awt.Dimension; // The Dimension class encapsulates the width and height of a component (in integer precision) in a single object.
import javax.swing.JRadioButton; // An implementation of a radio button -- an item that can be selected or deselected, and which displays its state to the user.
import java.io.FileNotFoundException; // This exception will be thrown by the FileInputStream, FileOutputStream, and RandomAccessFile constructors when a file with the specified pathname does not exist.
import java.io.IOException; // Signals that an I/O exception of some sort has occurred.
import java.io.RandomAccessFile; // Instances of this class support both reading and writing to a random access file.
import java.nio.channels.FileChannel; // A file channel is a SeekableByteChannel that is connected to a file. Writes bytes to file.
import javax.swing.event.ChangeEvent; // ChangeEvent is used to notify interested parties that state has changed in the event source. This is used for the valueBox.
import javax.swing.event.ChangeListener; // Defines an object which listens for ChangeEvents. This is used for the JSpinner.
import java.nio.ByteBuffer; // Byte buffers can be created either by allocation, which allocates space for the buffer's content, or by wrapping an existing byte array into a buffer.
import javax.swing.UIManager; // UIManager manages the current look and feel, the set of available look and feels, PropertyChangeListeners that are notified when the look and feel changes, look and feel defaults, and convenience methods for obtaining various default values.
import java.util.concurrent.atomic.AtomicInteger; // An integer value that may be updated atomically.

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
         JTextField textBox = new JTextField("Input a valid file pathway here or click \"Open File\"..."); // Creates new text box with "Choose a file.." as the default text.
         textBox.setHorizontalAlignment(JTextField.CENTER);
         textBox.setBorder(javax.swing.BorderFactory.createEmptyBorder()); // Removes blue border around text box.
         textBox.setPreferredSize(new Dimension(441,25)); // Resizes text box, so they user can see the file directory.
         textBox.addMouseListener(new MouseAdapter() { // Adds listener to the mouse.
         @Override // Overrides parent class.
         public void mouseClicked(MouseEvent e) { // Declares mouse event when mouse is clicked.
         textBox.setText(""); // Sets text value to blank.
         textBox.setHorizontalAlignment(JTextField.LEFT); // Sets text to left.
            }
         });

         // *** Text box for value ***
         JSpinner valueBox = new JSpinner();
         valueBox.setPreferredSize(new Dimension(168,25)); // Set sizing on text box.
         valueBox.setBorder(javax.swing.BorderFactory.createEmptyBorder()); // Removes border from text box.
         valueBox.setModel(new javax.swing.SpinnerNumberModel(1, 1, 999, 1)); // Default: Initial = 1, Minimum= 1, Maximum = 999, and Size per step = 1.
         valueBox.addChangeListener(new ChangeListener() { // Creates listener for new value.
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
            JFileChooser openFile = new JFileChooser();
            openFile.setCurrentDirectory(new java.io.File("C:\\Users\\" + currentUser)); // Sets default user directory to Windows user.
            openFile.setDialogTitle("Select a Valid File"); // Changes title of Open File
            openFile.setFileSelectionMode(JFileChooser.FILES_ONLY); // Takes files only.
            if (openFile.showOpenDialog(opnButt) == JFileChooser.APPROVE_OPTION){ // Checks to see if file.
            textBox.getText().replace("\t","\\"); // Adds extra / to existing / due to Java purposes.
            textBox.setHorizontalAlignment(JTextField.LEFT); // Sets text to left.
            textBox.setText(openFile.getSelectedFile().getAbsolutePath()); // Grabs full path to file.
            
             }
            }
         });

         // *** Panel declarations ***
         JPanel texty = new JPanel(); // Creates new JPanel for grid
         JPanel butty = new JPanel(); // Creates new JPanel for grid

         // *** RADIO BUTTONS ***
         int kiloValue = 1000; // 1 KB
         int megaValue = 1048576; // 1 MB
         int gigaValue =  1073741824; // 1 GB
         AtomicInteger x = new AtomicInteger(1000); // Place holder to avoid error default KB.

         JRadioButton kiloByte = new JRadioButton ("Kilobyte(s)");
         kiloByte.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
            	 valueBox.setModel(new javax.swing.SpinnerNumberModel(1, 1, 999, 1)); // Initial = 1, Minimum= 1, Maximum = 999, and Size per step = 1.
            	 x.set (kiloValue);
             }
         });

         JRadioButton megaByte = new JRadioButton ("Megabyte(s)");
         megaByte.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
            	 valueBox.setModel(new javax.swing.SpinnerNumberModel(1, 1, 999, 1)); // Initial = 1, Minimum= 1, Maximum = 999, and Size per step = 1.
            	 x.set (megaValue);
             }
         });

         JRadioButton gigaByte = new JRadioButton ("Gigabyte");
         gigaByte.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
            	 valueBox.setModel(new javax.swing.SpinnerNumberModel(1, 1, 1, 1)); // Initial = 1, Minimum= 1, Maximum = 1, and Size per step = 1.
            	 x.set (gigaValue);
             }
         });

         ButtonGroup groupButton = new ButtonGroup(); // Groups radio buttons which allows only one selection.
         groupButton.add(kiloByte);
         groupButton.add(megaByte);
         groupButton.add(gigaByte);

         JPanel radioList = new JPanel(); // Creates JPanel for GUI.
         radioList.add(valueBox);
         radioList.add(kiloByte);
         radioList.add(megaByte);
         radioList.add(gigaByte);

         // *** Button file pump GUI ***
         JButton buttonPump = new JButton("Pump those hexidecimals!"); // Creates button.
         buttonPump.setBorderPainted(false); // Removes border paint.
         buttonPump.setFocusPainted(false); // Removes blue focus ring around the button.
         
         // ** Actual program ***
         buttonPump.addActionListener(new ActionListener() {
             private RandomAccessFile randomAccessFile;
             	@Override
             	public void actionPerformed(java.awt.event.ActionEvent evt) {
            	 int valueUserMain = (Integer) valueBox.getValue(); // Grabs valueBox value.
            	 byte[] nullValue = new byte [1]; // Placeholder for length.
            	 FileChannel rwChannel = null;
            	 try {
			randomAccessFile = new RandomAccessFile(textBox.getText(), "rw");
			rwChannel = randomAccessFile.getChannel();
            	 	} catch (FileNotFoundException e3) { // File not found error.
        			JOptionPane.showMessageDialog(null, "File has not been found, closing with error.", "Error", JOptionPane.PLAIN_MESSAGE);
        			System.exit(0); // Exits program.
        			e3.printStackTrace();
			}
            	 	ByteBuffer writeRead = null;
            	 	try {
            randomAccessFile.seek(randomAccessFile.length());
			writeRead = rwChannel.map(FileChannel.MapMode.READ_WRITE, 0, nullValue.length * valueUserMain * x.get()); // Multiples for correct file size.
            	 	} catch (IOException e2) {
            	 	e2.printStackTrace();
            	 	}
            	 	for (int i = 0; i < valueUserMain; i++) // Creates a for loop based on the valueUserMain value.
            	 	{
            	    	writeRead.put(nullValue); // Writes data according to writeRead multiplication.
            	 	}
    			UIManager.put("OptionPane.background", Color.black);
				UIManager.put("Panel.background", Color.black);
				UIManager.put("OptionPane.messageForeground", Color.white);
				JOptionPane.showMessageDialog(null, "File has been pumped", "Completed!", JOptionPane.PLAIN_MESSAGE);
				System.exit(0); // Exits program when finished.
                 }
                 });

         JButton buttonInfo = new JButton("More information"); // Creates button for more information.
         buttonInfo.setBorderPainted(false); // Removes border paint.
         buttonInfo.setFocusPainted(false); // Removes blue focus ring around the button.
         buttonInfo.addActionListener(new ActionListener() { // Creates action listener to see if button is clicked.
             @Override
             public void actionPerformed(java.awt.event.ActionEvent evt) {
		         UIManager.put("OptionPane.background", Color.black);
		         UIManager.put("Panel.background", Color.black);
		         UIManager.put("OptionPane.messageForeground", Color.white);
                 	 JOptionPane.showMessageDialog(null, "Data Measurement Chart*"
                 		+ "\n8 BITS = 1 BYTE" + "\n1000 BYTE = 1 KB" + "\n1000 KB = 1 MB" + "\n1000 MB = 1 GB"
                		+ "\nExample: Step increment of 1 input value = 1 KB/MB/GB" + "\n* Minimum: 1 and the Maximum: 999 for KB and MB."
                 		+ "\nIf no radio button is selected default is KB automatically."
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
         kiloByte.setBackground(Color.black); // Sets kiloByte radio background to black.
         kiloByte.setForeground(Color.white); // Sets kiloByte radio text to white.
         kiloByte.requestFocusInWindow(); // Disables auto focus on textBox.

         mainWindow.setVisible(true); // Disables auto focus on textBox.
         mainWindow.setSize(500, 150); // Size of the window (Width by height)
         mainWindow.setVisible(true); // Make the frame visible on the screen via execution.
         mainWindow.getContentPane().setBackground(Color.black); // Sets Jframe butty background to black.

         megaByte.setBackground(Color.black); // Sets megaByte radio background to black.
         megaByte.setForeground(Color.white); // Sets megaByte radio text to white.

         gigaByte.setBackground(Color.black); // Sets gigaByte radio background to black.
         gigaByte.setForeground(Color.white); // Sets gigaByte radio text to white.

         radioList.setBackground(Color.black); // Sets JPanel radioList background to black.

         butty.setBackground(Color.black); // Sets JPanel butty background to black.
         butty.requestFocusInWindow(); // Sets focus on button to avoid focus on textField, because it will include "Choose a file..." if user types without clicking the textField.
         buttonPump.setFont(new Font("Arial", Font.BOLD, 13)); // Changes buttonPump font to Arial, Bold, and to size 13.
         
         buttonPump.setBackground(Color.gray); // Sets button background color to gray. (Contrasting colors)
         buttonPump.setForeground(Color.white); // Sets button text color to white. (Contrasting colors)

         opnButt.setBackground(Color.gray); // Sets button background color to gray. (Contrasting colors)
         opnButt.setForeground(Color.white); // Sets button text color to white. (Contrasting colors)
         opnButt.setFont(new Font("Arial", Font.BOLD, 13)); // Changes opnButt font to Arial, Italic, and to size 15.

         buttonInfo.setBackground(Color.gray); // Sets button background color to gray. (Contrasting colors)
         buttonInfo.setForeground(Color.white); // Sets button text color to white. (Contrasting colors)
         buttonInfo.setFont(new Font("Arial", Font.BOLD, 13)); // Changes opnButt font to Arial, Italic, and to size 15.

         texty.setBackground(Color.black); // Sets JPanel texty background to black.

         textBox.setFont(new Font("Arial", Font.ITALIC, 13)); // Changes textBox font to Arial, Italic, and to size 15.

         valueBox.setFont(new Font("Arial", Font.ITALIC, 13)); // Changes valueBox font to Arial, Italic, and to size 15.

         // === *** UIManager GUI SETTINGS *** ===
	     UIManager.put("Panel.background", Color.BLACK);
	     UIManager.put("Button.background", Color.BLACK);
	     UIManager.put("ComboBox.background", Color.BLACK);
	     UIManager.put("ComboBox.foreground", Color.WHITE);
	     UIManager.put("Button.foreground", Color.WHITE);
	     UIManager.put("TextField.background", Color.BLACK);
	     UIManager.put("TextField.foreground", Color.WHITE);
 	     UIManager.put("OptionPane.background", Color.BLACK);
	     UIManager.put("OptionPane.messageForeground", Color.WHITE);
	     UIManager.put("FileChooser.foreground", Color.white);  
	     UIManager.put("Label.foreground", Color.white);  
      }
}
