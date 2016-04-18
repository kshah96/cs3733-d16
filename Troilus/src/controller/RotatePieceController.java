package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.Kabasuji;
import model.Level;
import view.BullpenView;



public class RotatePieceController extends MouseAdapter{
	Kabasuji game;

	Level level;
	BullpenView bullpen;
	int degree;
	
	
	
	public RotatePieceController(Level level, Kabasuji game, BullpenView bullpen, int degree){

		this.game = game;
		this.bullpen = bullpen;
		this.level = level;
		this.degree = degree;
		
	}
	
	public void mousePressed(MouseEvent e) {
		level.getActivePiece().rotatePiece(degree);
	}
	
	

}