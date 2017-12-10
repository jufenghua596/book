#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_COMPOSITE_REDHEAD_DUCK_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_COMPOSITE_REDHEAD_DUCK_HPP_

#include "DuckSimulator.hpp"

namespace HeadFirstDesignPatterns {
namespace Compound {
namespace Composite {

class RedheadDuck : public Quackable {
	public: virtual void quack() {
		std::cout << "Quack" << std::endl;
	}
	public: virtual std::string toString() {
		return "Redhead Duck";
	}
};

} // namespace Composite
} // namespace Compound
} // namespace HeadFirstDesignPatterns

#endif