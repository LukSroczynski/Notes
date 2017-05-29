1. Garbage Collector

> http://www.bottega.com.pl/pdf/materialy/jvm/jvm2.pdf

Są dwa rodzaje algorytmów wykorzystywane przez GC: 

> Skalarne to usuwanie referencji. Jeśli referencja do obiektu jest równa zero wtedy odśmiecanie pamięci usuwa ten obiekt. 

> Wektorowe to usuwanie grafowe. Zaczynamy od początku grafu ROOT i idziemy tak daleko aż napotkamy koniec grafu. Wszystkie gałęzie nie uwzględnione w takim wyszukaniu zostaną usunięte.

1. Garbage Collector
> Is a automatic memory management. 
> We cannot force GC to happen e.g. System.gc()
> You can have memory leaks in GC. For example you want to do new allocation and heap is full you end up with java.lang.OutOfMemoryerror. 

So GC have 3 steps: 
1. Mark - Graph that checks if object is reachable. 
2. Delete/sweep - Delete unreachable objects 
3. Compacting - step where you arrange everything in order. It goes througt entire heap and arrange them. 

GC is basically called Generational Collectors. 
Heap is devided into:

  1. Young generation - 

 1.1 Eden space

 1.2 Survivor space from

 1.3 Survivor to

  2. Old generation - 




