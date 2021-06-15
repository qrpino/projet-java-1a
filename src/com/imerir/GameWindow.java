package com.imerir;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GameWindow extends JFrame implements ChangeListener {

    JFrame parent;
    Game game;

    JSlider sliderNbLemonade, sliderNbAds, sliderLemonadeSellPrice;

    JLabel labelNbLemonade, labelNbAds, labelLemonadeSellPrice, labelMoney;

    JLabel labelActualMoney, labelAdsProduction, labelTrueBenef, labelLemonageProduction;

    JButton next = new JButton(new ImageIcon(getClass().getResource("/next.png")));

    public GameWindow(JFrame parent, Game game) {
        this.parent = parent;
        this.game = game;

        setTitle("Lemonade Stand Day: " + game.dayId);
        setBounds(0,0,600,400);

        SpringLayout layout = new SpringLayout();

        JPanel panel = new JPanel();
        panel.setLayout(layout);
        setContentPane(panel);

        labelMoney = new JLabel();

        labelMoney.setText("Money : " + String.valueOf(game.getCurrentPlayer().getMoney()));

        labelNbLemonade = new JLabel();

        sliderNbLemonade = new JSlider(0, 100, 10);

        sliderNbLemonade.setPaintTrack(true);
        sliderNbLemonade.setPaintTicks(true);
        sliderNbLemonade.setPaintLabels(true);

        sliderNbLemonade.setMajorTickSpacing(20);
        sliderNbLemonade.setMinorTickSpacing(10);

        sliderNbLemonade.addChangeListener(this);


        labelNbAds = new JLabel();

        sliderNbAds = new JSlider(0, 30, 2);

        sliderNbAds.setPaintTrack(true);
        sliderNbAds.setPaintTicks(true);
        sliderNbAds.setPaintLabels(true);

        sliderNbAds.setMajorTickSpacing(10);
        sliderNbAds.setMinorTickSpacing(2);

        sliderNbAds.addChangeListener(this);

        labelLemonadeSellPrice = new JLabel();

        sliderLemonadeSellPrice = new JSlider(0, 100, 1);

        sliderLemonadeSellPrice.setPaintTrack(true);
        sliderLemonadeSellPrice.setPaintTicks(true);
        sliderLemonadeSellPrice.setPaintLabels(true);

        sliderLemonadeSellPrice.setMajorTickSpacing(15);
        sliderLemonadeSellPrice.setMinorTickSpacing(5);

        sliderLemonadeSellPrice.addChangeListener(this);

        labelNbLemonade.setText("Number of Lemonade : " + String.valueOf(sliderNbLemonade.getValue()));
        labelNbAds.setText("Number of Ads : " + String.valueOf(sliderNbAds.getValue()));
        labelLemonadeSellPrice.setText("Price of Lemonade : " + String.valueOf(sliderLemonadeSellPrice.getValue()));

        next.addActionListener(this::nextDay);
        next.setSize(224, 59);

        layout.putConstraint(SpringLayout.WEST, labelNbLemonade, 50, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, labelNbLemonade, 25, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.NORTH, sliderNbLemonade, 25, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, sliderNbLemonade, 20, SpringLayout.EAST, labelNbLemonade);

        layout.putConstraint(SpringLayout.WEST, labelNbAds, 50, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, labelNbAds, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.NORTH, sliderNbAds, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, sliderNbAds, 20, SpringLayout.EAST, labelNbAds);

        layout.putConstraint(SpringLayout.WEST, labelLemonadeSellPrice, 50, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, labelLemonadeSellPrice, 175, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.NORTH, sliderLemonadeSellPrice, 175, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, sliderLemonadeSellPrice, 20, SpringLayout.EAST, labelLemonadeSellPrice);

        layout.putConstraint(SpringLayout.WEST, next, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, next, 230, SpringLayout.NORTH, panel);

        panel.add(sliderNbLemonade);
        panel.add(labelNbLemonade);

        panel.add(sliderNbAds);
        panel.add(labelNbAds);

        panel.add(sliderLemonadeSellPrice);
        panel.add(labelLemonadeSellPrice);

        panel.add(labelMoney);
        panel.add(next);

        this.setVisible(true);
    }

    void nextDay(ActionEvent event) {
        game.questionGui(sliderNbLemonade.getValue(), sliderNbAds.getValue(), sliderLemonadeSellPrice.getValue());
        JDialog dialog = new JDialog(parent, "Bilan de la journee", true);
        dialog.setSize(200, 200);
        FlowLayout experimentLayout = new FlowLayout();
        dialog.setLayout(experimentLayout);

        labelActualMoney = new JLabel();
        labelActualMoney.setText("ACTUAL MONEY : " + String.valueOf(game.getSellFactory().getActualMoney()));
        dialog.add(labelActualMoney);

        labelAdsProduction = new JLabel();
        labelAdsProduction.setText("ADS PRODUCTION : " + String.valueOf(game.getSellFactory().getAdsProduction()));
        dialog.add(labelAdsProduction);

        labelTrueBenef = new JLabel();
        labelTrueBenef.setText("TRUE BENEFITS : " + String.valueOf(game.getSellFactory().getTrueBenef()));
        dialog.add(labelTrueBenef);

        labelLemonageProduction = new JLabel();
        labelLemonageProduction.setText("LEMONADE SOLD : " + String.valueOf(game.getSellFactory().getLemonadeProduction()));
        dialog.add(labelLemonageProduction);

        dialog.setVisible(true);
        setTitle("Lemonade Stand Day: " + game.dayId);
        labelMoney.setText("Money : " + String.valueOf(game.getCurrentPlayer().getMoney()));

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        labelNbLemonade.setText("Number of Lemonage : " + String.valueOf(sliderNbLemonade.getValue()));
        labelNbAds.setText("Number of Ads : " + String.valueOf(sliderNbAds.getValue()));
        labelLemonadeSellPrice.setText("Price of Lemonade : " + String.valueOf(sliderLemonadeSellPrice.getValue()));
    }
}