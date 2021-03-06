package com.olbimacoojam.heaven.yutnori;

import com.olbimacoojam.heaven.yutnori.point.PointName;
import com.olbimacoojam.heaven.yutnori.point.Points;
import com.olbimacoojam.heaven.yutnori.yut.Yut;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BoardTest {
    @Test
    @DisplayName("board 움직임 테스트(잡기)")
    void move_test() {
        Piece piece1 = new Piece(Color.BLACK, Points.get(PointName.DO));
        Piece piece2 = new Piece(Color.RED, Points.get(PointName.GAE));
        Piece piece3 = new Piece(Color.BLACK, Points.get(PointName.GUL));
        Piece piece4 = new Piece(Color.RED, Points.get(PointName.MO));

        Board board = new Board(Arrays.asList(piece1, piece2, piece3, piece4));
        MoveResults moveResults = board.move(Points.get(PointName.DO), Yut.DO);

        MoveResult moveResult1 = new MoveResult(piece1, new Route(Arrays.asList(Points.get(PointName.DO), Points.get(PointName.GAE))));
        MoveResult moveResult2 = new MoveResult(piece2, new Route(Arrays.asList(Points.get(PointName.GAE), Points.get(PointName.STANDBY))));
        MoveResults checkMoveResults = new MoveResults(Arrays.asList(moveResult1, moveResult2));
        assertThat(moveResults).isEqualTo(checkMoveResults);
    }

    @Test
    @DisplayName("board 움직임 테스트(엎기, 잡기)")
    void move_test2() {
        Piece piece1 = new Piece(Color.BLACK, Points.get(PointName.DO));
        Piece piece2 = new Piece(Color.RED, Points.get(PointName.GAE));
        Piece piece3 = new Piece(Color.BLACK, Points.get(PointName.GUL));
        Piece piece4 = new Piece(Color.RED, Points.get(PointName.MO));

        Board board = new Board(Arrays.asList(piece1, piece2, piece3, piece4));
        board.move(Points.get(PointName.DO), Yut.DO);
        board.move(Points.get(PointName.GAE), Yut.DO);
        MoveResults finalMoveResults = board.move(Points.get(PointName.GUL), Yut.GAE);


        MoveResult moveResult1 = new MoveResult(piece1, new Route(Arrays.asList(Points.get(PointName.GUL), Points.get(PointName.YUT), Points.get(PointName.MO))));
        MoveResult moveResult2 = new MoveResult(piece3, new Route(Arrays.asList(Points.get(PointName.GUL), Points.get(PointName.YUT), Points.get(PointName.MO))));
        MoveResult moveResult3 = new MoveResult(piece4, new Route(Arrays.asList(Points.get(PointName.MO), Points.getStandByPoint())));
        MoveResults checkMoveResults = new MoveResults(Arrays.asList(moveResult1, moveResult2, moveResult3));
        assertThat(finalMoveResults).isEqualTo(checkMoveResults);
    }
}