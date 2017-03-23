# Machanizm this w javascript

Jedynym z najbardziej mylących mechanizmów w Javascript jest słowo kluczowe ```this```

```javascript

function identify() {
    return this.name.toUpperCase();
}

function speak() {
    var greeting = "Hello, I'm " + identify.call( this );
    console.log( greeting );
}

var me = {
    name: "Kyle"
};

var you = {
    name: "Reader"
};

identify.call( me ); // KYLE
identify.call( you ); // READER

speak.call( me ); // Hello, I'm KYLE
speak.call( you ); // Hello, I'm READER

```

Powyższy kod pozwala na wielokrotne użycie ```identify()``` i ```speak()```. Nie ma potrzeby
pisania oddzielnych funkcji dla każdego obiektu. 

Można oczywiście pominąć powyższy krok i przekazać do funkcji parametr ```context```. W przypadku poniżej
pominęliśmy ```this``` kod działa tak samo jak powyższy przykład jednakże stosowanie ```this``` 
jest bardziej eleganckie i prowadzi do czystszego i bardziej zrozumiałego kodu naszej aplikacji, który może być z większą łatwości ponownie użyty.


```javascript

function identify(context) {
	return context.name.toUpperCase();
}

function speak(context) {
	var greeting = "Hello, I'm " + identify( context );
	console.log( greeting );
}

identify( you ); // READER
speak( me ); // Hello, I'm KYLE

```

Im bardziej skomplikowany jest twój wzorzec tym bardziej zobaczysz, że stosowanie 
jawnych (ang. explicit) parametrów jest niechlujne. W dalszej części wpisu będzie pokazana przydatność
funkcji, która automatycznie zawiera referencję do obiektu. 

## Jesteś pewien, że wiesz jak działa ```this``` ? 

Sama nazwa ```this```  jest często myląca przez co programiści, myślą o tym zbyt dosłownie.
Pierwszym błędem jest myślenie o ```this``` jako o referencji do funkcji samej w sobie. Jest to błędne założenie. 
Przykładem może być rekurencja, czyli kiedy funkcja wywołuje samą siebie. 

```javascript

function foo(num) {
	console.log( "foo: " + num );


	this.count++; // to nie zadziała, a w dodatku stworzy nam globalną zmienna count 
	
	/**
	*  To nie zadziała: 
	*  this.count++;
	*  W tym przypadku jest tworzona zmienna globalna. 
	*  Wstępnie jest ona undefinied przez co gdy ją inkrementujemy zmienia się w NaN.
	* 
	*  To zadziała:
	*  foo.count++; 
	*  
	*  To także zadziała, ale jest to znowu rezygnacja z mechanizmu ```this```: 
	*  data.count++;
	*  Jest to ucieczka do znanego leksykalnego zakresu.
	*  Pomijanie mechanizmu ```this``` wcale nam nie pomaga po prostu ignorujemy problem z powodu braku zrozumienia go. 
	*  
    */
}

foo.count = 0;

var data = {
	count: 0
};

var i;

for (i=0; i<10; i++) {
	if (i > 5) {
		foo( i );
	}
}

// foo: 6
// foo: 7
// foo: 8
// foo: 9

console.log( foo.count ); // 0 

/**
*   Najlepszym sposobem jest po prostu nauczenie się mechanizmu ```this```
*   Poniżej użyliśmy ```this``` jako referencji do obiektu count
*   Poprzez użycie call() upewniliśmy się, że ```this``` wskazuje na obiekt funkcji foo()
*   
*/

function foo(num) {
	console.log( "foo: " + num );
	this.count++;
}

foo.count = 0;

var i;

for (i=0; i<10; i++) {
	if (i > 5) {
		foo.call( foo, i );
	}
}
// foo: 6
// foo: 7
// foo: 8
// foo: 9

console.log( foo.count ); // 4

```

Kolejnym bardzo popularnym nieporozumieniem jest to, że ```this``` odwołuje sie zakresu funkcji. 
Jest to podchwytliwe, dlatego, że jednocześnie jest to prawda, ale też i błędne założenie. 
Zacznijmy od tego, że ```this``` nie odnosi się w żadnym wypadku do leksykalnego zakresu jak było pokazane w 
powyższych przykładach. 
Zakres jest to pewnego rodzaju obiekt z właściwościami, ale nie jest on dostępny dla programisty. Jest to po
prostu część silnika.

```javascript

/**
*   Mamy tutaj próbę stworzenia pomostu między leksykalnymi zakresami. Jest to niemożliwe. 
*   Użycie ```this``` nie tworzy mostu pomiędzy foo() i bar().
*   Nie można używać ```this``` aby zobaczyć coś w leksykalnym zakresie.
*/

function foo() {
	var a = 2;
	this.bar();
}

function bar() {
	console.log( this.a );
}
foo(); //undefined

```

<<<<<<< HEAD


=======
Podsumowując ```this``` nie jest odwołaniem do funkcji, ani do zakresu leksykalnego.
Wiązanie (ang. binding) ```this``` jest gdy funkcja jest wywoływana i to do 
czego odwołuje się mechanizm ```this``` jest całkowicie zdeterminowane przez źródło wywołania.
>>>>>>> 31cef19509d083420fb9881c1e1d475322dc738b
