package com.example.challenge;

import com.example.challenge.model.Game;
import com.example.challenge.model.Team;
import com.example.challenge.util.GameUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

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

    @Test
    void shouldSortMapByValue() {
        //given
        Map<String, Integer> map = new HashMap<>();
        map.put("Team 1", 2);
        map.put("Team 2", 5);
        map.put("Team 3", 6);

        //when
        LinkedHashMap<String, Integer> sortedMap = GameUtil.sortMapByValue(map);

        //then
        Assertions.assertEquals("Team 3", sortedMap.entrySet().iterator().next().getKey());
    }

    @Test
    void shouldGetName() {
        //given
        String teamName = "Lions 3";
        //when
        String name = GameUtil.getName(teamName);
        //then
        Assertions.assertEquals("Lions", name);

    }

    @Test
    void shouldGetPoint() {
        //given
        String teamAndScore = "Lions 3";
        //when
        Integer score = GameUtil.getScore(teamAndScore);
        //then
        Assertions.assertEquals(3, score);
    }

    @Test
    void shouldCreateGame() {
        //given
        String gameData = "Tarantulas 1, FC Awesome 0";
        //when
        Optional<Game> game = GameUtil.createGame(gameData);
        //then
        Assertions.assertTrue(game.isPresent());
        Assertions.assertEquals("Tarantulas", game.get().getTeam1().getName());
        Assertions.assertEquals(1, game.get().getTeam1().getScore());

    }

    @Test
    void shouldSumPointOfTeam1() {
        //given
        List<Game> games = new ArrayList<>();

        //when
        Game game1 = new Game(new Team("Team 1", 2, 3),
            new Team("Team 2", 2, 3));

        Game game2 = new Game(new Team("Team 1", 2, 3),
            new Team("Team 2", 2, 2));

        games.add(game1);
        games.add(game2);

        Map<String, Integer> sumMap = GameUtil.groupByTeam1(games);

        //then
        Assertions.assertEquals(6, sumMap.entrySet().iterator().next().getValue());

    }

    @Test
    void shouldSumPointOfTeam2() {
        //given
        List<Game> games = new ArrayList<>();

        //when
        Game game1 = new Game(new Team("Team 1", 2, 3),
            new Team("Team 2", 2, 3));

        Game game2 = new Game(new Team("Team 1", 2, 3),
            new Team("Team 2", 2, 2));

        games.add(game1);
        games.add(game2);

        Map<String, Integer> sumMap = GameUtil.groupByTeam2(games);

        //then
        Assertions.assertEquals(5, sumMap.entrySet().iterator().next().getValue());

    }

    @Test
    void shouldReturnEmpty() {
        //given
        String gameData="";
        //when
        Optional<Game> game = GameUtil.createGame(gameData);
        //then
        Assertions.assertFalse(game.isPresent());
    }


}
