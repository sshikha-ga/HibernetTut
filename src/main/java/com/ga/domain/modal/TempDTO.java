package com.ga.domain.modal;

public class TempDTO {
	private Integer workLogId;
	private String startTime;
	private String totalHours;
	private String totalMinutes;
	private String totalDays;
	private int userId;
	private String userName;

	public Integer getWorkLogId() {
		return workLogId;
	}

	public void setWorkLogId(Integer workLogId) {
		this.workLogId = workLogId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(String totalHours) {
		this.totalHours = totalHours;
	}

	public String getTotalMinutes() {
		return totalMinutes;
	}

	public void setTotalMinutes(String totalMinutes) {
		this.totalMinutes = totalMinutes;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTotalDays() {
		return totalDays;
	}

	public void setTotalDays(String totalDays) {
		this.totalDays = totalDays;
	}

	@Override
	public String toString() {
		return "TempDTO [workLogId=" + workLogId + ", startTime=" + startTime
				+ ", totalHours=" + totalHours + ", totalMinutes="
				+ totalMinutes + "]";
	}

}
