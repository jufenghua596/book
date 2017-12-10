#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_STRATEGY_FLY_ROCKET_POWERED_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_STRATEGY_FLY_ROCKET_POWERED_HPP_

#include "MiniDuckSimulator.hpp"

namespace HeadFirstDesignPatterns {
namespace Strategy {

class FlyRocketPowered : public FlyBehavior {
	public:	virtual void fly () {
		std::cout << "I'm flying with a rocket" << std::endl;
	}
};

} // namespace Strategy
} // namespace HeadFirstDesignPatterns

#endif