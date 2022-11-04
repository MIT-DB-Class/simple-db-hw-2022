package simpledb.systemtest;

import java.io.IOException;

import org.junit.Test;

import simpledb.common.DbException;
import simpledb.transaction.TransactionAbortedException;

/**
 * Tests running concurrent transactions.
 * You do not need to pass this test until Lab 4.
 * @see simpledb.systemtest.TransactionTestUtil
 */
public class TransactionTestTwo extends SimpleDbTestBase {
    @Test public void testTwoThreads()
            throws IOException, DbException, TransactionAbortedException {
        TransactionTestUtil.validateTransactions(2);
    }

    /** Make test compatible with older version of ant. */
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(TransactionTestTwo.class);
    }
}
