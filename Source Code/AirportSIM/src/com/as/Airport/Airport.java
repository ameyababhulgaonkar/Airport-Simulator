package com.as.Airport;

import java.util.LinkedList;

import com.as.Aircraft.Aircraft;
import com.as.Driver.*;

public class Airport {
	public int NumberOfGates;
	public int NumberOfEmergencyLandings;
	public static int NumberOfRunway = 1;
	public static int TaxiTime = 15;

	public int getNumberOfGates(int flights, LinkedList<Aircraft> ll) {
		// This function will determine number of optimal number of gates.
		NumberOfGates = 1;

		Aircraft[] ac = new Aircraft[flights];
		int g = 1, ng = flights - 1, time = 0, buffer = 7, scount = 0;
		int sums = 0, sume = 0, sumb = 0;
		int totalWaitsum[] = new int[flights];

		boolean flag = true;
		for (; NumberOfGates <= flights; NumberOfGates++) {
			LinkedList<Gate> gateLinkedList = new LinkedList<Gate>();
			int counter = 0;
			while (counter < NumberOfGates) {
				Gate G = new Gate();
				G.GateNumber = counter + 1;
				gateLinkedList.add(G);

				counter++;
			}
			LinkedList<Runway> runwayLinkedList = new LinkedList<Runway>();
			int runwayCounter=0;
			
			for(;runwayCounter<NumberOfRunway;runwayCounter++)
			{
				Runway rw = new Runway();
				rw.runwayNumber=runwayCounter;
				runwayLinkedList.add(rw);
			}
			
			
			// System.out.println("In number of gates loop");
			for (; g <= flights - 1 && ng >= 1; g++, ng--) {
				// System.out.println("For "+NumberOfGates+" gates size of gate linked list
				// is"+gateLinkedList.size());
				// System.out.println("In configuration loop");

				int flightCounter = 0;
				while (flightCounter < NumberOfGates && flightCounter < g) {
					ll.get(flightCounter).state = "c";

					ll.get(flightCounter).gateNo = flightCounter;
					gateLinkedList.get(flightCounter).status = false;
					flightCounter++;
				}
				while (flightCounter < g) {
					ll.get(flightCounter).state = "b";

					flightCounter++;
				}
				while (flightCounter < flights && flightCounter < g + buffer) {
					ll.get(flightCounter).state = "s";

					scount++;
					flightCounter++;
				}
				while (flightCounter < flights) {
					ll.get(flightCounter).state = "z";

					flightCounter++;
				}

				/*
				 * for(int i=0;i<flights;i++) { System.out.println(ll.get(i).state); }
				 */

				while (true) {

					// System.out.println("tick="+time+":");

					for (int i = 0; i < ll.size(); i++) {
						if (ll.get(i).state.equals("z")) {
							if (scount < buffer) {
								ll.get(i).state = "s";
							}
						}
						if (ll.get(i).state.equals("s")) {
							// System.out.println("State s");
							boolean flags = false;
							int j;
							for (j = 0; j < NumberOfRunway; j++) {

								for (int k = 0; k < ll.size(); k++) {
									for (int l = 0; l < ll.size() && l != k; l++) {
										if (ll.get(k).sWaitTime >= ll.get(l).sWaitTime
												&& ll.get(k).sWaitTime >= ll.get(l).eWaitTime
												&& runwayLinkedList.get(j).status == true) {
											{
												ll.get(i).state = "r'";
												ll.get(i).RunwayNumber=runwayLinkedList.get(j).runwayNumber;
												scount--;
												ll.get(i).sfwt += ll.get(i).sWaitTime;

												ll.get(i).sWaitTime = 0;
												runwayLinkedList.get(j).status = false;
												flags = true;
												break;
											}
										}
									}

								}
							}
							if (flags == false)
								ll.get(i).sWaitTime++;
						}

						if (ll.get(i).state.equals("r'")) {
							// System.out.println("State r'");

							ll.get(i).rdstatetimer++;
							for (int j = 0; j < NumberOfRunway; j++) {
								if (runwayLinkedList.get(j).status == false) {

									runwayLinkedList.get(j).rdt++;

								}
								if (runwayLinkedList.get(j).rdt == ll.get(i).at.runwayTime) {
									runwayLinkedList.get(j).status = true;
									runwayLinkedList.get(j).rdt = 0;
								}
							}

							if (ll.get(i).rdstatetimer == ll.get(i).at.runwayTime) {
								ll.get(i).state = "a";
								runwayLinkedList.get(ll.get(i).RunwayNumber).status=true;

							}
						}

						else if (ll.get(i).state.equals("a")) {
							// System.out.println("State a");

							ll.get(i).astatetimer++;
							if (ll.get(i).astatetimer == TaxiTime) {
								ll.get(i).state = "b";
							}
						} else if (ll.get(i).state.equals("b")) {
							// System.out.println("State b");

							boolean flagb = false;
							int j;
							for (j = 0; j < NumberOfGates; j++) {
								if (gateLinkedList.get(j).status == true) {
									ll.get(i).state = "c";
									ll.get(i).gateNo = j;
									gateLinkedList.get(j).status = false;
									flagb = true;
									break;
								}
							}
							if (flagb == false)
								ll.get(i).bWaitTime++;
						}

						if (ll.get(i).state.equals("c")) {
							// System.out.println("c case");
							ll.get(i).cstatetimer++;
							int j;
							/*
							 * for(j=0;j<NumberOfGates;j++) { if(gateLinkedList.get(j).status==false) {
							 * 
							 * gateLinkedList.get(j).gatetimer++;
							 * 
							 * } if(gateLinkedList.get(j).gatetimer==ll.get(i).at.boardingTime) {
							 * gateLinkedList.get(j).status=true; gateLinkedList.get(j).gatetimer=0; }}
							 */

							if (ll.get(i).cstatetimer == ll.get(i).at.boardingTime) {
								ll.get(i).state = "d";
								gateLinkedList.get(ll.get(i).gateNo).status = true;

								// System.out.println("Sate cganksdb");
							}
							// System.out.println("Exit c");
						}

						if (ll.get(i).state.equals("d")) 
						{
							// System.out.println("State d");

							ll.get(i).dstatetimer++;
							if (ll.get(i).dstatetimer == TaxiTime)
								ll.get(i).state = "e";
						} 
						else if (ll.get(i).state.equals("e")) {
							// System.out.println("State e");

							boolean flage = false;
							int j;
							for (j = 0; j < NumberOfRunway; j++) {

								for (int k = 0; k < ll.size(); k++) {
									for (int l = 0; l < ll.size() && l != k; l++) {
										if (ll.get(k).eWaitTime >= ll.get(l).sWaitTime
												&& ll.get(k).eWaitTime >= ll.get(l).eWaitTime) {

											if (runwayLinkedList.get(j).status == true) {

												ll.get(i).state = "r";
												ll.get(i).RunwayNumber=runwayLinkedList.get(j).runwayNumber;
												runwayLinkedList.get(j).status = false;
												flage = true;
												break;
											}
										}
									}
								}
							}
							if (flage == false)
								ll.get(i).eWaitTime++;
						}
						if (ll.get(i).state.equals("r")) {
							// System.out.println("State r");

							ll.get(i).rstatetimer++;
							/*for (int j = 0; j < NumberOfRunway; j++) 
							{
								if (runwayLinkedList.get(j).status == false) {

									runwayLinkedList.get(j).RunwayTimer++;

								}
								if (runwayLinkedList.get(j).RunwayTimer == ll.get(i).at.runwayTime) {
									runwayLinkedList.get(j).status = true;
									runwayLinkedList.get(j).RunwayTimer = 0;
								}
							}*/

							if (ll.get(i).rstatetimer == ll.get(i).at.runwayTime) {
								ll.get(i).state = "x";
								runwayLinkedList.get(ll.get(i).RunwayNumber).status=true;
								ll.get(i).efwt += ll.get(i).eWaitTime;
								ll.get(i).eWaitTime = 0;

								ll.get(i).cstatetimer = 0;
								ll.get(i).astatetimer = 0;
								ll.get(i).dstatetimer = 0;
								ll.get(i).rstatetimer = 0;
								ll.get(i).rdstatetimer = 0;
								// System.out.println("Sstate x");
							}
						}

					}
					int tempcounter = 0;
					for (int i = 0; i < ll.size(); i++) {
						if (ll.get(i).state.equals("x")) {
							tempcounter++;

						}
					}
					// System.out.println(tempcounter);
					if (tempcounter == flights) {

						break;

					}

					// System.out.println(" ");
					time++;

				}
				time++;
				for (int i = 0; i < ll.size(); i++) {
					sums = ll.get(i).sfwt + sums;
					sumb = ll.get(i).bWaitTime + sumb;
					sume = ll.get(i).efwt + sume;
				}

				for (int i = 0; i < ll.size(); i++) {
					ll.get(i).sfwt = 0;
					ll.get(i).bWaitTime = 0;
					ll.get(i).efwt = 0;

				}

			}
			totalWaitsum[NumberOfGates - 1] = sums + sumb + sume;

			/*
			 * System.out.println("For"+NumberOfGates+" gate ");
			 * System.out.println(sums+" "+sumb+" "+sume);
			 */
			sums = 0;
			sumb = 0;
			sume = 0;

			for (int i = 0; i < gateLinkedList.size(); i++) {
				gateLinkedList.remove(i);
			}
			for (int i = 0; i < runwayLinkedList.size(); i++) {
				runwayLinkedList.remove(i);
			}

			g = 1;
			ng = flights - 1;

		}
//		
//
		System.out.println("Time:" + time);
for(int i = 0;i<flights;i++)
{
	System.out.println("Gate "+ (i+1) + " is "+totalWaitsum[i]);
}

		int min = totalWaitsum[0];
		int temp = 1;
		int i;
		for (i = 1; i < flights; i++) {
			if (totalWaitsum[i] < min) {
				temp = i + 1;
				min = totalWaitsum[i];
			}
		}
		System.out.println(min/(flights-1));
		
		/*
		 * if((min/(flights-1))>1440) { NumberOfRunway++; getNumberOfGates(flights, ll);
		 * 
		 * }
		 */
//System.out.println("The Optimal Number of gates is "+ temp + " with waiting time of  " + ((float)min/(flights-1)));
//System.out.println("Number of Optimal Gates "+ temp);
		return temp;

	}

	public int getNumberOfEmergencyLandings(int NumberOfFlights, int OptimalNumberOfGates, LinkedList<Aircraft> ll) {
		int LastNumberOfFlights = NumberOfFlights;
		int NewNumberOfGates;
		int answer;
		boolean flag = false;
		while (true) {

			NumberOfFlights = NumberOfFlights + 1;
			Driver.Add();
			NewNumberOfGates = getNumberOfGates(NumberOfFlights, ll);

			if (NewNumberOfGates != OptimalNumberOfGates) {

				// flag = true;
				System.out.println("Hi      fbgrt grh ");
				break;
			}
		}

		answer = NumberOfFlights - LastNumberOfFlights - 1;

		return answer;

	}

}
