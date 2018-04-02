import java.io.*;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		
			String path = "test.csv";
			MyStudent student = new MyStudent(path);
			PrintStream ps = new PrintStream(new FileOutputStream("./score.txt"));
			System.setOut(ps);
			
			student.getAvg();
			student.getPart();
			student.getVS();
			
			System.out.format("The highest score: %d\r\n",student.getH());
			System.out.format("The lowest score: %d\r\n",student.getL());
			System.out.format("Average score: %f\r\n",student.getA());
			System.out.format("Number of score 60-69: %d\r\n",student.getSix());
			System.out.format("Number of score 70-79: %d\r\n",student.getSeven());
			System.out.format("Number of score 80-89: %d\r\n",student.getEight());
			System.out.format("Number of score 90-100: %d\r\n",student.getNine());



	}

}
