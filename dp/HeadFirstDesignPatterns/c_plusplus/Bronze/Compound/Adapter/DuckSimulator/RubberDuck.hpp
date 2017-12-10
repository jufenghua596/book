#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_ADAPTER_RUBBER_DUCK_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_ADAPTER_RUBBER_DUCK_HPP_

#include "DuckSimulator.hpp"

namespace HeadFirstDesignPatterns {
namespace Compound {
namespace Adapter {

class RubberDuck : public Quackable {
	public: virtual void quack() {
		std::cout << "Squeak" << std::endl;
	}
};

} // namespace Adapter
} // namespace Compound
} // namespace HeadFirstDesignPatterns

#endif