package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UI {

    public JFrame window;

    public JPanel GameTitlePanel, StartButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    public JLabel titleLabel, hpLabel, hpNumberLabel, weaponLabel, weaponNameLabel;
    public JTextArea mainTextArea;
    public JButton startButton, choice1, choice2, choice3, choice4, choice5;

    public Font TitleFont = new Font("Times New Roman", Font.PLAIN, 75);
    public Font NormalFont = new Font("Times New Roman", Font.PLAIN, 20);
    public Font smallFont = new Font("Times New Roman", Font.PLAIN, 20);

    public void createUI(ActionListener cHandler) {
        // Window
        window = new JFrame();
        window.setTitle("Echoes of Aetheria");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);

        // Title screen
        GameTitlePanel = new JPanel();
        GameTitlePanel.setBounds(100, 100, 600, 150);
        GameTitlePanel.setBackground(Color.BLACK);
        titleLabel = new JLabel("Echoes of Aetheria");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(TitleFont);
        GameTitlePanel.add(titleLabel);

        StartButtonPanel = new JPanel();
        StartButtonPanel.setBounds(300, 400, 200, 100);
        StartButtonPanel.setBackground(Color.BLACK);
        startButton = new JButton("START");
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);
        startButton.setFont(NormalFont);
        startButton.setFocusPainted(false);
        startButton.setActionCommand("START");
        startButton.addActionListener(cHandler);
        StartButtonPanel.add(startButton);

        window.add(GameTitlePanel);
        window.add(StartButtonPanel);

        // Main text panel
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(50, 50, 350, 500);
        mainTextPanel.setBackground(Color.BLACK);
        window.add(mainTextPanel);

        mainTextArea = new JTextArea();
        mainTextArea.setBounds(0, 0, 350, 500);
        mainTextArea.setBackground(Color.BLACK);
        mainTextArea.setForeground(Color.WHITE);
        mainTextArea.setFont(NormalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);
        mainTextPanel.add(mainTextArea);

        // Choice buttons panel
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(450, 100, 300, 250);
        choiceButtonPanel.setBackground(Color.BLACK);
        choiceButtonPanel.setLayout(new GridLayout(5, 1, 10, 10));
        window.add(choiceButtonPanel);

        choice1 = createChoiceButton(cHandler, "c1");
        choice2 = createChoiceButton(cHandler, "c2");
        choice3 = createChoiceButton(cHandler, "c3");
        choice4 = createChoiceButton(cHandler, "c4");
        choice5 = createChoiceButton(cHandler, "c5");

        choiceButtonPanel.add(choice1);
        choiceButtonPanel.add(choice2);
        choiceButtonPanel.add(choice3);
        choiceButtonPanel.add(choice4);
        choiceButtonPanel.add(choice5);

        // Player panel
        playerPanel = new JPanel();
        playerPanel.setBounds(50, 10, 700, 50);
        playerPanel.setBackground(Color.BLACK);
        playerPanel.setLayout(new GridLayout(1, 4));
        window.add(playerPanel);

        hpLabel = new JLabel("HP: ");
        hpLabel.setForeground(Color.WHITE);
        hpLabel.setFont(smallFont);
        playerPanel.add(hpLabel);

        hpNumberLabel = new JLabel("");
        hpNumberLabel.setForeground(Color.WHITE);
        hpNumberLabel.setFont(smallFont);
        playerPanel.add(hpNumberLabel);

        weaponLabel = new JLabel("Weapon: ");
        weaponLabel.setForeground(Color.WHITE);
        weaponLabel.setFont(smallFont);
        playerPanel.add(weaponLabel);

        weaponNameLabel = new JLabel("");
        weaponNameLabel.setForeground(Color.WHITE);
        weaponNameLabel.setFont(smallFont);
        playerPanel.add(weaponNameLabel);

        // Initial visibility
        GameTitlePanel.setVisible(false);
        StartButtonPanel.setVisible(false);
        mainTextPanel.setVisible(false);
        choiceButtonPanel.setVisible(false);
        playerPanel.setVisible(false);

        window.setVisible(true);
    }

    private JButton createChoiceButton(ActionListener cHandler, String command){
        JButton btn = new JButton("");
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.WHITE);
        btn.setFont(NormalFont);
        btn.setFocusPainted(false);
        btn.setActionCommand(command);
        btn.addActionListener(cHandler);
        btn.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        return btn;
    }
}
