package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Kun Cheng", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("brucegorman", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team t = Developer.getTeam();
        assertEquals("f26-13", t.getName());
    }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Kun Cheng"), "Team should contain Kun Cheng");
        assertTrue(t.getMembers().contains("Alex Peroulas"), "Team should contain Alex Peroulas");
        assertTrue(t.getMembers().contains("Branden Tang"), "Team should contain Branden Tang");
        assertTrue(t.getMembers().contains("Akshaj Kashyap"), "Team should contain Akshaj Kashyap");
        assertTrue(t.getMembers().contains("Michael Zhang"), "Team should contain Michael Zhang");
        assertTrue(t.getMembers().contains("Max Pinderski"), "Team should contain Max Pinderski");
        assertEquals(6, t.getMembers().size());
    }

}
