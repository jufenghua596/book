#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_DECORATOR_CONDIMENT_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_DECORATOR_CONDIMENT_HPP_

#include "Starbuzz.hpp"

namespace HeadFirstDesignPatterns {
namespace Decorator {

class CondimentDecorator : public Beverage {
	public: virtual std::string getDescription() = 0;
};

} // namespace Observer
} // namespace HeadFirstDesignPatterns

#endif