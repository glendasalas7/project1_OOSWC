package model;

import java.util.ArrayList;
import java.util.Random;


public class WordGuessModel {
	
	private char guess;//letter guess
	private ArrayList<String> keyPool = new ArrayList<String>();
	private String key;
	private int healthDamage = 0;
	
	public WordGuessModel(){
		keyPool.add("communication");
		keyPool.add("science");
		keyPool.add("programming");
		keyPool.add("language");
		keyPool.add("difficulty");
		keyPool.add("artificial");
		keyPool.add("intelligence");
		keyPool.add("attempts");
		keyPool.add("screenshot");
		keyPool.add("baseball");
		keyPool.add("windows");
		keyPool.add("learning");
		keyPool.add("electronics");
		keyPool.add("beautiful");
		keyPool.add("internet");
		keyPool.add("database");
		keyPool.add("organization");
		keyPool.add("application");
		keyPool.add("network");
		keyPool.add("friendly");
		keyPool.add("validation");
		keyPool.add("attempts");
		keyPool.add("statistics");
		keyPool.add("physics");
		keyPool.add("chemistry");
		keyPool.add("engineering");
		keyPool.add("school");
		keyPool.add("industry");
		keyPool.add("revolution");
		keyPool.add("progress");
		keyPool.add("characters");
		keyPool.add("heavily");
		keyPool.add("graphics");
		generateKey();
	}

	public WordGuessModel(char guess){
		this.guess = guess;
	}
	public void setGuess(char letter){
		guess = letter;
	}
	public char getGuess(){
		return guess;
	}

	public void computeDamage(){
			for(int i = 0; i < key.length(); i++){
				if (guess == key.charAt(i)) return;
			}
			healthDamage++;
		}
	
	public int getHealthDamage(){
		return healthDamage;
	}

	private void generateKey(){
		Random r = new Random();
		key = keyPool.get(r.nextInt(34));
	}
	public String getKey(){
		return key;
	}
}
