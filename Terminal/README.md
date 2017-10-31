# Konfiguracja

```

# Uruchamianie sublime z terminala ( na przykładzie Mac OS X )
1. Znajdujemy gdzie mamy zainstalowanego sublime
2. Tworzymy symbolic link pliku "subl"
$ ln -s /Applications/Sublime\ Text.app/Contents/SharedSupport/bin/subl /usr/local/bin/sublime

```

# Narzędzia

Narzędzie do archiwizacji:  

```

# Tworzenie nieskompresowanego archiwum

## Tworzenie archiwum
 $ tar cvf file_name.tar dir_name/

## Rozpakowanie archiwum
 $ tar xvf file_name

# Tworzenie skompresowanego archiwum
 $ tar cvzf archive_name.tar.gz dirname/
 $ tar xvfz archive_name.tar.gz

c - tworzy nowe archiwum
x - wypakowuje z archiwum

v - listuje pliki w terminalu (rozpakowane / spakowane) 
f - nazwa pliku
z - otwiera/tworzy skompresowane archiwum

```

Tworzenie folderów: 

```
# Tworzy folder
$ mkdir folder_name

# Tworzy folder razem z pod-folderami, jeśli potrzebne
$ mkdir folder_name/sub_fold/sub_fold_2


```

Listowanie zawartości folderów:

```
# Listowanie jednego pliku per linia
ls -l

# Listowanie folderu bez zawartości 
ls -ld


```

Znajdywanie procesu po portcie i zabicie go:
```
$ sudo lsof -i tcp:3000 

Wynik:
COMMAND   PID       USER        FD   TYPE            DEVICE SIZE/OFF NODE NAME
node      35154     user.name   xxx  IPv6 xxxxx      0t0  TCP *:hbci (LISTEN)

$ kill -9 35154

```



# Skróty w terminalu

```

# Czyszczenie command-prompt
CTRL + U

# Czyszczenie terminala
CTRL + L


```
