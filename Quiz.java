package QuizApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame implements ActionListener {
    String[][] questions = new String[10][5];
    String[][] answers = new String[10][2];
    String[][] userAnswers = new String[10][1];
    int currentQuestion = 0;
    int ansgiven = 0;

    JLabel qLabel;
    JRadioButton option1, option2, option3, option4;
    ButtonGroup optionsGroup;
    JButton nextButton, backButton, menubutton;

    static int timer = 30;

    Quiz() {
        // Initialize questions and answers
        questions[0][0] = "Which is used to find and fix bugs in Java programs?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";
        answers[0][1] = "JDB";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";
        answers[1][1] = "int";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

        //answers
        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";

        // Add remaining questions and answers similarly...

        // Frame settings
        setBounds(50, 0, 800, 600);
        getContentPane().setBackground(Color.YELLOW);
        setLayout(null);

        qLabel = new JLabel("");
        qLabel.setBounds(50, 360, 700, 30);
        qLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qLabel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Image/istockphoto-1272478640-612x612.jpg"));
        JLabel label = new JLabel(i1);
        label.setBounds(0,0,1300,300);
        add(label);

        option1 = new JRadioButton("");
        option1.setBounds(100, 400, 500, 30);
        option1.setBackground(Color.white);
        option1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(option1);

        option2 = new JRadioButton("");
        option2.setBounds(100, 440, 500, 30);
        option2.setBackground(Color.white);
        option2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(option2);

        option3 = new JRadioButton("");
        option3.setBounds(100, 480, 500, 30);
        option3.setBackground(Color.white);
        option3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(option3);

        option4 = new JRadioButton("");
        option4.setBounds(100, 520, 500, 30);
        option4.setBackground(Color.white);
        option4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(option4);

        optionsGroup = new ButtonGroup();
        optionsGroup.add(option1);
        optionsGroup.add(option2);
        optionsGroup.add(option3);
        optionsGroup.add(option4);

        nextButton = new JButton("Next");
        nextButton.setBounds(700, 450, 100, 30);
        nextButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        nextButton.setBackground(Color.cyan);
        nextButton.setForeground(Color.black);
        nextButton.addActionListener(this);
        add(nextButton);

        backButton = new JButton("Back");
        backButton.setBounds(900, 450, 100, 30);
        backButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        backButton.setBackground(Color.cyan);
        backButton.setForeground(Color.black);
        backButton.addActionListener(this);
        add(backButton);

        menubutton = new JButton("Menu");
        menubutton.setBounds(1100, 450, 100, 30);
        menubutton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        menubutton.setBackground(Color.cyan);
        menubutton.setForeground(Color.black);
        menubutton.addActionListener(this);
        add(menubutton);

        loadQuestion(currentQuestion);

        setVisible(true);
    }

    public void paint(Graphics g){
        super.paint(g);

        String time = "Time Left = " + timer + " seconds";
        g.setColor(Color.red);
        g.setFont(new Font("Tahomia", Font.BOLD, 25));

        if (timer > 0) {g.drawString(time, 1000, 410);
        timer -= 1;}

        else g.drawString("Times up!!", 1000, 410);

        try {
            Thread.sleep(1000);
            repaint();
        }

        catch (Exception e){
            e.getStackTrace();
        }

        if(ansgiven == 1) {
            ansgiven = 0;
            timer = 30;
        }

        else if(timer == 0){
            timer = 30;
        }
    }


    public void loadQuestion(int index) {
        qLabel.setText("Q" + (index + 1) + ": " + questions[index][0]);
        option1.setText(questions[index][1]);
        option2.setText(questions[index][2]);
        option3.setText(questions[index][3]);
        option4.setText(questions[index][4]);
        optionsGroup.clearSelection();

        setExtendedState(JFrame.MAXIMIZED_BOTH); // Make the window full-screen
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton) {
            // Store selected answer
            if (option1.isSelected()) userAnswers[currentQuestion][0] = option1.getText();
            else if (option2.isSelected()) userAnswers[currentQuestion][0] = option2.getText();
            else if (option3.isSelected()) userAnswers[currentQuestion][0] = option3.getText();
            else if (option4.isSelected()) userAnswers[currentQuestion][0] = option4.getText();

            currentQuestion++;
            if (currentQuestion < questions.length) {
                loadQuestion(currentQuestion);

            }

            else {
                JOptionPane.showMessageDialog(this, "Quiz completed!");
                // Here you can add logic to display score or result
            }
        }

        if (e.getSource() == backButton) {
            setVisible(false);
            new Rules("");
        }

        else if(e.getSource() == menubutton){
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Quiz();
    }
}
