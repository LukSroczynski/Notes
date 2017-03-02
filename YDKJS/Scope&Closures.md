# Czym jest zasięg?

Podstawowym paradygmatem z jakim spotykamy się w praktycznie każdym języku jest pojęcie zmiennej. Jest to krytyczna część języków programowania. Pozwala
na przechowywanie, modyfikowanie i pobieranie stanu naszej apliakcji. Istnieją pewne reguły, dzięki którym program odszukuje zmienne i nazywa się to zakresem. 

Javascript - język ten jest często określany mianem języka interpretowanego lub dynamicznego co nie do końca jest prawdą. W rzeczywistości jest to język kompilowany.
Różnica polega na tym, że nie jest on kompilowany w taki sam sposób jak większość tradycyjnych języków jak przykładowo starszy brat Java. W tradycyjnym języku 
kod źródłowy programu przechodzi przez trzy kroki:
1. Tokenizing/Lexing - podział ciągu tekstowego na tokeny. 

```javascript
    let x = 5; 

/*
    Powyższy program można podzielić na 5 części:
    -> let 
    -> x 
    -> = 
    -> 5 
    -> ;
 */
```

2. Parsing - pobranie tablicy tokenów i zamiana tego na drzewo zagnieżdżonych elementów AST (ang. Abstract Syntax Tree). 

```javascript
    let x = 5; 

/*
    Tworzenie drzewa dla powyższego przykładu może wyglądać w następujący sposób od najwyższego poziomu węzła: 
    - VariableDeclaration 
    - Identifier   
    - AssignmentExpression
    - NumericLiteral
 */
```

3. Code-Generation - pobranie AST (ang. Abstract Syntax Tree) i zmienienie go na zbiór instrukcji maszynowych. 
Jest to po prostu stworzenie zmiennej i zarezerwowanie miejsca w pamięci i przechowanie wartości w danej zmiennej. 

Silnik Javascriptu jest bardziej skomplikowany niż powyższe kroki. W skrócie kod javascriptu jest kompilowany tuż przed jego uruchomieniem.
Program bierze polecenie, kompiluje je i jest od razu gotowy do wykonania go. Wszystko to zajmuje ledwo kilka mikrosekund. 

##Zrozumieć zakres:

Na początek podzielmy zakres na role jakie odgrywa: 

- Silnik (ang. Engine) - jest odpowiedzialny za kompilację i wykonianie naszego programu od początku do końca.
- Kompilator (ang. Compiler) - powiązany z silnikiem. Zajmuje się brudną robotą, czyli generacją i analizą kodu. Jest to Parsing oraz Code-Generation (patrz poprzedni rozdział).
- Zakres (ang. Scope) - również powiązany z silnikiem. Zbiera i przechowuje wszystkie zadeklarowane zmienne. Dodakowo determinuje ich dostępność w aktualnie wykonywanym kodzie.

### Jak działa kompilator? 

```javascript
let a = 5;
```

1. Po napotkaniu powyższej deklaracji Kompilator pyta Zakres czy zmienna istnieje w zbiorze dla podanego Zakresu (ang. Scope Collection):
- if(true) - kompilator ignoruje deklarację i idzie dalej.
- else - kompilator prosi Zakres o zdeklarowanie zmiennej dla danego Zakresu
> Podsumowując: Kompilator deklaruje zmienną o ile nie została wcześniej zadeklarowana

2. Następnie kompilator produkuje kod dla Silnika, który jest
 potem przeznaczony do wykonania i jest odpowiedzialny za wykonanie przypisania do zmiennej wartości literalnej. 
Kod wykonywany przez Silnik najpierw zapyta czy zmienna o podanej nazwie istnieje w bieżącym zakresie. 
- if(true) - Silnik użyje zmiennej
- else - Silnik zacznie szukać w innych miejscach. ( patrz dalej w podpunkcie: Zakres zagnieżdżony )
> Podsumowując: Kompilator szuka zmiennej i przypisuje jej wartość

## Jak działa kompilator? 

Silnik wykonuje kod, który kompilator wyprodukował. Szuka on potem zmiennej, którą
konsultuje z Zakresem. 

