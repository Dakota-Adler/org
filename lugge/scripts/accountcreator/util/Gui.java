package org.lugge.scripts.accountcreator.util;

import org.lugge.scripts.accountcreator.data.Creation.GenderCreation;
import org.lugge.scripts.accountcreator.data.Creation.SettingsCreation;
import org.lugge.scripts.accountcreator.data.Options.SettingsOptions;
import org.lugge.scripts.accountcreator.data.Placement.DestinationsPlacement;
import org.lugge.scripts.accountcreator.data.Placement.SettingsPlacement;
import org.lugge.scripts.accountcreator.data.SuperState.SettingsSuperState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame {
    private JLabel emailNameText = new JLabel();
    private JTextField email = new JTextField();

    private JLabel emailHostText = new JLabel();
    private JTextField host = new JTextField();

    private JLabel extensionText = new JLabel();
    private SpinnerNumberModel extensionModel = new SpinnerNumberModel(1, 0, 9999, 1);
    private JSpinner extension = new JSpinner();


    private JLabel accountNameText = new JLabel();
    private JTextField name = new JTextField();

    private JLabel passwordText = new JLabel();
    private JTextField password = new JTextField();


    private JLabel amountText = new JLabel();
    private SpinnerNumberModel amountModel = new SpinnerNumberModel(1, 0, 9999, 1);
    private JSpinner amount = new JSpinner();


    private JLabel ageMinText = new JLabel();
    private JSpinner minAge = new JSpinner();
    private SpinnerNumberModel minAgeModel = new SpinnerNumberModel(15, 14, 50, 1);

    private JLabel ageMaxText = new JLabel();
    private JSpinner maxAge = new JSpinner();
    private SpinnerNumberModel maxAgeModel = new SpinnerNumberModel(27, 14, 50, 1);


    private JLabel disableHintsText = new JLabel();
    private JCheckBox disableHints = new JCheckBox();

    private JLabel enableLegacyText = new JLabel();
    private JCheckBox enableLegacy = new JCheckBox();

    private JLabel genderText = new JLabel();
    private JComboBox gender = new JComboBox(GenderCreation.values());


    private JLabel placementText = new JLabel();
    private JComboBox destination = new JComboBox(DestinationsPlacement.values());

    private JButton startButton = new JButton();


    public Gui(String guiname) {
        int frameWidth = 260;
        int frameHeight = 280;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);

        emailNameText.setBounds(0, 0, 86, 20);
        emailNameText.setText("E-mail name:");
        cp.add(emailNameText);

        emailHostText.setBounds(0, 32, 86, 20);
        emailHostText.setText("E-mail host:");
        cp.add(emailHostText);

        email.setBounds(88, 0, 70, 20);
        cp.add(email);

        host.setBounds(88, 32, 70, 20);
        host.setText("gmail.com");
        cp.add(host);

        extensionText.setBounds(160, 0, 46, 20);
        extensionText.setText("index:");
        cp.add(extensionText);

        accountNameText.setBounds(0, 64, 86, 20);
        accountNameText.setText("Account name:");
        cp.add(accountNameText);

        name.setBounds(88, 64, 160, 20);
        cp.add(name);

        passwordText.setBounds(0, 96, 86, 20);
        passwordText.setText("Password:");
        cp.add(passwordText);

        password.setBounds(88, 96, 160, 20);
        cp.add(password);

        amountText.setBounds(160, 32, 46, 20);
        amountText.setText("amount:");
        cp.add(amountText);

        amount.setBounds(208, 32, 40, 24);
        amount.setValue(0);
        amount.setModel(extensionModel);
        cp.add(amount);

        extension.setBounds(208, 0, 40, 24);
        extension.setValue(0);
        extension.setModel(amountModel);
        cp.add(extension);

        genderText.setBounds(0, 128, 86, 20);
        genderText.setText("Gender:");
        cp.add(genderText);

        ageMinText.setBounds(152, 128, 54, 20);
        ageMinText.setText("min age");
        cp.add(ageMinText);

        minAge.setBounds(208, 128, 40, 24);
        minAge.setValue(0);
        minAge.setModel(minAgeModel);
        cp.add(minAge);

        maxAge.setBounds(208, 160, 40, 24);
        maxAge.setValue(0);
        maxAge.setModel(maxAgeModel);
        cp.add(maxAge);

        placementText.setBounds(0, 160, 86, 20);
        placementText.setText("Placement:");
        cp.add(placementText);

        disableHintsText.setBounds(0, 192, 86, 20);
        disableHintsText.setText("Disable Hints");
        cp.add(disableHintsText);

        enableLegacyText.setBounds(0, 224, 86, 20);
        enableLegacyText.setText("Enable Legacy");
        cp.add(enableLegacyText);

        disableHints.setBounds(88, 192, 28, 20);
        disableHints.setOpaque(true);
        cp.add(disableHints);

        enableLegacy.setBounds(88, 224, 28, 20);
        enableLegacy.setOpaque(true);
        cp.add(enableLegacy);

        ageMaxText.setBounds(152, 160, 54, 20);
        ageMaxText.setText("max age");
        cp.add(ageMaxText);

        gender.setSelectedIndex(2);
        gender.setBounds(88, 128, 62, 20);
        cp.add(gender);

        destination.setSelectedIndex(2);
        destination.setBounds(88, 160, 62, 20);
        cp.add(destination);

        startButton.setBounds(120, 195, 115, 55);
        startButton.setText("start");
        startButton.setMargin(new Insets(2, 2, 2, 2));
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                start_ActionPerformed(evt);
            }
        });
        cp.add(startButton);
        setVisible(true);
    }

    public void start_ActionPerformed(ActionEvent evt) {
        if (!email.getText().isEmpty() && !host.getText().isEmpty() && !password.getText().isEmpty() && ((Number) amount.getValue()).intValue() != 0) {
            if (name.getText().isEmpty()) {
                SettingsCreation.NAME = null;
            } else {
                SettingsCreation.NAME = name.getText();
            }

            SettingsCreation.E_MAIL = email.getText();
            SettingsCreation.EXTENSION_BASE = ((Number) extension.getValue()).intValue();
            SettingsCreation.DOMAIN = host.getText();
            SettingsCreation.PASSWORD = password.getText();
            SettingsCreation.MIN_AGE = ((Number) minAge.getValue()).intValue();
            SettingsCreation.MAX_AGE = ((Number) maxAge.getValue()).intValue();

            SettingsCreation.QUANTITY = ((Number) amount.getValue()).intValue();

            SettingsCreation.GENDER = (GenderCreation) gender.getSelectedItem();

            SettingsOptions.DISABLE_HINTS = disableHints.isSelected();
            SettingsOptions.ACTIVATE_LEGACY = enableLegacy.isSelected();

            SettingsPlacement.DESTINATION = (DestinationsPlacement) destination.getSelectedItem();
            SettingsSuperState.running = true;
            setVisible(false);
        }
    }
}
