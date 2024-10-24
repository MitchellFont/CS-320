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

public class ContactTest {

    private Contact contact;

    @BeforeEach
    void setUp() {
        contact = new Contact("123", "Mitchell", "Fontaine", "1234567890", "123 Main St");
    }

    @Test
    void testContactCreation() {
        assertEquals("123", contact.getContactID());
        assertEquals("Mitchell", contact.getFirstName());
        assertEquals("Fontaine", contact.getLastName());
        assertEquals("1234567890", contact.getPhoneNumber());
        assertEquals("123 Main St", contact.getContactAddress());
    }

    @Test
    void testSetFirstName() {
        contact.setFirstName("April");
        assertEquals("April", contact.getFirstName());
    }

    @Test
    void testSetLastName() {
        contact.setLastName("Fontaine");
        assertEquals("Fontaine", contact.getLastName());
    }

    @Test
    void testSetPhoneNumber() {
        contact.setPhoneNumber("0987654321");
        assertEquals("0987654321", contact.getPhoneNumber());
    }

    @Test
    void testSetContactAddress() {
        contact.setContactAddress("456 Elm St");
        assertEquals("456 Elm St", contact.getContactAddress());
    }

    @Test
    void testInvalidPhoneNumberLength() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhoneNumber("12345");
        });
        assertEquals("Invalid phone number", exception.getMessage());
    }
}