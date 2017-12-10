#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_STRATEGY_FLY_NO_WAY_WINGS_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_STRATEGY_FLY_NO_WAY_WINGS_HPP_

#include "MiniDuckSimulator.hpp"

namespace HeadFirstDesignPatterns {
namespace Strategy {

class FlyNoWay : public FlyBehavior {
	public: virtual	void fly () {
		std::cout << "I can't fly" << std::endl;
	}
};

} // namespace Strategy
} // namespace HeadFirstDesignPatterns

#endif