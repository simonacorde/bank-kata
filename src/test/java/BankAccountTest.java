import com.craft.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


@ContextConfiguration("classpath:spring-config.xml")
public class BankAccountTest {

    @Autowired
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
