## Dependency injection

Dependency injection helps to make an object independent of the construction process of its objects.
The class does not get inflatet with the potentially very complex creation process of its objects. Instead it just focuses on the usage.
The dependencies are created externally and injected into the class by an injector. 
The usage of dependency injection allows to create objects at different places then the objects are actually used.
DI is essential to allow meaningful configuration options.

Injection can generally be done using 2 ways: Setter or constructor. The Setter can additionally be specified by an interface.


### Resources 
1. https://en.wikipedia.org/wiki/Dependency_injection