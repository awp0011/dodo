package foo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
		Date startDate = sdf.parse("1027");
		Date endDate = sdf.parse("1101");
		System.out.println(startDate.before(endDate));
		System.out.println(startDate.toString());
	}

}
