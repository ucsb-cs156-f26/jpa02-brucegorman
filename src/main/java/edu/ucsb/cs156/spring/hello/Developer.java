package edu.ucsb.cs156.spring.hello;

/**
 * A class with static methods to provide information about the developer.
 */

public class Developer {

    // This class is not meant to be instantiated
    // so we make the constructor private

    private Developer() {}
    
    /**
     * Get the name of the developer
     */

    public static String getName() {
        return "Kun Cheng";
    }

    /**
     * Get the github id of the developer
     * @return github id of the developer
     */

    public static String getGithubId() {
        return "brucegorman";
    }

    /**
     * Get the developers team
     * @return developers team as a Java object
     */
    
    public static Team getTeam() {
        Team team = new Team("f26-13");
        team.addMember("Kun Cheng");
        team.addMember("Alex Peroulas");
        team.addMember("Branden Tang");
        team.addMember("Akshaj Kashyap");
        team.addMember("Michael Zhang");
        team.addMember("Max Pinderski");
        return team;
    }
}
