#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_STRATEGY_QUACK_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_STRATEGY_QUACK_HPP_

#include "MiniDuckSimulator.hpp"

namespace HeadFirstDesignPatterns {
namespace Strategy {

class Quack : public QuackBehavior {
	public: virtual void quack () {
		std::cout << "Quack" << std::endl;
	}
};

} // namespace Strategy
} // namespace HeadFirstDesignPatterns

#endif