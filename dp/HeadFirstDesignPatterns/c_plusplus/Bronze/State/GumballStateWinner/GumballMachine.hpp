#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_STATE_GUMBALL_STATE_WINNER_GUMBALL_MACHINE_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_STATE_GUMBALL_STATE_WINNER_GUMBALL_MACHINE_HPP_

namespace HeadFirstDesignPatterns {
namespace State {
namespace GumballStateWinner {

class GumballMachine {
 
	private: State* soldOutState;
	private: State* noQuarterState;
	private: State* hasQuarterState;
	private: State* soldState;
	private: State* winnerState;
 
	private: State* state;	// = soldOutState;
	private: int count;		// = 0;
 
	public: GumballMachine(int numberGumballs);
	public: virtual void insertQuarter() {
		state->insertQuarter();
	}
	public: virtual void ejectQuarter() {
		state->ejectQuarter();
	}
	public: virtual void turnCrank() {
		state->turnCrank();
		state->dispense();
	}
	public: virtual void setState(State* state) {
		this->state = state;
	}
	public: virtual void releaseBall() {
		std::cout << "A gumball comes rolling out the slot..." << std::endl;
		if (count != 0) {
			count = count - 1;
		}
	}
	public: virtual int getCount() {
		return count;
	}
	public: virtual void refill(int count) {
		this->count = count;
		state = noQuarterState;
	}
    public: virtual State* getState() {
        return state;
    }
    public: virtual State* getSoldOutState() {
        return soldOutState;
    }
    public: virtual State* getNoQuarterState() {
        return noQuarterState;
    }
    public: virtual State* getHasQuarterState() {
        return hasQuarterState;
    }
   public: virtual State* getSoldState() {
        return soldState;
    }
    public: virtual State* getWinnerState() {
        return winnerState;
    }
	public: virtual std::string toString() {
		std::stringstream result; 
		result << std::endl << "Mighty Gumball, Inc.";
		result << std::endl << "C++-enabled Standing Gumball Model #2004";
		result << std::endl << "Inventory: " << count << " gumball";
		if (count != 1) {
			result << "s";
		}
		result << std::endl;
		result << "Machine is " << state->toString() << std::endl;
		return result.str();
	}
};

} // namespace GumballStateWinner
} // namespace State
} // namespace HeadFirstDesignPatterns

#endif
