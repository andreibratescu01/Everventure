package package01;

public class VisibilityManager {

    UI ui;
    public VisibilityManager(UI userInterface){
        ui = userInterface;

    }
    public void showLoginScreen(){

        //Show the login screen

        ui.loginPanel.setVisible(true);
        ui.loginButtonPanel.setVisible(true);
        ui.loginMessagePanel.setVisible(true);

        //Hide the game and title screen
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);
        ui.healthBarPanel.setVisible(false);
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);
        ui.registerPanel.setVisible(false);
        ui.registerMessagePanel.setVisible(false);
        ui.loginButtonPanel1.setVisible(false);
        ui.imagePanel.setVisible(false);
        ui.savequitPanel.setVisible(false);
    }
    public void showRegisterScreen(){

        //Show the login screen

        ui.registerPanel.setVisible(true);
        ui.loginButtonPanel1.setVisible(true);
        ui.registerMessagePanel.setVisible(true);

        //Hide the game and title screen
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);
        ui.healthBarPanel.setVisible(false);
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);
        ui.loginPanel.setVisible(false);
        ui.loginMessagePanel.setVisible(false);
        ui.loginButtonPanel.setVisible(false);
        ui.imagePanel.setVisible(false);
        ui.savequitPanel.setVisible(false);

    }
    public void showTitleScreen(){

        //Show the title screen
        ui.titleNamePanel.setVisible(true);
        ui.startButtonPanel.setVisible(true);

        //Hide the game screen and login screen
        ui.healthBarPanel.setVisible(false);
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);
        ui.loginPanel.setVisible(false);
        ui.loginButtonPanel.setVisible(false);
        ui.registerPanel.setVisible(false);
        ui.loginMessagePanel.setVisible(false);
        ui.registerMessagePanel.setVisible(false);
        ui.loginButtonPanel1.setVisible(false);
        ui.imagePanel.setVisible(false);
        ui.savequitPanel.setVisible(false);

    }
    public void titleToTown(){
        //Hide the title screen and login screen
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.loginPanel.setVisible(false);
        ui.loginButtonPanel.setVisible(false);
        ui.registerPanel.setVisible(false);
        ui.loginMessagePanel.setVisible(false);
        ui.registerMessagePanel.setVisible(false);
        ui.loginButtonPanel1.setVisible(false);

        //Show the game screen
        ui.imagePanel.setVisible(true);
        ui.healthBarPanel.setVisible(true);
        ui.mainTextPanel.setVisible(true);
        ui.playerPanel.setVisible(true);
        ui.savequitPanel.setVisible(true);

    }
}
