package application;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import greedy.KnapsackProblem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MyController implements Initializable {

	@FXML
	private TextArea myTextField0;
	@FXML
	private TextField myTextField;
	@FXML
	private Button myButton;
	@FXML
	private Button check;
	@FXML
	private TextField fullWeight;
	@FXML
	private TextField W01;
	@FXML
	private TextField W02;
	@FXML
	private TextField W03;
	@FXML
	private TextField W04;
	@FXML
	private TextField W05;
	@FXML
	private TextField W06;
	@FXML
	private TextField P01;
	@FXML
	private TextField P02;
	@FXML
	private TextField P03;
	@FXML
	private TextField P04;
	@FXML
	private TextField P05;
	@FXML
	private TextField P06;
	@FXML
	private ComboBox<String> one;
	
	
	private int n;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		assert false : "fx:id=\"appleImage\" was not injected: check your FXML file 'fruitcombo.fxml'.";
       // TODO (don't really need to do anything here).
	 	TextField[] W= {W01,W02,W03,W04,W05,W06};
	 	TextField[] P= {P01,P02,P03,P04,P05,P06};
		one.getItems().setAll("1", "2", "3","4","5","6");

		one.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() 
		{
		      @Override 
		      public void changed(ObservableValue<? extends String> selected, String oldFruit, String newFruit)
		      {
		        if (newFruit != null)
		        {
		        	n=Integer.parseInt(newFruit);
		        	for(int i=0;i<6;i++)
		        	{
		        		W[i].setDisable(true);
		        		P[i].setDisable(true);
		        	}
		        	for(int i=0;i<Integer.parseInt(newFruit);i++)
		        	{
		        		W[i].setDisable(false);
		        		P[i].setDisable(false);
		        	}
		        }
		      }
		    });
   }

   // When user click on myButton
   // this method will be called.
	public void showDateTime(ActionEvent event)
	{
       System.out.println("Button Clicked!");

       Date now= new Date();

       DateFormat df = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");
       String dateTimeString = df.format(now);
        // Show in VIEW
        myTextField.setText(dateTimeString);
      // one.setProgress(0.25F);
   }
	public void checkProblem(ActionEvent event)
	{
		TextField[] TW= {W01,W02,W03,W04,W05,W06};
	 	TextField[] TP= {P01,P02,P03,P04,P05,P06};
	 	int[] W=new int[n+1];
	 	int[] P=new int[n+1];
	 	for(int i=1;i<=n;i++)
	 	{
	 		W[i]=Integer.parseInt(TW[i-1].getText());
	 		P[i]=Integer.parseInt(TP[i-1].getText());
	 	}
	 	KnapsackProblem d1=new KnapsackProblem((byte)n,Integer.parseInt(fullWeight.getText()),P,W);
	 	d1.knapsack((byte)0, 0, 0);
	 	myTextField0.setText(d1.toString());
	 	System.out.print(d1);
	}
}