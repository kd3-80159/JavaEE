package dao;

import java.util.List;


import pojos.Team;

public interface TeamDao {
List<Team> getTeamDetails();
Team getTeamDetailsByTeamId(Integer TeamId);
}
