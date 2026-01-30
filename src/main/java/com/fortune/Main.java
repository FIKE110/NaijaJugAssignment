package com.fortune;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a conference
        Conference naijaJugConference = new Conference("Naija JUG Conference", "A conference for Java developers in Nigeria");

        // Create tracks
        Track coreJavaTrack = new Track("Core Java");
        Track enterpriseJavaTrack = new Track("Enterprise Java");

        // Create sessions
        Session session1 = new Session("Java Fundamentals", "An introduction to the basics of Java", 1);
        Session session2 = new Session("Java for the Web", "Building web applications with Java", 2);
        Session session3 = new Session("Microservices with Spring Boot", "Creating microservices with Spring Boot", 1);

        // Create speakers
        Speaker speaker1 = new Speaker("Fortune", "A passionate Java developer");
        Speaker speaker2 = new Speaker("Israel", "A seasoned enterprise architect");

        // Assign speakers to sessions
        session1.setSpeakers(new ArrayList<>(List.of(speaker1)));
        session2.setSpeakers(new ArrayList<>(List.of(speaker2)));
        session3.setSpeakers(new ArrayList<>(List.of(speaker1, speaker2)));

        // Assign sessions to tracks
        coreJavaTrack.setSessions(new ArrayList<>(List.of(session1, session3)));
        enterpriseJavaTrack.setSessions(new ArrayList<>(List.of(session2)));

        // Assign tracks to the conference
        naijaJugConference.setTracks(new ArrayList<>(List.of(coreJavaTrack, enterpriseJavaTrack)));

        // Print conference details
        System.out.println("Conference: " + naijaJugConference.getName());
        System.out.println("Description: " + naijaJugConference.getDescription());
        System.out.println("Tracks:");
        for (Track track : naijaJugConference.getTracks()) {
            System.out.println("- " + track.getTitle());
            System.out.println("  Sessions:");
            for (Session session : track.getSessions()) {
                System.out.println("  - " + session.getTitle());
                System.out.println("    Description: " + session.getDescription());
                System.out.println("    Time Slot: " + session.getTimeSlot());
                System.out.println("    Speakers:");
                for (Speaker speaker : session.getSpeakers()) {
                    System.out.println("    - " + speaker.getName() + " (" + speaker.getBio() + ")");
                }
            }
        }
    }
}