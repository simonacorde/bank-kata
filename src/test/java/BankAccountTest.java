import com.craft.*;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by scorde on 7/3/2015.
 */
public class BankAccountTest {

    private Account account;
    private TransactionRepository transactionRepository;
    private Printer printer;

    @Before
    public void setUp() {
        transactionRepository = mock(TransactionRepository.class);
        printer = mock(Printer.class);
        account = new BankAccount(printer,transactionRepository);
    }

    @Test
    public void depositTest(){

        account.deposit(1000);

        verify(transactionRepository).addTransaction(1000);
    }

    @Test
    public void givenABankAccountWhenWithdrawingThenAWithdrawTransactionIsStored() {

        account.withdraw(1000);

        verify(transactionRepository).addTransaction(-1000);
    }

    @Test
    public void whenPrintingAStatementThenPrinterInvoked() {

        account.printStatement();

        verify(printer).printTransactionsDescendent(transactionRepository.getTransactions());
    }




}
