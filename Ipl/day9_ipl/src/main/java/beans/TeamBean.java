package beans;

import java.util.List;

import dao.TeamDao;
import dao.TeamDaoImpl;
import pojos.Team;

public class TeamBean {

	private TeamDao teamDao;
	public TeamBean() {
		
		teamDao=new TeamDaoImpl();
		System.out.println("team bean n dao created ....");
	}

	public List<Team> getAllTeams() 
	{
		List<Team> list = teamDao.getTeamDetails();
		System.out.println(list);
		return list;
	}
}
