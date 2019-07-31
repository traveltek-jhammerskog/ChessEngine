package pieces;

import java.util.Collections;
import java.util.Set;

import board.Board;
import board.BoardUtility;
import board.Move;
import board.Player;
import board.Tile;
import board.Move.NonAttackingMove;



public class King extends Piece {

	protected King(int piecePosition, Player playerColour) {
		super(piecePosition, playerColour);
		
	}
	
	int[] possibleKingMoves = { -9, -8, -7, -1, 1, 7 , 8, 9 }; 
	
	@Override
	public Set<Move> calculateLegalMoves(Board board) { // the bulk of this function could be put in Piece and inhereted by King/pawn/Knight
		
		Set<Move> legalMoves = Collections.EMPTY_SET;
		int candidateCoordinate;
		
		for (int candidateMove : possibleKingMoves) {
			candidateCoordinate = this.piecePosition + candidateMove;

			if (BoardUtility.validDestinationTile(candidateCoordinate)) { 

				Tile candidateTile = board.getTile(candidateCoordinate); 

				if (!candidateTile.tileIsOccupied() /*&& tile is not attacked*/) {

					legalMoves.add(new NonAttackingMove(board, this, candidateTile)); // Move logic not yet finished
					// System.out.println("NEW LEGAL MOVE FOR TESTING: " + candidateCoordinate);

				} else {

					Piece pieceAtCandidateDestination = candidateTile.getPiece();
					Player pieceColour = pieceAtCandidateDestination.getPieceColour();

					if (pieceColour != this.playerColour /* && piece is not defended */) {
						legalMoves.add(new Move()); // AttackingMove
					}
				}
			}

		}
		
		
		
		return legalMoves;
	}

}
