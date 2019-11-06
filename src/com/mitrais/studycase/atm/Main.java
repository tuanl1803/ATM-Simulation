package com.mitrais.studycase.atm;

import com.mitrais.studycase.atm.views.WelcomeScreen;

public class Main {

    public static void main(String[] args) {
        WelcomeScreen welcomeScreen = new WelcomeScreen();
        while (true) {
            welcomeScreen.showScreen();
        }
    }
}
