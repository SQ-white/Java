
import java.util.ArrayList;
import java.util.Random;

public class kmeans {
	
	private int k;
	private int m;
	private int dataSetLength;
	private ArrayList<float[]> dataSet;
	private ArrayList<float[]> center;
	private ArrayList<ArrayList<float[]>> cluster;
	private ArrayList<Float> jc;
	private Random random;
	
	public void setDataSet(ArrayList<float[]> dataSet) {
		this.dataSet = dataSet;
	}
	
	public ArrayList<ArrayList<float[]>> getCluster(){
		return cluster;
	}
	
	public kmeans(int k) {
		if(k<=0) {
			k=1;
		}
		this.k=k;
	}
	
	private void init() {
		m=0;
		random=new Random();
		if(dataSet==null||dataSet.size()==0) {
			initDataSet();
		}
		dataSetLength=dataSet.size();
		if(k>dataSetLength) {
			k=dataSetLength;
		}
		center = initCenters();
		cluster=initCluster();
		jc=new ArrayList<Float>();
	}
	
	private void initDataSet() {
		dataSet=new ArrayList<float[]>();
		float[][] dataSetArray=new float[][] {
			{ 8, 2 },{ 3, 4 }, { 2, 5 },  
			{ 4, 2 }, { 7, 3 }, { 6, 2 }, { 4, 7 }, 
			{ 6, 3 }, { 5, 3 },  { 6, 3 }, { 6, 9 }, 
			{ 1, 6 }, { 3, 9 }, { 4, 1 }, { 8, 6 }
			};
			
			for(int i=0;i<dataSetArray.length;i++) {
				dataSet.add(dataSetArray[i]);
			}
		}
	
	private ArrayList<float[]> initCenters(){
		ArrayList<float[]> center=new ArrayList<float[]>();
		int[] randoms =new int[k];
		boolean flag;
		int temp=random.nextInt(dataSetLength);
		randoms[0]=temp;
		for(int i=1;i<k;i++) {
			flag=true;
			while(flag) {
				temp=random.nextInt(dataSetLength);
				int j=0;
				while(j<i) {
					if(temp==randoms[j]) {
						break;
					}
					j++;
				}
				if(j==i) {
					flag=false;
				}
			}
			randoms[i]=temp;
		}
		for(int i=0;i<k;i++) {
			center.add(dataSet.get(randoms[i]));
		}
		return center;
	}
	
	private ArrayList<ArrayList<float[]>>initCluster(){
		ArrayList<ArrayList<float[]>>cluster=new ArrayList<ArrayList<float[]>>();
		for(int i=0;i<k;i++) {
			cluster.add(new ArrayList<float[]>());
		}
		return cluster;
	}
	
	private float distance(float[] element,float[] center) {
		float distance=0.0f;
		float x=element[0]-center[0];
		float y=element[1]-center[1];
		float z=x*x+y*y;
		distance = (float) Math.sqrt(z);
		
		return distance;
	}
	
	private int minDistance(float[] distance) {
		float minDistance=distance[0];
		int minLocation=0;
		for (int i=1;i<distance.length;i++) {
			if(distance[i]<minDistance) {
				minDistance=distance[i];
				minLocation=i;
			}
			else if(distance[i]==minDistance) {
				if(random.nextInt(10)<5) {
					minLocation=i;
				}
			}
		}
		return minLocation;
	}
	
	private void clusterSet() {
		float[] distance=new float[k];
		for(int i=0;i<dataSetLength;i++) {
			for(int j=0;j<k;j++) {
				distance[j]=distance(dataSet.get(i),center.get(j));
			}
			int minLocation=minDistance(distance);
			
			cluster.get(minLocation).add(dataSet.get(i));
		}
	}
	
	private float errorSquare(float[] element,float[] center) {
		float x=element[0]-center[0];
		float y=element[1]-center[1];
		
		float errSquare=x*x+y*y;
		
		return errSquare;
	}
	
	private void countRule() {
		float jcF=0;
		for(int i=0;i<cluster.size();i++) {
			for(int j=0;j<cluster.get(i).size();j++) {
				jcF+=errorSquare(cluster.get(i).get(j),center.get(i));
			}
		}
		jc.add(jcF);
	}
	
	private void setNewCenter() {
		for(int i=0;i<k;i++) {
			int n=cluster.get(i).size();
			if(n!=0) {
				float[] newCenter= {0,0};
				for(int j=0;j<n;j++) {
					newCenter[0]+=cluster.get(i).get(j)[0];
					newCenter[1]+=cluster.get(i).get(j)[1];
				}
				newCenter[0]=newCenter[0]/n;
				newCenter[1]=newCenter[1]/n;
				center.set(i, newCenter);
			}
		}
	}
	
	public void printDataArray(ArrayList<float[]> dataArray,String dataArrayName) {
		for(int i=0;i<dataArray.size();i++) {
			System.out.println("print:"+dataArrayName+"["+i+"]={"
		+dataArray.get(i)[0]+","+dataArray.get(i)[1]+"}");
		}
		System.out.println("=================================");
	}
	
	private void Kmeans() {
		init();
		
		while(true) {
			clusterSet();
			countRule();
			
			if(m!=0) {
				if(jc.get(m)-jc.get(m-1)==0) {
					break;
				}
			}
			
			setNewCenter();
			m++;
			cluster.clear();
			cluster=initCluster();
		}
	}
	
	public void execute() {
		long startTime=System.currentTimeMillis();
		System.out.println("kmeans begins");
		Kmeans();
		long endTime=System.currentTimeMillis();
		System.out.println("kmeans ends");
		System.out.println();
	}
}





