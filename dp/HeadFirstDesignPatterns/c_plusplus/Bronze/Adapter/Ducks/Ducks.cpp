#include "Ducks.hpp"

using namespace HeadFirstDesignPatterns::Adapter::Ducks;

void testDuck(Duck* duck) {
	duck->quack();
	duck->fly();
}

int main(int argc, char* argv[]) {
	MallardDuck* duck = new MallardDuck();

#ifndef _DUCK_ADAPTER_
	WildTurkey* turkey = new WildTurkey();
	Duck* turkeyAdapter = new TurkeyAdapter(turkey);

	std::cout << "The Turkey says..." << std::endl;
	turkey->gobble();
	turkey->fly();

	std::cout << std::endl << "The Duck says..." << std::endl;
	testDuck(duck);

	std::cout << std::endl << "The TurkeyAdapter says..." << std::endl;
	testDuck(turkeyAdapter);
#else
	Turkey* duckAdapter = new DuckAdapter(duck);
 
	for(int i=0;i<10;i++) {
		std::cout << "The DuckAdapter says..." << std::endl;
		duckAdapter->gobble();
		duckAdapter->fly();
	}
#endif

	return 0;
}