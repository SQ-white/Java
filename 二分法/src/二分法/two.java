package ¶þ·Ö·¨;

import java.util.Scanner;

public class two {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		double x1=sc.nextDouble();
		double x2=sc.nextDouble();
		while(x2-x1>=0.001) {
			if(f((x1+x2)/2)==0) {
				System.out.printf("%.2f", (x1+x2)/2);
				break;
			}
			if(f((x1+x2)/2)*f(x1)>0) {
				x1=(x1+x2)/2;
			}
			else {
				x2=(x1+x2)/2;
			}
		}
		if(f((x1+x2)/2)!=0) {
		System.out.printf("%.2f", ((x1+x2)/2));
	    }
	}
	public static double f(double x) {
		return x*x*x-10*x+23;
	}
}
