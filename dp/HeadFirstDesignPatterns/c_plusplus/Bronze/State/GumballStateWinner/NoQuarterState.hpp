#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_STATE_GUMBALL_STATE_WINNER_NO_QUARTER_STATE_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_STATE_GUMBALL_STATE_WINNER_NO_QUARTER_STATE_HPP_

namespace HeadFirstDesignPatterns {
namespace State {
namespace GumballStateWinner {

class NoQuarterState : public State {
    GumballMachine* gumballMachine;
 
    public: NoQuarterState(GumballMachine* gumballMachine) {
        this->gumballMachine = gumballMachine;
    }
	public: virtual void insertQuarter() {
		std::cout << "You inserted a quarter" << std::endl;
		gumballMachine->setState(gumballMachine->getHasQuarterState());
	}
	public: virtual void ejectQuarter() {
		std::cout << "You haven't inserted a quarter" << std::endl;
	}
	public: virtual void turnCrank() {
		std::cout << "You turned, but there's no quarter" << std::endl;
	}
	public: virtual void dispense() {
		std::cout << "You need to pay first" << std::endl;
	} 
	public: virtual std::string toString() {
		return "waiting for quarter";
	}
};

} // namespace GumballSateWinner
} // namespace State
} // namespace HeadFirstDesignPatterns

#endif

