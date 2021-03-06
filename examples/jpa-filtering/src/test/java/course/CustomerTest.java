package course;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import course.jpa.dbutil.PopulateDBWork;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import course.example.Customer;

public class CustomerTest {
	
	private EntityManagerFactory emf;
	private EntityManager em;

	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("course-hsql");
		em = emf.createEntityManager();
		//PopulateDBWork.populate(em, "/db.xml" );
	}

	@After
	public void tearDown() throws Exception {
		if (em != null && em.isOpen()) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			em.close();
		}
		emf.close();
	}
   
	@Test
	public void testCreate() {
		Customer customer = new Customer();
		//customer.setId(1);
		customer.setEmail("mail@host.com");
		customer.setFirstName("Hans");
		customer.setLastName("Dampf");
		em.getTransaction().begin();
		em.persist(customer);
		em.getTransaction().commit();
		assertNotNull(customer);
	}

}
