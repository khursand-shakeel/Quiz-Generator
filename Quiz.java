import java.io.Serializable;
import java.util.List;


public class Quiz implements Serializable {

	private String title;
	private String description;
	private int noOfQuestions;
	private List<MultipleChoiceQuestion> listOfQuestions;
	
	
	Quiz(String title, String description, List<MultipleChoiceQuestion> listOfQuestions){
		this.title = title;
		this.description = description;
		this.listOfQuestions = listOfQuestions;
	}
	
	
	public List<MultipleChoiceQuestion> getListOfQuestions(){
		return this.listOfQuestions;
	}
	
	public void setListOfQuestions(List<MultipleChoiceQuestion> list){
		this.listOfQuestions = list;
	}
	public void setNoOfQuestions(int no){
		this.noOfQuestions = no;
	}
	
	public int getNoOfQuestions(){
		return this.noOfQuestions;
	}
	
}
