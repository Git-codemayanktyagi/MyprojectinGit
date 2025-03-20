package QuizApplication;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rules extends JFrame implements ActionListener {
    JButton rule, back;
    String name;
    public Rules(String name){
        this.name = name;
        getContentPane().setBackground(Color.yellow);
        setLayout(null);

        JLabel h = new JLabel("Welcome " + name + " in Brain Quiz");
        h.setBounds(400, 7, 800, 100);
        h.setFont(new Font("Georgia", Font.ITALIC, 50));
        h.setForeground(Color.GREEN);
        add(h);

        JLabel rules =  new JLabel();
        rules.setBounds(20, 100, 700, 550);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 18));
        rules.setText("<html>" +
                "1. time Limit: Each question must be answered within a set time limit (e.g., 30 seconds). If time runs out, the question is marked incorrect." + "<br><br>" +

                "2. No Backtracking: Once an answer is submitted, you can’t go back to change it. " + "<br><br>" +

                "3. Scoring: Each correct answer awards a certain number of points (e.g., 10 points). Incorrect answers or skipped questions don’t score points." + "<br><br>" +

                "4. Hints and Lifelines: If hints are allowed, using one may reduce the points awarded for that question." + "<br><br>" +

                "5. No External Help: Players should not use external resources, such as the internet, books, or other people." + "<br><br>" +

                "6. Leaderboard Access: Only the top 5 players are displayed on the leaderboard (optional, if applicable)." + "<br><br>" +

                "7. One Player per Game: Only one person may play each game session; no group play is allowed." + "<br><br>" +

                "8. End of Game: The game ends after a set number of questions or if the player chooses to quit early." +"<br><br>" +
                "<html>"
        );
        add(rules);

        rule = new JButton("Start");
        rule.setBounds(965, 230, 100, 30);
        rule.setFont(new Font("Tahoma", Font.PLAIN, 22));
        rule .setBackground(Color.cyan);
        rule.setForeground(Color.black);
        rule.addActionListener(this);
        add(rule);

        back = new JButton("Back");
        back.setBounds(965, 350, 100, 30);
        back.setFont(new Font("Tahoma", Font.PLAIN, 22));
        back .setBackground(Color.cyan);
        back.setForeground(Color.black);
        back.addActionListener(this);
        add(back);

        setSize(800, 650);
        setLocation(300, 150);
        setVisible(true);

        setExtendedState(JFrame.MAXIMIZED_BOTH); // Make the window full-screen
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent a){
        if(a.getSource() == back){
            setVisible(false);
            new Login();
        }

        else{
            setVisible(false);
            new Quiz();
        }
    }
    public static void main(String[] args) {
        new Rules("Simple");
    }
}
