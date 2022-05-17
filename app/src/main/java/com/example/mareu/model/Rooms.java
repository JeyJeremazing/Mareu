package com.example.mareu.model;


import java.util.List;

public class Rooms {

  //FIELDS
    private String roomName;
    public List <Rooms> roomList;
    private int numberOfRooms;
    private int maximumAttendees;

  //CONSTRUCTORS
  public Rooms(String name, List<Rooms> roomList, int numberOfRooms, int maximumAttendees) {
    this.roomName = name;
    this.roomList = roomList;
    this.numberOfRooms = numberOfRooms;
    this.maximumAttendees = maximumAttendees;
  }

  //GETTERS & SETTERS
  public String getRoomName() {
    return roomName;
  }

  public void setName(String name) {
    this.roomName = name;
  }

  public List<Rooms> getRoomList() {
    return roomList;
  }

  public void setRoomList(List<Rooms> roomList) {
    this.roomList = roomList;
  }

  public int getNumberOfRooms() {
    return numberOfRooms;
  }

  public void setNumberOfRooms(int numberOfRooms) {
    this.numberOfRooms = numberOfRooms;
  }

  public int getMaximumAttendees() {
    return maximumAttendees;
  }

  public void setMaximumAttendees(int maximumAttendees) {
    this.maximumAttendees = maximumAttendees;
  }
}
