Credential decrypter for ManageEngine OpManager version 11.x
Tested on Free and Essential version

Abusing some SQL Injection on OpManager, is it possible to dump the
table that contains managed devices' username/password and ip.

OpManager encrypts password before to store them in the database. Of
course OpManager need passwords in plaintext to login on devices
so the alghoritm couldn't be one-way.
The encryption algorithm doesn't use a per-site key therefore
reversing^Hguessing the algorithm leads to decryption of credentials
on every (tested) installation.

Notified to the vendor the 7th of April 2015, no fix nor workaround yet.

Usage:
$ javac DecryptOpManager
$ java -cp . DecryptOpManager [encrypt|decrypt] string