> LHS - szuka kontenera, gdzie może przypisać wartość
Przypisanie może być poprzez operator równości lub jako parametr w funkcji

> RHS - szuka wartości zmiennej, pobranie jej wartości


```javascript

/*
    Tutaj jest referencja RHS. Nic nie jest przypisane do a
    Zamiast tego szukamy wartość a
 */
console.log(a);

/*
    Tutaj jest referencja LHS, nie obchodzi nas jaka jest wartość
    Chcemy znaleźć zmienną i przypisać wartość
 */
a = 2;

```

#### Jak działa silnik? ~streszczenie krótki opis
Silnik javascriptu na początku komiluje kod przed jego wykonaniem. Podczas tego 
rozdziela polecenie ``` var a = 2; ``` na dwa kroki
- deklaracja ``` var a ``` w zakresie. To jest robione na początku przed wykonianiem kodu
- przypisanie ``` a = 2 ``` (referencja LHS). Szuka zmiennej i jeśli znajdzie przypisuje wartość

Szukanie RHS, które nie znajdzie referencji wyrzuca błąd ReferenceError 

Szukanie LHS, które nie znajdzie referencji automatycznie tworzy globalną zmienną. Można temu
zapobieć poprzez zastosowanie "use strict"
 

```javascript

function foo(a) {
    console.log( a ); // 2
}
foo( 2 );

```

Silnik-Zakres: 
- Silnik pyta Zakres o referencję RHS ``` foo() ```
- Zakres odbiera od Kompilatora deklarację 
- Silnik wykonuje funkcję
- Silnik pyta Zakres o referencję LHS ``` a ```
- Zakres obiera od Kompilatora deklarację ``` a ``` jako parametru funkcji
- Silnik przypisuje wartość ``` 1 ``` do ``` a ```
- Silnik pyta Zakres  ``` console ``` potem o ``` log(...) ```
- Silnik pyta Zakres o referencję RHS do ``` a ```
- Silnik przekazuje ``` a ``` do ``` log() ```

## Zagnieżdżony Zakres

Zakres - zestaw zasad, który szuka zmiennych. Zazwyczaj jest więcej niż jeden Zakres. 

Jeśli funkcja jest zagniżdżona w innej funkcji i zmienna nie może być znaleziona 
w tej wewnętrznej funkcji Silnik przechodzi do kolejnego zewnętrznego Zakresu kontynuując to
aż do Globalnego Zakresu.

# Czym jest leksykalny zasięg? 

Nazwa zmiennej, funkcji to inaczej nazwa identyfikatora 

```javascript

/*
    Są tutaj trzy zakresy: 
    - zakres globalny - zawiera identyfikator foo
    - zakres foo - zawiera identyfikator a, b, bar
    - zakres foo.bar - zawiera identyfikator c 
 */

function foo(a) {

    var b = a * 2;

    function bar(c) {
        console.log( a, b, c );
    }
    bar(b * 3);
}

foo( 2 ); // 2 4 12 

```



Założenie: Każda funkcja ma nowy 'bąbelek zakresu'

Szukanie zmiennej jak w powyższym przykładzie zatrzymuje się zawsze w momencie jak 
znajdzie zmienną. Przykładowo szukanie c zatrzymuje sie w bar i nie przechodzi do foo.
Szukający to Silnik

Globalne zmienne są automatycznie właściwościami globalnego obiektu ``` window ```. 
Jest więc możliwe użycie właściwości obiektu zamiast leksykalnej nazwy.
Przykład: ``` window.a ```

### Oszukanie leksykalne

Zakres leksykalny to w skrócie zakres zdefiniowany przez autora gdzie mają się znajdywać funkcje. 
W fazie lexing kompilacji jest wiadomo gdzie są wszystkie identyfikatory zadeklarowane i przewidziane jak będą wykonane

Javascript ma dwa mechanizmy do modyfikacji leksykalnego zakresu podczas run-time.
Niestety to tak zwane oszukiwanie prowadzi do spadku wydajności. 

Pierwsza funkcja to ``` eval(..) ``` bierze String jako argument. Możesz wygenerować kod w środku twojego kodu. 
Pozwala to na modyfikację zakresu leksykalnego przez co możesz oszukać, ze jakiś kod był tam od początku.

