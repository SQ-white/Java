import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyStudent {
	
	private List<DataNode> list;
	private int h;
	private int l;
	private int sum=0;
	private double avg;
	private int countSix=0;
	private int countSeven=0;
	private int countEight=0;
	private int countNine=0;
	int max=0;
	int min=100;
	
	public MyStudent(String path) throws IOException{
		this.list = new ArrayList<DataNode>();
		
		init(path);
	}
	
	public int getH() {
		return h;
	}
	
	public int getL() {
		return l;
	}
	
	public double getA() {
		return avg;
	}
	
	public int getSix() {
		return countSix;
	}
	
	public int getSeven() {
		return countSeven;
	}
	
	public int getEight() {
		return countEight;
	}
	
	public int getNine() {
		return countNine;
	}
	
	private void init(String path) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
		String line = "";
		
		while ((line = reader.readLine()) != null) {
			String str[] = line.split(",");
			DataNode dataNode = new DataNode();
			dataNode.setScore(Integer.parseInt(str[1]));
			this.list.add(dataNode);
			
		}
		
		reader.close();
	}
	
	public void getAvg() {
		int n=list.size();
		
		for(DataNode dataNode : list) {
			sum+=dataNode.getScore();
			}
		
		this.avg=sum/n;
	}
	
	public void getPart() {
		for(DataNode dataNode : list) {
			if(dataNode.getScore()>=60 && dataNode.getScore()<=69)
				++this.countSix;
			else if(dataNode.getScore()>=70 && dataNode.getScore()<=79)
				++this.countSeven;
			else if(dataNode.getScore()>=80 && dataNode.getScore()<=89)
				++this.countEight;
			else if(dataNode.getScore()>=90 && dataNode.getScore()<=100)
				++this.countNine;
		}		
	}
	
	public void getVS() {
		for(DataNode dataNode : list) {
			if(dataNode.getScore()>max)
				max = dataNode.getScore();
			if(dataNode.getScore()<min)
				min = dataNode.getScore();
		}
		
		this.h = max;
		this.l = min;
	}

}
