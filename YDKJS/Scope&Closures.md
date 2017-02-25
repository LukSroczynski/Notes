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
- Kompilator (ang. Compiler) - zajmuje się brudną robotą. Czyli Parsing oraz Code-Generation (patrz poprzedni rozdział).
- Zakres (ang. Scope) - zbiera i przechowuje wszystkie zadeklarowane zmienne. Dodakowo determinuje ich dostępność w aktualnie wykonywanym kodzie.

