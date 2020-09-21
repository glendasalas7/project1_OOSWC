package view;

import javax.swing.JPanel;

import model.WordGuessModel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.util.ArrayList;


public class GameCanvas extends JPanel{

	private WordGuessPanel panel;
	private ArrayList<WordGuessModel> lifeBar = new ArrayList<>();
	int damage = 0;
	
	public GameCanvas(WordGuessPanel panel){
		this.panel = panel;
		setPreferredSize(new Dimension(500, 500));
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		WordGuessPanel.GameState state = panel.getGameState();
		if (state == WordGuessPanel.GameState.READY){
			g2.setColor(Color.BLUE);
			g2.setFont(new Font("Arial", Font.PLAIN, 30));
			g2.drawString("Press <New> to Start", 100, 150);
		}else if(state == WordGuessPanel.GameState.GAMEOVER){
			if(damage == 5){
				g2.setColor(Color.RED);
				g2.setFont(new Font("Arial", Font.BOLD, 30));
				g2.drawString("You Lost ! ! !", 100, 100);
				g2.setColor(Color.BLUE);
				g2.setFont(new Font("Arial", Font.PLAIN, 30));
				g2.drawString("Press <New> to Start", 100, 150);
			}
			else if(damage != 5){
				g2.setColor(Color.RED);
				g2.setFont(new Font("Arial", Font.BOLD, 30));
				g2.drawString("You Won!!!", 100, 100);
				g2.setColor(Color.BLUE);
				g2.setFont(new Font("Arial", Font.BOLD, 30));
				g2.drawString("Press <New> to Start", 100, 150);
			}
		} else{
			g2.setColor(Color.BLUE);
			g2.setFont(new Font("Arial", Font.PLAIN, 40));
			g2.drawString("Health Level" ,100, 50);

			if(damage == 0){
				g2.setColor(Color.BLUE);
				g2.fillRect(100, 70, 50, 50);
				g2.fillRect(160, 70, 50, 50);
				g2.fillRect(220, 70, 50, 50);
				g2.fillRect(280, 70, 50, 50);
				g2.fillRect(340, 70, 50, 50);
			} else if(damage == 1){
				for(int i = 0; i < 1; i++){
				g2.fillRect(100, 70, 50, 50);
				g2.fillRect(160, 70, 50, 50);
				g2.fillRect(220, 70, 50, 50);
				g2.fillRect(280, 70, 50, 50);
				}
			} else if(damage == 2){
				for(int i = 0; i < 2; i++){
					g2.setColor(Color.BLUE);
					g2.fillRect(100, 70, 50, 50);
					g2.fillRect(160, 70, 50, 50);
					g2.fillRect(220, 70, 50, 50);
				}
			} else if(damage== 3){
				for(int i = 0; i < 3; i++){
					g2.setColor(Color.BLUE);
					g2.fillRect(100, 70, 50, 50);
					g2.fillRect(160, 70, 50, 50);
				}
			} else if(damage== 4){
				for(int i = 0; i < 4; i++){
					g2.setColor(Color.BLUE);
					g2.fillRect(100, 70, 50, 50);
				}
			}
	}	
}
	public ArrayList<WordGuessModel> getLifeBar(){
		return lifeBar;
	}
	public void setDamage(int damage){
		this.damage = damage;
	}
}

	