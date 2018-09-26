import dao_factory.*;
import footballer.*;
import footballTeam.*;

public class DAOFactoryHandler {
  public static void main(String[] args) {
    DAOFactory factory = new MysqlDAOFactory();

    FootballTeamDAO teamDAO = factory.getFootballTeamDAO();
    FootballerDAO footballerDAO = factory.getFootballerDAO();

    FootballTeamTO team = new FootballTeamTO(1, "Juventus");
    FootballerTO footballer = new FootballerTO(1, "Cristiano Ronaldo", "Portuguese", 1);

    teamDAO.insert(team);
    footballerDAO.insert(footballer);
  }
}