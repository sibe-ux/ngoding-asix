package com.javaoop.kelas_terbuka.polymorphisme;

public class HeroIntel extends Hero{
	String type = "intel";

	HeroIntel(String nama){
		super(nama);
	}

	@Override
	void display(){
		super.display();
		System.out.println("Type \t: " + this.type);
	}
}
