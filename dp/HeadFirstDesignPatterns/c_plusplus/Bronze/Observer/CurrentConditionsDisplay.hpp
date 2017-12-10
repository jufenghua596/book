#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_OBSERVER_CURRENT_CONDITIONS_DISPLAY_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_OBSERVER_CURRENT_CONDITIONS_DISPLAY_HPP_

#include "WeatherStation.hpp"

namespace HeadFirstDesignPatterns {
namespace Observer {

class CurrentConditionsDisplay : public Observer, public DisplayElement {
	private: float temperature;
	private: float humidity;
	private: Subject* weatherData;

	public: CurrentConditionsDisplay(Subject* weatherData) {
		this->weatherData = weatherData;
		weatherData->registerObserver(this);
	}
	public: virtual void update(float temperature, float humidity, float pressure) {
		this->temperature = temperature;
		this->humidity = humidity;
		display();
	}
	public: virtual void display() {
		std::cout.setf(std::ios::showpoint);
		std::cout.precision(3);
		std::cout << "Current conditions: "	<< temperature 
			      << " F degrees and " << humidity << "% humidity"
				  << std::endl;
	}
};

} // namespace Observer
} // namespace HeadFirstDesignPatterns

#endif