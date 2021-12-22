package mainFrame;
import java.util.Calendar;
import java.util.Date;

public class LookUpInform
{	

	public LookUpInform(String id,int startStation,int endStation,int outwardSartTime,int returnSartTime,Calendar outwardtDate,
			Calendar returnDate,int seatPreference,int ticketNumberU,boolean willReturn){
		this.id = id;
		this.startStation = startStation;
		this.endStation = endStation;
		this.outwardSartTime = outwardSartTime;
		this.returnSartTime = returnSartTime;
		this.outwardtDate = outwardtDate;
		this.returnDate = returnDate;
		this.seatPreference = seatPreference;
		this.ticketNumberU = ticketNumberU;
		this.isCollege = true;
		this.willReturn = willReturn;
		init();
	} 
	public LookUpInform(String id,int startStation,int endStation,int outwardSartTime,int returnSartTime,
			Calendar outwardtDate,Calendar returnDate,int seatPreference,int[] ticketNumber,boolean willReturn){
		this.id = id;
		this.startStation = startStation;
		this.endStation = endStation;
		this.outwardSartTime = outwardSartTime;
		this.returnSartTime = returnSartTime;
		this.outwardtDate = outwardtDate;
		this.returnDate = returnDate;
		this.seatPreference = seatPreference;
		this.ticketNumber = ticketNumber;
		this.isCollege = false;
		this.willReturn = willReturn;
		init();
	}
	private void init(){
		Calendar calendar = Calendar.getInstance();
		
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		calendar.add(Calendar.DATE, -1);
		this.after = calendar.getTime();
		
		calendar.add(Calendar.MONTH, 1);
		this.before = calendar.getTime();
	}
	

	public static void main(String[] args){
		StationId[] p = StationId.values();
		System.out.println(p[0].toString().equals("�n��"));
	}

	public String isInputValid(){
		if(id.equals("")){return "�п�J�ϥΪ�ID";}
		if(!checkIdformatValid(id)) {return "id�榡���~";}
		if(outwardtDate.getTime().compareTo(before) >0 || returnDate.getTime().compareTo(before) > 0 ){
			return "�u��w�w28�Ѥ�����";
		}

		if(outwardtDate.getTime().compareTo(after) < 0 ){
			return "���L����l �N��DCARD�@��";
		}
		if(outwardtDate.after(returnDate)  && willReturn){return "�A�������X�o �~��^��";}
		if(outwardtDate.getTime().compareTo(returnDate.getTime())== 0 && outwardSartTime > returnSartTime && willReturn){return "�A�������X�o �~��^��";}
		if(startStation == endStation && startStation*endStation != 0){return "�_�������ۦP";}
		if(startStation*endStation == 0){return "�п�� �_�� ����";}
		if(!isCollege){
			int totalTicketNum = 0;
			for(int c : ticketNumber){
				totalTicketNum += c;
			}
			if(totalTicketNum > 10){return "�ʶR�i�ƶW�L10�i";}
			if(totalTicketNum == 0){return "�п���ʶR�i��";}
		}
		else {
			if(ticketNumberU > 10){return "�P�ǡA�ʶR�i�ƶW�L10�i";}
			if(ticketNumberU == 0){return "�п���ʶR�i��";}
		}
		return "";
	}
	private boolean checkIdformatValid(String id) {
		if(id.length() != 10) {return false;}
		char []c = id.toCharArray();
		String digit = id.substring(1,id.length());
		if(c[0] > 'z' || c[0] < 'a') {return false;}
		try {
			Integer.parseInt(digit);
		}catch(NumberFormatException e) {return false;}
		return true;
	}

	public String getId(){
		return id;
	}
	public String getStartStation(){
		return stationId[startStation].getValue();
	}
	public String getStartStationName(){
		return stationId[startStation].toString();
	}
	public String getEndStation(){
		return stationId[endStation].getValue();
	}
	public String getEndStationName(){
		return stationId[endStation].toString();
	}
	public int getOutwardSartTime(){
		return outwardSartTime;
	}
	public int getReturnSartTime(){
		return returnSartTime;
	}
	public Calendar getOutwardtDate(){
		return outwardtDate;
	}
	public Calendar getReturnDate(){
		return returnDate;
	}
	public int getSeatPreference(){
		return seatPreference;
	}
	public int getTicketNumberU(){
		return ticketNumberU;
	}
	public int[] getOutwardTicketNumber(){
		return ticketNumber;
	}
	public int getTotalTicketNumber() {
		int totalNumber = 0;
		if(ticketNumber != null) {
			for(int n : ticketNumber) {
				totalNumber += n;
			}
		}
		totalNumber += ticketNumberU ;
		return totalNumber;
	}
	public boolean isCollegeStudent(){
		return isCollege;
	}
	public boolean willReturn(){
		return willReturn;
	}

	public void setId(String input){
		id = input;
	}
	public void setStartStation(int input){
		startStation = input;
	}
	public void setEndStation(int input){
		endStation = input;
	}
	public void setOutwardSartTime(int input){
		outwardSartTime = input;
	}
	public void setReturnSartTime(int input){
		returnSartTime = input;
	}
	public void setOutwardtDate(Calendar input){
		outwardtDate = input;
	}
	public void setReturnDate(Calendar input){
		returnDate = input;
	}
	public void setSeatPreference(int input){
		seatPreference = input;
	}
	public void setOTicketNumberU(int input){
		ticketNumberU = input;
	}
	public void setWillReturn(boolean willReturn){
		this.willReturn = willReturn;
	}

	private String id; 
	private int startStation; 
	private int endStation; 
	private int outwardSartTime; 
	private int returnSartTime; 
	private Calendar outwardtDate; 
	private Calendar returnDate; 
	private int seatPreference; 
	private int ticketNumberU; 
	private int[] ticketNumber/* = new int[4]*/;
	private boolean isCollege = true;
	private Date before,after;
	private boolean willReturn = false;
	private StationId[] stationId = StationId.values();
	
	
}