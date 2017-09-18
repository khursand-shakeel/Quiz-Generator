
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainClass extends Application{

	private static Stage primaryStage;
	private static Button loginButton;
//	private static Button createQuizButton;
	private static TextField loginUsernameField;
	private static PasswordField loginPasswordField;
	//private TextField quizTitleField;
	
	
	public static void main(String[] args) {
		launch(args);
		
	}

	@Override
	public void start(Stage pStage) throws Exception {
		this.primaryStage = pStage;
		
		primaryStage.setTitle("Title of the window");

		GridPane signUpGrid = getSignUpGrid();
		Scene scene = new Scene(signUpGrid, 300, 275);
		primaryStage.setScene(scene);
	
		GridPane signInGrid = getSignInGrid();
		setLoginButtonListener(signInGrid);

		Scene signInScene = new Scene(signInGrid, 300, 275);

		
		Hyperlink signInLink = new Hyperlink();
		signInLink.setText("Sign In instead");
		signUpGrid.add(signInLink, 0, 5);
		signInLink.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent e) {
		    	primaryStage.setScene(signInScene);
		    }
		});
		
		Hyperlink signUpLink = new Hyperlink();
		signUpLink.setText("Sign Up instead");
		signInGrid.add(signUpLink, 0, 3);
		signUpLink.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent e) {
		    	primaryStage.setScene(scene);
		    }
		});
		
        primaryStage.show();
	}
	
	private static GridPane getSignUpGrid(){
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		Text scenetitle = new Text("Sign Up");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);
		
		Label email = new Label("Email:");
		grid.add(email, 0, 1);

		TextField userEmail = new TextField();
		grid.add(userEmail, 1, 1);
		
		Label userName = new Label("User Name:");
		grid.add(userName, 0, 2);

		TextField userTextField = new TextField();
		grid.add(userTextField, 1, 2);

		Label password = new Label("Password:");
		grid.add(password, 0, 3);

		PasswordField userPassword = new PasswordField();
		grid.add(userPassword, 1, 3);
		
		Label role = new Label("Role:");
		grid.add(role, 0, 4);
		/*888*/
		final ToggleGroup group = new ToggleGroup();

		RadioButton rb1 = new RadioButton("Student");
		rb1.setToggleGroup(group);
		rb1.setSelected(true);
		

		RadioButton rb2 = new RadioButton("Instructor");
		rb2.setToggleGroup(group);
		
		HBox hbox = new HBox();
		hbox.getChildren().add(rb1);
		hbox.getChildren().add(rb2);
		grid.add(hbox, 1, 4);
		
		/*888*/
		
		//grid.setGridLinesVisible(true);

		Button btn = new Button("Sign up");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 5);
		
		/*final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);*/
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent e) {
                /*actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Sign in button pressed");*/
            	/*User user = new User(userEmail.getText(), userTextField.getText(), userPassword.getText(), 
            			group.getSelectedToggle().getUserData().toString());*/
            	
            	User user = new User(userEmail.getText(), userTextField.getText(), userPassword.getText());           	
            	//System.out.println(user.getEmail()+" "+ user.getUsername() + " "+ user.getPassword());
            	
            	/*System.out.println(userEmail.getText());
            	System.out.println(userTextField.getText());
            	System.out.println(userPassword.getText());           	
            	//System.out.println(group.getSelectedToggle().getUserData().toString());*/

            	try {
            		File file = new File("D:\\users.txt");
					FileOutputStream fout = new FileOutputStream(file);
				    ObjectOutputStream oos = new ObjectOutputStream(fout);
				    oos.writeObject(user);
				    oos.close();
            	
				} catch (FileNotFoundException e1) {
					System.out.println("First Exception:\n");
					e1.printStackTrace();
				} catch (IOException e1) {
					System.out.println("Second Exception:\n");
					e1.printStackTrace();
				}
            	
            	try {
					FileInputStream fis = new FileInputStream("D:\\users.txt");
					ObjectInputStream ois = new ObjectInputStream(fis);
					User user1 = (User) ois.readObject();
					//System.out.println("User1 details:");
					//System.out.println(user1.getEmail()+" "+ user1.getUsername() + " "+ user1.getPassword());
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
            }
        });
        
		return grid;
	}
	private static GridPane getSignInGrid(){
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		Text scenetitle1 = new Text("Sign In");
		scenetitle1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle1, 0, 0, 2, 1);
		
		Label loginUsername = new Label("Username:");
		grid.add(loginUsername, 0, 1);
		
		loginUsernameField = new TextField();
		grid.add(loginUsernameField, 1, 1);
		
		Label loginPassword = new Label("Password:");
		grid.add(loginPassword, 0, 2);

		loginPasswordField = new PasswordField();
		grid.add(loginPasswordField, 1, 2);
		
		loginButton = new Button("Sign In");
		HBox loginhbBtn = new HBox(10);
		loginhbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		loginhbBtn.getChildren().add(loginButton);
		grid.add(loginhbBtn, 1, 3);
		
		/*final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 5);*/
        
		
		return grid; 
	}
	
	private static User retrieveSerializedObject(){
		User user = null;
		try {
			FileInputStream fis = new FileInputStream("D:\\users.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			user = (User) ois.readObject();
			//System.out.println("User1 details:");
			//System.out.println(user1.getEmail()+" "+ user1.getUsername() + " "+ user1.getPassword());
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return user;
	}
	private Stage getPrimaryStage(){
		return this.primaryStage;
	}
	
	
	
	private static void setLoginButtonListener(GridPane grid){
		
		loginButton.setOnAction(new EventHandler<ActionEvent>() {
	       	 
            @Override
            public void handle(ActionEvent e) {              	
            	String username = loginUsernameField.getText();
            	String password = loginPasswordField.getText();
            	//System.out.println(username + "  "+ password);
            	
            	User user = retrieveSerializedObject();
            	//System.out.println(user.getUsername()+"   "+ user.getPassword() );
            	if (user.getUsername().equals(username) && user.getPassword().equals(password)){    		
            		/*GridPane welcomeGrid = getWelcomeGrid();
            		Scene welcomeScene = new Scene(welcomeGrid, 300, 275);
            		primaryStage.setScene(welcomeScene);
            		primaryStage.show();*/
            		
            		
            		
            		
            		
            		
            		
            		/*grid.setAlignment(Pos.CENTER);
            		grid.setHgap(10);
            		grid.setVgap(10);
            		grid.setPadding(new Insets(25, 25, 25, 25));*/
            		
            		/*Text scenetitle1 = new Text("Sign In");
            		scenetitle1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
            		grid.add(scenetitle1, 0, 0, 2, 1);
            		
            		Label loginUsername = new Label("Username:");
            		grid.add(loginUsername, 0, 1);
            		
            		loginUsernameField = new TextField();
            		grid.add(loginUsernameField, 1, 1);
            		
            		Label loginPassword = new Label("Password:");
            		grid.add(loginPassword, 0, 2);

            		loginPasswordField = new PasswordField();
            		grid.add(loginPasswordField, 1, 2);
            		
            		loginButton = new Button("Sign In");
            		HBox loginhbBtn = new HBox(10);
            		loginhbBtn.setAlignment(Pos.BOTTOM_RIGHT);
            		loginhbBtn.getChildren().add(loginButton);
            		grid.add(loginhbBtn, 1, 3);
            		
            		
            		
            		
            		
            		
            		
            		
            		Scene welcomeScene = new Scene(grid, 300, 275);
            		primaryStage.setScene(welcomeScene);
            		primaryStage.show();*/
            		
            		grid.getChildren().clear();
            		grid.setAlignment(Pos.TOP_CENTER);
            		Text scenetitle = new Text("Welcome to the Quiz Generator!");
            		scenetitle.setFont(Font.font("Tahoma", FontWeight.SEMI_BOLD, 40));
            		grid.add(scenetitle, 0, 0, 2, 1);
            		
            		Label title = new Label("Title:");
            		grid.add(title, 0, 3);
            		
            		TextField titleField = new TextField();
            		grid.add(titleField, 1, 3);
            		
            		Label description = new Label("Description:");
            		grid.add(description, 0, 4);
            		
            		TextField descriptionField = new TextField();
            		grid.add(descriptionField, 1, 4);
            		
            		Button createQuizButton = new Button("Create Quiz");
            		HBox loginhbBtn = new HBox(10);
            		loginhbBtn.setAlignment(Pos.BOTTOM_CENTER);
            		loginhbBtn.getChildren().add(createQuizButton);
            		grid.add(loginhbBtn, 1, 6);
            		
            		setCreateQuizButtonListener(grid, titleField, descriptionField, createQuizButton);

            	}
            	else{
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("Sign In failed");
            		alert.setHeaderText(null);
            		alert.setContentText("Username or password not correct");
            		alert.showAndWait();
            		
            	}
            }
        });
		
	}
	
	private static void setCreateQuizButtonListener(GridPane grid, TextField titleField, TextField descriptionField, Button createQuizButton){
		createQuizButton.setOnAction(new EventHandler<ActionEvent>() {
	       	 
            @Override
            public void handle(ActionEvent e) { 
        		grid.getChildren().clear();
 		
            	Quiz quiz = new Quiz(titleField.getText(), descriptionField.getText(), new ArrayList<MultipleChoiceQuestion>());
            	quiz.setNoOfQuestions(0);
        		
            	Text scenetitle = new Text("Quiz: " + titleField.getText() + "\n");
        		scenetitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 40));
        		grid.add(scenetitle, 0, 0, 2, 1);
        		
        		Text quizDescription = new Text(descriptionField.getText() + "\n\n");
        		quizDescription.setFont(Font.font("Tahoma", FontWeight.SEMI_BOLD, 30));
        		grid.add(quizDescription, 0, 1, 2, 1);
        		
        		Text question = new Text("Question 1:" + "\n");
        		question.setFont(Font.font("Tahoma", FontWeight.SEMI_BOLD, 20));
        		grid.add(question, 0, 2, 2, 1);
        		
        		Label questionTitle = new Label("Title:");
        		grid.add(questionTitle, 0, 3);
        		
        		TextField titleField = new TextField();
        		grid.add(titleField, 1, 3);
        		
        		Label option1 = new Label("Option 1:");
        		grid.add(option1, 0, 4);
        		
        		TextField option1Field = new TextField();
        		grid.add(option1Field, 1, 4);
        		
        		Label option2 = new Label("Option 2:");
        		grid.add(option2, 0, 5);
        		
        		TextField option2Field = new TextField();
        		grid.add(option2Field, 1, 5);
        		
        		Label option3 = new Label("Option 3:");
        		grid.add(option3, 0, 6);
        		
        		TextField option3Field = new TextField();
        		grid.add(option3Field, 1, 6);
        		
        		Label option4 = new Label("Option 4:");
        		grid.add(option4, 0, 7);
        		
        		TextField option4Field = new TextField();
        		grid.add(option4Field, 1, 7);
        		
        		Button addQuestionButton = new Button("Add Question");
        		HBox loginhbBtn = new HBox(10);
        		loginhbBtn.setAlignment(Pos.BOTTOM_CENTER);
        		loginhbBtn.getChildren().add(addQuestionButton);
        		grid.add(loginhbBtn, 4, 5);
        		//grid.add(loginhbBtn, 1, 9);
        		
        		Button finishQuizButton = new Button("Finish Creating Quiz");
        		HBox finishQuizhbBtn = new HBox(10);
        		finishQuizhbBtn.setAlignment(Pos.BOTTOM_CENTER);
        		finishQuizhbBtn.getChildren().add(finishQuizButton);
        		grid.add(finishQuizhbBtn, 1, 10);
        		
        		List<TextField> list = new ArrayList<TextField>();
        		list.add(titleField);
        		list.add(option1Field);
        		list.add(option2Field);
        		list.add(option3Field);
        		list.add(option4Field);
        		
        		
        		setAddQuestionButtonListener(addQuestionButton, list, quiz, question);     
        		setFinishQuizButtonListener(finishQuizButton, quiz);
            }         
		});
		
	}
	
	private static void setAddQuestionButtonListener(Button addQuestionButton, List<TextField> list, Quiz quiz, Text question){
		
		addQuestionButton.setOnAction(new EventHandler<ActionEvent>() {
	       	 
            @Override
            public void handle(ActionEvent e) {
            	quiz.setNoOfQuestions(quiz.getNoOfQuestions() + 1);
            	MultipleChoiceQuestion mcq = new MultipleChoiceQuestion(list.get(0).getText(), list.get(1).getText(), list.get(2).getText(),
            			list.get(3).getText(), list.get(4).getText());
            	
            	quiz.getListOfQuestions().add(mcq);
            	String qTitle = list.get(0).getText();
            	for(int i = 0; i < 5; i++){
            		list.get(i).clear();         		
            	}
            	
            	Alert alert = new Alert(AlertType.INFORMATION);
        		alert.setTitle("Question added to the quiz");
        		alert.setHeaderText(null);
        		alert.setContentText("Question title: " + "\"" + qTitle + "\"");
        		alert.showAndWait();
            	          	
            	        		
        		/*grid.getChildren().remove(question);
        		Text question = new Text("Question " + (quiz.getNoOfQuestions() + 1) + ":" + "\n");
        		question.setFont(Font.font("Tahoma", FontWeight.SEMI_BOLD, 20));
        		grid.add(question, 0, 2, 2, 1);*/
            }
                        
		});
	}
		
	private static void setFinishQuizButtonListener(Button finishQuizButton, Quiz quiz){
		
		finishQuizButton.setOnAction(new EventHandler<ActionEvent>() {
	       	 
            @Override
            public void handle(ActionEvent e) {
            	try {
            		File file = new File("D:\\quizzes.txt");
        			FileOutputStream fout = new FileOutputStream(file);
        		    ObjectOutputStream oos = new ObjectOutputStream(fout);
        		    oos.writeObject(quiz);
        		    oos.close();
            	
        		} catch (FileNotFoundException e1) {
        			System.out.println("First Exception:\n");
        			e1.printStackTrace();
        		} catch (IOException e1) {
        			System.out.println("Second Exception:\n");
        			e1.printStackTrace();
        		}
            }
		});
		
	}
}
