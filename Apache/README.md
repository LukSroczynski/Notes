<b> XAMPP </b> 
[XAMPP - Custom Path](http://stackoverflow.com/questions/1408/make-xampp-apache-serve-file-outside-of-htdocs)


<h2>Virtual Hosts</h2>

1. Open C:\xampp\apache\conf\extra\httpd-vhosts.conf.
2. Un-comment line 19 (NameVirtualHost *:80).
3. Add your virtual host (~line 36):
```xml
<VirtualHost *:80>
    DocumentRoot C:\Projects\transitCalculator\trunk
    ServerName transitcalculator.localhost
    <Directory C:\Projects\transitCalculator\trunk>
        Order allow,deny
        Allow from all
    </Directory>
</VirtualHost>
```
4. Open your hosts file (C:\Windows\System32\drivers\etc\hosts).
5. Add
```xml
127.0.0.1 transitcalculator.localhost #transitCalculator
```
to the end of the file (before the Spybot - Search & Destroy stuff if you have that installed).

6. Save (You might have to save it to the desktop, change the permissions on the old hosts file (right click > properties), and copy the new one into the directory over the old one (or rename the old one) if you are using Vista and have trouble).
7. Restart Apache.

- Now you can access that directory by browsing to http://transitcalculator.localhost/.

<h2> Make an Alias </h2>

1. Starting ~line 200 of your http.conf file, copy everything between ```xml<Directory "C:/xampp/htdocs">``` and ```xml</Directory>``` (~line 232) and paste it immediately below with ```xmlC:/xampp/htdocs``` replaced with your desired directory (in this case ```xmlC:/Projects```) to give your server the correct permissions for the new directory.
2. Find the ```xml <IfModule alias_module></IfModule> ``` section (~line 300) and add

```xml Alias /transitCalculator "C:/Projects/transitCalculator/trunk" ```
(or whatever is relevant to your desires) below the Alias comment block, inside the module tags. 

<h2>Change your document root</h2>

1. Edit ~line 176 in ```xml "C:\xampp\apache\conf\httpd.conf" ``` change DocumentRoot ```xml "C:/xampp/htdocs" ``` to #DocumentRoot ```xml"C:/Projects"``` (or whatever you want).
2. Edit ~line 203 to match your new location (in this case ```xmlC:/Projects```).
