package tests;

import org.junit.jupiter.api.Test;
import pages.StaticPage;

import static org.junit.jupiter.api.Assertions.*;

public class StaticPageTest extends BaseTest {

    @Test
    public void testContactPageLoads() {
        StaticPage staticPage = new StaticPage(driver);
        assertTrue(staticPage.isLoaded());
    }
}

