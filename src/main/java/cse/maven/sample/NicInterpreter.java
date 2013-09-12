package cse.maven.sample;

import cse.maven.sample.exception.InvalidBmiPropException;

public class NicInterpreter {

	
	public NicProp createNicProp(String idNumberV) throws InvalidBmiPropException {
		try {
			return new NicProp(idNumberV);
		} catch(Exception ex) {
			throw new InvalidBmiPropException();
		}
	}
	
	public String calculate(NicProp prop) throws InvalidBmiPropException {
		
		if(!validate(prop)) {
			throw new InvalidBmiPropException();
		}
                
                int idn,year,date,dateJ;


                String idNumber = prop.getIdNumberV().substring(0,9);

		idn = Integer.parseInt(idNumber);
		
		year = idn/10000000 ;
		
		date = idn/10000 - year*1000 ;
		dateJ = idn/10000 - year*1000 ;
		
		String gender="",month="";
		int birthDay=0;
		String birthYear="";
                
                if(year % 4 != 0){
                    date = date - 1;
                }		
		
		
                if(500 < date && date < 999){
                    date = date - 500;	
                    gender="Female";
                }
                if(0 < date && date < 500){
                    gender="Male";
                }
                
                if(dateJ > 0 && dateJ <= 31){
			birthDay = dateJ;
			month = "January";
			birthYear = "19"+year;
		}
		
		else if(dateJ > 31 && date <= 59){
			birthDay = dateJ-31;
			month = "February";
			birthYear = "19"+year;
		}
		
		else if(date > 59 && date <= 90){
			birthDay = date-59;
			month = "March";
			birthYear = "19"+year;
		}
		
		else if(date > 90 && date <= 120){
			birthDay = date-90;
			month = "April";
			birthYear = "19"+year;
		}
		
		else if(date > 120 && date <= 151){
			birthDay = date-120;
			month = "May";
			birthYear = "19"+year;
		}
		
		else if(date > 151 && date <= 181){
			birthDay = date-151;
			month = "June";
			birthYear = "19"+year;
		}
		
		else if(date > 181 && date <= 212){
			birthDay = date-181;
			month = "July";
			birthYear = "19"+year;
		}
		
		else if(date > 212 && date <= 243){
			birthDay = date-212;
			month = "August";
			birthYear = "19"+year;
		}
		
		else if(date > 243 && date <= 273){
			birthDay = date-243;
			month = "September";
			birthYear = "19"+year;
		}
		
		else if(date > 273 && date <= 304){
			birthDay = date-273;
			month = "October";
			birthYear = "19"+year;
		}
		
		else if(date > 304 && date <= 334){
			birthDay = date-304;
			month = "November";
			birthYear = "19"+year;
		}
		
		else if(date > 334 && date <= 365){
			birthDay = date-334;
			month = "December";
			birthYear = "19"+year;
		}


                return "Nic[birthday=Birthday[year= "+birthYear+ ", " + "month= "+month+ ", "+ "date= "+birthDay+"] , gender= "+gender+"]";
                
	}
	
	public boolean validate(NicProp nicProp) {
		 return nicProp.getIdNumberV().length() > 0 && nicProp.getIdNumberV().length() < 11 ? true : false;
	}
	
	
}
