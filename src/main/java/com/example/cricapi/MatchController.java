package com.example.cricapi;

import com.ctc.wstx.util.StringUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author navaneshwar
 * @Date 27/03/22
 */

@RestController
public class MatchController {

    public static final Pattern catchPattern = Pattern.compile("c ([a-zA-z ]*) b ([a-zA-z ]*)", Pattern.CASE_INSENSITIVE);
    public static final Pattern stumpedPattern = Pattern.compile("st ([a-zA-z ]*) b ([a-zA-z ]*)", Pattern.CASE_INSENSITIVE);
    public static final Pattern runOutPattern = Pattern.compile("run out \\(([a-zA-z ]*)\\/([a-zA-z ]*)\\)\n", Pattern.CASE_INSENSITIVE);

    @GetMapping(value = "/test",
            produces = MediaType.APPLICATION_JSON_VALUE )
    public String getMatchResponse() {
           return "App is fine";
        }

    @GetMapping(value = "/getMatch",
            produces = MediaType.APPLICATION_JSON_VALUE )
    public MatchResponse getMatchResponse(@RequestParam String matchId) {
        try {

            if(matchId.equals("test")) {
                MatchResponse matchResponse =  new MatchResponse();
                matchResponse.setType("type cpoune");
                return  matchResponse;
            }

            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://unofficial-cricbuzz.p.rapidapi.com/matches/get-scorecard?matchId=" + matchId)
                    .get()
                    .addHeader("X-RapidAPI-Host", "unofficial-cricbuzz.p.rapidapi.com")
                    .addHeader("X-RapidAPI-Key", "8df2f59a25msh5df00509f3d3039p128cd6jsn9e7aac9345e9")
                    .build();


            Response response = client.newCall(request).execute();
            //Match match = new Gson().fromJson("{\"scorecard\":[{\"inningsId\":1,\"batsman\":[{\"id\":576,\"balls\":32,\"runs\":41,\"fours\":4,\"sixes\":2,\"strkRate\":\"128.12\",\"name\":\"Rohit\",\"isCaptain\":true,\"outDec\":\"c Rovman Powell b Kuldeep Yadav\",\"isKeeper\":false},{\"id\":10276,\"balls\":48,\"runs\":81,\"fours\":11,\"sixes\":2,\"strkRate\":\"168.75\",\"name\":\"Ishan Kishan\",\"isCaptain\":false,\"outDec\":\"not out\",\"isKeeper\":true},{\"id\":10947,\"balls\":9,\"runs\":8,\"fours\":0,\"sixes\":0,\"strkRate\":\"88.89\",\"name\":\"Anmolpreet Singh\",\"isCaptain\":false,\"outDec\":\"c Lalit Yadav b Kuldeep Yadav\",\"isKeeper\":false},{\"id\":14504,\"balls\":15,\"runs\":22,\"fours\":3,\"sixes\":0,\"strkRate\":\"146.67\",\"name\":\"Tilak Varma\",\"isCaptain\":false,\"outDec\":\"c Prithvi Shaw b Khaleel Ahmed\",\"isKeeper\":false},{\"id\":657,\"balls\":6,\"runs\":3,\"fours\":0,\"sixes\":0,\"strkRate\":\"50\",\"name\":\"Pollard\",\"isCaptain\":false,\"outDec\":\"c Seifert b Kuldeep Yadav\",\"isKeeper\":false},{\"id\":13169,\"balls\":8,\"runs\":12,\"fours\":0,\"sixes\":1,\"strkRate\":\"150\",\"name\":\"Tim David\",\"isCaptain\":false,\"outDec\":\"c Mandeep b Khaleel Ahmed\",\"isKeeper\":false},{\"id\":13162,\"balls\":2,\"runs\":7,\"fours\":0,\"sixes\":1,\"strkRate\":\"350\",\"name\":\"Daniel Sams\",\"isCaptain\":false,\"outDec\":\"not out\",\"isKeeper\":false},{\"id\":8796,\"balls\":0,\"runs\":0,\"fours\":0,\"sixes\":0,\"strkRate\":\"0\",\"name\":\"M Ashwin\",\"isCaptain\":false,\"isKeeper\":false},{\"id\":9311,\"balls\":0,\"runs\":0,\"fours\":0,\"sixes\":0,\"strkRate\":\"0\",\"name\":\"Bumrah\",\"isCaptain\":false,\"isKeeper\":false},{\"id\":7860,\"balls\":0,\"runs\":0,\"fours\":0,\"sixes\":0,\"strkRate\":\"0\",\"name\":\"Tymal Mills\",\"isCaptain\":false,\"isKeeper\":false},{\"id\":10267,\"balls\":0,\"runs\":0,\"fours\":0,\"sixes\":0,\"strkRate\":\"0\",\"name\":\"Basil Thampi\",\"isCaptain\":false,\"isKeeper\":false}],\"bowler\":[{\"id\":8683,\"overs\":\"4\",\"runs\":47,\"economy\":\"11.8\",\"name\":\"Thakur\",\"wickets\":0},{\"id\":10952,\"overs\":\"4\",\"runs\":27,\"economy\":\"6.8\",\"name\":\"Khaleel Ahmed\",\"wickets\":2},{\"id\":8808,\"overs\":\"4\",\"runs\":40,\"economy\":\"10\",\"name\":\"Axar\",\"wickets\":0},{\"id\":12092,\"overs\":\"2\",\"runs\":29,\"economy\":\"14.5\",\"name\":\"K Nagarkoti\",\"wickets\":0},{\"id\":8292,\"overs\":\"4\",\"runs\":18,\"economy\":\"4.5\",\"name\":\"Kuldeep Yadav\",\"wickets\":3},{\"id\":13252,\"overs\":\"2\",\"runs\":15,\"economy\":\"7.5\",\"name\":\"Lalit Yadav\",\"wickets\":0}],\"fow\":[{\"batsmanId\":0,\"overNbr\":0.0,\"runs\":0,\"ballNbr\":0,\"fow\":[{\"batsmanId\":576,\"batsmanName\":\"Rohit\",\"overNbr\":8.2,\"runs\":67,\"ballNbr\":82},{\"batsmanId\":10947,\"batsmanName\":\"Anmolpreet Singh\",\"overNbr\":10.4,\"runs\":83,\"ballNbr\":104},{\"batsmanId\":14504,\"batsmanName\":\"Tilak Varma\",\"overNbr\":14.2,\"runs\":117,\"ballNbr\":142},{\"batsmanId\":657,\"batsmanName\":\"Pollard\",\"overNbr\":15.5,\"runs\":122,\"ballNbr\":155},{\"batsmanId\":13169,\"batsmanName\":\"Tim David\",\"overNbr\":18.6,\"runs\":159,\"ballNbr\":186}]}],\"extras\":{\"legByes\":1,\"wides\":2,\"total\":3},\"pp\":[{\"powerPlay\":[{\"id\":50,\"ovrFrom\":0.1,\"ovrTo\":6,\"ppType\":\"mandatory\",\"run\":53}]}],\"score\":177,\"wickets\":5,\"runRate\":8.85,\"batTeamName\":\"Mumbai Indians\",\"batTeamSName\":\"MI\",\"ballNbr\":120,\"rpb\":0.89},{\"inningsId\":2,\"batsman\":[{\"id\":12094,\"balls\":24,\"runs\":38,\"fours\":4,\"sixes\":2,\"strkRate\":\"158.33\",\"name\":\"Prithvi Shaw\",\"isCaptain\":false,\"outDec\":\"c Ishan Kishan b Basil Thampi\",\"isKeeper\":false,\"nickName\":\"Prithvi Shaw\"},{\"id\":9443,\"balls\":14,\"runs\":21,\"fours\":4,\"sixes\":0,\"strkRate\":\"150\",\"name\":\"Tim Seifert\",\"isCaptain\":false,\"outDec\":\" b M Ashwin\",\"isKeeper\":false,\"nickName\":\"Seifert\"},{\"id\":6319,\"balls\":2,\"runs\":0,\"fours\":0,\"sixes\":0,\"strkRate\":\"0\",\"name\":\"Mandeep Singh\",\"isCaptain\":false,\"outDec\":\"c Tilak Varma b M Ashwin\",\"isKeeper\":false,\"nickName\":\"Mandeep\"},{\"id\":10744,\"balls\":2,\"runs\":1,\"fours\":0,\"sixes\":0,\"strkRate\":\"50\",\"name\":\"Rishabh Pant\",\"isCaptain\":true,\"outDec\":\"c Tim David b Tymal Mills\",\"isKeeper\":true,\"nickName\":\"Pant\"},{\"id\":13252,\"balls\":38,\"runs\":48,\"fours\":4,\"sixes\":2,\"strkRate\":\"126.32\",\"name\":\"Lalit Yadav\",\"isCaptain\":false,\"outDec\":\"not out\",\"isKeeper\":false,\"nickName\":\"Lalit Yadav\"},{\"id\":11445,\"balls\":2,\"runs\":0,\"fours\":0,\"sixes\":0,\"strkRate\":\"0\",\"name\":\"Rovman Powell\",\"isCaptain\":false,\"outDec\":\"c Daniel Sams b Basil Thampi\",\"isKeeper\":false,\"nickName\":\"Rovman Powell\"},{\"id\":8683,\"balls\":11,\"runs\":22,\"fours\":4,\"sixes\":0,\"strkRate\":\"200\",\"name\":\"Shardul Thakur\",\"isCaptain\":false,\"outDec\":\"c Rohit b Basil Thampi\",\"isKeeper\":false,\"nickName\":\"Thakur\"},{\"id\":8808,\"balls\":17,\"runs\":38,\"fours\":2,\"sixes\":3,\"strkRate\":\"223.53\",\"name\":\"Axar Patel\",\"isCaptain\":false,\"outDec\":\"not out\",\"isKeeper\":false,\"nickName\":\"Axar\"},{\"id\":10952,\"balls\":0,\"runs\":0,\"fours\":0,\"sixes\":0,\"strkRate\":\"0\",\"name\":\"Khaleel Ahmed\",\"isCaptain\":false,\"isKeeper\":false,\"nickName\":\"Khaleel Ahmed\"},{\"id\":8292,\"balls\":0,\"runs\":0,\"fours\":0,\"sixes\":0,\"strkRate\":\"0\",\"name\":\"Kuldeep Yadav\",\"isCaptain\":false,\"isKeeper\":false,\"nickName\":\"Kuldeep Yadav\"},{\"id\":12092,\"balls\":0,\"runs\":0,\"fours\":0,\"sixes\":0,\"strkRate\":\"0\",\"name\":\"Kamlesh Nagarkoti\",\"isCaptain\":false,\"isKeeper\":false,\"nickName\":\"K Nagarkoti\"}],\"bowler\":[{\"id\":13162,\"overs\":\"4\",\"runs\":57,\"economy\":\"14.2\",\"name\":\"Daniel Sams\",\"wickets\":0,\"nickName\":\"Daniel Sams\"},{\"id\":9311,\"overs\":\"3.2\",\"runs\":43,\"economy\":\"12.9\",\"name\":\"Jasprit  Bumrah\",\"wickets\":0,\"nickName\":\"Bumrah\"},{\"id\":10267,\"overs\":\"4\",\"runs\":35,\"economy\":\"8.8\",\"name\":\"Basil Thampi\",\"wickets\":3,\"nickName\":\"Basil Thampi\"},{\"id\":8796,\"overs\":\"4\",\"runs\":14,\"economy\":\"3.5\",\"name\":\"Murugan Ashwin\",\"wickets\":2,\"nickName\":\"M Ashwin\"},{\"id\":7860,\"overs\":\"3\",\"runs\":26,\"economy\":\"8.7\",\"name\":\"Tymal Mills\",\"wickets\":1,\"nickName\":\"Tymal Mills\"}],\"fow\":[{\"batsmanId\":0,\"overNbr\":0.0,\"runs\":0,\"ballNbr\":0,\"fow\":[{\"batsmanId\":9443,\"batsmanName\":\"Tim Seifert\",\"overNbr\":3.3,\"runs\":30,\"ballNbr\":33},{\"batsmanId\":6319,\"batsmanName\":\"Mandeep Singh\",\"overNbr\":3.5,\"runs\":30,\"ballNbr\":35},{\"batsmanId\":10744,\"batsmanName\":\"Rishabh Pant\",\"overNbr\":4.1,\"runs\":32,\"ballNbr\":41},{\"batsmanId\":12094,\"batsmanName\":\"Prithvi Shaw\",\"overNbr\":9.2,\"runs\":72,\"ballNbr\":92},{\"batsmanId\":11445,\"batsmanName\":\"Rovman Powell\",\"overNbr\":9.4,\"runs\":72,\"ballNbr\":94},{\"batsmanId\":8683,\"batsmanName\":\"Shardul Thakur\",\"overNbr\":13.2,\"runs\":104,\"ballNbr\":132}]}],\"extras\":{\"legByes\":4,\"wides\":7,\"total\":11},\"pp\":[{\"powerPlay\":[{\"id\":51,\"ovrFrom\":0.1,\"ovrTo\":6,\"ppType\":\"mandatory\",\"run\":46}]}],\"score\":179,\"wickets\":6,\"runRate\":9.76,\"batTeamName\":\"Delhi Capitals\",\"batTeamSName\":\"DC\",\"ballNbr\":110,\"rpb\":0.98}],\"appIndex\":{\"seoTitle\":\"Cricket scorecard - DC vs MI 2nd Match,Indian Premier League 2022 | Cricbuzz.com\",\"webURL\":\"http://www.cricbuzz.com/live-cricket-scorecard/45891/dc-vs-mi-2nd-match-indian-premier-league-2022\"},\"status\":\"Delhi Capitals won by 4 wkts\",\"responseLastUpdated\":\"1648480501\"}", Match.class);
            Match match = new Gson().fromJson(response.body().string(), Match.class);
            return convertToMatchResponse(match);
        } catch (Exception e) {
            MatchResponse matchResponse =  new MatchResponse();
            matchResponse.setType(e.getMessage());
            matchResponse.setV(e.getStackTrace().toString());
            return  matchResponse;
        }
    }


