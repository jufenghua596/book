#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_STRATEGY_REDHEAD_DUCK_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_STRATEGY_REDHEAD_DUCK_HPP_

#include "MiniDuckSimulator.hpp"

namespace HeadFirstDesignPatterns {
namespace Strategy {

class RedHead : public Duck {
	public:	RedHead() {
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	}
	public: virtual void display() {
		std::cout << "I'm a real Red Headed duck" << std::endl;
	}
};

} // namespace Strategy
} // namespace HeadFirstDesignPatterns

#endif