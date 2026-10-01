package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_true_for_same_object() {
        assertTrue(team.equals(team));
    }

    @Test
    public void equals_returns_true_for_same_object_even_with_null_name() {
        // only the obj == this check can return true here; name.equals would throw
        team.setName(null);
        assertTrue(team.equals(team));
    }

    @Test
    public void equals_returns_false_for_different_class() {
        assertFalse(team.equals("test-team"));
        assertFalse(team.equals(null));
    }

    @Test
    public void equals_returns_true_for_same_name_and_members() {
        Team t1 = new Team("foo");
        t1.addMember("bar");
        Team t2 = new Team("foo");
        t2.addMember("bar");
        assertEquals(t1, t2);
    }

    @Test
    public void equals_returns_false_for_different_name() {
        Team t1 = new Team("foo");
        t1.addMember("bar");
        Team t2 = new Team("baz");
        t2.addMember("bar");
        assertNotEquals(t1, t2);
    }

    @Test
    public void equals_returns_false_for_different_members() {
        Team t1 = new Team("foo");
        t1.addMember("bar");
        Team t2 = new Team("foo");
        t2.addMember("qux");
        assertNotEquals(t1, t2);
    }

    @Test
    public void hashCode_is_same_for_equal_teams() {
        Team t1 = new Team("foo");
        t1.addMember("bar");
        Team t2 = new Team("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    public void hashCode_returns_expected_value() {
        // "foo".hashCode() | ["bar"].hashCode() == 101574 | 97330
        Team t = new Team("foo");
        t.addMember("bar");
        assertEquals(130294, t.hashCode());
    }

    @Test
    public void setMembers_and_getMembers_work() {
        java.util.ArrayList<String> members = new java.util.ArrayList<String>();
        members.add("bar");
        team.setMembers(members);
        assertEquals(members, team.getMembers());
    }

    @Test
    public void default_constructor_creates_empty_team() {
        Team t = new Team();
        assertEquals("", t.getName());
        assertTrue(t.getMembers().isEmpty());
    }

}
