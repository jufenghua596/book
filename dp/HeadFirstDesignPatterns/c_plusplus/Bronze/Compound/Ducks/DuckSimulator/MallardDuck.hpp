#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_DUCKS_MALLARD_DUCK_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_DUCKS_MALLARD_DUCK_HPP_

#include "DuckSimulator.hpp"

namespace HeadFirstDesignPatterns {
namespace Compound {
namespace Ducks {

class MallardDuck : public Quackable {
	public: virtual void quack() {
		std::cout << "Quack" << std::endl;
	}
};

} // namespace Ducks
} // namespace Compound
} // namespace HeadFirstDesignPatterns

#endif