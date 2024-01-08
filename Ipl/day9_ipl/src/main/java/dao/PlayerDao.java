package dao;
import static utils.HibernateUtils.getFactory;

import pojos.Player;
public interface PlayerDao {
	
	public String addPlayerDetails(Integer Id, Player newPlayer); 

}
