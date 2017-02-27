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

> RHS - szuka wartości zmiennej 

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

