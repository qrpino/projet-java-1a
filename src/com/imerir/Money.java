package com.imerir;

public class Money {

    private double money = 0;
    private double adsCost = 0.15;
    private double limonadeCost = 0.02;

    /* fonction principale */
    public Money(double money) {
        this.money = money;

    }

    /* fonction permetant de payée les annonces */
    public void payAds(int nunAds) {
        money -= nunAds * adsCost;
    }

    /* fonction permetant de payée les lemonade */
    public void payLemonade(int numLemonde) {
        money -= numLemonde * limonadeCost;
    }

    /* fonction permetant de donner l'argent gagner de la journée */
    public void winMoney(double win) {
        money += win;
    }

    /* fonction permetant de retounée l'argent du joueur */
    public double getMoney() {
        return money;
    }

}
