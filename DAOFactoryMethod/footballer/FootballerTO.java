package footballer;

import java.io.Serializable;

public class FootballerTO implements Serializable {
  private static final long serialVersionUID = 1L;

  private int id;
  private String name;
  private String nationality;

  public FootballerTO() {
  }

  public FootballerTO(int id, String name, String nationality) {
    initData(id, name, nationality);
  }

  public FootballerTO(FootballerTO footballer) {
    initData(footballer.getId(), footballer.getName(), footballer.getNationality());
  }

  public void initData(int id, String name, String nationality) {
    this.id = id;
    this.name = name;
    this.nationality = nationality;
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

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getNationality() {
    return nationality;
  }

  public FootballerTO getData() {
    return new FootballerTO(this);
  }
}