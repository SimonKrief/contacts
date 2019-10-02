package fr.gtm.contacts.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.gtm.contacts.entities.Contact;

public class ContactDAOTest {
	private Contact[] contacts = {
			new Contact("M","Lagaffe","Gaston"),
			new Contact("Mme","Blanc-Sec","Adèle"),
			new Contact("M","Leblanc","Juste"),
			new Contact("M","Brown","Emmet"),
			new Contact("M","Gordon","James"),
			new Contact("Mme","Croft","Lara")
	};
	private ContactDAO dao = new ContactMockDAO();
	
	@Test
	public void testSave() {
		Contact c = contacts[0];
		dao.save(c);
		int nb = dao.getAllContacts().size();
		assertEquals(1, nb);
		assertNotEquals(0, c.getId());
	}

	@Test
	public void testUpdate() {
		Contact c = contacts[0];
		dao.save(c);
		c.setNom("foo");
		dao.update(c);
		Contact c1 = dao.getContactById(c.getId());
		assertEquals("foo", c1.getNom());
	}

	@Test
	public void testDelete() {
		Contact c= contacts[0];
		dao.delete(c);
		int nb = dao.getAllContacts().size();	
		assertEquals(0, nb);
	}
	
	

	@Test
	public void testGetAllContacts() {
		Contact c = contacts[0];
		dao.save(c);
		System.out.println(dao.toString());		
		System.out.println(dao.getAllContacts().toString());
	}

//	@Test
//	public void testGetContactById() {
//		fail("Not yet implemented");
//	}

//	@Test
//	public void testGetContactsByNom() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetContactsByCivilite() {
//		fail("Not yet implemented");
//	}

}
