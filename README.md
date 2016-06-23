# pfbackup
Maven-based pure Java backup utility with a (somewhat) novel rotation mechanism

This utility aims to meet similar goals to the following related projects, and can be considered to be their Java-based cousin:

* https://www.tablix.org/~avian/blog/archives/2015/01/exponential_backup_rotation/
* https://github.com/jekor/log2rotate
* https://github.com/avian2/pylog2rotate

It simply creates a ZIP archive of a supplied directory.  That is not very interesting, but simply minimal and functional.

It is possible to send backups to a supplied collection of destinations.  It is probably most useful to supply one on your local harddrive and one on a network drive which is backed up offsite by your organization.  But where these backups go is up to you.

What is somewhat interesting is how old backups are expired over time.  Whenever a new backup is created, its filename is set to contain both a timestamp and a sequence number.  The timestamp reflects the time of creation of the backup.  The sequence number is the increment of the largest sequence number of prior backups of the same directory, or 1 if there aren't any. After a new backup has been produced, a filtering process is applied to the collection of all backups for the directory in question.  For each such backup, its sequence number is used (in any one of a configurable variety of ways) together with a supplied timescale, to compute a "shelflife" for that backup.  If the backup is older than its computed shelflife, it is deleted.

Interesting ways of computing a shelflife for a backup involve first prime factorizing the sequence number (hence the name _pfbackup_), and then extracting some information from that factorization.  For example, multiplying the factors of 2 should yield a shelflife distribution similar to the one implemented by the abovementioned related projects.  Alternatively, one could simply use the value of the smallest prime factor, or the total number of factors.

Notice that all the information for determining whether a given backup should be deleted is encoded in the backup's name, and the configuration parameters supplied to the utility.  So manual deletion of other unexpired backups from the collection will not affect the expiry decision.

DISCLAIMER: I make no claims about the nature of the tradeoff between disk space and retention guarantees implied by any of these schemes.  I simply present this utility as something which may be useful to you and which has interesting tuning potential which you are free to explore. USE AT YOUR OWN RISK. :innocent:
