#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_STRATEGY_MALLARD_DUCK_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_STRATEGY_MALLARD_DUCK_HPP_

#include "MiniDuckSimulator.hpp"

namespace HeadFirstDesignPatterns {
namespace Strategy {

class MallardDuck : public Duck {
	public:	MallardDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	}
	public: virtual void display() {
		std::cout << "I'm a real Mallard duck" << std::endl;
	}
};

} // namespace Strategy
} // namespace HeadFirstDesignPatterns

#endif