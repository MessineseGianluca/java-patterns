package football_team;

import java.io.Serializable;
import footballer.FootballerTO;

public class FootballTeamTO implements Serializable {
  private static final long serialVersionUID = 1L;
  private int id;
  private String name;

  public FootballTeamTO() {
  }

  public FootballTeamTO(int id, String name) {
    initData(id, name);
  }

  public FootballTeamTO(FootballTeamTO footballTeam) {
    initData(footballTeam.getId(), footballTeam.getName());
  }

  public void initData(int id, String name) {
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
}