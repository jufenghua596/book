#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_STRATEGY_FAKE_QUACK_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_STRATEGY_FAKE_QUACK_HPP_

#include "MiniDuckSimulator.hpp"

namespace HeadFirstDesignPatterns {
namespace Strategy {

class FakeQuack : public QuackBehavior {
	public:	virtual void quack () {
		std::cout << "Qwak" << std::endl;
	}
};

} // namespace Strategy
} // namespace HeadFirstDesignPatterns

#endif