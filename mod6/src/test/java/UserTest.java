import ru.urfu.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    private User user;
    public void setUp() {
// Инициализируем объект User перед каждым тестом
        user = new User("TestUser", "testuser@example.com");
    }
    @Test
    public void testUserCreationWithParameters() {
        assertNotNull(user);
        assertEquals("TestUser", user.getLogin());
        assertEquals("testuser@example.com", user.getEmail());
    }

    @Test
    public void testInvalidEmail() {
        user.setEmail("invalid-email");
        assertNull(user.getEmail());
    }
    @Test
    public void testUserCreationWithoutParameters() {
        User emptyUser = new User("", "");
        assertNotNull(emptyUser);
        assertNull(emptyUser.getLogin());
        assertNull(emptyUser.getEmail());
    }

    @Test
    public void testShortLogin() {
        user.setLogin("abc");
        assertNull(user.getLogin());
    }
}