1. Struktury danych, paradygmaty projektowania algorytmów, modele rozwiązywania problemów.

Stuktury danych to pojemniki na dane, które je gromadzą i układają w odpowiedni sposób. 

## Podstawowe struktury danych: 

### Stos - Last In, First Out
> Można sobie wyobrazić jako stos książek, które układamy kolejno na sobie, w danym momencie dostępna jest tylko książka na górze stosu, którą możemy zabrać. .

Funkcje: 
* empty() zwraca true jeżeli stos jest pusty
* pop() usuwa element znajdujący się na szczycie stosu
* push() dodaje element na szczycie stosu
* size() zwraca liczbę elementów stosu
* top() zwraca referencję do elementu na szczycie stosu


### Kolejka - First In, First out

> Podobny do stosu, wstawiony element do kolejki jest jako pierwszy z niej pobierany.  

Funkcje: 
* empty() zwraca true jeżeli kolejka jest pusta
* pop() usuwa element znajdujący się na początku kolejki
* push() dodaje element na końcu kolejki
* size() zwraca liczbę elementów w kolejce

### Lista

> Jest to struktura danych przechowująca nieznaną z góry liczbę parametrów tego samego typu. Składa się ona z węzłów. Zawierają one dane z listy oraz wskaźnik do kolejnego elementu. W przypadku listy dwukierunkowej także do poprzedniego. 

Lista jednokierunkowa - Zawiera blok informacyjny INFO (Głowa: wskaźnik do pierwszego elementu oraz ostatniego). Ponadto każdy element zawiera wskaźnik do następnego elementu. 

Lista dwukierunkowa - to samo co jednokierunkowa. Zawiera dodatkowo wskaźnik do poprzedniego elementu. 

Lista posortowane / nieposortowane - dane z listy mogą być posortowane lub też być przypadkowe. 

Listy z wartownikiem / bez wartownika -  na początku listy może
znajdować się dodatkowy element zwany wartownikiem (wówczas
pierwszy element listy to następnik wartownika; ostatni element listy
to poprzednik wartownika; lista pusta składa się tylko z wartownika)

Funkcje: 
* push_front() dodaje element na początku listy
* push_back() dodaje element na końcu listy
* insert() dodaje element we wskazanym miejscu listy
* pop_front() usuwa element z początku listy
* pop_back() usuwa element z końca listy
* size() zwraca liczbę elementów na liście
* max_size() zwraca maks. liczbę elementów jakie może zmieścić lista
* empty() sprawdza czy lista jest pusta
* remove() usuwa z listy wszystkie elementy mające daną wartość
* sort() układa elementy na liście rosnąco
* reverse() odwraca kolejność elementów na liście

### Drzewo

> Jest to hierarchiczna struktura danych. Znaczy to tyle, że dane są uporządkowane według jakiegoś kryterium. Elementy są nazwane węzłami lub wierzchołkami. A więc węzeł posiada co najwyżej dwa następniki, binarny = dwójkowy, dwa elementy. Następniki te nazywamy potomkami. (child node) danego węzła czyli ojca (parent node). Czyli mamy ~Parent Node i on ma ~Child Node. Węzeł, który nie posiada rodzica jest nazwany ~Root Node. Tak, więc podsumowując hierarchia węzłów wygląda następująco: 
Root Node -> Parent Node -> Child Node 

https://upload.wikimedia.org/wikipedia/commons/thumb/d/d4/Full_binary.pdf/page1-220px-Full_binary.pdf.jpg

### Graf 
### Kopiec - Heap

2. Podstawowe konstrukcje języków algorytmicznych. Rekurencja i typy programów rekurencyjnych. Analiza sprawności algorytmów.

3. Programowanie strukturalne i obiektowe. Algorytmy sortowania i wyszukiwania danych.

4. Dynamiczne struktury danych – listy, tablicowe implementacje list, stos, kolejki, sterty i kolejki priorytetowe, drzewa i ich reprezentacje. Zastosowanie techniki programowania typu „dziel-i-rządź”

5. Paradygmaty programowania Obiektowego. 

6. Klasy Kolekcji.

7. Polimorfizm, dziedziczenie. 
