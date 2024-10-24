/* 
 * Mitchell Fontaine
 * 10/09/2024
 * CS-320
 */


package projectOne;

public class Contact {
    
    // Private fields for storing contact information
    private final String contactID;  // Final to ensure immutability
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String contactAddress;
    
    /**
     * Constructor to initialize a new Contact object.
     * Validates the input data before assignment.
     * 
     * @param id the contact's ID, must not be null and length <= 10
     * @param firstName the contact's first name, must not be null and length <= 10
     * @param lastName the contact's last name, must not be null and length <= 10
     * @param number the contact's phone number, must be exactly 10 characters
     * @param address the contact's address, must not be null and length <= 30
     * @throws IllegalArgumentException if any parameter is invalid
     */
    public Contact(String id, String firstName, String lastName, String number, String address) {
        // Validate contact ID
        if (id == null || id.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        }

        // Validate first name
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }

        // Validate last name
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }

        // Validate phone number (must be exactly 10 digits)
        if (number == null || number.length() != 10) {
            throw new IllegalArgumentException("Invalid phone number");
        }

        // Validate address (must not exceed 30 characters)
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }

        // Assign values if all validations pass
        this.contactID = id;  // Final and immutable
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = number;
        this.contactAddress = address;
    }

    // Getter methods

    public String getContactID() {
        return this.contactID;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getContactAddress() {
        return this.contactAddress;
    }

    // Setter methods for updatable fields

    public void setFirstName(String newFirstName) {
        if (newFirstName == null || newFirstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        this.firstName = newFirstName;
    }

    public void setLastName(String newLastName) {
        if (newLastName == null || newLastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        this.lastName = newLastName;
    }

    public void setPhoneNumber(String newPhoneNumber) {
        if (newPhoneNumber == null || newPhoneNumber.length() != 10) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phoneNumber = newPhoneNumber;
    }

    public void setContactAddress(String newContactAddress) {
        if (newContactAddress == null || newContactAddress.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.contactAddress = newContactAddress;
    }
}
