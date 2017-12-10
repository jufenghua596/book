#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_STATE_GUMBALL_STATE_WINNER_STATE_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_STATE_GUMBALL_STATE_WINNER_STATE_HPP_

namespace HeadFirstDesignPatterns {
namespace State {
namespace GumballStateWinner {

class State {
 	public: virtual void insertQuarter() = 0;
	public: virtual void ejectQuarter() = 0;
	public: virtual void turnCrank() = 0;
	public: virtual void dispense() = 0;
	public: virtual std::string toString() = 0;
};

} // namespace GumballStateWinner
} // namespace State
} // namespace HeadFirstDesignPatterns

#endif