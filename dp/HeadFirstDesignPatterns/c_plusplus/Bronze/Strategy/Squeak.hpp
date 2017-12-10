#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_STRATEGY_SQUEAK_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_STRATEGY_SQUEAK_HPP_

#include "MiniDuckSimulator.hpp"

namespace HeadFirstDesignPatterns {
namespace Strategy {

class Squeak : public QuackBehavior {
	public:	virtual void quack () {
		std::cout << "Squeak" << std::endl;
	}
};

} // namespace Strategy
} // namespace HeadFirstDesignPatterns

#endif