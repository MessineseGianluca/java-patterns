package footballer;

import java.io.Serializable;

public class FootballerTO implements Serializable {
  private static final long serialVersionUID = 1L;

  private int id;
  private String name;
  private String nationality;
  private int teamId;

  public FootballerTO() {
  }

  public FootballerTO(int id, String name, String nationality, int teamId) {
    initData(id, name, nationality, teamId);
  }

  public FootballerTO(String name, String nationality, int teamId) {
    initData(name, nationality, teamId);
  }

  public FootballerTO(FootballerTO footballer) {
    initData(footballer.getId(), footballer.getName(), footballer.getNationality(), footballer.getTeamId());
  }

  private void initData(String name, String nationality, int teamId) {
    this.name = name;
    this.nationality = nationality;
    this.teamId = teamId;
  }

  private void initData(int id, String name, String nationality, int teamId) {
    this.id = id;
    this.name = name;
    this.nationality = nationality;
    this.teamId = teamId;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }

  public void setTeam(int teamId) {
    this.teamId = teamId;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getNationality() {
    return nationality;
  }

  public int getTeamId() {
    return teamId;
  }

  public FootballerTO getData() {
    return new FootballerTO(this);
  }

  public String toString() {
    return this.getId() + " " + this.getName() + " " + this.getNationality() + " " + this.getTeamId();
  }
}