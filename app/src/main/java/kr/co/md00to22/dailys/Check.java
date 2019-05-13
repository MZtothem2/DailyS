package kr.co.md00to22.dailys;

public class Check {
    private String message;
    private String makeTime;
    private String doneTIme;
    private Boolean isdone;

    public Check(String message, String makeTime, Boolean isdone) {
        this.message = message;
        this.makeTime = makeTime;
        this.isdone = isdone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMakeTime() {
        return makeTime;
    }

    public void setMakeTime(String makeTime) {
        this.makeTime = makeTime;
    }

    public String getDoneTIme() {
        return doneTIme;
    }

    public void setDoneTIme(String doneTIme) {
        this.doneTIme = doneTIme;
    }

    public Boolean getIsdone() {
        return isdone;
    }

    public void setIsdone(Boolean isdone) {
        this.isdone = isdone;
    }
}
