#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_STATE_GUMBALL_STATE_WINNER_SOLD_STATE_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_STATE_GUMBALL_STATE_WINNER_SOLD_STATE_HPP_

namespace HeadFirstDesignPatterns {
namespace State {
namespace GumballStateWinner {

class SoldState : public State {
    private: GumballMachine* gumballMachine;
 
    public: SoldState(GumballMachine* gumballMachine) {
        this->gumballMachine = gumballMachine;
    }
	public: virtual void insertQuarter() {
		std::cout << "Please wait, we're already giving you a gumball" << std::endl;
	}
	public: virtual void ejectQuarter() {
		std::cout << "Sorry, you already turned the crank" << std::endl;
	}
	public: virtual void turnCrank() {
		std::cout << "Turning twice doesn't get you another gumball!" << std::endl;
	}
	public: virtual void dispense() {
		gumballMachine->releaseBall();
		if (gumballMachine->getCount() > 0) {
			gumballMachine->setState(gumballMachine->getNoQuarterState());
		} else {
			std::cout << "Oops, out of gumballs!" << std::endl;
			gumballMachine->setState(gumballMachine->getSoldOutState());
		}
	}
	public: virtual std::string toString() {
		return "dispensing a gumball";
	}
};

} // namespace GumballStateWinner
} // namespace State
} // namespace HeadFirstDesignPatterns

#endif

