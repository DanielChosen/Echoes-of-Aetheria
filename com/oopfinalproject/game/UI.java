package com.oopfinalproject.game;


import com.oopfinalproject.core.Combat_System;
import com.oopfinalproject.core.Enemy;
import com.oopfinalproject.core.EquipmentManager;
import com.oopfinalproject.core.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UI {

    public JFrame window;

    public JPanel GameTitlePanel, StartButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    public JLabel titleLabel, hpLabel, hpNumberLabel, mainHandLabel, mainHandNameLabel,mpLabel,mpNumberLabel,offHandLabel,offHandNameLabel,armorLabel,armorNameLabel,accessoryLabel,accessoryNameLabel;
    public JTextArea mainTextArea;
    public JButton startButton, choice1, choice2, choice3, choice4, choice5;

    public Font TitleFont = new Font("Times New Roman", Font.PLAIN, 80);
    public Font StartFont = new Font("Times New Roman", Font.PLAIN, 35);
    public Font NormalFont = new Font("Times New Roman", Font.PLAIN, 20);
    public Font smallFont = new Font("Times New Roman", Font.PLAIN, 20);
    
    //combat ui 
    public JPanel combat_playerPanel,combat_titlePanel,combat_enemyPanel, combat_choicePanel;
    public JLabel combat_playerLabel,combat_titleLabel,combat_enemyLabel,combat_choiceLabel;
    public JTextArea combat_TextArea;
    public JButton combat_action1,combat_action2,combat_action3,combat_action4;
    
    public JTextArea damageTextArea;
    public JScrollPane damageScrollArea;

    //skills ui
    /*public JPanel;
    public JLabel;
    public JButton;
    public JTextArea;*/

    //temp

    private Combat_System combatSystem;

    Player player = Player.getInstance();

    public void setCombatSystem(Combat_System cs){
        this.combatSystem = cs;
    }

    public void createUI(ActionListener cHandler) {
        // Window
        window = new JFrame();
        window.setTitle("Echoes of Aetheria");
        window.setSize(960, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);

        // Title screen
        GameTitlePanel = new JPanel();
        GameTitlePanel.setBounds(175, 180, 600, 150);
        GameTitlePanel.setBackground(Color.black);
        titleLabel = new JLabel("Echoes of Aetheria");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(TitleFont);
        GameTitlePanel.add(titleLabel);

        StartButtonPanel = new JPanel();
        StartButtonPanel.setBounds(380, 350, 200, 100);
        StartButtonPanel.setBackground(Color.black);
        startButton = new JButton("START");
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);
        startButton.setFont(StartFont);
        startButton.setFocusPainted(false);
        startButton.setActionCommand("START");
        startButton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.WHITE, 2),
            BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));
        startButton.addActionListener(cHandler);
        StartButtonPanel.add(startButton);

        window.add(GameTitlePanel);
        window.add(StartButtonPanel);

        // Main text panel
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(50, 75, 500, 600);
        mainTextPanel.setBackground(Color.black);
        window.add(mainTextPanel);

        mainTextArea = new JTextArea();
        mainTextArea.setBounds(0, 0, 450, 600);
        mainTextArea.setBackground(Color.BLACK);
        mainTextArea.setForeground(Color.WHITE);
        mainTextArea.setFont(NormalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);
        mainTextPanel.add(mainTextArea);

        // Choice buttons panel
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(590, 50, 300, 250);
        choiceButtonPanel.setBackground(Color.BLACK);
        choiceButtonPanel.setLayout(new GridLayout(5, 1, 10, 10));
        choiceButtonPanel.setOpaque(false);
        window.add(choiceButtonPanel);

        choice1 = createChoiceButton(cHandler, "choice1");
        choice2 = createChoiceButton(cHandler, "choice2");//test
        choice3 = createChoiceButton(cHandler, "choice3");
        choice4 = createChoiceButton(cHandler, "choice4");
        //choice5 = createChoiceButton(cHandler, "choice5");

        choiceButtonPanel.add(choice1);
        choiceButtonPanel.add(choice2);
        choiceButtonPanel.add(choice3);
        choiceButtonPanel.add(choice4);
        //choiceButtonPanel.add(choice5);

        // Player panel
        playerPanel = new JPanel();
        playerPanel.setBounds(590, 280, 300, 250);
        playerPanel.setBackground(Color.BLACK);
        playerPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2,2,2,2);
        gbc.anchor = GridBagConstraints.WEST;

        playerPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        window.add(playerPanel);

        
        hpLabel = new JLabel("HP: ");
        hpLabel.setForeground(Color.WHITE);
        hpLabel.setFont(smallFont);
        
        hpNumberLabel = new JLabel();
        hpNumberLabel.setForeground(Color.WHITE);
        hpNumberLabel.setFont(smallFont);


        mpLabel = new JLabel("MP: ");
        mpLabel.setForeground(Color.white);
        mpLabel.setFont(smallFont);
        
        mpNumberLabel = new JLabel();
        mpNumberLabel.setForeground(Color.white);
        mpNumberLabel.setFont(smallFont);
        

        mainHandLabel = new JLabel("Main Weapon: ");
        mainHandLabel.setForeground(Color.WHITE);
        mainHandLabel.setFont(smallFont);
                
        mainHandNameLabel = new JLabel();
        mainHandNameLabel.setForeground(Color.WHITE);
        mainHandNameLabel.setFont(smallFont);
        

        offHandLabel = new JLabel("OffHand: ");
        offHandLabel.setForeground(Color.WHITE);
        offHandLabel.setFont(smallFont);
        

        offHandNameLabel = new JLabel();
        offHandNameLabel.setForeground(Color.WHITE);
        offHandNameLabel.setFont(smallFont);
        

        armorLabel = new JLabel("Armor: ");
        armorLabel.setForeground(Color.WHITE);
        armorLabel.setFont(smallFont);
        

        armorNameLabel = new JLabel();
        armorNameLabel.setForeground(Color.WHITE);
        armorNameLabel.setFont(smallFont);
        

        accessoryLabel = new JLabel("Accessory: ");
        accessoryLabel.setForeground(Color.WHITE);
        accessoryLabel.setFont(smallFont);
        


        accessoryNameLabel = new JLabel();
        accessoryNameLabel.setForeground(Color.WHITE);
        accessoryNameLabel.setFont(smallFont);
        


    // Row 0
    gbc.gridx = 0; gbc.gridy = 0;
    playerPanel.add(hpLabel, gbc);
    gbc.gridx = 1;
    playerPanel.add(hpNumberLabel, gbc);

    // Row 1
    gbc.gridx = 0; gbc.gridy = 1;
    playerPanel.add(mpLabel, gbc);
    gbc.gridx = 1;
    playerPanel.add(mpNumberLabel, gbc);

    // Row 2
    gbc.gridx = 0; gbc.gridy = 2;
    playerPanel.add(mainHandLabel, gbc);
    gbc.gridx = 1;
    playerPanel.add(mainHandNameLabel, gbc);

    // Row 3
    gbc.gridx = 0; gbc.gridy = 3;
    playerPanel.add(offHandLabel, gbc);
    gbc.gridx = 1;
    playerPanel.add(offHandNameLabel, gbc);

    // Row 4
    gbc.gridx = 0; gbc.gridy = 4;
    playerPanel.add(armorLabel, gbc);
    gbc.gridx = 1;
    playerPanel.add(armorNameLabel, gbc);

    // Row 5
    gbc.gridx = 0; gbc.gridy = 5;
    playerPanel.add(accessoryLabel, gbc);
    gbc.gridx = 1;
    playerPanel.add(accessoryNameLabel, gbc);


    // Combat ui
    combat_titlePanel = new JPanel();
    combat_titlePanel.setBounds(30,25,890,50);
    combat_titlePanel.setBackground(Color.black);
    combat_titleLabel = new JLabel();
    combat_titleLabel.setForeground(Color.white);
    combat_titlePanel.setOpaque(false);
    combat_titleLabel.setFont(NormalFont);
    combat_titlePanel.add(combat_titleLabel);
    

    combat_playerPanel = new JPanel();
    combat_playerPanel.setBounds(27,70,440,200);
    combat_playerPanel.setBackground(Color.gray);
    combat_playerPanel.setOpaque(false);
    combat_playerPanel.setBorder(BorderFactory.createLineBorder(Color.white, 3));
    

    combat_enemyPanel = new JPanel();
    combat_enemyPanel.setBounds(480,70,440,200);
    combat_enemyPanel.setBackground(Color.green);
    combat_enemyPanel.setOpaque(false);
    combat_enemyPanel.setBorder(BorderFactory.createLineBorder(Color.white, 3));

    combat_TextArea = new JTextArea();
    combat_TextArea.setBackground(Color.red);
    combat_TextArea.setForeground(Color.WHITE);
    combat_TextArea.setOpaque(false);
    combat_TextArea.setBounds(27,280,893,45);
    combat_TextArea.setLineWrap(true);
    combat_TextArea.setWrapStyleWord(true);
    combat_TextArea.setEditable(true);
    combat_TextArea.setFont(NormalFont);
    combat_TextArea.setBorder(BorderFactory.createLineBorder(Color.white, 3));

    //dmg text area

    damageTextArea = new JTextArea();
    damageScrollArea = new JScrollPane(damageTextArea);
    damageTextArea.setBounds(27,345,893,75);
    damageTextArea.setBackground(Color.black);
    damageTextArea.setOpaque(true);
    damageTextArea.setForeground(Color.white);
    damageTextArea.setLineWrap(true);
    damageTextArea.setWrapStyleWord(true);
    damageTextArea.setEditable(false);
    damageTextArea.setFont(NormalFont);
    damageTextArea.setBorder(BorderFactory.createLineBorder(Color.white, 3));

    //window.add(damageTextArea);
    damageScrollArea.setBounds(27,345,893,75);
    damageScrollArea.setOpaque(false);
    damageScrollArea.getViewport().setBackground(Color.BLACK);
    damageScrollArea.setForeground(Color.WHITE);
    damageScrollArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
    damageScrollArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    damageScrollArea.setWheelScrollingEnabled(false);
    window.add(damageScrollArea);
    //combat
    
    combat_choicePanel = new JPanel();
    combat_choicePanel.setBounds(27,440,893,100);
    combat_choicePanel.setBackground(Color.pink);
    combat_choicePanel.setOpaque(false);
    combat_choicePanel.setLayout(new GridLayout(1,4,10,10));
    
    
    combat_action1 = createChoiceButton(cHandler, "Attack");
    combat_action2 = createChoiceButton(cHandler, "Skills");
    combat_action3 = createChoiceButton(cHandler, "Dodge");
    combat_action4 = createChoiceButton(cHandler, "Items");


    combat_choicePanel.add(combat_action1);
    combat_choicePanel.add(combat_action2);
    combat_choicePanel.add(combat_action3);
    combat_choicePanel.add(combat_action4);

    combat_action1.addActionListener(e -> combatSystem.playerTurn("Attack"));
    combat_action2.addActionListener(e -> combatSystem.playerTurn("Skill"));
    combat_action3.addActionListener(e -> combatSystem.playerTurn("Dodge"));
    combat_action4.addActionListener(e -> combatSystem.playerTurn("Item"));


    //add the combat ui to the window
    window.add(combat_titlePanel);
    window.add(combat_playerPanel);
    window.add(combat_enemyPanel);
    window.add(combat_TextArea);
    window.add(combat_choicePanel);

    // skills ui




    window.setVisible(true);
    }

    private JButton createChoiceButton(ActionListener cHandler, String text){
        JButton btn = new JButton(text);
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.WHITE);
        btn.setFont(NormalFont);
        btn.setFocusPainted(false);
        btn.setActionCommand(text);
        btn.addActionListener(cHandler);
        btn.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        return btn;
    }

    // ✅✅✅ PASTE YOUR NEW METHODS BELOW ✅✅✅

    public void updatePlayerPanel(int hp, int maxHp, int mp, int maxMp) {
    combat_playerPanel.removeAll();
    combat_playerPanel.setLayout(new GridLayout(3, 1, 5, 5)); // 3 rows: name, HP, MP

    JLabel playerNameLabel = new JLabel("Player");
    JLabel playerHpLabel = new JLabel("HP: " + hp + " / " + maxHp);
    JLabel playerMpLabel = new JLabel("MP: " + mp + " / " + maxMp);

    playerNameLabel.setForeground(Color.white);
    playerHpLabel.setForeground(Color.white);
    playerMpLabel.setForeground(Color.white);

    playerNameLabel.setFont(NormalFont);
    playerHpLabel.setFont(NormalFont);
    playerMpLabel.setFont(NormalFont);

    combat_playerPanel.add(playerNameLabel);
    combat_playerPanel.add(playerHpLabel);
    combat_playerPanel.add(playerMpLabel);

    combat_playerPanel.revalidate();
    combat_playerPanel.repaint();
}

    public void updateEnemyPanel(String enemyName, int hp, int maxHp) {
    combat_enemyPanel.removeAll();
    combat_enemyPanel.setLayout(new GridLayout(2, 1, 5, 5)); // 2 rows: name, HP

    JLabel enemyNameLabel = new JLabel(enemyName);
    JLabel enemyHpLabel = new JLabel("HP: " + hp + " / " + maxHp);

    enemyNameLabel.setForeground(Color.white);
    enemyNameLabel.setText(enemyName);
    enemyHpLabel.setForeground(Color.white);

    enemyNameLabel.setFont(NormalFont);
    enemyHpLabel.setFont(NormalFont);

    combat_enemyPanel.add(enemyNameLabel);
    combat_enemyPanel.add(enemyHpLabel);

    combat_enemyPanel.revalidate();
    combat_enemyPanel.repaint();
}

