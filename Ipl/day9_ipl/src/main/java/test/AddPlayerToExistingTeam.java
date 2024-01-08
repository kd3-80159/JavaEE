package test;

import java.time.LocalDate;
import java.util.Scanner;

import dao.PlayerDao;
import dao.PlayerDaoImpl;
import pojos.Player;

public class AddPlayerToExistingTeam {
	public static void main(String[] args) {
		System.out.println("Enter a ID");
		Scanner sc = new Scanner(System.in);
		Integer teamId=sc.nextInt();
		PlayerDao playerDao = new PlayerDaoImpl();
		System.out.println("Enter emp details : firstName lastName Date Avg Wickets");
		Player Player = new Player(sc.next(), sc.next(), LocalDate.parse(sc.next()), sc.nextDouble(), sc.nextInt());
		playerDao.addPlayerDetails(teamId, Player);
	}
}
