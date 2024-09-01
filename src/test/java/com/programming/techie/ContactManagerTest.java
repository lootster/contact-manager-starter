package com.programming.techie;

import org.junit.jupiter.api.*;

class ContactManagerTest {

    ContactManager contactManager;

    @BeforeAll
    public static void setupAll() {
        System.out.println("Should print before all Tests");
    }

    @BeforeEach
    public void setup() {
        contactManager = new ContactManager();
    }

    @Test
    public void shouldCreateContact() {
        contactManager.addContact("John", "Doe", "0123456789");

        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        Assertions.assertEquals(1, contactManager.getAllContacts().size());
        Assertions.assertTrue(contactManager.getAllContacts().stream()
                .anyMatch(contact -> contact.getFirstName().equals("John") &&
                        contact.getLastName().equals("Doe") &&
                        contact.getPhoneNumber().equals("0123456789")));
    }

    @Test
    @DisplayName("Should Not Create Contact When First Name Is Null")
    public void shouldThrowRuntimeExceptionWhenFirstNameIsNull() {

        Assertions.assertThrows(RuntimeException.class, () -> {
            contactManager.addContact(null, "Doe", "0123456789");
        });
    }

    @Test
    @DisplayName("Should Not Create Contact When Last Name Is Null")
    public void shouldThrowRuntimeExceptionWhenLastNameIsNull() {

        Assertions.assertThrows(RuntimeException.class, () -> {
            contactManager.addContact("John", null, "0123456789");
        });
    }

    @Test
    @DisplayName("Should Not Create Contact When Phone Number Is Null")
    public void shouldThrowRuntimeExceptionWhenPhoneNumberIsNull() {

        Assertions.assertThrows(RuntimeException.class, () -> {
            contactManager.addContact("John", "Doe", null);
        });
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Should Execute After Each Test");
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.println("Should Be Executed At The End Of The Test");
    }
}