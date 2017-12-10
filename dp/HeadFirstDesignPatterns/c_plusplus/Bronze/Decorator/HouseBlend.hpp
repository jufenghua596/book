#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_DECORATOR_HOUSE_BLEND_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_DECORATOR_HOUSE_BLEND_HPP_

#include "Starbuzz.hpp"

namespace HeadFirstDesignPatterns {
namespace Decorator {

class HouseBlend : public Beverage { 
	public: HouseBlend() {
		description = "House Blend Coffee";
	}
	public: virtual double cost() {
		return 0.89;
	}
};

} // namespace Observer
} // namespace HeadFirstDesignPatterns

#endif