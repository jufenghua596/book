#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_STRATEGY_MUTE_QUACK_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_STRATEGY_MUTE_QUACK_HPP_

#include "MiniDuckSimulator.hpp"

namespace HeadFirstDesignPatterns {
namespace Strategy {

class MuteQuack : public QuackBehavior {
	public:	virtual void quack () {
		std::cout << "<< Silence >>" << std::endl;
	}
};

} // namespace Strategy
} // namespace HeadFirstDesignPatterns

#endif