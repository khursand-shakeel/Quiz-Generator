import java.util.List;

public class Quiz{

	private int id;
	private String title;
	private String description;
	private int noOfQuestions;
	private List<MultipleChoiceQuestion> listOfQuestions;
	
	Quiz(){
		
	}
	
	Quiz(int id, String title, String description, List<MultipleChoiceQuestion> listOfQuestions){
		this.title = title;
		this.description = description;
		this.listOfQuestions = listOfQuestions;
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public String setTitle(String title){
		return this.title = title;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public String setDescription(String description){
		return this.description = description;
	}
	
	public List<MultipleChoiceQuestion> getListOfQuestions(){
		return this.listOfQuestions;
	}

	public void setListOfQuestions(List<MultipleChoiceQuestion> listOfQuestions){
		this.listOfQuestions = listOfQuestions;
	}
	
	public int getNoOfQuestions(){
		return this.noOfQuestions;
	}
	
	public void setNoOfQuestions(int no){
		this.noOfQuestions = no;
	}
	
	
	
}
