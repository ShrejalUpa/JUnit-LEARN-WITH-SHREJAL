package org.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserServiceTest {

    private UserService userService;

    @Before
    public void setUp() {
        userService = new UserService();
        userService.addUser("john_doe", "password123");
    }

    @Test
    public void testAddUser() {
        userService.addUser("jane_doe", "pass456");
        assertNotNull(userService.getUser("jane_doe"));
    }

    @Test
    public void testGetUser() {
        User user = userService.getUser("john_doe");
        assertEquals("john_doe", user.getUsername());
        assertEquals("password123", user.getPassword());
    }

    @Test
    public void testAuthenticateSuccess() {
        assertTrue(userService.authenticate("john_doe", "password123"));
    }

    @Test
    public void testAuthenticateFailure() {
        assertFalse(userService.authenticate("john_doe", "wrongpassword"));
    }

    @Test
    public void testChangePassword() {
        userService.changePassword("john_doe", "newpassword");
        assertTrue(userService.authenticate("john_doe", "newpassword"));
    }

    @Test
    public void testUserNotFound() {
        assertNull(userService.getUser("non_existent_user"));
    }
}
