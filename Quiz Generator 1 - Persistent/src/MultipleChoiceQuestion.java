
public class MultipleChoiceQuestion{
	
	private int id;
	private String title;
	private String option1;
	private String option2;
	private String option3;
	private String option4;

	MultipleChoiceQuestion(){
		
	}
	
	public MultipleChoiceQuestion(int id, String title, String option1, String option2, String option3, String option4) {
		
		this.id = id;
		this.title = title;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
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

	public void setTitle(String title){
		this.title = title;
	}
	
	public String getOption1(){
		return this.option1;
	}

	public void setOption1(String option1){
		this.option1 = option1;
	}
	
	public String getOption2(){
		return this.option2;
	}
	
	public void setOption2(String option2){
		this.option2 = option2;
	}
	
	public String getOption3(){
		return this.option3;
	}
	
	public void setOption3(String option3){
		this.option3 = option3;
	}
	
	public String getOption4(){
		return this.option4;
	}
	
	public void setOption4(String option4){
		this.option4 = option4;
	}
	
}
