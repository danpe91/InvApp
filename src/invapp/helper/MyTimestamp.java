package invapp.helper;

import java.sql.Timestamp;
import java.util.Date;

public class MyTimestamp extends Timestamp {
    
    public MyTimestamp(Timestamp date) {
        super(date.getTime());
    }
    
    public MyTimestamp() {
        super(new Date().getTime());
    }
    
    @Override
    public String toString() {
        String min = (getMinutes() < 10)? "0": "";
        String sec = (getSeconds() < 10)? "0": "";
        return getDate() + "/" +
                getMonth() + "/" +
                (getYear() + 1900) + " " +
                getHours() + ":" + min + 
                getMinutes() + ":" + sec + 
                getSeconds();
    }
}
