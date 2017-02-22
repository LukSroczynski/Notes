# You don't know JS - Up & Going 

## Słówka:
- <b> subsequent </b> - kolejny
- <b> despite  </b> - pomimo
- <b> explicitly  </b> - wyraźnie
- <b> compound  </b> - złożony
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
- <b>  </b> - 
- <b>  </b> - 
- <b>  </b> - 
- <b>  </b> - 

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
let obj = {
    a: "hello world",
    "test test test": 42,
};

obj.a;      // "hello world"

obj["a"];   // "hello world"
obj["test test test"];   // 42
```

W większości przypadków lepiej jest używać zapisu ``` obj.a ``` jest to po prostu bardziej czytelne.
Jednakże jesli właściwość obiektu wygląda jak powyżej ``` "test test test" ``` potrzebny jest 
łańcuch znaków zwany String.
 
 