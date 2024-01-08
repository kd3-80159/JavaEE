package dao;

import java.util.List;

import pojos.Team;

import static utils.HibernateUtils.getFactory;
import static utils.HibernateUtils.getFactory;
import org.hibernate.*;

public class TeamDaoImpl implements TeamDao {

	@Override
	public List<Team> getTeamDetails() {
		List<Team> teams=null;
		// 1. get session from SF
		String jpql="select new pojos.Team(id,abbreviation) from Team t";
		Session session=getFactory().getCurrentSession();
		//2. begin a tx
		Transaction tx=session.beginTransaction();
		try {
			teams=session.createQuery(jpql, Team.class)
					.getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}	
		return teams;
	}
	public Team getTeamDetailsByTeamId(Integer TeamId) {
		Team t=null;
		Session session=getFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		try {
			t = session.get(Team.class, TeamId);
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return t;
	}
}
