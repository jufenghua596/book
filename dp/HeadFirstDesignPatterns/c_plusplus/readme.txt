In the spirit of contributing to the design pattern community (whilst learning
more about patterns), I followed Mark McFadden’s example of converting the
Java examples associated with “Head First Design Patterns” to another computer
language: C++.  

First, I would like to acknowledge the good work done by the authors of this 
book and their support of my efforts. Second, I do not claim to be a Java 
developer, so I may have misinterpreted a subtle Java notion or convention
during the conversion process. In this regard, I welcome (constructive) feedback. 
Finally, I intend to provide three levels of interpretation (Bronze, Silver & Gold)
on two different platforms (Windows & Linux):

	-	Bronze; a literal (syntax) translation that produces identical output
	-	Silver; a semantic translation that preserves the intent using
		good C++ programming practices (copy contructors, etc...) 
	-	Gold: a modern level using templates and more STL.

Bronze:

Adapter:
--------

	Duck and Turkey test drives' where combined into ducks.cpp and implemented
	by defining (or not defining) the pre-processor definition: _DUCK_ADAPTER_

Factory:
--------

	Pizzaaf has a logic error--it does not cut Chicago Style pizza's in squares. 
	
Iterator:
---------

	Renamed ‘Menu’ to ‘Menus’ to avoid a conflict between the project name and one
	of its header files.

	MenuIterator was initially attempted but dismissed for the following reasons:

	-	It did not eliminate the need for 'PancakeHouseMenuIterator' as in the Java
		version. In C++, 'PancakeHouseMenuIterator' became an 'adapter' that 
		translated the Java Iterator interface to the STL std::iterator interface.
	
Proxy:
--------

	Pending suitable solution for RMI

MVC (Model, View, Controller)
---------------------------------------

	Pending suitable solution for GUI


