import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    JFrame window;
    Container con;

    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;

    JButton startButton, choiceOne, choiceTwo, choiceThree, choiceFour;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 75);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 40);

    Font playerFont = new Font("Times New Roman", Font.PLAIN, 35);

    JTextArea mainTextArea;

    int playerHp;

    String weaponName, position;

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler chHandler = new ChoiceHandler();


    public static void main(String[] args) {
        new Game();
    }

    public Game() {

        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setSize(850, 700);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        con = window.getContentPane();


        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 100);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("Tiny Adventure 2");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("Start");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);
        con.add(titleNamePanel);
        con.add(startButtonPanel);

    }

    public void createGameScreen() {

        titleNamePanel.setVisible(false);
        startButton.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 700, 350);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea();
        mainTextArea.setBounds(100, 100, 700, 250);
        mainTextPanel.add(mainTextArea);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);


        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(350, 450, 300, 200);
        con.add(choiceButtonPanel);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));


        choiceOne = new JButton();
        choiceButtonPanel.add(choiceOne);
        choiceOne.setBackground(Color.black);
        choiceOne.setForeground(Color.white);
        choiceOne.setFont(normalFont);
        choiceOne.setFocusPainted(false);
        choiceOne.addActionListener(chHandler);
        choiceOne.setActionCommand("c1");


        choiceTwo = new JButton();
        choiceButtonPanel.add(choiceTwo);
        choiceTwo.setBackground(Color.black);
        choiceTwo.setForeground(Color.white);
        choiceTwo.setFont(normalFont);
        choiceTwo.setFocusPainted(false);
        choiceTwo.addActionListener(chHandler);
        choiceTwo.setActionCommand("c2");


        choiceThree = new JButton();
        choiceButtonPanel.add(choiceThree);
        choiceThree.setBackground(Color.black);
        choiceThree.setForeground(Color.white);
        choiceThree.setFont(normalFont);
        choiceThree.setFocusPainted(false);
        choiceThree.addActionListener(chHandler);
        choiceThree.setActionCommand("c3");


        choiceFour = new JButton();
        choiceButtonPanel.add(choiceFour);
        choiceFour.setBackground(Color.black);
        choiceFour.setForeground(Color.white);
        choiceFour.setFont(normalFont);
        choiceFour.setFocusPainted(false);
        choiceFour.addActionListener(chHandler);
        choiceOne.setActionCommand("c4");

        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        con.add(playerPanel);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1, 4));
        hpLabel = new JLabel("HP:");
        hpLabel.setFont(playerFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);
        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(playerFont);
        hpLabelNumber.setForeground(Color.white);
        playerPanel.add(hpLabelNumber);
        weaponLabel = new JLabel("Weapon:");
        weaponLabel.setFont(playerFont);
        weaponLabel.setForeground(Color.white);
        playerPanel.add(weaponLabel);
        weaponLabelName = new JLabel();
        weaponLabelName.setFont(playerFont);
        weaponLabelName.setForeground(Color.white);
        playerPanel.add(weaponLabelName);

        playerSetUp();

    }

    public void playerSetUp() {
        playerHp = 12;
        weaponName = "S. Sword";
        weaponLabelName.setText(weaponName);
        hpLabelNumber.setText("" + playerHp);

        DarkTower();

    }

    public void DarkTower() {
        position = "DarkTower";
        mainTextArea.setText("You step forth into the Dark Tower.\nThe air is thick with the smell of decay, " +
                "\nThere is a door to your left,a painting hangs on the wall in front of you, " +
                "\nand a stairway on your right.\n\tWhat do you do?");

        choiceOne.setText("Leave Tower");
        choiceTwo.setText("Try the Door");
        choiceThree.setText("Go up Stairs");
        choiceFour.setText("Inspect Painting");

    }

    public void leaveTower() {
        position = "leaveTower";
        mainTextArea.setText("You leave the tower heading back\nto the forest seems your not\nquite ready for the task \n\t\t\tGame over");

        choiceOne.setText(">");
        choiceTwo.setText("");
        choiceThree.setText("");
        choiceFour.setText("");

    }

    public class TitleScreenHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            createGameScreen();
        }
    }

    public class ChoiceHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String playerChoice = e.getActionCommand();
            switch (position) {
                case "DarkTower":
                    switch (playerChoice) {
                        case "c1":
                            leaveTower();
                            break;
                        case "c2":
                            break;

                    }
            }
        }
    }
}




