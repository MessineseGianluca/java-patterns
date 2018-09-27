import java.util.List;
import java.util.Iterator;

import dao_factory.*;
import football_team.*;
import footballer.*;

public class DAOFactoryMethodHandler {
  public static void main(String[] args) {
    DAOFactory factory = new MysqlDAOFactory();

    FootballTeamDAO teamDAO = factory.getFootballTeamDAO();
    FootballerDAO footballerDAO = factory.getFootballerDAO();

    FootballTeamTO team = new FootballTeamTO("Juventus");
    FootballerTO footballer = new FootballerTO("Cristiano Ronaldo", "Portuguese", 1);

    teamDAO.insertFootballTeam(team);
    footballerDAO.insertFootballer(footballer);

    List<FootballerTO> footballersOfJuventus = footballerDAO.getFootballersOfTeam(1);

    Iterator<FootballerTO> i = footballersOfJuventus.iterator();
    while (i.hasNext()) {
      FootballerTO f = i.next();
      System.out.println(f.getId() + " " + f.getName() + " " + f.getNationality());
    }
  }
}