    private MatchResponse convertToMatchResponse(Match match) {
        Map<String , String> playerNameVsPlayerId = Maps.newHashMap();
        MatchResponse matchResponse = new MatchResponse();
        Match.Scorecard scorecard1 = match.getScorecard().get(0);
        Match.Scorecard scorecard2 = match.getScorecard().get(1);

        MatchResponse.Data data = new MatchResponse.Data();
        MatchResponse.Team team1 = new MatchResponse.Team();
        team1.setPlayers(getPlayers(scorecard1, playerNameVsPlayerId));
        MatchResponse.Team team2 = new MatchResponse.Team();
        team2.setPlayers(getPlayers(scorecard2, playerNameVsPlayerId));
        data.setTeam(Lists.newArrayList(team1, team2));
        matchResponse.setData(data);

        Map<String , MatchResponse.Score> fieldingScores = Maps.newHashMap();

        MatchResponse.Batting batting = new MatchResponse.Batting();
        List<MatchResponse.Score> scores1 = Lists.newArrayList();
        scorecard1.getBatsman().forEach( batsman ->  {
            scores1.add(convertBatsmanToScore(batsman, playerNameVsPlayerId, fieldingScores));
        });
        batting.setScores(scores1);


        MatchResponse.Batting batting2 = new MatchResponse.Batting();
        List<MatchResponse.Score> scores2 = Lists.newArrayList();
        scorecard2.getBatsman().forEach( batsman ->  {
            scores2.add(convertBatsmanToScore(batsman, playerNameVsPlayerId, fieldingScores));
        });
        batting2.setScores(scores2);

        data.setBatting(Lists.newArrayList(batting, batting2));


        MatchResponse.Bowling bowling = new MatchResponse.Bowling();
        List<MatchResponse.Score> bowlingScores1 = Lists.newArrayList();
        scorecard2.getBowler().forEach(bowler ->  {
            bowlingScores1.add(convertBowlerToScore(bowler));
        });
        bowling.setScores(bowlingScores1);

        MatchResponse.Bowling bowling2 = new MatchResponse.Bowling();
        List<MatchResponse.Score> bowlingScores2 = Lists.newArrayList();
        scorecard2.getBowler().forEach(bowler ->  {
            bowlingScores2.add(convertBowlerToScore(bowler));
        });
        bowling2.setScores(bowlingScores2);

        data.setBatting(Lists.newArrayList(batting, batting2));
        data.setBowling(Lists.newArrayList(bowling, bowling2));

        MatchResponse.Fielding fielding = new MatchResponse.Fielding();
        MatchResponse.Fielding fielding1 = new MatchResponse.Fielding();
        fielding1.setScores(Lists.newArrayList());
        fielding.setScores(Lists.newArrayList(fieldingScores.values()));
        data.setFielding(Lists.newArrayList(fielding, fielding1));


        return matchResponse;

    }

