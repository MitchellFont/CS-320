/* 
 * Mitchell Fontaine
 * 10/09/2024
 * CS-320
 */


package projectOne;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContactService {
    
    // List to store a list of Contact objects
    private List<Contact> contactList = new ArrayList<>();

    /**
     * Getter method for the list of contacts.
     * @return a List containing the contact list.
     */
    public List<Contact> getContactList() {
        return contactList;
    }
    
    /**
     * Adds a new contact to the list.
     * @param contactID the ID of the new contact
     * @param firstName the first name of the new contact
     * @param lastName the last name of the new contact
     * @param phoneNumber the phone number of the new contact
     * @param address the address of the new contact
     * @throws IllegalArgumentException if a contact with the same ID already exists
     */
    public void addContact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
        // Check if the contact ID already exists
        if (findContactById(contactID) != null) {
            throw new IllegalArgumentException("A contact with this ID already exists.");
        }

        // Create a new contact object and add it to the list
        Contact newContact = new Contact(contactID, firstName, lastName, phoneNumber, address);
        contactList.add(newContact);
    }

    /**
     * Removes a contact from the list using its ID.
     * @param contactID the ID of the contact to be removed.
     * @throws IllegalArgumentException if the contact is not found.
     */
    public void removeContact(String contactID) {
        Contact contactToRemove = findContactById(contactID);
        if (contactToRemove == null) {
            throw new IllegalArgumentException("Contact not found.");
        }

        contactList.remove(contactToRemove);
    }
    
    /**
     * Updates a specific field of a contact using its ID and selection.
     * @param contactID the contact ID to be updated.
     * @param updateValue the new value for the selected field.
     * @param selection the field to be updated (1: firstName, 2: lastName, 3: phoneNumber, 4: address).
     * @throws IllegalArgumentException if the contact ID is invalid or the update is invalid.
     */
    public void updateContact(String contactID, String updateValue, int selection) {
        Contact contactToUpdate = findContactById(contactID);
        if (contactToUpdate == null) {
            throw new IllegalArgumentException("Contact not found.");
        }

        switch (selection) {
            case 1:
                contactToUpdate.setFirstName(updateValue);
                break;
            case 2:
                contactToUpdate.setLastName(updateValue);
                break;
            case 3:
                contactToUpdate.setPhoneNumber(updateValue);
                break;
            case 4:
                contactToUpdate.setContactAddress(updateValue);
                break;
            default:
                throw new IllegalArgumentException("Invalid selection.");
        }
    }

    /**
     * Generates a unique ID for new contacts.
     * @return a unique contact ID as a String.
     */
    public String generateUniqueId() {
        Random rand = new Random();
        String uniqueID;
        
        do {
            uniqueID = String.valueOf(rand.nextInt(1000000000));
        } while (findContactById(uniqueID) != null);
        
        return uniqueID;
    }

    /**
     * Helper method to find a contact by its ID.
     * @param contactID the contact ID to search for.
     * @return the Contact object if found, or null if not found.
     */
    private Contact findContactById(String contactID) {
        for (Contact contact : contactList) {
            if (contact.getContactID().equals(contactID)) {
                return contact;
            }
        }
        return null;
    }
}