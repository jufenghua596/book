#include "DuckSimulator.hpp"

using namespace HeadFirstDesignPatterns::Compound::Observer;

int QuackCounter::_numberOfQuacks = 0;

void simulate( const Quackable* duck ) { assert( duck );
	duck->quack();
}

int main(int argc, char* argv[]) {

	std::auto_ptr< AbstractDuckFactory > duckFactory( new CountingDuckFactory() );

	std::auto_ptr< Quackable > redheadDuck( duckFactory->createRedheadDuck() );
	std::auto_ptr< Quackable > duckCall( duckFactory->createDuckCall() );
	std::auto_ptr< Quackable > rubberDuck( duckFactory->createRubberDuck() );
	std::auto_ptr< Quackable > gooseDuck( new GooseAdapter( new Goose() ) );

	std::auto_ptr< Flock > flockOfDucks( new Flock() );

	flockOfDucks->add(redheadDuck.get() );
	flockOfDucks->add( duckCall.get() );
	flockOfDucks->add(rubberDuck.get() );
	flockOfDucks->add( gooseDuck.get() );

	std::auto_ptr< Flock > flockOfMallards( new Flock() );

	std::auto_ptr< Quackable > mallardOne( duckFactory->createMallardDuck() );
	std::auto_ptr< Quackable > mallardTwo( duckFactory->createMallardDuck() );
	std::auto_ptr< Quackable > mallardThree( duckFactory->createMallardDuck() );
	std::auto_ptr< Quackable > mallardFour( duckFactory->createMallardDuck() );

	flockOfMallards->add( mallardOne.get() );
	flockOfMallards->add( mallardTwo.get() );
	flockOfMallards->add( mallardThree.get() );
	flockOfMallards->add( mallardFour.get() );

	flockOfDucks->add(flockOfMallards.get() );

	std::cout << std::endl << "Duck Simulator: With Observer" << std::endl;

	std::auto_ptr< Quackologist > quackologist( new Quackologist() );
	flockOfDucks->registerObserver( quackologist.get() );

	simulate( flockOfDucks.get() );

	std::cout << std::endl << "The ducks quacked " << QuackCounter::getQuacks() << " times" << std::endl;

	return 0;
}