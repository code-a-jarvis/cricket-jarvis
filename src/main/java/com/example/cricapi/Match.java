package com.example.cricapi;

import java.util.List;

/**
 * @author navaneshwar
 * @Date 27/03/22
 */
public class Match {

    public List<Scorecard> scorecard;
    public AppIndex appIndex;
    public String status;
    public String responseLastUpdated;

    public List<Scorecard> getScorecard() {
        return scorecard;
    }

    public void setScorecard(List<Scorecard> scorecard) {
        this.scorecard = scorecard;
    }

    public AppIndex getAppIndex() {
        return appIndex;
    }

    public void setAppIndex(AppIndex appIndex) {
        this.appIndex = appIndex;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResponseLastUpdated() {
        return responseLastUpdated;
    }

    public void setResponseLastUpdated(String responseLastUpdated) {
        this.responseLastUpdated = responseLastUpdated;
    }

    public class Batsman{
        public int id;
        public int balls;
        public int runs;
        public int fours;
        public int sixes;
        public String strkRate;
        public String name;
        public boolean isCaptain;
        public String outDec;
        public boolean isKeeper;
        public String nickName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getBalls() {
            return balls;
        }

        public void setBalls(int balls) {
            this.balls = balls;
        }

        public int getRuns() {
            return runs;
        }

        public void setRuns(int runs) {
            this.runs = runs;
        }

        public int getFours() {
            return fours;
        }

        public void setFours(int fours) {
            this.fours = fours;
        }

        public int getSixes() {
            return sixes;
        }

        public void setSixes(int sixes) {
            this.sixes = sixes;
        }

        public String getStrkRate() {
            return strkRate;
        }

        public void setStrkRate(String strkRate) {
            this.strkRate = strkRate;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isCaptain() {
            return isCaptain;
        }

        public void setCaptain(boolean captain) {
            isCaptain = captain;
        }

        public String getOutDec() {
            return outDec;
        }

        public void setOutDec(String outDec) {
            this.outDec = outDec;
        }

        public boolean isKeeper() {
            return isKeeper;
        }

        public void setKeeper(boolean keeper) {
            isKeeper = keeper;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }
    }

    public class Bowler{
        public int id;
        public String overs;
        public int runs;
        public String economy;
        public String name;
        public int wickets;
        public String nickName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOvers() {
            return overs;
        }

        public void setOvers(String overs) {
            this.overs = overs;
        }

        public int getRuns() {
            return runs;
        }

        public void setRuns(int runs) {
            this.runs = runs;
        }

        public String getEconomy() {
            return economy;
        }

        public void setEconomy(String economy) {
            this.economy = economy;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getWickets() {
            return wickets;
        }

        public void setWickets(int wickets) {
            this.wickets = wickets;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }
    }

    public class Fow{
        public int batsmanId;
        public String batsmanName;
        public double overNbr;
        public int runs;
        public int ballNbr;
        public List<Fow> fow;

        public int getBatsmanId() {
            return batsmanId;
        }

        public void setBatsmanId(int batsmanId) {
            this.batsmanId = batsmanId;
        }

        public String getBatsmanName() {
            return batsmanName;
        }

        public void setBatsmanName(String batsmanName) {
            this.batsmanName = batsmanName;
        }

        public double getOverNbr() {
            return overNbr;
        }

        public void setOverNbr(double overNbr) {
            this.overNbr = overNbr;
        }

        public int getRuns() {
            return runs;
        }

        public void setRuns(int runs) {
            this.runs = runs;
        }

        public int getBallNbr() {
            return ballNbr;
        }

        public void setBallNbr(int ballNbr) {
            this.ballNbr = ballNbr;
        }

        public List<Fow> getFow() {
            return fow;
        }

        public void setFow(List<Fow> fow) {
            this.fow = fow;
        }
    }

    public class Extras{
        public int legByes;
        public int wides;
        public int total;
    }

    public class PowerPlay{
        public int id;
        public double ovrFrom;
        public int ovrTo;
        public String ppType;
        public int run;
    }

    public class Pp{
        public List<PowerPlay> powerPlay;
    }

    public class Scorecard{
        public int inningsId;
        public List<Batsman> batsman;
        public List<Bowler> bowler;
        public List<Fow> fow;
        public Extras extras;
        public List<Pp> pp;
        public int score;
        public int wickets;
        public double runRate;
        public String batTeamName;
        public String batTeamSName;
        public int ballNbr;
        public double rpb;

        public int getInningsId() {
            return inningsId;
        }

        public void setInningsId(int inningsId) {
            this.inningsId = inningsId;
        }

        public List<Batsman> getBatsman() {
            return batsman;
        }

        public void setBatsman(List<Batsman> batsman) {
            this.batsman = batsman;
        }

        public List<Bowler> getBowler() {
            return bowler;
        }

        public void setBowler(List<Bowler> bowler) {
            this.bowler = bowler;
        }

        public List<Fow> getFow() {
            return fow;
        }

        public void setFow(List<Fow> fow) {
            this.fow = fow;
        }

        public Extras getExtras() {
            return extras;
        }

        public void setExtras(Extras extras) {
            this.extras = extras;
        }

        public List<Pp> getPp() {
            return pp;
        }

        public void setPp(List<Pp> pp) {
            this.pp = pp;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getWickets() {
            return wickets;
        }

        public void setWickets(int wickets) {
            this.wickets = wickets;
        }

        public double getRunRate() {
            return runRate;
        }

        public void setRunRate(double runRate) {
            this.runRate = runRate;
        }

        public String getBatTeamName() {
            return batTeamName;
        }

        public void setBatTeamName(String batTeamName) {
            this.batTeamName = batTeamName;
        }

        public String getBatTeamSName() {
            return batTeamSName;
        }

        public void setBatTeamSName(String batTeamSName) {
            this.batTeamSName = batTeamSName;
        }

        public int getBallNbr() {
            return ballNbr;
        }

        public void setBallNbr(int ballNbr) {
            this.ballNbr = ballNbr;
        }

        public double getRpb() {
            return rpb;
        }

        public void setRpb(double rpb) {
            this.rpb = rpb;
        }
    }

    public class AppIndex{
        public String seoTitle;
        public String webURL;
    }



}
