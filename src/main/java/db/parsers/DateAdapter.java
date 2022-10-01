package db.parsers;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAdapter extends XmlAdapter<String, Date> {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date unmarshal(String dateStr) throws Exception {
        return dateFormat.parse(dateStr);
    }

    @Override
    public String marshal(Date date) {
        return dateFormat.format(date);
    }
}
