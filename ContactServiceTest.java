/* 
 * Mitchell Fontaine
 * 10/09/2024
 * CS-320
 */

package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projectOne.Contact;
import projectOne.ContactService;

public class ContactServiceTest {

    private ContactService contactService;

    @BeforeEach
    void setUp() {
        contactService = new ContactService();
    }

    @Test
    void testAddContact() {
        contactService.addContact("001", "Mitchell", "Fontaine", "1234567890", "123 Main St");
        assertEquals(1, contactService.getContactList().size());

        Contact contact = contactService.getContactList().get(0);
        assertEquals("001", contact.getContactID());
        assertEquals("Mitchell", contact.getFirstName());
        assertEquals("Fontaine", contact.getLastName());
        assertEquals("1234567890", contact.getPhoneNumber());
        assertEquals("123 Main St", contact.getContactAddress());
    }

    @Test
    void testAddDuplicateContactID() {
        contactService.addContact("001", "Mitchell", "Fontaine", "1234567890", "123 Main St");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact("001", "April", "Fontaine", "0987654321", "456 Elm St");
        });
        assertEquals("A contact with this ID already exists.", exception.getMessage());
    }

    @Test
    void testRemoveContact() {
        contactService.addContact("001", "Mitchell", "Fontaine", "1234567890", "123 Main St");
        contactService.removeContact("001");
        assertEquals(0, contactService.getContactList().size());
    }

    @Test
    void testRemoveNonExistentContact() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            contactService.removeContact("999");
        });
        assertEquals("Contact not found.", exception.getMessage());
    }

    @Test
    void testUpdateContactFirstName() {
        contactService.addContact("001", "Mitchell", "Fontaine", "1234567890", "123 Main St");
        contactService.updateContact("001", "April", 1);

        Contact updatedContact = contactService.getContactList().get(0);
        assertEquals("April", updatedContact.getFirstName());
    }

    @Test
    void testUpdateInvalidField() {
        contactService.addContact("001", "Mitchell", "Fontaine", "1234567890", "123 Main St");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact("001", "Invalid", 5);  // Invalid selection
        });
        assertEquals("Invalid selection.", exception.getMessage());
    }

    @Test
    void testUpdateInvalidPhoneNumber() {
        contactService.addContact("001", "Mitchell", "Fontaine", "1234567890", "123 Main St");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact("001", "123", 3);  // Invalid phone number
        });
        assertEquals("Invalid phone number", exception.getMessage());
    }

    @Test
    void testGenerateUniqueID() {
        String uniqueID = contactService.generateUniqueId();
        assertNotNull(uniqueID);
        assertEquals(9, uniqueID.length());
    }
}