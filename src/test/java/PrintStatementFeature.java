import com.craft.*;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PrintStatementFeature {

    private Account account;
    private Console console;
    private Printer printer;


    @Test
    public void print_statement_containing_transactions_in_reverse_chronological_order() {
        console = mock(Console.class);
        printer = new Printer(console);
        DateTransaction dateTransaction = mock(DateTransaction.class);
        when(dateTransaction.getCurrentDate()).thenReturn("02/07/2015").thenReturn("03/07/2015").thenReturn("07/07/2015");
        account = new BankAccount(printer, new TransactionRepository(dateTransaction));

        account.deposit(1000);
        account.withdraw(100);
        account.deposit(500);

        account.printStatement();

        InOrder inOrder = Mockito.inOrder(console);
        inOrder.verify(console).printLine("DATE | AMOUNT | BALANCE");
        inOrder.verify(console).printLine("07/07/2015 | 500.0 | 1400.0");
        inOrder.verify(console).printLine("03/07/2015 | -100.0 | 900.0");
        inOrder.verify(console).printLine("02/07/2015 | 1000.0 | 1000.0");
    }

}