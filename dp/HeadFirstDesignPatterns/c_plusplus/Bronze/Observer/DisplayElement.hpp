#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_OBSERVER_DISPLAY_ELEMENT_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_OBSERVER_DISPLAY_ELEMENT_HPP_

#include "WeatherStation.hpp"

namespace HeadFirstDesignPatterns {
namespace Observer {

class DisplayElement {
	public: virtual void display() = 0;
};

} // namespace Observer
} // namespace HeadFirstDesignPatterns

#endif