#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_STATE_GUMBALL_STATE_WINNER_HAS_QUARTER_STATE_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_STATE_GUMBALL_STATE_WINNER_HAS_QUARTER_STATE_HPP_

#include <process.h>

namespace HeadFirstDesignPatterns {
namespace State {
namespace GumballStateWinner {

class HasQuarterState : public State {
	private: int random;

	//Random* randomWinner = new Random(System->currentTimeMillis());
	private: GumballMachine* gumballMachine;
 
	public: HasQuarterState(GumballMachine* gumballMachine) {
		this->gumballMachine = gumballMachine;
		srand(_getpid());
	}
	public: virtual void insertQuarter() {
		std::cout << "You can't insert another quarter" << std::endl;
	}
	public: virtual void ejectQuarter() {
		std::cout << "Quarter returned" << std::endl;
		gumballMachine->setState(gumballMachine->getNoQuarterState());
	}
	public: virtual void turnCrank() {
		std::cout << "You turned..." << std::endl;
		int winner = rand() % 5;	// randomWinner->nextInt(10);
		if ((winner == 0) && (gumballMachine->getCount() > 1)) {
			gumballMachine->setState(gumballMachine->getWinnerState());
		} else {
			gumballMachine->setState(gumballMachine->getSoldState());
		}
	}
    public: virtual void dispense() {
        std::cout << "No gumball dispensed" << std::endl;
    }
	public: virtual std::string toString() {
		return "waiting for turn of crank";
	}
};

} // namespace GumballStateWinner
} // namespace State
} // namespace HeadFirstDesignPatterns

#endif
