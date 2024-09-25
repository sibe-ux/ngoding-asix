package com.javaoop.kelas_terbuka.staticMethod;

import java.util.ArrayList;


class Hero{

    private static int numberOfPlayer;
    private static ArrayList<String> nameList = new ArrayList<String>();

    private String name;

    Hero(String name){
        this.name = name;
        Hero.numberOfPlayer++;
        Hero.nameList.add(this.name);
    }

    void show(){
        System.out.println("Player name = " + this.name);
    }

    // static method
    static void showNumberOfPlayer(){
        System.out.println("Number of Player = " + Hero.numberOfPlayer);
    }

    static ArrayList<String> getNames(){
        return Hero.nameList;
    }

}

class staticMethod{
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Hero Hero1 = new Hero("Saitama");
        Hero Hero2 = new Hero("All Mighty");
        Hero player3 = new Hero("Midnight");
        Hero player4 = new Hero("Mt Lady");

        Hero.showNumberOfPlayer();
        
        System.out.println("Names = " + Hero.getNames());
        // System.out.println("Names = " + player1.getNames()); // ini bisa dilakukan
        
    }
}
