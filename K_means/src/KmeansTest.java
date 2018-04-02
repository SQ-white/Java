import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class KmeansTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		kmeans k=new kmeans(10);
		ArrayList<float[]> dataSet=new ArrayList<float[]>();

		Scanner sc = new Scanner(new File("KMeans_Set.txt"));
		while (sc.hasNextDouble()) {
			float x = sc.nextFloat();
			float y = sc.nextFloat();
			dataSet.add(new float[] {x, y});
		}
		
		k.setDataSet(dataSet);
		
		k.execute();
		
		ArrayList<ArrayList<float[]>> cluster=k.getCluster();
		
		for(int i=0;i<cluster.size();i++) {
			k.printDataArray(cluster.get(i), "cluster["+i+"]");
		}

	}

}
