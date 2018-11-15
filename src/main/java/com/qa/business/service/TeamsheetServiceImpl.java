package com.qa.business.service;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qa.persistence.domain.Teamsheet;
import com.qa.persistence.repository.TeamsheetRepository;


@Default
public class TeamsheetServiceImpl implements TeamsheetService {

	@Inject
	private TeamsheetRepository repo;

	public String getAllTeamsheets() {
		return repo.getAllTeamsheets();
	}

	public String createTeamsheet(String ts) {
		return repo.createTeamsheet(ts);
	}

	@Override
	public String deleteTeamsheet(long id) {
		return repo.deleteTeamsheet(id);
	}

	@Override
	public String getTeamsheet(long id) {
		return repo.getTeamsheet(id);
	}

	@Override
	public String updateTeamsheet(Teamsheet ts) {
		return repo.updateTeamsheet(ts);
	}

	
	public void setRepo(TeamsheetRepository repo) {
		this.repo = repo;
	}


	
}
