package model;

import java.util.ArrayList;

public class Bullpen {
	ArrayList<Piece> pieces;
	
	// TODO: Is there any case where we will need to pass parameters to the constructor?
	public Bullpen(){
		pieces = new ArrayList<Piece>();
	}

	// TODO: Do we need these methods? Should they return void or boolean?
	//Adds the specified piece to the bullpen
	public void addPiece(Piece p){
		this.pieces.add(p);
	}
	
	public void removePiece(Piece p){
		this.pieces.remove(p);
	}
	
	// TODO: Assumed we would need to be able to get a piece from the bullpen so I added this
	public Piece getPiece(int row, int col){
		for(int i = 0; i < pieces.size(); i++){
			if(pieces.get(i).row == row && pieces.get(i).col == col){
				return pieces.get(i);
			}
		}
		return null;
	}
}