public void updatePlayerHpLabel(int hp, int maxHp) {
    hpNumberLabel.setText(hp + " / " + maxHp);
}

    public void updateCombatText(String text) {
    combat_TextArea.setText(text);
}

    // Refresh the standard player panel equipment labels
    public void refreshEquipmentLabels() {
        com.oopfinalproject.core.EquipmentManager eq = com.oopfinalproject.core.EquipmentManager.getInstance();

        mainHandNameLabel.setText(eq.getEquippedWeaponMainHand() != null ? eq.getEquippedWeaponMainHand().getName() : "None");
        offHandNameLabel.setText(eq.getEquippedWeaponOffhand() != null ? eq.getEquippedWeaponOffhand().getName() : (eq.getEquippedShield() != null ? eq.getEquippedShield().getName() : "None"));
        armorNameLabel.setText(eq.getEquippedArmor() != null ? eq.getEquippedArmor().getName() : "None");
        accessoryNameLabel.setText(eq.getEquippedAccessory() != null ? eq.getEquippedAccessory().getName() : "None");

        // If the player panel is visible we should revalidate and repaint so updates are shown
        if (playerPanel != null) {
            playerPanel.revalidate();
            playerPanel.repaint();
        }
    }

    /**
     * Display a modal summary dialog showing newly acquired/upgraded equipment and consumables
     * This dialog is lightweight and blocks until the player clicks OK.
     */
    public void showLootSummary(java.util.List<com.oopfinalproject.items.Item> newLoots) {
        if (newLoots == null) return;

        // Build the text to display
        StringBuilder sb = new StringBuilder();
        sb.append("You received the following from combat:\n\n");
        for (com.oopfinalproject.items.Item it : newLoots) {
            if (it == null) continue;
            String name = it.getName();
            String desc = it.getSkillDescription() != null ? it.getSkillDescription() : "";
            String extra = "";
            if (it instanceof com.oopfinalproject.items.Weapon) extra = " (DMG: " + ((com.oopfinalproject.items.Weapon)it).getDmg() + ")";
            if (it instanceof com.oopfinalproject.items.Armor) extra = " (DEF: " + ((com.oopfinalproject.items.Armor)it).getDef() + ")";
            if (it instanceof com.oopfinalproject.items.Shield) extra = " (DEF: " + ((com.oopfinalproject.items.Shield)it).getDef() + ")";
            sb.append("- ").append(name).append(extra);
            if (desc != null && !desc.isEmpty()) sb.append(" — ").append(desc);
            sb.append("\n");
        }

        // Create modal dialog
        JDialog dlg = new JDialog(window, "Combat Reward", true);
        dlg.setSize(480, 300);
        dlg.setLocationRelativeTo(window);
        dlg.setLayout(new BorderLayout(8,8));

        JTextArea area = new JTextArea(sb.toString());
        area.setEditable(false);
        area.setFont(NormalFont);
        area.setBackground(Color.BLACK);
        area.setForeground(Color.WHITE);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));

        JButton ok = new JButton("OK");
        ok.addActionListener(e -> dlg.dispose());
        ok.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        ok.setBackground(Color.BLACK);
        ok.setForeground(Color.WHITE);

        dlg.add(new JScrollPane(area), BorderLayout.CENTER);
        JPanel footer = new JPanel(); footer.setBackground(Color.BLACK); footer.add(ok);
        dlg.add(footer, BorderLayout.SOUTH);

        dlg.setVisible(true);
    }

public void updatedamageTextArea(String text){
    //damageTextArea.setText("");
    damageTextArea.append(text + "\n");
    damageTextArea.setCaretPosition(
        damageTextArea.getDocument().getLength()
    );
}

    public void updateCombatTitle(String title){
        combat_titleLabel.setText(title);
    }

}
