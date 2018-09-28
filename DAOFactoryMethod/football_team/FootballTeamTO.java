package football_team;

import java.io.Serializable;

public class FootballTeamTO implements Serializable {
  private static final long serialVersionUID = 1L;
  private int id;
  private String name;

  public FootballTeamTO() {
  }

  public FootballTeamTO(int id, String name) {
    initData(id, name);
  }

  public FootballTeamTO(String name) {
    initData(name);
  }

  public FootballTeamTO(FootballTeamTO footballTeam) {
    initData(footballTeam.getId(), footballTeam.getName());
  }

  private void initData(String name) {
    this.name = name;
  }

  private void initData(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public FootballTeamTO getData() {
    return new FootballTeamTO(this);
  }

  public String toString() {
    return this.getId() + " " + this.getName();
  }
}