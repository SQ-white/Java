
public class PrimeApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m,n;
		int j=0;
		int a[]=new int[10000000];
		System.out.println("10000000内最大的素数是：");
		A:for(n=10000000;n>0;n--) {
			for(m=2;m<n;m++) {
				if(n%m==0)
					continue A;
			}
			//System.out.print(n+" "+"\t");
			a[j]=n;
			//System.out.print(a[j]+" "+"\t");
			System.out.print(a[j]+" "+"\t");
		    break;
		}
	}

}
