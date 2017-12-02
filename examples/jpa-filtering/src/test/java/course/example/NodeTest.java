package course.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by tf on 20.02.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:jpaContext.xml"})
@Transactional
@Commit
public class NodeTest {
    @Inject
    private EntityManagerFactory emf;
    private EntityManager em;

    private Node a;
    private Node e;

    @Before
    public void setUp() {
        //   A
        //  /|\
        // B C D
        //      \
        //       E
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        a.addChild(b,c,d);
        d.addChild(e);
        this.a = a;
        this.e = e;
        em = emf.createEntityManager();
    }
    
    @BeforeTransaction
    public void beforeTx() {

    }

    @After
    public void tearDown() {
        if (em != null) em.close();
    }
    
    @AfterTransaction
    public void afterTx() {

    }

    @Test @Transactional
    public void verifyThatTreeIsLoaded() {
        em.getTransaction().begin();
        em.persist(a);
        em.flush();
        List resultList = em.createNamedQuery
                ("findAllRootNodesWithTheirChildren").getResultList();
        System.out.println(resultList);
        assertNotNull(em.find(Node.class, a.getId()));
        em.getTransaction().commit();
    }

    @Test
    public void verifyTreeStructure() {
        em.persist(a);
        System.out.println("path of e="+ e.getPath());
        assertTrue(em.contains(e));
    }

    @Test
    public void verifyForRootNode() {
        assertTrue(a.isParent());
        assertFalse(e.isParent());
    }

    @Test(timeout = 1000)
    public void verifyBulkLoad() {
        em.getTransaction().begin();
        Node root = new Node("A");
        for(int i = 0; i<10; i++) {
            Node level1Node = new Node("B"+i);
            level1Node.setParent(root);
            for (int j=0; j<5; j++) {
                Node level2Node = new Node("C"+i+j);
                level2Node.setParent(root);
            }
            em.persist(root);
        }
        List resultList = em.createQuery("from Node as n").getResultList();
        System.out.println(resultList);
        em.getTransaction().commit();
    }

}
