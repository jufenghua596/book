#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_DECORATOR_QUACKABLE_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_DECORATOR_QUACKABLE_HPP_

#include "DuckSimulator.hpp"

namespace HeadFirstDesignPatterns {
namespace Compound {
namespace Decorator {

class Quackable {
	public: virtual void quack() = 0;
	public: virtual std::string toString() = 0;
};

} // namespace Decorator
} // namespace Compound
} // namespace HeadFirstDesignPatterns

#endif