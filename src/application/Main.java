package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			Parent root=FXMLLoader.load(getClass().getResource("MyPage.fxml"));

			primaryStage.setTitle("0-1�I�]���D");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{

		Application.launch(args);
	}
}
