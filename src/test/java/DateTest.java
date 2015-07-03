import com.craft.DateTransaction;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by scorde on 7/3/2015.
 */
public class DateTest {

    private DateTransaction dateTransaction;
    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private Date date;

    @Test
    public void testDate(){

        date = new Date();
        dateTransaction = mock(DateTransaction.class);

        when(dateTransaction.getCurrentDate()).thenReturn(dateFormat.format(date));

        String theDate = dateTransaction.getCurrentDate();
        assertEquals(theDate, dateFormat.format(date));

    }

}
