import com.craft.DateTransaction;
import com.craft.Transaction;
import com.craft.TransactionRepository;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


/**
 * Created by scorde on 7/3/2015.
 */
public class TransactionRepoTest {

    private DateTransaction dateTransaction;
    private Transaction transaction;
    private TransactionRepository transactionRepository;

    @Test
    public void whenAddingATransactionThenItExistsInTheRepository(){
        dateTransaction = mock(DateTransaction.class);
        transactionRepository = new TransactionRepository(dateTransaction);

        transactionRepository.addTransaction(1000);

        verify(dateTransaction).getCurrentDate();
        assertThat(transactionRepository.getTransactions(), Matchers.hasSize(1));
        assertThat(transactionRepository.getTransactions(), hasItem(aTransaction(1000)));
    }

    private Matcher<Transaction> aTransaction(final int i) {
        return new TypeSafeMatcher<Transaction>() {

            @Override
            protected boolean matchesSafely(Transaction item) {
                return item.getAmount() == i;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("a transaciton with amount " + i);
            }

        };

    }
}
