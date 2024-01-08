package beans;

import java.time.LocalDate;
import java.util.List;

import dao.PlayerDao;
import dao.PlayerDaoImpl;
import dao.TeamDao;
import dao.TeamDaoImpl;
import pojos.Player;
import pojos.Team;
import java.time.LocalDate;
public class PlayerBean {
	private Integer myTeam;
	private String firstName;
	private String lastName;
	private String dob;
	private double battingAvg;
	private int wicketsTaken;
	private PlayerDao playerDao;
	private TeamDao teamDao;
	

	public PlayerBean() {
		playerDao = new PlayerDaoImpl();
		teamDao=new TeamDaoImpl();
	}







	public Integer getMyTeam() {
		return myTeam;
	}







	public void setMyTeam(Integer myTeam) {
		this.myTeam = myTeam;
	}







	public String getFirstName() {
		return firstName;
	}







	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}







	public String getLastName() {
		return lastName;
	}







	public void setLastName(String lastName) {
		this.lastName = lastName;
	}







	public String getDob() {
		return dob;
	}







	public void setDob(String dob) {
		this.dob = dob;
	}







	public double getBattingAvg() {
		return battingAvg;
	}







	public void setBattingAvg(double battingAvg) {
		this.battingAvg = battingAvg;
	}







	public int getWicketsTaken() {
		return wicketsTaken;
	}







	public void setWicketsTaken(int wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}







	public PlayerDao getPlayerDao() {
		return playerDao;
	}







	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}







	public TeamDao getTeamDao() {
		return teamDao;
	}







	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}







	public String validateAndPlayer() {
		String msg = "Not Added";
		Team t = teamDao.getTeamDetailsByTeamId(myTeam);		
		int age = t.getMaxAge();
		double battingAvg=t.getBattingAvg();
		int	wicketTaken=t.getWicketsTaken();
	
		if(age<=40 || battingAvg<=90 || wicketTaken>0) {
			Player p = new Player(firstName, lastName,  LocalDate.parse(dob),  battingAvg,  wicketsTaken);
			playerDao.addPlayerDetails(myTeam, p);
		}else {
//			msg="Invalid credentilas";
//			return msg;
		}
		
	msg="AddedSuccessfully";
	return msg;
	}
}
//validation get Done