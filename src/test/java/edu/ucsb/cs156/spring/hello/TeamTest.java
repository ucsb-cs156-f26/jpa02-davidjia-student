package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void equals_returns_correct_boolean() {
        assertEquals(true, team.equals(team));
        String otherString = new String("helloWorld");
        assertEquals(false, team.equals(otherString));
        Team otherTeam = new Team("test-team");
        team.addMember("David");
        team.addMember("Alan");
        otherTeam.addMember("David");
        otherTeam.addMember("Alan");
        assertEquals(true, team.equals(otherTeam));
        otherTeam = new Team("test");
        otherTeam.addMember("David");
        otherTeam.addMember("Alan");
        assertEquals(false, team.equals(otherTeam));
        otherTeam = new Team("test-team");
        otherTeam.addMember("David");
        otherTeam.addMember("Bob");
        assertEquals(false, team.equals(otherTeam));
    }

    @Test
    public void hashCode_returns_correct_hashCode() {
        Team otherTeam = new Team("test-team");
        team.addMember("David");
        team.addMember("Alan");
        otherTeam.addMember("David");
        otherTeam.addMember("Alan");
        assertEquals(-65603, otherTeam.hashCode());
    }
  
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
