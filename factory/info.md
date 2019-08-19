## Factory Method Design Pattern

If you have a couple of classes which extend a common class or implement a common interface you can use the factory method design pattern in order to abstract the object creation process.
This is done by creating a new method(usually sth like newInstance()) with a couple of parameters in a class(usually sth like {InterfaceName}Factory).
This method uses the given parameters to determine which class to instantiate. The method returns the implemented interface or extended class. The usage of interfaces promotes loose coupling.


### References
1. https://javapapers.com/design-patterns/factory-method-pattern/