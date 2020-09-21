package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import model.WordGuessModel;
import view.WordGuessPanel;

public class GameButtonListener implements ActionListener {

	private WordGuessPanel panel;

	public GameButtonListener(WordGuessPanel panel){
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		if(button == panel.getNewButton()){
			String guesses = "";
			var game = new WordGuessModel();
			panel.setGame(game);
			panel.setGameState(WordGuessPanel.GameState.PLAYING);
			String key = game.getKey();
			panel.getGameKey().setText(key);

			for(int i = 0; i < key.length(); i++){
				guesses += '.';
			}
			panel.getPlayerGuess().setText(guesses);
			for(var b: panel.getLetterButtons()){
				b.setEnabled(true);
			}
			panel.getCanvas().setDamage(0);
			panel.getCanvas().repaint();
		} else{
			WordGuessModel game = panel.getGame();
			String key = game.getKey();
			String guesses = panel.getPlayerGuess().getText();
			String n = button.getText();
			button.setEnabled(false);
			game.setGuess(n.charAt(0));
			for(int i = 0; i < key.length(); i++){
				if(n.charAt(0) == key.charAt(i)){
					int index = i;
					char replace = n.charAt(0);
					guesses = guesses.substring(0, index) + replace + guesses.substring(index + 1); 
					panel.getPlayerGuess().setText(guesses);
				}
			}
			if(guesses.equals(key)){
				panel.setGameState(WordGuessPanel.GameState.GAMEOVER);
				for(var b:panel.getLetterButtons()){
					b.setEnabled(false);
				}
			}
			game.computeDamage();
			int damage = game.getHealthDamage();
			panel.getCanvas().setDamage(damage);

			if(damage == 5){
					panel.setGameState(WordGuessPanel.GameState.GAMEOVER);
					for(var b:panel.getLetterButtons()){
						b.setEnabled(false);
					}
				}
				panel.getCanvas().repaint();
			}
		}
	}