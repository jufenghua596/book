#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_OBSERVER_OBSERVER_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_OBSERVER_OBSERVER_HPP_

#include "WeatherStation.hpp"

namespace HeadFirstDesignPatterns {
namespace Observer {

class Observer {
	public: virtual void update(float temp, float humidity, float pressure) = 0;
};

} // namespace Observer
} // namespace HeadFirstDesignPatterns

#endif