    private MatchResponse.Score convertBatsmanToScore(Match.Batsman batsman, Map<String , String> playerNameVsPlayerId, Map<String , MatchResponse.Score> fieldingScores) {
        MatchResponse.Score score = new MatchResponse.Score();
        score.setBatsman(batsman.getName());
        score.setsR(batsman.getStrkRate());
        score.set_4s(batsman.getFours());
        score.set_6s(batsman.getSixes());
        score.setB(batsman.getBalls());
        score.setR(String.valueOf(batsman.getRuns()));
        score.setPid(String.valueOf(batsman.getId()));
        checkForPatternAndAddFielding(batsman, playerNameVsPlayerId, fieldingScores);
        return score;
    }

    private void checkForPatternAndAddFielding(Match.Batsman batsman, Map<String , String> playerNameVsPlayerId,  Map<String , MatchResponse.Score> fieldingScores) {

        String dismissal = batsman.getOutDec();
        Set<String> playerNames = playerNameVsPlayerId.keySet();
        if(StringUtils.isBlank(dismissal)) {
            return;
        }
            Matcher matcher = catchPattern.matcher(dismissal);
            if (matcher.matches()) {
                String fielderName = matcher.group(1);
                playerNames.forEach(playerName -> {
                    if (playerName.contains(fielderName)) {
                        String id = playerNameVsPlayerId.get(playerName);
                        MatchResponse.Score currentScore = fieldingScores.get(id);
                        if (currentScore == null) {
                            currentScore = new MatchResponse.Score();
                        }

                        currentScore.setMycatch(currentScore.mycatch + 1);
                        fieldingScores.put(id, currentScore);
                    }
                });
            }

        Matcher matcher1 = stumpedPattern.matcher(dismissal);
        if(matcher1.matches()) {
            String fielderName= matcher1.group(1);
            playerNames.forEach( playerName -> {
                if (playerName.contains(fielderName)) {
                    String id = playerNameVsPlayerId.get(playerName);

                    MatchResponse.Score currentScore = fieldingScores.get(id);
                    if(currentScore == null) {
                        currentScore = new MatchResponse.Score();
                    }
                    currentScore.setMycatch(currentScore.stumped + 1);
                    fieldingScores.put(id, currentScore);
                }
            });
        }

        Matcher matcher2 = runOutPattern.matcher(dismissal);
        if(matcher2.matches()) {
            String fielderName1= matcher1.group(1);
            playerNames.forEach( playerName -> {
                if (playerName.contains(fielderName1)) {
                    String id = playerNameVsPlayerId.get(playerName);
                    MatchResponse.Score currentScore = fieldingScores.get(id);
                    if(currentScore == null) {
                        currentScore = new MatchResponse.Score();
                    }
                    currentScore.setMycatch(currentScore.runout + 1);
                    fieldingScores.put(id, currentScore);
                }
            });

            String fielderName2= matcher1.group(2);
            playerNames.forEach( playerName -> {
                String id = playerNameVsPlayerId.get(playerName);
                if (playerName.contains(fielderName2)) {
                    MatchResponse.Score currentScore = fieldingScores.get(id);
                    if(currentScore == null) {
                        currentScore = new MatchResponse.Score();
                    }
                    currentScore.setMycatch(currentScore.runout + 1);
                    fieldingScores.put(id, currentScore);
                }
            });
        }

    }

    private MatchResponse.Score convertBowlerToScore(Match.Bowler bowler) {
        MatchResponse.Score score = new MatchResponse.Score();
        score.setPid(String.valueOf(bowler.getId()));
        score.setW(String.valueOf(bowler.getWickets()));
        score.setEcon(bowler.getEconomy());
        return score;
    }

    List<MatchResponse.Player> getPlayers(Match.Scorecard scorecard, Map<String , String> playerNameVsPlayerId) {

        List<MatchResponse.Player> players = new ArrayList<>();
        List<Match.Batsman> batsmen = scorecard.getBatsman();
        batsmen.forEach(batsman ->  {
            MatchResponse.Player player = new MatchResponse.Player();
            player.setName(batsman.getName());
            player.setPid(String.valueOf(batsman.getId()));
            players.add(player);
            playerNameVsPlayerId.put(batsman.getName(), String.valueOf(batsman.getId()));
        });
        
        return players;

    }

}
