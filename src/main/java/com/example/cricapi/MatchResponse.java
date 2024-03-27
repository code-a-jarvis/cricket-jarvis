package com.example.cricapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author navaneshwar
 * @Date 27/03/22
 */
public class MatchResponse {

    public Data data;
    public String type;
    public boolean cache3;
    public int creditsLeft;
    public String v;
    public int ttl;
    public Provider provider;

    public void setData(Data data) {
        this.data = data;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCache3(boolean cache3) {
        this.cache3 = cache3;
    }

    public void setCreditsLeft(int creditsLeft) {
        this.creditsLeft = creditsLeft;
    }

    public void setV(String v) {
        this.v = v;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public static class Score {
        public String name;
        public int runout = 0;
        public int stumped = 0;
        public int bowled = 0;
        public int lbw;
        @JsonProperty("catch")
        public int mycatch = 0;
        public String pid;
        @JsonProperty("NB")
        public String nB;
        @JsonProperty("WD")
        public String wD;
        @JsonProperty("6s")
        public int _6s;
        @JsonProperty("4s")
        public int _4s;
        @JsonProperty("0s")
        public int _0s;
        @JsonProperty("Econ")
        public String econ;
        @JsonProperty("W")
        public String w;
        @JsonProperty("R")
        public String r;
        @JsonProperty("M")
        public String m = "0";
        @JsonProperty("O")
        public String o;
        public String bowler;
        @JsonProperty("dismissal-by")
        public DismissalBy dismissalBy;
        public String dismissal;
        @JsonProperty("SR")
        public String sR;
        @JsonProperty("B")
        public int b;
        @JsonProperty("dismissal-info")
        public String dismissalInfo;
        public String batsman;

        public void setName(String name) {
            this.name = name;
        }

        public void setRunout(int runout) {
            this.runout = runout;
        }

        public void setStumped(int stumped) {
            this.stumped = stumped;
        }

        public void setBowled(int bowled) {
            this.bowled = bowled;
        }

        public void setLbw(int lbw) {
            this.lbw = lbw;
        }

        public void setMycatch(int mycatch) {
            this.mycatch = mycatch;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public void setnB(String nB) {
            this.nB = nB;
        }

        public void setwD(String wD) {
            this.wD = wD;
        }

        public void set_6s(int _6s) {
            this._6s = _6s;
        }

        public void set_4s(int _4s) {
            this._4s = _4s;
        }

        public void set_0s(int _0s) {
            this._0s = _0s;
        }

        public void setEcon(String econ) {
            this.econ = econ;
        }

        public void setW(String w) {
            this.w = w;
        }

        public void setR(String r) {
            this.r = r;
        }

        public void setM(String m) {
            this.m = m;
        }

        public void setO(String o) {
            this.o = o;
        }

        public void setBowler(String bowler) {
            this.bowler = bowler;
        }

        public void setDismissalBy(DismissalBy dismissalBy) {
            this.dismissalBy = dismissalBy;
        }

        public void setDismissal(String dismissal) {
            this.dismissal = dismissal;
        }

        public void setsR(String sR) {
            this.sR = sR;
        }

        public void setB(int b) {
            this.b = b;
        }

        public void setDismissalInfo(String dismissalInfo) {
            this.dismissalInfo = dismissalInfo;
        }

        public void setBatsman(String batsman) {
            this.batsman = batsman;
        }
    }

    public static class Fielding {
        public String title;
        public List<Score> scores;

        public void setTitle(String title) {
            this.title = title;
        }

        public void setScores(List<Score> scores) {
            this.scores = scores;
        }
    }

    public static class Bowling {
        public List<Score> scores;
        public String title;

        public void setScores(List<Score> scores) {
            this.scores = scores;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public class DismissalBy {
        public String name;
        public String pid;
    }

    public static class Batting {
        public List<Score> scores;
        public String title;

        public void setScores(List<Score> scores) {
            this.scores = scores;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static class Player {
        public String name;
        public String nickName;
        public String pid;

        public void setName(String name) {
            this.name = name;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

         public void setNickName(String nickName) {
            this.nickName = nickName;
        }
    }

    public static class Team {
        public List<Player> players;
        public String name;

        public void setPlayers(List<Player> players) {
            this.players = players;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public class ManOfTheMatch {
        public String name;
        public String pid;
    }

    public static class Data {
        public List<Fielding> fielding;
        public List<Bowling> bowling;
        public List<Batting> batting;
        public List<Team> team;
        @JsonProperty("man-of-the-match")
        public ManOfTheMatch manOfTheMatch;
        public String toss_winner_team;
        public String winner_team;
        public boolean matchStarted;

        public void setFielding(List<Fielding> fielding) {
            this.fielding = fielding;
        }

        public void setBowling(List<Bowling> bowling) {
            this.bowling = bowling;
        }

        public void setBatting(List<Batting> batting) {
            this.batting = batting;
        }

        public void setTeam(List<Team> team) {
            this.team = team;
        }

        public void setManOfTheMatch(ManOfTheMatch manOfTheMatch) {
            this.manOfTheMatch = manOfTheMatch;
        }

        public void setToss_winner_team(String toss_winner_team) {
            this.toss_winner_team = toss_winner_team;
        }

        public void setWinner_team(String winner_team) {
            this.winner_team = winner_team;
        }

        public void setMatchStarted(boolean matchStarted) {
            this.matchStarted = matchStarted;
        }
    }

    public class Provider {
        public String source;
        public String url;
    }


}

