package com.imerir;

import java.util.Random;

public class Day {

    private int minRand = 0;
    private int maxRand = 13;
    private Weather weather;
    private int date;

    /* fonction permetant de crée le premier jour */
    public Day() {
        date = 1;
        randWeather();
        System.out.println("Day : " + date + ", Weather : " + weather);
    }

    /* fonction permetant de un jour X */
    public Day(int date) {
        this.date = date;
        randWeather();
        System.out.println("Day : " + date + ", Weather : " + weather);

    }

    public int getDate() {
        return date;
    }

    /* fonction permetant de retournée la météo */
    public Weather getWeather() {
        return weather;
    }

    /* fonction permetant de passer au jour suivant */
    public void nextDay() {
        date += 1;
        new Day(date);
    }

    /* fonction permetant de generai aleatoirement la météo */
    public void randWeather () {
        Random random = new Random();
        int randNum = random.nextInt(maxRand - minRand) + minRand;

        if (randNum <= 2 && randNum >= 0) {
            weather = Weather.RAIN;
        }else if (randNum <= 5 && randNum >= 3){
            weather = Weather.CLOUDY;
        } else if (randNum <= 10 && randNum >= 6){
            weather = Weather.SUNNY;
        } else if (randNum <= 14 && randNum >= 11) {
            weather = Weather.HOT;
        }
    }

}
