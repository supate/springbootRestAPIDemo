package com.springboot.jpa.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public int savePlayerData(Player player) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction txn = session.beginTransaction();
			session.saveOrUpdate(player);
			txn.commit();
		} catch(Exception e) {
		       e.printStackTrace();
		} finally {
			session.close();
		}
		
		return player.getId();
	}
	
	public Player getPlayerById(int id) {
		Session session = null;
		Player player = null;
	    try {
	        session = sessionFactory.openSession();
	        player = (Player)session.get(Player.class, id);
	    } catch (Exception e) {
	       e.printStackTrace();
	    } finally {
	        if (session != null && session.isOpen()) {
	            session.close();
	        }
	    }
	    return player;		
	}
	
	@SuppressWarnings("unchecked")
	public List<Player> getPlayers() {
		Session session = null;
		List<Player> players = null;
	    try {
	        session = sessionFactory.openSession();
	        String hql = "from Player";
	        Query query = session.createQuery(hql);
	        players = query.list();
	        
	    } catch (Exception e) {
	       e.printStackTrace();
	    } finally {
	        if (session != null && session.isOpen()) {
	            session.close();
	        }
	    }
	    return players;		
	}
}
