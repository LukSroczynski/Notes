1. Struktury danych, paradygmaty projektowania algorytmów, modele rozwiązywania problemów.

Stuktury danych to pojemniki na dane, które je gromadzą i układają w odpowiedni sposób. 

Podstawowe struktury danych: 

- Stos
> Można sobie wyobrazić jako stos książek, które układamy kolejno na sobie, w danym momencie dostępna jest tylko książka na górze stosu, którą możemy zabrać. 

Funkcje: 
empty() zwraca true jeżeli stos jest pusty
pop() usuwa element znajdujący się na szczycie stosu
push() dodaje element na szczycie stosu
size() zwraca liczbę elementów stosu
top() zwraca referencję do elementu na szczycie stosu

```java

public class Stack {
 
    // Zdefiniowanie tablicy i elementów odpowiedzialnych za wierzchołek.
    double[] tab;
    int firstFree;
 
    // Konstruktor, który zainicjuje wierzchołek i stos o odpowiedniej
    // wielkości.
    public Stack(int MaxSize) {
        tab = new double[MaxSize];
        firstFree = 0;
    }
 
    // Metoda zwracająca maksymalny rozmiar stosu
    int getMaximumStackSize() {
        return tab.length;
    }
 
    // Metoda zwracająca prawdę, jeżeli stos jest pusty
    boolean isEmpty() {
        if (firstFree == 0) {
            return true;
        } else
            return false;
    }
 
    // Metoda zwracająca rozmiar stosu
    int getSize() {
        return firstFree;
    }
 
    // Metoda dodająca na stos
    void Push(double E) throws ArrayIndexOutOfBoundsException {
        if (firstFree < tab.length) {
            tab[firstFree] = E;
            firstFree++;
 
        } else {
            throw new ArrayIndexOutOfBoundsException(
                    "Przepełnienie stosu, operacja nie powiodła się");
        }
    }
 
    // Metoda zdejmująca ze stosu
    double Pop() throws IndexOutOfBoundsException {
        if (firstFree <= 0) {
            throw new IndexOutOfBoundsException(
                    "Stos jest pusty, operacja nie powiodła się");
        }
 
        double temp = tab[firstFree - 1];
        firstFree--;
        return temp;
    }
 
    // Metoda wyświetlająca zawartość stosu
    void display() throws IndexOutOfBoundsException {
        if (firstFree == 0) {
            throw new IndexOutOfBoundsException(
                    "Stos jest pusty, operacja nie powiodła się");
        }
 
        int temp = firstFree - 1;
        do {
            System.out.println(tab[temp]);
            temp--;
        } while (temp > -1);
 
    }
 
    // Metoda wielokrotnego zdjęcia
    void multiPop(int k) {
        if (k < firstFree) {
            for (int i = k; i > 0; i--) {
                System.out.println(Pop());
            }
        }
    }
 
    // Metoda czyszcząca stos
    void clear() {
        for (int i = 0; i < firstFree; i++) {
            tab[i] = 0.0;
 
        }
 
        firstFree = 0;
    }
 
    // Metoda odwracająca kolejność elementów na stosie
    void reverse() {
        for (int i = 0; i < firstFree / 2; i++) {
            double temp = tab[i];
            tab[i] = tab[firstFree - 1 - i];
            tab[firstFree - 1 - i] = temp;
 
        }
    }
}

```

- Lista
- Kolejka
- Graf 
- Drzewo
- Kopiec

2. Podstawowe konstrukcje języków algorytmicznych. Rekurencja i typy programów rekurencyjnych. Analiza sprawności algorytmów.

3. Programowanie strukturalne i obiektowe. Algorytmy sortowania i wyszukiwania danych.

4. Dynamiczne struktury danych – listy, tablicowe implementacje list, stos, kolejki, sterty i kolejki priorytetowe, drzewa i ich reprezentacje. Zastosowanie techniki programowania typu „dziel-i-rządź”

5. Paradygmaty programowania Obiektowego. 

6. Klasy Kolekcji.

7. Polimorfizm, dziedziczenie. 
