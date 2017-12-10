#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_ADAPTER_REDHEAD_DUCK_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_ADAPTER_REDHEAD_DUCK_HPP_

#include "DuckSimulator.hpp"

namespace HeadFirstDesignPatterns {
namespace Compound {
namespace Adapter {

class RedheadDuck : public Quackable {
	public: virtual void quack() {
		std::cout << "Quack" << std::endl;
	}
};

} // namespace Adapter
} // namespace Compound
} // namespace HeadFirstDesignPatterns

#endif