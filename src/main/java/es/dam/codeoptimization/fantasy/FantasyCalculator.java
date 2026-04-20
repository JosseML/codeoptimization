/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.dam.codeoptimization.fantasy;
import es.dam.codeoptimization.PlayerStats;

/**
 * THE CLASS YOU HAVE TO MODIFY
 * @author Jose
 */
public class FantasyCalculator {

    // Method to calculate the points
    public static int calculatePoints(PlayerStats stats) {
        int r = 0;
        
        int minutes = stats.minutes;
        int goals = stats.goals;
        int assistances = stats.assists;
        boolean yellow = stats.yellowCard;
        boolean red = stats.redCard;
        int saves = stats.saves;
        int goals_against = stats.goalsAgainst;
        char result = stats.matchResult;
        String position = stats.position;

        // --- GOALKEEPER LOGIC ---
        if (position.equals("PORTERO")) {
            
            if (minutes > 0 && minutes < 60) {
                r = r + 3;
            } else if (minutes >= 60) {
                r = r + 5;
            }

            for (int i = 0; i < goals; i++) {
                r = r + 5;
            }

            r = r + (assistances * 6);

            // 1 point per save
            r = r + saves; 
            
            if (goals_against == 0) {
                r = r + 5; 
            } else if (goals_against == 1) {
                r = r + 3;
            } else if (goals_against == 2) {
                r = r + 1;
            }

            if (yellow == true) r = r - 3; 
            if (red == true) r = r - 5;
            
            if (result == 'G') {
                r = r + 5;
            } else if (result == 'E') {
                r = r + 2;
            }

        // --- DEFENDER LOGIC ---
        } else if (position.equals("DEFENSA")) {
            if (minutes > 0 && minutes < 60) {
                r = r + 3;
            } else if (minutes >= 60) {
                r = r + 5;
            }

            for (int i = 0; i < goals; i++) {
                r = r + 5;
            }

            r = r + (assistances * 6);

            if (goals_against == 0) {
                r = r + 5; 
            } else if (goals_against == 1) {
                r = r + 3;
            } else if (goals_against == 2) {
                r = r + 1;
            }

            if (yellow == true) r = r - 3;
            if (red == true) r = r - 5;
            
            if (result == 'G') {
                r = r + 5;
            } else if (result == 'E') {
                r = r + 2;
            }

        // --- MIDFIELDER LOGIC ---
        } else if (position.equals("MEDIO")) {
            if (minutes > 0 && minutes < 60) {
                r = r + 3;
            } else if (minutes >= 60) {
                r = r + 5;
            }

            for (int i = 0; i < goals; i++) {
                r = r + 5;
            }

            r = r + (assistances * 6);

            if (yellow == true) r = r - 3;
            if (red == true) r = r - 5;
            
            if (result == 'G') {
                r = r + 5;
            } else if (result == 'E') {
                r = r + 2;
            }

        // --- FORWARD LOGIC ---
        } else if (position.equals("DELANTERO")) {
            if (minutes > 0 && minutes < 60) {
                r = r + 3;
            } else if (minutes >= 60) {
                r = r + 5;
            }

            for (int i = 0; i < goals; i++) {
                r = r + 6;
            }

            r = r + (assistances * 5);

            if (yellow == true) r = r - 3;
            if (red == true) r = r - 5;
            
            if (result == 'G') {
                r = r + 5;
            } else if (result == 'E') {
                r = r + 2;
            }
        }

        return r;
    }
}
