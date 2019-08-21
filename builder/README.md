## Builder design pattern

The builder pattern is used to construct complex objects.
The builder must be able to build different versions of the same class. There is an individual builder subclass foreach type of object that needs to be build.
The class including the creation process gets simplified. However a meaningful director has to be found and creating multiple builders causes a lot of work.


## Remark 
There seems to be quit a lot of misunderstanding revolving around the builder pattern. One example of that can be currently found on the [wikipedia page](https://en.wikipedia.org/wiki/Builder_pattern).
Generally speaking classes like the java StringBuilder have nothing to do with the builder pattern.
The static inner class used in java for object creation is a work around for java specific problems concerning the constructor.
(no named parameters and no optional ones)

The builder design pattern however has nothing to do with java but works in different programming languages. 
And it's actually way more complex.

### Compare
The builder pattern can be compared with the abstract factory pattern as both can be used to create complex objects.


### Resources 
1. https://javapapers.com/design-patterns/builder-pattern/
2. [Confusion with builders in java](https://www.javaspecialists.eu/archive/Issue253.html)