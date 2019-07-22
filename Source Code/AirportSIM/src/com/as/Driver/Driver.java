package com.as.Driver;


import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

import com.as.Aircraft.Aircraft;
import com.as.Airport.*;
public class Driver {
	public static int rt1,rt2,rt3;
	public static int bt1,bt2,bt3;
	public static   LinkedList<Aircraft> ll=new LinkedList<Aircraft>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		

		int flights;
		int rt;
		int bt;
		int type1;
		int type2;
		int type3;
		//Airport object
		
		Airport ap=new Airport();
		/*Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of each type of flight");
		type1=sc.nextInt();
		type2=sc.nextInt();
		type3=sc.nextInt();
		*/
		AirportSimulatorGUI obj = new AirportSimulatorGUI();
		synchronized(obj) {
		try {
			obj.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		type1=obj.getNF1();
		type2=obj.getNF2();
		type3=obj.getNF3();
		int totalFlights=type1+type2+type3;
		
		//System.out.println("Enter RT and BT for Type 1");
		rt1=obj.getRT1();
		bt1=obj.getBT1();
		
		for(int i=0;i<type1;i++)
		{
			Aircraft ac=new Aircraft();
			ac.at.runwayTime=rt1;
			ac.at.boardingTime=bt1;
			ll.add(ac);
		}
		
	//	System.out.println("Enter RT and BT for Type 2");
		rt2=obj.getRT2();
		bt2=obj.getBT2();
		
		for(int i=0;i<type2;i++)
		{
			Aircraft ac=new Aircraft();
			ac.at.runwayTime=rt2;
			ac.at.boardingTime=bt2;
			ll.add(ac);
		}
		
		//System.out.println("Enter RT and BT for Type 3");
		rt3=obj.getRT3();
		bt3=obj.getBT3();
		
		for(int i=0;i<type3;i++)
		{
			Aircraft ac=new Aircraft();
			ac.at.runwayTime=rt3;
			ac.at.boardingTime=bt3;
			ll.add(ac);
		}
		
		
		
		//Collections.shuffle(ll);
		for(int i=0;i<ll.size();i++)
		{
			//System.out.println(ll.get(i).at.runwayTime);
			//System.out.println(ll.get(i).at.boardingTime);
		}
		
		
		int nofg=ap.getNumberOfGates(totalFlights, ll);
		System.out.println("Number of Optimal Gates "+ nofg);
		
		
		
		int nel=ap.getNumberOfEmergencyLandings(totalFlights,nofg,ll);
		System.out.println("Number of Emergency landings : "+ nel);
		

	}
	}
	public static void Add()
	{
		Aircraft ac = new Aircraft();
		ac.at.runwayTime=rt1;
		ac.at.boardingTime=bt1;
		ll.addFirst(ac);
	}
	
}

