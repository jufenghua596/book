#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_STATE_GUMBALL_STATE_WINNER_WINNER_STATE_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_STATE_GUMBALL_STATE_WINNER_WINNER_STATE_HPP_

namespace HeadFirstDesignPatterns {
namespace State {
namespace GumballStateWinner {

class WinnerState : public State {
    GumballMachine* gumballMachine;
 
    public: WinnerState(GumballMachine* gumballMachine) {
        this->gumballMachine = gumballMachine;
    }
	public: virtual void insertQuarter() {
		std::cout << "Please wait, we're already giving you a Gumball" << std::endl;
	}
	public: virtual void ejectQuarter() {
		std::cout << "Please wait, we're already giving you a Gumball" << std::endl;
	}
	public: virtual void turnCrank() {
		std::cout << "Turning again doesn't get you another gumball!" << std::endl;
	}
	public: virtual void dispense() {
		std::cout << "YOU'RE A WINNER! You get two gumballs for your quarter" << std::endl;
		gumballMachine->releaseBall();
		if (gumballMachine->getCount() == 0) {
			gumballMachine->setState(gumballMachine->getSoldOutState());
		} else {
			gumballMachine->releaseBall();
			if (gumballMachine->getCount() > 0) {
				gumballMachine->setState(gumballMachine->getNoQuarterState());
			} else {
            	std::cout << "Oops, out of gumballs!" << std::endl;
				gumballMachine->setState(gumballMachine->getSoldOutState());
			}
		}
	}
	public: virtual std::string toString() {
		return "despensing two gumballs for your quarter, because YOU'RE A WINNER!";
	}
};

} // namespace GumballStateWinner
} // namespace State
} // namespace HeadFirstDesignPatterns

#endif

