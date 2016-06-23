package ebhc.pfbackup;
import org.apache.commons.math3.primes.Primes;

/**
 * Backup utility entry point
 */
public class Backup
{
    public static void main( String[] args )
    {
        System.out.printf( "factors of 1 are %s\n", Primes.primeFactors(1) );
    }
}
