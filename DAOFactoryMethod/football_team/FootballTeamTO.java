package football_team;

import java.io.Serializable;
import footballer.FootballerTO;

public class FootballTeamTO implements Serializable {
  private static final long serialVersionUID = 1L;
  private int id;
  private String name;
  private FootballerTO[] footballers;

  public FootballTeamTO() {
  }

  public FootballTeamTO(int id, String name, FootballerTO[] footballers) {
    initData(id, name, footballers);
  }

  public FootballTeamTO(FootballTeamTO footballTeam) {
    initData(footballer.getId(), footballer.getName(), footballTeam.getFootballers());
  }

  public void initData(int id, String name, FootballerTO[] footballers) {
    this.id = id;
    this.name = name;
    this.footballers = footballers;

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

  public FootballerTO[] getFootballers() {
    return footballers;
  }

  public FootballTeamTO getData() {
    return new FootballTeamTO(this);
  }
}