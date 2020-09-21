package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controller.GameButtonListener;
import model.WordGuessModel;

import java.awt.BorderLayout;
import javax.swing.JButton;

public class WordGuessPanel {

	public enum GameState{
		READY, PLAYING, GAMEOVER
	}

	private JFrame window;
	private GameCanvas canvas;
	private WordGuessModel game;
	private JButton newButton = new JButton("New");
	private JTextField gameKey = new JTextField("");
	private JTextField playerGuess = new JTextField("");
	public char[] alphabetLetter = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
								'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	private JButton[] letterButtons = new JButton[26];
	private GameState gameState = GameState.READY;


	public WordGuessPanel(JFrame window){
		this.window = window;
	}

	public void init(){
		Container cp = window.getContentPane();
		JPanel North = new JPanel();
		North.setLayout(new GridLayout(2, 1));
		gameKey.setEditable(false);
		playerGuess.setEditable(false);
		gameKey.setFont(new Font("Arial", Font.BOLD, 17));
		gameKey.setForeground(Color.red);
		playerGuess.setFont(new Font("Arial", Font.BOLD, 17));
		North.add(gameKey);
		North.add(playerGuess);


		JPanel Center = new JPanel();
		Center.setPreferredSize(new Dimension(500, 500));
		canvas = new GameCanvas(this);
		Center.add(BorderLayout.CENTER, canvas);


		JPanel South = new JPanel();
		South.setLayout(new GridLayout(4, 7));

		GameButtonListener listener = new GameButtonListener(this);
		newButton.addActionListener(listener);

		for(int i = 0; i < alphabetLetter.length; i++){
			letterButtons[i] = new JButton(Character.toString(alphabetLetter[i]));
			South.add(letterButtons[i]).setEnabled(false);
			letterButtons[i].addActionListener(listener);
		}
		South.add(newButton);
		
		cp.add(BorderLayout.CENTER, Center);
		cp.add(BorderLayout.NORTH, North);
		cp.add(BorderLayout.SOUTH, South);

	}

public JButton[] getLetterButtons(){
	return letterButtons;
}
public JButton getNewButton() {
	return newButton;
}
public GameState getGameState(){
	return gameState;
}
public void setGameState(GameState state){
	this.gameState = state;
}
public WordGuessModel getGame(){
	return game;
}
public void setGame(WordGuessModel game){
	this.game = game;
}
public JTextField getGameKey(){
	return gameKey;
}
public JTextField getPlayerGuess(){
	return playerGuess;
}
public GameCanvas getCanvas(){
	return canvas;
}

}