package com.javaniuniu.pojo;


public class StudentScore {
    private Integer sid;
    private String scoreName;
    private Integer score;

    public StudentScore() {
    }

    public StudentScore(Integer sid, String scoreName, Integer score) {
        this.sid = sid;
        this.scoreName = scoreName;
        this.score = score;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getScoreName() {
        return scoreName;
    }

    public void setScoreName(String scoreName) {
        this.scoreName = scoreName;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "StudentScore{" +
                "sid=" + sid +
                ", scoreName='" + scoreName + '\'' +
                ", score=" + score +
                '}';
    }
}