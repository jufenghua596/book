#include "GumballStateWinner.hpp"

using namespace HeadFirstDesignPatterns::State::GumballStateWinner;

//
// put here to resolve forward reference paradox where GumballMachine
// references State(s) and State references GumballMachine. Note, a 
// simple forward 'class' reference is not sufficient to resolve the
// circular (chicken&egg) paradox. Morever, since the intent is to 
// preserve as much of the original examples, this minor deviation is
// acceptable.
//
GumballMachine::GumballMachine(int numberGumballs) {
	soldOutState = new SoldOutState(this);
	noQuarterState = new NoQuarterState(this);
	hasQuarterState = new HasQuarterState(this);
	soldState = new SoldState(this);
	winnerState = new WinnerState(this);

	this->state = soldOutState;
	this->count = numberGumballs;
	if (numberGumballs > 0) {
		state = noQuarterState;
	} 
}

int main(int argc, char* argv[]) {

	GumballMachine* gumballMachine = 
		new GumballMachine(10);

	std::cout << gumballMachine->toString() << std::endl;

	gumballMachine->insertQuarter();
	gumballMachine->turnCrank();
	gumballMachine->insertQuarter();
	gumballMachine->turnCrank();

	std::cout << gumballMachine->toString() << std::endl;

	gumballMachine->insertQuarter();
	gumballMachine->turnCrank();
	gumballMachine->insertQuarter();
	gumballMachine->turnCrank();

	std::cout << gumballMachine->toString() << std::endl;

	gumballMachine->insertQuarter();
	gumballMachine->turnCrank();
	gumballMachine->insertQuarter();
	gumballMachine->turnCrank();

	std::cout << gumballMachine->toString() << std::endl;

	gumballMachine->insertQuarter();
	gumballMachine->turnCrank();
	gumballMachine->insertQuarter();
	gumballMachine->turnCrank();

	std::cout << gumballMachine->toString() << std::endl;

	gumballMachine->insertQuarter();
	gumballMachine->turnCrank();
	gumballMachine->insertQuarter();
	gumballMachine->turnCrank();

	std::cout << gumballMachine->toString() << std::endl;

	return 0;
}