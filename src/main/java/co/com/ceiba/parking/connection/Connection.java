package co.com.ceiba.parking.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {
	
	private static final String PARKING_PU = "parking-pu";
	private static EntityManagerFactory entityManagerFactory;

	public Connection() {
		entityManagerFactory = Persistence.createEntityManagerFactory(PARKING_PU);
	}
	
	public EntityManager createEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
}
