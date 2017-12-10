#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_STRATEGY_QUACK_BEHAVIOR_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_STRATEGY_QUACK_BEHAVIOR_HPP_

#include "MiniDuckSimulator.hpp"

namespace HeadFirstDesignPatterns {
namespace Strategy {

class QuackBehavior {
	public: virtual void quack() = 0;
};

} // namespace Strategy
} // namespace HeadFirstDesignPatterns

#endif