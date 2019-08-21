## Chain of command design pattern

A chain of objects able to process a certain type of information. Information an object cannot use will be passed along to the next object in the chain.
The order of the objects in the chain is important. The first object that can use the data grabs it.
An example could be a chain of loggers for different severities. Each logger is task to handle a certain kind of level.

This pattern can be thought of as a replacement for blocks of if ... else if ... . The logic is set while setting up the chain and can therefor
be changed at runtime.

### Resources 
1. https://en.wikipedia.org/wiki/Chain-of-responsibility_pattern#Java_example 
