package QuizApplication;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    JTextField textField;
    JButton next, exit;

    public Login(){
        // background color
        getContentPane().setBackground(Color.yellow);
        setLayout(null);

        // image add
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Image/QUIZ.jpg"));
        JLabel img = new JLabel(i1);
        img.setBounds(0, 0, 680, 700);
        add(img);

        // text
        JLabel j = new JLabel("Brain Quiz");
        j.setBounds(750, 20, 500, 100);
        j.setFont(new Font("Georgia", Font.ITALIC, 24));
        j.setForeground(Color.GREEN);
        add(j);

        JLabel label = new JLabel("Enter your name");
        label.setBounds(816, 46, 180, 150);
        label.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        add(label);

        textField = new JTextField();
        textField.setBounds(735, 140, 300, 25);
        textField.setFont(new Font("Sans Serif", Font.PLAIN, 17));
        add(textField);

        //j.setFont(new Font("Arial", Font.BOLD, 24));
        //j.setFont(new Font("Serif", Font.BOLD, 24));
        //j.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        // j.setFont(new Font("Monospaced", Font.ITALIC, 22));
        //j.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 26));
        // j.setFont(new Font("Verdana", Font.PLAIN, 18));
        //j.setFont(new Font("Tahoma", Font.BOLD, 30));
        //j.setFont(new Font("Comic Sans MS", Font.BOLD, 28));

        next = new JButton("Next");
        next.setBounds(735, 180, 100, 30);
        next.setBackground(Color.CYAN);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setForeground(Color.black);
        next.addActionListener(this);
        add(next);

        exit = new JButton("Exit");
        exit.setBounds(935, 180, 100, 30);
        exit.setBackground(Color.CYAN);
        exit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        exit.setForeground(Color.black);
        exit.addActionListener(this);
        add(exit);

        setExtendedState(JFrame.MAXIMIZED_BOTH); // Make the window full-screen
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit){
            setVisible(false);
        }

        else if(e.getSource() == next) {
            String name = textField.getText();
            setVisible(false);
            new Rules(name);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
