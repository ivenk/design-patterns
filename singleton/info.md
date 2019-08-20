## Singleton design pattern

The rules for this pattern are very simple. There can never be more then one instance of the singleton and it should be globally accessible.
The singleton design pattern is therefore rather simple however there are a couple of pitfalls when it comes to implementation. 
Mostly thread safety has to be ensured and serialization + deserialization can cause multiple instances to exist.

Singleton can be implemented using either lazy initialization or not. Using lazy initialization prevents resources from being used unnecessarily but can be a bit trickier.

### References
1. https://javapapers.com/design-patterns/singleton-pattern/