1. Garbage Collector

http://www.bottega.com.pl/pdf/materialy/jvm/jvm2.pdf

Dzieli się na dwie grupy. Skalarne i wektorowe. 

> Skalarne to usuwanie referencji. Jeśli referencja do obiektu jest równa zero wtedy odśmiecanie pamięci usuwa ten obiekt. 

> Wektorowe to usuwanie grafowe. Zaczynamy od początku grafu ROOT i idziemy tak daleko aż napotkamy koniec grafu. Wszystkie gałęzie nie uwzględnione w takim wyszukaniu zostaną usunięte.


