#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_COMPOSITE_DUCK_CALL_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_COMPOSITE_DUCK_CALL_HPP_

#include "DuckSimulator.hpp"

namespace HeadFirstDesignPatterns {
namespace Compound {
namespace Composite {

class DuckCall : public Quackable {
	public: virtual void quack() {
		std::cout << "Kwak" << std::endl;
	}
	public: virtual std::string toString() {
		return "Duck Call";
	}
};

} // namespace Composite
} // namespace Compound
} // namespace HeadFirstDesignPatterns

#endif