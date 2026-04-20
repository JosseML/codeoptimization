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
        int result = 0;
        
        int minutes = stats.minutes;
        int goals = stats.goals;
        int assistances = stats.assists;
        boolean yellow = stats.yellowCard;
        boolean red = stats.redCard;
        int saves = stats.saves;
        int goals_against = stats.goalsAgainst;
        char match_result = stats.matchResult;
        String position = stats.position;

        // --- GOALKEEPER LOGIC ---
        if (position.equals("PORTERO")) {
            
            if (minutes > 0 && minutes < 60) {
                result = result + 3;
            } else if (minutes >= 60) {
                result = result + 5;
            }

            for (int i = 0; i < goals; i++) {
                result = result + 5;
            }

            result = result + (assistances * 6);

            // 1 point per save
            result = result + saves; 
            
            if (goals_against == 0) {
                result = result + 5; 
            } else if (goals_against == 1) {
                result = result + 3;
            } else if (goals_against == 2) {
                result = result + 1;
            }

            if (yellow == true) result = result - 3; 
            if (red == true) result = result - 5;
            
            if (match_result == 'G') {
                result = result + 5;
            } else if (match_result == 'E') {
                result = result + 2;
            }

        // --- DEFENDER LOGIC ---
        } else if (position.equals("DEFENSA")) {
            if (minutes > 0 && minutes < 60) {
                result = result + 3;
            } else if (minutes >= 60) {
                result = result + 5;
            }

            for (int i = 0; i < goals; i++) {
                result = result + 5;
            }

            result = result + (assistances * 6);

            if (goals_against == 0) {
                result = result + 5; 
            } else if (goals_against == 1) {
                result = result + 3;
            } else if (goals_against == 2) {
                result = result + 1;
            }

            if (yellow == true) result = result - 3;
            if (red == true) result = result - 5;
            
            if (match_result == 'G') {
                result = result + 5;
            } else if (match_result == 'E') {
                result = result + 2;
            }

        // --- MIDFIELDER LOGIC ---
        } else if (position.equals("MEDIO")) {
            if (minutes > 0 && minutes < 60) {
                result = result + 3;
            } else if (minutes >= 60) {
                result = result + 5;
            }

            for (int i = 0; i < goals; i++) {
                result = result + 5;
            }

            result = result + (assistances * 6);

            if (yellow == true) result = result - 3;
            if (red == true) result = result - 5;
            
            if (match_result == 'G') {
                result = result + 5;
            } else if (match_result == 'E') {
                result = result + 2;
            }

        // --- FORWARD LOGIC ---
        } else if (position.equals("DELANTERO")) {
            if (minutes > 0 && minutes < 60) {
                result = result + 3;
            } else if (minutes >= 60) {
                result = result + 5;
            }

            for (int i = 0; i < goals; i++) {
                result = result + 6;
            }

            result = result + (assistances * 5);

            if (yellow == true) result = result - 3;
            if (red == true) result = result - 5;
            
            if (match_result == 'G') {
                result = result + 5;
            } else if (match_result == 'E') {
                result = result + 2;
            }
        }

        return result;
    }
}