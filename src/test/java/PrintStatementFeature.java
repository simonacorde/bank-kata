import com.craft.Account;
import com.craft.BankAccount;
import com.craft.Console;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PrintStatementFeature {

    private Account account = new BankAccount();

    @Mock
    private Console console;


    @Test
    public void print_statement_containing_transactions_in_reverse_chronological_order() {
        console = mock(Console.class);

        account.deposit(1000);
        account.withdraw(100);
        account.deposit(500);

        List<String> allTrans ;
        allTrans = account.printStatement();
        for(int i=0;i<allTrans.size();i++)
            console.printLine(allTrans.get(i));


        verify(console).printLine("DATE | AMOUNT | BALANCE");
        verify(console).printLine("02/07/2015 | 500.0 | 1400.0");
        verify(console).printLine("02/07/2015 | -100.0 | 900.0");
        verify(console).printLine("02/07/2015 | 1000.0 | 1000.0");
    }

}