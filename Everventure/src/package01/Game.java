package package01;

import package02.Weapon_Knife;
import package02.Weapon_LongSword;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

public class Game {

	ChoiceHandler cHandler = new ChoiceHandler();
	UI ui = new UI();
	VisibilityManager vm = new VisibilityManager(ui);
	Story story = new Story(this, ui, vm);
	int sessionid;

	String nextPosition1, nextPosition2, nextPosition3, nextPosition4;

	public static void main(String[] args) {

		new Game();

	}

	public Game() {
		ui.createUI(cHandler);
		story.defaultSetup();
		vm.showTitleScreen();
	}

	public class ChoiceHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			String yourChoice = event.getActionCommand();

			switch (yourChoice) {
				case "start":
					ui.loginMessage.setText(null);
					ui.username1.setText(null);
					ui.password1.setText(null);
					vm.showLoginScreen();
					break;
				case "login":
					login(cHandler);
					break;
				case "register":
					ui.registerMessage.setText(null);
					ui.username2.setText(null);
					ui.password2.setText(null);
					ui.password3.setText(null);
					vm.showRegisterScreen();
					break;
				case "register1":
				    register(cHandler);
					break;

				case "c1":
					story.selectPosition(nextPosition1);
					break;
				case "c2":
					story.selectPosition(nextPosition2);
					break;
				case "c3":
					story.selectPosition(nextPosition3);
					break;
				case "c4":
					story.selectPosition(nextPosition4);
					break;
				case "save":
					save();
					break;
				case "quit":
					ui.loginMessage.setText(null);
					ui.username1.setText(null);
					ui.password1.setText(null);
					vm.showLoginScreen();
					break;
			}


		}

	}
	public void login(Game.ChoiceHandler event)
	{
		if(ui.username1.getText().isBlank() == false && ui.password1.getPassword().length > 0)
		{
			validatelogin();
		} else {

			ui.loginMessage.setText("Please enter username and password");

		}
	}

	public void validatelogin() {

		DatabaseConnection connectNow = new DatabaseConnection();
		Connection connectDB = connectNow.getConnection();

		String username = ui.username1.getText();
		String password = String.valueOf(ui.password1.getPassword());

		String verifyLogin = "SELECT * FROM db_joc.login WHERE username = '"+ username + "' AND password = '"+ password + "'";

		try
		{
			Statement statement = connectDB.createStatement();
			ResultSet queryResult = statement.executeQuery(verifyLogin);

				if(queryResult.next()) {


					ui.loginMessage.setText("Login successful!");
					sessionid = queryResult.getInt(1);
					load();
					vm.titleToTown();

				}
				else {
					ui.loginMessage.setText("Invalid login!");

				}

		} catch (Exception e) {

			e.printStackTrace();
			e.getCause();

		}
	}
	public void register(Game.ChoiceHandler event)
	{
		if(Arrays.equals(ui.password2.getPassword(), ui.password3.getPassword()))
		{
			registerUser();
		}
		else
		{
			ui.registerMessage.setText("Password does not match!");
		}

	}
	public void registerUser()
	{
		DatabaseConnection connection = new DatabaseConnection();
		Connection connection1 = connection.getConnection();

		String username = ui.username2.getText();
		String password = String.valueOf(ui.password2.getPassword());

		String insertFields = "INSERT INTO db_joc.login(username, password) VALUES ('";
		String insertValues = username + "','" + password + "')";
		String insertToRegister = insertFields + insertValues;

		String insertFields1 = "INSERT INTO db_joc.state(state, hp, silverring, weapon) VALUES ('townGate','15','0','Knife')";

		try
		{
			Statement statement = connection1.createStatement();
			statement.executeUpdate(insertToRegister);
			statement.executeUpdate(insertFields1);
			ui.registerMessage.setText("Register successful!");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			e.getCause();
		}

	}
	public void save()
	{
		DatabaseConnection connection = new DatabaseConnection();
		Connection connection2 = connection.getConnection();

		String update1 = "UPDATE db_joc.state SET state = '" + story.state + "' , hp = " + story.player.hp + ", silverring = " + story.silverRing;
		String update2 = ", weapon = '" + story.player.currrentWeapon.name +"' WHERE id = " + sessionid;
		String update = update1 + update2;
		try
		{
			Statement statement = connection2.createStatement();
			statement.executeUpdate(update);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			e.getCause();
		}

	}
	public void load()
	{
		DatabaseConnection connection = new DatabaseConnection();
		Connection connection3 = connection.getConnection();

		String load = "SELECT * FROM db_joc.state WHERE id= " + sessionid;
		try
		{

				Statement statement = connection3.createStatement();
				ResultSet queryResult = statement.executeQuery(load);
			if(queryResult.next()) {
				story.selectPosition(queryResult.getString("state"));
				story.player.hp = queryResult.getInt("hp");
				ui.healthBar.setValue(story.player.hp);
				story.silverRing = queryResult.getInt("silverring");
				if (queryResult.getString("weapon").equals("Knife"))
				{
					story.player.currrentWeapon = new Weapon_Knife();
					ui.weaponNameLabel.setText(story.player.currrentWeapon.name + " (" + story.player.currrentWeapon.damage + ")");
				}
				else {
					story.player.currrentWeapon = new Weapon_LongSword();
					ui.weaponNameLabel.setText(story.player.currrentWeapon.name + " (" + story.player.currrentWeapon.damage + ")");
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			e.getCause();
		}
	}

}