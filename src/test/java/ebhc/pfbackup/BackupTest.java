package ebhc.pfbackup;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple Backup.
 */
public class BackupTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public BackupTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( BackupTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testBackup()
    {
        assertTrue( true );
    }
}
