package dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Player;
import pojos.Team;

public class PlayerDaoImpl implements PlayerDao {
	


	@Override
	public String addPlayerDetails(Integer Id, Player newPlayer) {

		String mesg = "Adding player failed!!!!";
	
		Session session = getFactory().getCurrentSession();
	
		Transaction tx = session.beginTransaction();
		try {
			
			Team team = session.get(Team.class, Id);
			if (team != null) {

				team.addPlayer(newPlayer);

				mesg = "Added new Player   in dept " + team.getName();			}
			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
//newEmp : DETACHED => from L1 cache.
		return mesg;
		
	}
}
