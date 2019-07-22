package com.as.Aircraft;

import com.as.Aircraft.AircraftType;

public class Aircraft {
	public int AircraftNumber;
	public AircraftType at=new AircraftType();
	public int bWaitTime,sWaitTime,eWaitTime,efwt=0,sfwt=0,gateNo;
	public int astatetimer=0,cstatetimer=0,dstatetimer=0,rstatetimer=0,rdstatetimer=0;
	public boolean inState=false;
	public boolean status;
	public String state;
	public int RunwayNumber;
	public int getAircraftNumber() {
		return AircraftNumber;
	}
	public void setAircraftNumber(int aircraftNumber) {
		AircraftNumber = aircraftNumber;
	}
	public AircraftType getAt() {
		return at;
	}
	public void setAt(AircraftType at) {
		this.at = at;
	}
	public int getWaitTime() {
		return bWaitTime;
	}
	public void setWaitTime(int waitTime) {
		bWaitTime = waitTime;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}
