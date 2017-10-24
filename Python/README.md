```python

class Animal:

    # To są prywatne zmienne (teoretycznie niewidoczne, w praktyce widać je i można je zmieniać, ale nie powinno się)
    __name = None
    __height = 0
    __sound = 0


    # To jest konstruktor
    def __init__(self, name, height, sound):
        self.__name = name
        self.__height = height
        self.__sound = sound


    # Obiektowe podejście do programowania w pythonie

    def set_name(self, name):
        self.__name = name


    def set_height(self, height):
        self.__height = height


    def set_speed(self, speed):
        self.__speed = speed


    def get_name(self):
        return str(self.__name)


    def get_height(self):
        return str(self.__height)


    def get_sound(self):
        return str(self.__sound)


    def get_type(self):
        return type(Animal)


    def toString(self):
        return "{}, {}, {}".format(self.__name, self.__height, self.__sound)


class Dog(Animal):
    __owner_name = None

    def __init__(self, name, height, sound, owner):
        self.__owner_name = name
        super(Dog, self).__init__(name, height, sound)


    def get_multiple_sounds(self, how_many = None):
        if how_many is None:
            print(self.get_sound())
        else:
            print(self.get_sound() * how_many)

animal = Dog("Name", 100, "Sound", "Jack")
print(animal.toString())
print(animal.get_multiple_sounds(10))


```
