use Digest::MD5  qw(md5 md5_hex md5_base64);
use DBI;

my $dbh = DBI->connect('DBI:mysql:rainbow', 'root', '') || die "Could not connect $DBI::errstr";

open(FILE, 'rockyou.txt') || die('Could not open file');
while(<FILE>) {

	my $data;
	chomp($data = $_);
	$data =~ s/\r\n?//g;
	$hash = md5_hex $data;
	$data =~ s/'/''/g;
	my @vals = ($data,$hash);
	my $sth = $dbh->prepare("insert into hash(hash_word, hash_hash) values (?,?);");
	$sth->execute(@vals) || die "Query failed! $DBI::errstr";
}

close(FILE);
$dbh->disconnect();
