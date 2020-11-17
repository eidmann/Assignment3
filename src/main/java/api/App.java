package main.java.api;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {

	private static Statement stmt;
	private static ResultSet results;

	public static void main(String[] args) {

		String sql_select = "Select * From actors";

		int id = 10;
		String fname;
		String lname;

		Scanner input = new Scanner(System.in);
		System.out.println("Ange förnamn");
		fname = input.nextLine();
		System.out.println("Ange efternamn");
		lname = input.nextLine();

		Person person = new Person(fname, lname);

		String sql_select2 = "Insert into actors (fname, lname) values ('" + person.getFname() + "','"
				+ person.getLname() + "')";

		try (Connection conn = dbConnect.createNewDBconnection()) {

			stmt = conn.createStatement();
			stmt.executeUpdate(sql_select2);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}

		// ---------------Test för Select-----

		try (Connection conn = dbConnect.createNewDBconnection()) {

			stmt = conn.createStatement();
			results = stmt.executeQuery(sql_select);

			List<GetActors> studentsList = new ArrayList<GetActors>();

			while (results.next()) {

				GetActors stdObject = new GetActors();

				stdObject.setId(Integer.valueOf(results.getString("id")));
				stdObject.setFName(results.getString("fname"));
				stdObject.setLName(results.getString("lname"));
				// stdObject.setAddress(results.getString("Address"));
				// stdObject.setCourse_code(results.getString("course_code"));

				studentsList.add(stdObject);
			}

			ObjectMapper mapper = new ObjectMapper();
			String JSONOutput = mapper.writeValueAsString(studentsList);
			System.out.println(JSONOutput);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

	}

	public String testActors() {
		String sql_select = "Select * From actors";
		String JSONOutput = "";
		List<GetActors> studentsList = new ArrayList<GetActors>();

		try (Connection conn = dbConnect.createNewDBconnection()) {

			stmt = conn.createStatement();
			results = stmt.executeQuery(sql_select);

			while (results.next()) {

				GetActors stdObject = new GetActors();

				stdObject.setId(Integer.valueOf(results.getString("id")));
				stdObject.setFName(results.getString("fname"));
				stdObject.setLName(results.getString("lname"));
				// stdObject.setAddress(results.getString("Address"));
				// stdObject.setCourse_code(results.getString("course_code"));

				studentsList.add(stdObject);
			}

			ObjectMapper mapper = new ObjectMapper();
			JSONOutput = mapper.writeValueAsString(studentsList);
			System.out.println(JSONOutput);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return JSONOutput;

	}

	public Person createActors(String fname, String lname) {

		int id = 0;

		Scanner input = new Scanner(System.in);
		System.out.println("Ange förnamn");
		fname = input.nextLine();
		System.out.println("Ange efternamn");
		lname = input.nextLine();

		Person person = new Person(fname, lname);

		String sql_select2 = "Insert into actors (fname, lname) values ('" + person.getFname() + "','"
				+ person.getLname() + "')";

		try (Connection conn = dbConnect.createNewDBconnection()) {

			stmt = conn.createStatement();
			stmt.executeUpdate(sql_select2);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return person;

	}
}
