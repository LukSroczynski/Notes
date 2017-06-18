# What is web socket? 

Client-Server - internet connection connects those two. Internet connection is Full-Duplex, means data can flow in both direction. Also it's reliable (niezawodny). So socket is just a end connection. So there is Server-Socket and Client-Socket. One connection needs two sockets.

# Web Browsers

Basic components of web browser:
- user interface, buttons etc.
- browser engine
- rendering engine, taking html, css, js and putting something on the screen
- networking, uses HTTP, requests, responses, resolve DNS's
- javascript interpreter
- UI back-end - stuff that draw stuff that you want like i want rectangle and you have it... xd
- data persistance, cookies, search-history and all other data


Rendering engine includes and do stuff like:


> Resource gathering - web uses network to get resources, HTML, CSS, Pictures... 

> Parse HTML & Create DOM Tree - (DOM - document object tree) DOM is very flexible, if you fotget a tag it's still gonna work, so basically this point refers to taking resources from point above and create a tree from that. 

> Create Render Tree From DOM Tree - now take CSS from resources and apply that to DOM tree (HTML files)

> Layout - position all elements

> Painting - send to UI back-end and display onto screen, draw stuff

> Additional: 
e.g. You have DOM-tree and there is a tag that is hidden. If you hide something then Render-Tree-part doesn't gonna need to render HTML's tag that is hidden. 


# HTTP Overview

- follows client-server model
- stateless which means every transaction is independent is not related to others. Fliping a coin is a stateless example. BUT web application still provide you state: session & cookies mechanisms
- it's application layer which means it on top of TCP/IP layer. In most cases uses TCP. 
- client-actions - GET / POST / PUT / DELETE 
- response status codes
- headers - bit of information that you send with response / request. Cool header is cache-control determines how those resurces are cached. 

# Sessions & Cookies





