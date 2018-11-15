package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Teamsheet_Player {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long teamsheetPlayerId;
	private long teamsheetId;
	private long playerId;
	
	public long getTeamsheetPlayerId() {
		return teamsheetPlayerId;
	}
	public void setTeamsheetPlayerId(long teamsheetPlayerId) {
		this.teamsheetPlayerId = teamsheetPlayerId;
	
	}
}
