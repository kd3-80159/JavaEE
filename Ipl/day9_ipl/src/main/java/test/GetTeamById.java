package test;

import java.util.Scanner;

import dao.TeamDao;
import dao.TeamDaoImpl;


public class GetTeamById {
public static void main(String[] args) {
	TeamDao t= new TeamDaoImpl(); 
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter a teamId");
	System.out.println(t.getTeamDetailsByTeamId(sc.nextInt()));
}
}
