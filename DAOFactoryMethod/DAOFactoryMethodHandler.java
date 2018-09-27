import java.util.List;
import java.util.Iterator;

import dao_factory.*;
import football_team.*;
import footballer.*;

public class DAOFactoryMethodHandler {

  private static void insertFootballers(FootballerDAO footballerDAO) {
    FootballerTO footballer = new FootballerTO("Cristiano Ronaldo", "Portuguese", 1);
    FootballerTO footballer2 = new FootballerTO("Paulo Dybala", "Argentinian", 1);
    boolean isInserted = footballerDAO.insertFootballer(footballer);
    isInserted &= footballerDAO.insertFootballer(footballer2);
    if (isInserted) {
      System.out.println("Footballers added.");
    }
  }

  private static void deleteAFootballer(FootballerDAO footballerDAO, int footballerId) {
    boolean isDeleted = footballerDAO.deleteFootballer(footballerId);
    if (isDeleted) {
      System.out.println("Footballer deleted.");
    }
  }

  private static void printFootballersOfTeam(FootballerDAO footballerDAO, int teamId) {

    List<FootballerTO> footballersOfJuventus = footballerDAO.getFootballersOfTeam(teamId);

    Iterator<FootballerTO> i = footballersOfJuventus.iterator();
    while (i.hasNext()) {
      FootballerTO f = i.next();
      System.out.println(f);
    }
  }

  private static void movePlayerToAnotherTeam(FootballerDAO footballerDAO, int footballerId, int teamId) {
    FootballerTO footballer3 = footballerDAO.getFootballerInfo(footballerId);

    footballer3.setTeam(teamId);
    boolean isMoved = footballerDAO.updateFootballer(footballer3); // moves player
    if (isMoved) {
      System.out.println("Footballer moved.");
    }

  }

  private static void insertTeams(FootballTeamDAO teamDAO) {
    FootballTeamTO team = new FootballTeamTO("Juventus");
    FootballTeamTO team2 = new FootballTeamTO("Milan");
    boolean isInserted = teamDAO.insertFootballTeam(team);
    isInserted &= teamDAO.insertFootballTeam(team2);
    if (isInserted) {
      System.out.println("Teams inserted.");
    }
  }

  private static void deleteTeam(footballTeamDAO teamDAO, int teamId) {
    boolean isDeleted = footballTeamDAO.deleteFootballTeam(2);
    if (isDeleted) {
      System.out.println("Team deleted.");
    }
  }

  private static void changeTeamName(FootballTeamDao teamDAO, String newName, int teamId) {
    FootballTeamTO team = teamDAO.getFootballTeamInfo(teamId);
    team.setName(newName);
    boolean isChanged = footballTeamDAO.updateFootballTeam(team);
    if (isChanged) {
      System.out.println("Team name changed.");
    }
  }

  private static void printTeamInfo(FootballTeamDao teamDAO, int teamId) {
    FootballTeamTO team = teamDAO.getFootballTeamInfo(teamId)
    System.out.println(team);
  }

  public static void main(String[] args) {
    DAOFactory factory = new MysqlDAOFactory();

    FootballTeamDAO teamDAO = factory.getFootballTeamDAO();
    FootballerDAO footballerDAO = factory.getFootballerDAO();

    insertTeams(teamDAO);
    insertFootballers(footballersDAO);

    printFootballersOfTeam(footballerDAO, 1); // prints footballers of Juventus

    deleteAFootballer(footballerDAO, 1); // deletes Cristiano Ronaldo

    movePlayerToAnotherTeam(footballerDAO, 2, 2); // move Dybala to Milan
    movePlayerToAnotherTeam(footballerDAO, 2, 1); // move Dybala to Juventus

    printFootballersOfTeam(footballerDAO, 2); // prints footballers of Milan

    changeTeamName(teamDAO, "RealMadrid", 1); // change Juventus name

    deleteTeam(footballTeamDAO, 2); // delete Milan

    printTeamInfo(teamDAO, 1); // prints Real Madrid info

  }
}