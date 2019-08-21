## Proxy design pattern

The proxy pattern describes an object that acts as an interface for another object. It shares the same interface with 
the original object, therefore it can easily be used by clients without them even knowing they are dealing with a proxy.
Before passing the received commands along to the main object the proxy can perform additional checks or other logic.
This removes this logic from the original object and helps to keep the original object cohesive.


### Resources
1. https://en.wikipedia.org/wiki/Proxy_pattern