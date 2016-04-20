package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Level;
import model.LevelBuilder;
import model.Piece;
import model.Square;
import view.LevelLoaderView;

public class ToggleSquareController extends MouseAdapter{
	
	

	Level level;
	LevelBuilder builder;
	LevelLoaderView editorView;

	
	public ToggleSquareController(LevelBuilder builder,Level level, LevelLoaderView editorView){
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
			int row = (x-10)/30;
			int col = (y-30)/30;
			Square toggle = level.getBoard().getSquare(row,col);
				if(toggle == null){
					System.out.print("No piece here.");
				}
				else if(toggle.isValid() == false)//OutOfBoundsSquare, toggle on
					level.getBoard().toggleSquareOn(row, col);
				else if(toggle.isValid() == true){
					level.getBoard().toggleSquareOff(row, col);
					
				}
				
				
				}//end check bounds else
		
	}
	

}