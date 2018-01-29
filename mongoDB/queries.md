MongoDB queries:


Find tylko te co mają “Joel Coen” na pierwszym miejscu w tablicy
db.getCollection(‘yourCollection’).find({"writers.0”: "Joel Coen"})

Tylko tytuł z _id (domyślnie zawsze)
db.getCollection('movieDetails').find({rated: "PG"}, {title: 1}) 

Tylko tytuł 
db.getCollection('movieDetails').find({rated: "PG"}, {title: 1, _id: 0}) 

