package my.pkg1st.javabot;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class My1stJavabot extends JFrame {

    public JTextArea textArea = new JTextArea();
    private JScrollPane scrollPane;
    private JTextField My1stJavabot = new JTextField();
    private JLabel lebelOne = new JLabel(" Welcome to Arogya Channeling Center");

    private JButton clearButton;

    private Map<String, String> knowledgeBase; // for storing user answers

    private String name; // variable for storing the name value
    private String info; // to store the booking data

    JLabel labelForImage = new JLabel(); // label to store the image
    ImageIcon icon = new ImageIcon("C:\\Users\\acer\\Desktop\\chatbot resources\\welcome.png");

    public My1stJavabot() {

        // ==================== structure of the frame ========================//
        JFrame frame = new JFrame("🚑Arogya Channeling Chat.🙏");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        // CODE BLOCK FOR SETTING COLOR TO THE FRAME
        Color lightGreen = new Color(37, 92, 78); // RGB values
        Color lightsky = new Color(137, 204, 187); // RGB values
        Color lightSky = new Color(224, 236, 243);
        Color theNewBlue = new Color(44, 62, 80);
        Color theNewRed = new Color(231, 76, 60);
        
        frame.getContentPane().setBackground(lightGreen); // Set background color of the frame
        

        // Set up the welcome label
        lebelOne.setFont(new Font("Viner Hand ITC", Font.BOLD, 25));
        lebelOne.setForeground(lightsky);
        lebelOne.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        frame.add(lebelOne, gbc);

        // Set up the image label
        labelForImage.setIcon(new ImageIcon(icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
        labelForImage.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        frame.add(labelForImage, gbc);

        // Set up the text area
        textArea.setEditable(false);
        textArea.setBackground(lightSky);
        textArea.setFont(new Font("Arial", Font.BOLD, 15));
        textArea.setForeground(theNewBlue);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        // Set up the scroll pane
        scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        frame.add(scrollPane, gbc);

        // Set up the text field
        My1stJavabot.setFont(new Font("Kristen ITC", Font.BOLD, 15));
        My1stJavabot.setForeground(theNewBlue);
        My1stJavabot.setBackground(lightSky);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.weightx = 0.8;
        gbc.weighty = 0;
        frame.add(My1stJavabot, gbc);

        // Set up the clear button
        clearButton = new JButton("Clear");
        clearButton.setFont(new Font("Kristen ITC", Font.BOLD, 13));
        clearButton.setBackground(theNewRed);
        clearButton.setForeground(Color.WHITE);
        clearButton.setFocusPainted(false);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.weightx = 0.2;
        frame.add(clearButton, gbc);

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });

        // Initialize knowledge base
        knowledgeBase = new HashMap<>();
        
        // Set the frame visible
        frame.setVisible(true);

        // Chat processing code block
        My1stJavabot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String gtext = My1stJavabot.getText().toLowerCase(); // get text from text feild and assign it to gtext variable

                textArea.append("You: " + gtext + "\n");
                My1stJavabot.setText("");

                if (gtext.contains("hi") || gtext.contains("hello")) {
                    ImageIcon newIcon = new ImageIcon("C:\\Users\\acer\\Desktop\\chatbot resources\\hi.png"); // replace the image
                    labelForImage.setIcon(new ImageIcon(newIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

                    int randA = (int) (Math.random() * 3 + 1);
                    switch (randA) {
                        case 1:
                            bot("Hello there! How can I help you?");
                            break;
                        case 2:
                            bot("Hi there, how can I help you?");
                            break;
                        case 3:
                            bot("We gladly welcome you! How can I help you?");
                            break;
                    }
                }
                   
                else if(gtext.contains("bye")|| gtext.contains("lets meet again"))
                {
                   
                    ImageIcon newIcon = new ImageIcon("C:\\Users\\acer\\Desktop\\chatbot resources\\bye.png");
                    labelForImage.setIcon(newIcon);
                    int randA= (int ) (Math.random() *3 +1);
                   
                    if(name != null){ //this run only if the user is given the name
                   
                   
                    switch (randA){
                        case  1:
                             bot("  Good Bye ! "+name);
                             break;
                        case 2:
                             bot("  Bye "+name+ ", Have a Nice Day !");
                             break;
                             
                        case 3:
                            bot("   Happy to help you "+name+", is there any issue feel free to ask !");
                            break;
     
                    }
       
                    }
                    if(name == null){ //this run only if the user is not given the name
                   
                    switch (randA){
                        case  1:
                             bot("  Good Bye ! ");
                             break;
                        case 2:
                             bot("  Bye , Have a Nice Day !");
                             break;
                             
                        case 3:
                            bot("   Happy to help you, is there any issue feel free to ask !");
                            break;
     
                    }
       
                    }
                   
                }
                else if(gtext.contains("what is your name")||gtext.contains( "what name is your"))
                {
                    ImageIcon newIcon = new ImageIcon("C:\\Users\\acer\\Desktop\\chatbot resources\\idea.png");
                    labelForImage.setIcon(newIcon);
                   
                    int randA= (int ) (Math.random() *2 +1);
                    switch (randA){
                        case  1:
                             bot("  I' m Arogya , what is your name ? ");
                             break;
                        case 2:
                             bot("  My name is Arogya, what yours ? ");
                             break;
           
                    }
                }
                else if(gtext.contains("my name is"))
                {
                    ImageIcon newIcon = new ImageIcon("C:\\Users\\acer\\Desktop\\chatbot resources\\hi2.png");
                    labelForImage.setIcon(newIcon);

                    name = gtext.substring(10); // Extract the name
           
                    int randA= (int ) (Math.random() *2 +1);
                    switch (randA){
                        case  1:
                             bot("  Hello "+ name +" ,what do you wanna know ?");
                             break;
                        case 2:
                             bot("  Hi "+ name +" ,what do you wanna know ?");
                             break;
                               
                    }
                }
                else if(gtext.contains("i am"))
                {
                    ImageIcon newIcon = new ImageIcon("C:\\Users\\acer\\Desktop\\chatbot resources\\hi2.png");
                    labelForImage.setIcon(newIcon);

                    name = gtext.substring(4); // Extract the name
           
                    int randA= (int ) (Math.random() *2 +1);
                    switch (randA){
                        case  1:
                             bot("  Hello "+ name +" ,what do you wanna know ?");
                             break;
                        case 2:
                             bot("  Hi "+ name +" ,what do you wanna know ?");
                             break;
             
                    }
                }
               
                else if(gtext.contains("how are you")||gtext.contains( "how ar u"))
                {
                    ImageIcon newIcon = new ImageIcon("C:\\Users\\acer\\Desktop\\chatbot resources\\idea.png");
                    labelForImage.setIcon(newIcon);
                   
                    int randA= (int ) (Math.random() *2 +1);
                    switch (randA){
                        case  1:
                             bot("  I' m Good , what about you ? ");
                             break;
                        case 2:
                             bot("  I'm fine , are you fine ? ");
                             break;
           
                    }
                }
                 else if(gtext.contains("i am good")||gtext.contains( "fine"))
                {
                    ImageIcon newIcon = new ImageIcon("C:\\Users\\acer\\Desktop\\chatbot resources\\idea.png");
                    labelForImage.setIcon(newIcon);
                   
                    int randA= (int ) (Math.random() *2 +1);
                    switch (randA){
                        case  1:
                             bot(" wow happy to here that");
                             break;
                        case 2:
                             bot("  ohh good to here");
                             break;
           
                    }
                }
                else if(gtext.contains("what is your job")||gtext.contains( "what do you do"))
                {
                    ImageIcon newIcon = new ImageIcon("C:\\Users\\acer\\Desktop\\chatbot resources\\idea.png");
                    labelForImage.setIcon(newIcon);
                   
                 
                    switch (1){
                        case  1:
                             bot("  I' m Arogya , i am your vertual helper to book a dr :)");
                             break;
                       
           
                    }
                }
                else if(gtext.contains("medicines for common cold")||gtext.contains( "treatment for common cold"))
                {
                    ImageIcon newIcon = new ImageIcon("C:\\Users\\acer\\Desktop\\chatbot resources\\medicince.png");
                    labelForImage.setIcon(newIcon);
                   
                 
                    switch (1){
                        case  1:
                             bot("  [1] Acetaminophen (Tylenol): Used to relieve fever and minor aches and pains.\n" +
                                 "  [2] Decongestants (Pseudoephedrine or Phenylephrine): Help to reduce nasal congestion.\n" +
                                 "  [3] Cough Suppressants (Dextromethorphan): Used to relieve a dry cough.");
                             break;
                       
           
                    }
                }else if(gtext.contains("medicines for stomachache")||gtext.contains( "treatment for stomachache"))
                {
                    ImageIcon newIcon = new ImageIcon("C:\\Users\\acer\\Desktop\\chatbot resources\\medicince.png");
                    labelForImage.setIcon(newIcon);
                   
                 
                    switch (1){
                        case  1:
                             bot("  [1]Antacids (Tums, Rolaids): Help neutralize stomach acid and relieve indigestion.\n" +
                                 "  [2]Proton Pump Inhibitors (Omeprazole): Reduce the production of stomach acid.\n" +
                                 "  [3]Antispasmodics (Hyoscine butylbromide, also known as Buscopan): Help to relieve stomach cramps.");
                             break;
                       
           
                    }
                }else if(gtext.contains("medicines for back pain")||gtext.contains( "treatment for back pain"))
                {
                    ImageIcon newIcon = new ImageIcon("C:\\Users\\acer\\Desktop\\chatbot resources\\medicince.png");
                    labelForImage.setIcon(newIcon);
                   
                 
                    switch (1){
                        case  1:
                             bot("  [1] Nonsteroidal Anti-Inflammatory Drugs (NSAIDs) (Ibuprofen, Naproxen): Reduce inflammation and alleviate pain.\n" +
                                 "  [2] Muscle Relaxants (Cyclobenzaprine, Methocarbamol): Help to relieve muscle spasms.\n" +
                                 "  [3] Acetaminophen (Tylenol): Used for pain relief without anti-inflammatory effects.");
                             break;
                       
           
                    }
                }
                else if(gtext.contains("thank you")||gtext.contains( "thank you very much")||gtext.contains( "thank you for the help"))
                {
                    ImageIcon newIcon = new ImageIcon("C:\\Users\\acer\\Desktop\\chatbot resources\\idea.png");
                    labelForImage.setIcon(newIcon);
                   
                    int randA= (int ) (Math.random() *2 +1);
                    switch (randA){
                        case  1:
                             bot("  You are welcome !");
                             break;
                        case 2:
                             bot("  Happy to help you !");
                             break;
           
                    }
                }

                //the bot greeting according to the actual time mot depending the user input
               
                else if(gtext.contains("good morning")||gtext.contains( "good evening")||gtext.contains( "good afternoon")||gtext.contains( "good night"))
                {
                    ImageIcon newIcon = new ImageIcon("C:\\Users\\acer\\Desktop\\chatbot resources\\greeting.png");
                    labelForImage.setIcon(newIcon);

                 // Get the current time and determine the greeting
                 
                 LocalTime currentTime = LocalTime.now();
                 

                // Determine the appropriate greeting based on the current time using switch
                int hour = currentTime.getHour();
                switch (hour / 6) {
                    case 0:
                        bot("Good Night");
                        break;
                    case 1:
                        bot("Good Morning");
                       
                        break;
                    case 2:
                        bot ("Good Afternoon");
                        break;
                    case 3:
                        bot( "Good Evening");
                        break;
                   
                }
            } else if (gtext.contains("what time is it")) {
            LocalTime time = LocalTime.now();
            bot("Now : " + time.getHour() + ":" + time.getMinute());
            
            } else if (gtext.contains("date")) {
            java.util.Date date = new java.util.Date();
            bot( "Today is " + date);
                   
               }

                else if(gtext.contains("branches"))
                {
                   
                    ImageIcon newIcon = new ImageIcon("C:\\Users\\acer\\Desktop\\chatbot resources\\idea.png");
                    labelForImage.setIcon(newIcon);
                    try {
                        File    Obj = new File("C:\\Users\\acer\\Desktop\\chatbot resources\\branches.txt");
                        Scanner  s = new Scanner(Obj);
                       
                        while (s.hasNextLine())
                        {
                            String data = s.nextLine();
                            textArea.append(data+"\n");
                        }
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(My1stJavabot.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                }
                else if(gtext.contains("dr details")||gtext.contains( "give me more dr details")||gtext.contains( "who are the drs visit you"))
                {
                   
                    ImageIcon newIcon = new ImageIcon("C:\\Users\\acer\\Desktop\\chatbot resources\\idea.png");
                    labelForImage.setIcon(newIcon);
                    try {
                        File    Obj = new File("C:\\Users\\acer\\Desktop\\chatbot resources\\dr.txt");
                        Scanner  s = new Scanner(Obj);
                       
                        while (s.hasNextLine())
                        {
                            String data = s.nextLine();
                            textArea.append(data+"\n");
                        }
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(My1stJavabot.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                }
               
                else if(gtext.contains("dr nimal")||gtext.contains("cardiology") )
                {
                   
                    ImageIcon newIcon = new ImageIcon("C:\\Users\\acer\\Desktop\\chatbot resources\\idea.png");
                    labelForImage.setIcon(newIcon);
                    try {
                        File    Obj = new File("C:\\Users\\acer\\Desktop\\chatbot resources\\drnimal.txt");
                        Scanner  s = new Scanner(Obj);
                       
                        while (s.hasNextLine())
                        {
                            String data = s.nextLine();
                            textArea.append(data+"\n");
                        }
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(My1stJavabot.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                }
                else if(gtext.contains("dr shanika")||gtext.contains("dermatology") )
                {
                   
                    ImageIcon newIcon = new ImageIcon("C:\\Users\\acer\\Desktop\\chatbot resources\\idea.png");
                    labelForImage.setIcon(newIcon);
                    try {
                        File    Obj = new File("C:\\Users\\acer\\Desktop\\chatbot resources\\drshanika.txt");
                        Scanner  s = new Scanner(Obj);
                       
                        while (s.hasNextLine())
                        {
                            String data = s.nextLine();
                            textArea.append(data+"\n");
                        }
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(My1stJavabot.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                }  
                else if(gtext.contains("dr ajith")||gtext.contains("pediatrics") )
                {
                   
                    ImageIcon newIcon = new ImageIcon("C:\\Users\\acer\\Desktop\\chatbot resources\\idea.png");
                    labelForImage.setIcon(newIcon);
                    try {
                        File    Obj = new File("C:\\Users\\acer\\Desktop\\chatbot resources\\drajith.txt");
                        Scanner  s = new Scanner(Obj);
                       
                        while (s.hasNextLine())
                        {
                            String data = s.nextLine();
                            textArea.append(data+"\n");
                        }
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(My1stJavabot.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                }
                else if(gtext.contains("dr malini")||gtext.contains("neurology") )
                {
                   
                    ImageIcon newIcon = new ImageIcon("C:\\Users\\acer\\Desktop\\chatbot resources\\idea.png");
                    labelForImage.setIcon(newIcon);
                    try {
                        File    Obj = new File("C:\\Users\\acer\\Desktop\\chatbot resources\\drmalini.txt");
                        Scanner  s = new Scanner(Obj);
                       
                        while (s.hasNextLine())
                        {
                            String data = s.nextLine();
                            textArea.append(data+"\n");
                        }
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(My1stJavabot.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                }
                else if(gtext.contains("dr ruwan")||gtext.contains("orthopedics") )
                {
                   
                    ImageIcon newIcon = new ImageIcon("C:\\Users\\acer\\Desktop\\chatbot resources\\idea.png");
                    labelForImage.setIcon(newIcon);
                    try {
                        File    Obj = new File("C:\\Users\\acer\\Desktop\\chatbot resources\\drruwan.txt");
                        Scanner  s = new Scanner(Obj);
                       
                        while (s.hasNextLine())
                        {
                            String data = s.nextLine();
                            textArea.append(data+"\n");
                        }
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(My1stJavabot.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                }
                 else if(gtext.contains("yes"))
                {
                    ImageIcon newIcon = new ImageIcon("C:\\Users\\acer\\Desktop\\chatbot resources\\idea.png");
                    labelForImage.setIcon(newIcon);
                   
                   
                    switch (1){
                        case  1:
                             bot("give your name / TP number and Dr name  in following structure");
                             
                             bot("Your Name:| Tp :| Dr name : ");

                             break;

                    }
                }
                 else if(gtext.contains("your name:| tp :| dr name : "))
                {
                    ImageIcon newIcon = new ImageIcon("C:\\Users\\acer\\Desktop\\chatbot resources\\idea.png");
                    labelForImage.setIcon(newIcon);
                   
                   
                    switch (1){
                        case  1:
                           
                             info = gtext.substring(28);
                             int randA = (int ) (Math.random() *50);
                             bot("**Your Channeling process is completed.... ! \n   "
                             + "    @Your Number is ["+randA+ "] pleace be on time ! \n "
                              + "   @Is there any question feel free to ask !");
                             
                             
                             //put data to text file
                             
                             String filePath = "C:\\Users\\acer\\Desktop\\chatbot resources\\inforstore.txt";
                             
                             // Writing the data to the file
                             try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                                writer.write(info);
                                writer.newLine();
                                System.out.println("Data successfully written to the file.");
                            } catch (IOException e) {
                                System.err.println("An error occurred while writing to the file.");
                                e.printStackTrace();
                            }


                             break;

                    }
                }
                  else if(gtext.contains("no"))
                {
                    ImageIcon newIcon = new ImageIcon("C:\\Users\\acer\\Desktop\\chatbot resources\\idea.png");
                    labelForImage.setIcon(newIcon);
                   
                   
                    switch (1){
                        case  1:
                             bot("Is there any question feel free to ask !");

                             break;

                    }
                }
                else{
                   
                    ImageIcon newIcon = new ImageIcon("C:\\Users\\acer\\Desktop\\chatbot resources\\thinking.png");
                    labelForImage.setIcon(newIcon);
                   
                    if (knowledgeBase.containsKey(gtext)) {
                    bot(knowledgeBase.get(gtext));
                    }else
                       
                       
                               bot("Tell it !");
                               My1stJavabot.addActionListener(new ActionListener() {
                               @Override
                               public void actionPerformed(ActionEvent e) {
                                   String answer = My1stJavabot.getText();

                                   knowledgeBase.put(gtext, answer);

                                   //bot("stored !");
                                   
                                   My1stJavabot.removeActionListener(this);
                                   
                               }
                               
                           });
   
                }
            }

        });
       

        // Clear button action listener
        clearButton.addActionListener(new ActionListener() {
           
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
           
        });
 
    }

    //********reply bot method for hospital side
   
    private void bot(String string){

            textArea.append("Arogya :-" +string+ "\n");
        }

   
   
    //*************main method
    public static void main(String[] args) {
        new My1stJavabot();
    }
}