package board;

import board.Board.Builder;
import pieces.Piece;

/***
 * Move.java will contain the Move class and its children which are responsible
 * for the intricacies of move logic.
 */

public abstract class Move {

	final protected Board board;
	final protected Piece movedPiece;
	final protected int destinationTileCoordinate;

	public Move(Board board, Piece movedPiece, int destinationTileCoordinate) {
		this.board = board;
		this.movedPiece = movedPiece;
		this.destinationTileCoordinate = destinationTileCoordinate;
	}

	public int getDestinationTileCoordinate() {
		return destinationTileCoordinate;
	}

	public Piece getMovedPiece() {
		return movedPiece;
	}

	public abstract Board executeMoveAndBuildBoard(); // This method returns a board modified depending on the move

	public static final class NonAttackingMove extends Move {

		public NonAttackingMove(Board board, Piece movedPiece, int destinationTile) {
			super(board, movedPiece, destinationTile);
		}

		@Override
		public Board executeMoveAndBuildBoard() {
			final Builder b = new Builder(); // Use this builder to return the new board

			for (Piece piece : board.getActiveBlackPieces()) {
				if (!(piece.equals(movedPiece))) {
					b.setPiece(piece);
				}
			}

			for (Piece piece : board.getActiveWhitePieces()) {
				if (!(piece.equals(movedPiece))) {
					b.setPiece(piece);
				}
			}

			b.setPiece(movedPiece.movePiece(this));
			b.setNextPlayerToMove(board.getCurrentPlayer().getAlliance().getOpponent());

			return b.build();
		}
	}

	public static final class AttackingMove extends Move {

		final protected Piece attackedPiece;

		public AttackingMove(Board board, Piece movedPiece, int destinationTile, Piece attackedPiece) {
			super(board, movedPiece, destinationTile);
			this.attackedPiece = attackedPiece;
		}

		@Override
		public Board executeMoveAndBuildBoard() {
			final Builder b = new Builder(); // Use this builder to return the new board

			for (Piece piece : board.getActiveBlackPieces()) {
				if (!(piece.equals(movedPiece)) && !(piece.equals(attackedPiece))) {
					b.setPiece(piece);
				}
			}

			for (Piece piece : board.getActiveWhitePieces()) {
				if (!(piece.equals(movedPiece)) && !(piece.equals(attackedPiece))) {
					b.setPiece(piece);
				}
			}

			b.setPiece(movedPiece.movePiece(this));
			b.setNextPlayerToMove(board.getCurrentPlayer().getAlliance().getOpponent());

			return b.build();
		}
	}
	
	// Add Pawn move/attackmove
	
	// Add CastlingMove
	
	// Add en passent
	
	

}