```javascript

/*
    str - definiuje za pomocą eval() zmienną b, modyfikując w ten sposób zakres leksykalny
    zmienna b zdefiniowana w Stringu nadpisuje zmienną b=2 z zasięgu globalnego
    
    w przypadku użycia let nie działa tak samo 
 */

function foo(str, a) {
    eval( str ); // cheating!
    console.log( a, b );
}

var b = 2;

foo( "var b = 3;", 1 ); // 1 3

```

Kolejną funkcją jest ``` with() ```. Tworzy kilka referencji właściwości obiektu bez 
konieczności powtarzania referencji obiektu kilka razy. 

```javascript

/*
    Zwykły obiekt z właściwościami
 */

var obj = {
    a: 1,
    b: 2,
    c: 3
};

/*
    W przypadku zwykłego wywołania obiektu trzeba powtarzać 'obj'
 */

obj.a = 2;
obj.b = 3;
obj.c = 4;

/*
    Tutaj jest wykonana funkcja 'with' przez co 'obj' jest wykonywane tylko raz
 */

with (obj) {
    a = 3;
    b = 4;
    c = 5;
}
// e.g.
console.log(obj.a); // a = 3

```

Kolejny przykład:

```javascript

function foo(obj) {
    with (obj) {
        a = 2;
    }
}

var o1 = {
    a: 3
};

var o2 = {
    b: 3
};

foo( o1 );
console.log( o1.a ); // 2

foo( o2 );
console.log( o2.a ); // undefined
console.log( a ); // 2 -- Oops, leaked global!

/*
    W przypadku o1: Zakres miał tutaj identyfikator with miał referencję do właściwości 'a' 
    W przypadku o2: Tutaj zadziałało LHS jako, że nie było w Zakresie 'a'. Kontynuowało, aż do Zakresu Globalnego
    (Kolejny przykład dlaczego powinno używać sie strict mode)
    Przypomnienie: "use strict" -  nie pozwala na tworzenie globalnych zmiennych w powyższy sposób (przez przypadek)
 */

```

> Funkcja eval() modyfikuje już istniejący leksykalny Zakres.

> Funkcja with() tworzy kompletnie nowy leksykalny Zakres z obiektu, który tam wrzucasz. 
  
Obie funkcje są już przestarzałe (ang. deprecated) i nie powinno się ich używać
  
### Ale dlaczego nie używać eval() lub with()? 

Przecież można przez to zrobić bardziej elastyczny kod co w tym wielkiego, że będę używać tych funkcji? 

Silnik javascriptu ma wiele mechanizmów optymalizacji, które wykonują się podczas kompilacji.
Przykładowo Silnik identyfikuje gdzie znajdują się zmienne. W przypadku jak Silnik napotka 
na deklarację eval() lub with() musi założyć, że wszystkie deklaracje zmiennych mogą być nieprawidłowe. 
Dlatego też w takim wypadku Silnik nie wykonuje optymalizacji. Taki kod będzie działał
znacząco wolniej. 

Podsumowanie:
Leksykalny Zakres - są to funkcje, zmienne zdefiniowane podczas pisania kodu. 

Faza leksykalizcji (ang. lexing phase) - jest to w skrócie wiedza gdzie 
są ulokowane identyfikatory (zmienne) i jak będą dostępne podczas wykanania kodu.
   
Dwa mechanizmy mogą oszukać Leksykalny Zakres eval() oraz with: 

> Funkcja eval() modyfikuje już istniejący leksykalny Zakres. Może przykładowo dodac String z deklaracją zmiennej

> Funkcja with() tworzy kompletnie nowy leksykalny Zakres z obiektu, który tam wrzucasz. Ważne robi to podczas run-time. Traktuje referencję do obiektu jako Zakres, a właściwości obiektu jako identyfikatory w danym zakresie.

<b> Nie używać tych funkcji!</b> 

- wykonanie programu jest przez to wolniejsze, gdyż Silnik nie używa optymalizacji wykonywanych podczas kompilacji. 

# Funkcje vs Zakres Blokowy


