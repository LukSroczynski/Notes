# You don't know JS - Up & Going 

## Słówka:
- <b> subsequent </b> - kolejny
- <b> despite  </b> - pomimo
- <b> explicitly  </b> - wyraźnie
- <b> compound  </b> - złożony
- <b> coercion </b> - koercja
- <b> explicit  </b> - wyraźny
- <b> implicit </b> - niewyraźny 
- <b> concise  </b> - zwięzły
- <b>  </b> - 
- <b>  </b> - 
- <b>  </b> - 
- <b>  </b> - 
- <b>  </b> - 
- <b>  </b> - 
- <b>  </b> - 
- <b>  </b> - 
- <b>  </b> - 
- <b>  </b> - 
- <b>  </b> - 
- <b>  </b> - 

## Pojęcia

Prototypes - 

Coercion - 



## Chapter 2

Przedstawione tutaj zostaną tylko najważniejsze nieścisłości, które występują w JS: 
()

Wbudowane typy wartości w JS: 
- string
- number
- boolean
- null and undefined
- object
- symbol (new to ES6)

<h4> Wartości i typy - Przykład:  </h4>

```javascript
let a;
typeof a;               // "undefined"

a = "hello world";
typeof a;               // "string"

a = 42;
typeof a;               // "number"

a = true;
typeof a;               // "boolean"

a = null;
typeof a;               // "object" - bug? 

a = undefined;
typeof a;               // "undefined"

a = { b: "c" };
typeof a;               // "object"
```


> typeof - zwraca typ wartości, która znajduje się obecnie w zmiennej

> Wartość, którą zwraca typeof jest to zawsze "string", a nie string. 

Warto wspomnieć o ``` typeof = null ```, które zwraca ``` object ```
w przypadku gdzie oczekiwałbyś null'a.

> Jest to dawny bug Javascriptu, którego prawdopodobnie nigdy nie naprawią ponieważ zbyt 
duża ilość kodu w sieci opiera się na tym błędzie. Gdyby postanowiliby go naprawić
ilość błędów jakie naprawa by wygenerowała byłaby ogromna!

Jest kilka możliwości dostępu do obiektu w JS:

```javascript

// przykład dostępu do obiektu
let obj = {
    a: "hello world",
    "test test test": 42
};

obj.a;      // "hello world"
obj["test test test"];   // 42
 
 
// przykład dostępu do tablicy
let arr = [
    "hello world",
    42,
    true
];

arr[0];         // "hello world"
arr[1];         // 42
arr[2];         // true

```

- W większości przypadków lepiej jest używać zapisu ``` obj.a ``` jest to po prostu bardziej czytelne.
Jednakże jesli właściwość obiektu wygląda jak powyżej ``` "test test test" ``` potrzebny jest 
łańcuch znaków (String).

- Coercion (koercja) - dzieli się na wyraźną (explicit) i niejawną (implicit)

Example of explicit coercion:
```javascript
var a = "42";

var b = Number( a );

a;              // "42"
b;              // 42 -- the number!
```

Example of implicit coercion: 
```javascript
var a = "42";

var b = a * 1;  // "42" implicitly coerced to 42 here

a;              // "42"
b;              // 42 -- the number!
```

- Truthy & Falsy

Lista wartości Falsy:

- "" (empty string)
- 0, -0, 
- NaN (invalid number) (not a number) 
- null
- undefined
- false

Każda inna wartość jest Truthy. Przykłady: 

- [ ], [ 1, "2", 3 ] (arrays)
- { }, { a: 42 } (objects)
- function foo() { .. } (functions)
- "test"

Są dwa rodzaje porównania w JS:
>  ==  
loose-equaality

> ===  
strict-equality

W przypadku porówniania: 

``` "42" == 42 ```  - (koercja)"42" zostaje przekonwertowany na 42 (number), więc są porównywane liczby, 
które dają wynik porówniania true

``` "42" === 42 ``` - tutaj koercja nie jest zezwolona, więc wynik porównania to false

Przydatne rzeczy: 

1. Switch statement:
break statement - przerywa wykonywanie warunku:

```javascript

let a = 10;
/*
    Tylko jeden case jest wykonany
 */
switch (a) {
    case 2:
        // do something
        break;
    case 10:
        // do another thing
        break;
    case 42:
        // do yet another thing
        break;
    default:
        // default 
}

/*
    Wykonanie będzie kontynuowane bez względu na "case matching"
    Nazywa się to: "fall through"
 */
switch (a) {
    case 2:
    case 10:
        // some cool stuff
        break;
    case 42:
        // other stuff
        break;
    default:
        // fallback
}

```

2. Ternary operator (conditional operator): 

- najbardziej popularnym przypadkiem w jakim jest użyty to przypisanie do zmiennej

```javascript
    let b = (a > 41) ? "true-value" : "false-value";
```

3. Strict mode 

- dodaje ograniczenia przez co kod staje się bezpieczniejszy 
( Nie pozwala na deklarację zmiennej pomijającej let/var/const )
- czyni twój kod bardziej zoptymalizowany przez silnik. 
- 
 
```javascript
    "use strict";
    
    function foo() {
        // this code is strict mode
    
        function bar() {
            // this code is strict mode
        }
    }
    // this code is strict mode  
```

4. IIFE - Immediately Invoked Function Expression

related video: // dodać konkretny czas filmu, gdzie mówi IIFE'eee
- var, const, let - fun fun function (https://goo.gl/ZHoYtT)

```javascript
 
 /*
    Prosty przykład:
    Ostatnia linika kodu jest odpowiedzialna na natychmiastowe wykonanie funkcji - nawiasy ()
  */
(function IIFE(){
    console.log( "Hello!" );
})();

/*
    Porównanie do zwykłej funkcji: 
    W obu przypadkach wykonianie funkcji następuje po nawiasach () 
 */
function test() { ... }
test();

(function IIFE(){ ... })();


```

5. Closure (domknięcie)

Można powiedzieć, ze domknięcie jest to swego rodzaju sposób na zapmiętanie stanu funkcji. Jest to sposób na 
dostęp do funkcji nawet po tym jak została ona zakończona. 

- link do drugiej części LINK - wytłumaczone bardziej szczegółowo

```javascript

/*
    Prosty przykład domknięcia
 */

function makeAdder(x) {
    function add(y) {
        return y + x;
    };
    return add;
}


let plusOne = makeAdder( 1 );
let plusTen = makeAdder( 10 );

plusOne( 3 );       // 4  <-- 1 + 3
plusOne( 41 );      // 42 <-- 1 + 41

plusTen( 13 );      // 23 <-- 10 + 13

```

