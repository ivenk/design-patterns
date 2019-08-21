## Composite design pattern

The composite design pattern treats a composition of objects in the same way as a single instance. 
This is mostly used for tree like data and can help simplify code.
Basically the client interacts with an interface instead of the collection of objects. The interface is inherited by a composition and the individual leaf elements.
The composition holds the elements and it passes the interface calls done by the client to each leaf.
The client does not know how many leafs exist and he doesn't need to know.



### Resources 
1. https://en.wikipedia.org/wiki/Composite_pattern