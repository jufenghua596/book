#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_STRATEGY_FLY_WITH_WINGS_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_STRATEGY_FLY_WITH_WINGS_HPP_

#include "MiniDuckSimulator.hpp"

namespace HeadFirstDesignPatterns {
namespace Strategy {

class FlyWithWings : public FlyBehavior {
	public:	virtual void fly () {
		std::cout << "I'm flying!!" << std::endl;
	}
};

} // namespace Strategy
} // namespace HeadFirstDesignPatterns

#endif