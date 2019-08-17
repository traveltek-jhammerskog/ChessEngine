package player;

import java.util.List;

import board.Alliance;
import board.Board;
import board.Move;
import pieces.Piece;

public class WhitePlayer extends Player {

	public WhitePlayer(Board board, List<Move> whiteLegalMovesInPosition, List<Move> blackLegalMovesInPosition) {
		super(board, whiteLegalMovesInPosition, blackLegalMovesInPosition);
	}

	public List<Piece> getActivePieces() {
		return this.board.getActiveWhitePieces();
	}

	@Override
	public Alliance getAlliance() {
		return Alliance.WHITE;
	}

	@Override
	public Alliance getOpponentAlliance() {
		return Alliance.BLACK;
	}

	public String toString() {
		return "WHITE";
	}

	// White Castling logic here if you have time

}
