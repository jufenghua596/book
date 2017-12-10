#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_STATE_GUMBALL_STATE_WINNER_SOLD_OUT_STATE_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_STATE_GUMBALL_STATE_WINNER_SOLD_OUT_STATE_HPP_

namespace HeadFirstDesignPatterns {
namespace State {
namespace GumballStateWinner {

class SoldOutState : public State {
    GumballMachine* gumballMachine;
 
    public: SoldOutState(GumballMachine* gumballMachine) {
        this->gumballMachine = gumballMachine;
    }
	public: virtual void insertQuarter() {
		std::cout << "You can't insert a quarter, the machine is sold out" << std::endl;
	}
	public: virtual void ejectQuarter() {
		std::cout << "You can't eject, you haven't inserted a quarter yet" << std::endl;
	}
	public: virtual void turnCrank() {
		std::cout << "You turned, but there are no gumballs" << std::endl;
	}
	public: virtual void dispense() {
		std::cout << "No gumball dispensed" << std::endl;
	}
	public: virtual std::string toString() {
		return "sold out";
	}
};

} // namespace GumballStateWinner
} // namespace State
} // namespace HeadFirstDesignPatterns

#endif

