package com.qa.persistence.repository;

import com.qa.persistence.domain.Teamsheet_Player;

public interface Teamsheet_PlayerRepository {

	String getAllTeamsheet_Player();
	String createTeamsheet_Player(String tsp);
	String getTeamsheet_Player(long id);
	String deleteTeamsheet_Player(long id);
	String updateTeamsheet_Player(Teamsheet_Player tsp);
}