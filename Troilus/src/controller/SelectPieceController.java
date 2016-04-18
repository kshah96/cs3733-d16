package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import model.Kabasuji;
import model.Level;
import model.LevelBuilder;
import model.Piece;
import view.LevelLoaderView;
import view.LevelView;

public class SelectPieceController extends MouseAdapter{
	Kabasuji game;

	Level level;
	LevelView levelView;
	LevelBuilder builder;
	LevelLoaderView editorView;
	

	public SelectPieceController(Kabasuji game,Level level, LevelView levelView){
		this.level = level;
		this.game = game;
		this.levelView = levelView;
		
	}
	
	public SelectPieceController(LevelBuilder builder,Level level, LevelLoaderView editorView){
		this.level = level;
		this.builder = builder;
		this.editorView = editorView;
		
	}
	
	
	
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		if(x > 370 || x < 10 || y > 390 || y < 30)
		{
			System.out.println("Error: Did not click within the board");
		}
		else {
		ArrayList<Piece> pieces= new ArrayList<Piece>();
		pieces = level.getBoard().getPieces();
		
		
			
			Piece activePiece = new Piece(null, null, -1);
			activePiece = level.getBoard().getPiece((x/30), (y/30));
			if(activePiece.getAnchor() == null){
				System.out.print("Invalid Piece");
			}
			else 
				level.setActivePiece(activePiece);
		
		}//end check bounds else
		
	}
}
