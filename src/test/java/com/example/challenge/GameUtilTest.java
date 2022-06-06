package com.example.challenge;

import com.example.challenge.model.Game;
import com.example.challenge.model.Team;
import com.example.challenge.util.GameUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author German Magana
 */
public class GameUtilTest {

    @Test
    void shouldCalculatePointWhenTeam2Won() {

        //given
        Game game = new Game(new Team("test", 1), new Team("test2", 3));

        //when
        game.getTeam1().setPoints(GameUtil.calculatePoints(game.getTeam1(), game.getTeam2()));
        game.getTeam2().setPoints(GameUtil.calculatePoints(game.getTeam2(), game.getTeam1()));

        //then
        Assertions.assertEquals(3, game.getTeam2().getPoints());
        Assertions.assertEquals(0, game.getTeam1().getPoints());

    }

    @Test
    void shouldCalculatePointWhenTeam1Won() {

        //given
        Game game = new Game(new Team("test", 2), new Team("test2", 1));

        //when
        game.getTeam1().setPoints(GameUtil.calculatePoints(game.getTeam1(), game.getTeam2()));
        game.getTeam2().setPoints(GameUtil.calculatePoints(game.getTeam2(), game.getTeam1()));

        //then
        Assertions.assertEquals(0, game.getTeam2().getPoints());
        Assertions.assertEquals(3, game.getTeam1().getPoints());

    }

    @Test
    void shouldCalculatePointWhenDraw() {

        //given
        Game game = new Game(new Team("test", 1), new Team("test2", 1));

        //when
        game.getTeam1().setPoints(GameUtil.calculatePoints(game.getTeam1(), game.getTeam2()));
        game.getTeam2().setPoints(GameUtil.calculatePoints(game.getTeam2(), game.getTeam1()));

        //then
        Assertions.assertEquals(1, game.getTeam2().getPoints());
        Assertions.assertEquals(1, game.getTeam1().getPoints());

    }


}
