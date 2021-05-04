//Question 1

public static String scrambleWord(String word){
	String ret = "";
	int i = 0;
	while(i <= word.length()-2){
		if(word.substring(i,i+1).equals("A") && !word.substring(i+1,i+2).equals("A")){
			ret += word.substring(i+1,i+2) + word.substring(i,i+1);
			i+=2;
		}
		else{
			ret += word.substring(i,i+1);
			i++;
		}
	}
	if(i < word.length()) ret += word.substring(i);
	return ret;
}

public static void scrambleOrRemove(List<String> wordList){
	for(int i = 0; i < wordList.size(); i++){
		String s = scrambleWord(wordList.get(i));
		if(s.equals(wordList.get(i))){
			wordList.remove(i);
			i--;
		}
		else wordList.set(i, s);
	}
}

//Question 2 - n/a, Gridworld

//Question 3

public SeatingChart(List<Student> studentList, int rows, int cols){
	seats[][] = new Student[rows][cols];
	int index = 0;
	int r = 0;
	int c = 0;
	while(index < studentList.size()){
		if(r < rows) {
			seats[r][c] = studentList.get(index);
			index++
			r++;
		}
		else if(r == rows){
			c++;
			r = 0;
		}
	}
}

public int removeAbsentStudents(int allowedAbsences){
	int removed = 0;
	for(int r = 0; r < seats.length; r++){
		for(int c = 0; c < seats[r].length; c++){
			if(seats[r][c] != null){
				if(seats[r][c].getAbsenceCount() > allowedAbsences()){
					seats[r][c] = null;
					removed++;
				}
			}
		}
	}
	return removed;
}

//Question 4

public class Trio implements MenuItem{
	
	private String name;
	private double price;
	
	public Trio(sandwich sand, salad sal, drink dr){
		name = sand.getName() + "/" + sal.getName() + "/" + dr.getName() + " Trio";
		price = Math.min(sand.getPrice(), Math.min(sal.getPrice(), dr.getPrice()));
	}
	
	public String getName(){
		return name;
	}
	
	public double getPrice(){
		return price;
	}
}