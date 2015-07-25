package com.gester.GesterAchievementServer;


public class LoggedAchievement {
	
	private long iD;
	private String userEmail;
	private long achievementID;
	
	private String comment;
	private String pic;
	private String timeStamp;
	private boolean priv;
	
	public LoggedAchievement() {
	}

	public long getiD() {
		return iD;
	}

	public void setiD(long iD) {
		this.iD = iD;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public long getAchievementID() {
		return achievementID;
	}

	public void setAchievementID(long achievementID) {
		this.achievementID = achievementID;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public boolean isPriv() {
		return priv;
	}

	public void setPriv(boolean priv) {
		this.priv = priv;
	}
	
	

}
