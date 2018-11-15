package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Teamsheet_Player;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class Teamsheet_PlayerDBRepository implements Teamsheet_PlayerRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil jsonOb;
	
	public String getAllTeamsheet_Player() {
		Query query = manager.createQuery("Select ts FROM Teamsheet_Player ts");
		Collection<Teamsheet_Player> Teamsheet_Players = (Collection<Teamsheet_Player>) query.getResultList();
		return jsonOb.getJSONForObject(Teamsheet_Players);
	}
	
	@Transactional(REQUIRED)
	public String createTeamsheet_Player(String Teamsheet_Player) {
		Teamsheet_Player aTeamsheet_Player = jsonOb.getObjectForJSON(Teamsheet_Player, Teamsheet_Player.class);
		manager.persist(aTeamsheet_Player);
		return "{\"message\": \"Teamsheet_Player has been sucessfully added\"}";
	}
	
	@Transactional(REQUIRED)
	public String deleteTeamsheet_Player(long id) {
		Teamsheet_Player Teamsheet_PlayerInDB = findTeamsheet_Player(id);
		if (Teamsheet_PlayerInDB != null) {
			manager.remove(Teamsheet_PlayerInDB);
		}
		return "{\"message\": \"Teamsheet_Player sucessfully deleted\"}";
	}

	public String getTeamsheet_Player(long id) {
		Teamsheet_Player Teamsheet_PlayerInDB = findTeamsheet_Player(id);
		return jsonOb.getJSONForObject(Teamsheet_PlayerInDB);
	}
	
	@Transactional(REQUIRED)
	public String updateTeamsheet_Player(Teamsheet_Player ts) {
		//Teamsheet_Player Teamsheet_PlayerInDB = findTeamsheet_Player(ts.getTeamsheet_PlayerId());
		//Teamsheet_PlayerInDB.setSaveName(ts.getSaveName());
		//Teamsheet_PlayerInDB.setPlayers(ts.getPlayers());
		return "{\"message\": \"Teamsheet_Player has been sucessfully updated\"}";
	}
	
	
	private Teamsheet_Player findTeamsheet_Player(long id) {
		return manager.find(Teamsheet_Player.class, id);
	}


	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	

		
}