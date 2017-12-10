#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_OBSERVER_FORECAST_DISPLAY_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_OBSERVER_FORECAST_DISPLAY_HPP_

#include "WeatherStation.hpp"

namespace HeadFirstDesignPatterns {
namespace Observer {

class ForecastDisplay : public Observer, public DisplayElement {
	private: float currentPressure;  
	private: float lastPressure;
	private: WeatherData* weatherData;

	public: ForecastDisplay(WeatherData* weatherData) : currentPressure(29.92F), lastPressure(0) {
		this->weatherData = weatherData;
		weatherData->registerObserver(this);
	}
	public: virtual void update(float temp, float humidity, float pressure) {
        lastPressure = currentPressure;
		currentPressure = pressure;

		display();
	}
	public: virtual void display() {
		std::cout.setf(std::ios::showpoint);
		std::cout.precision(3);
		std::cout << "Forecast: ";
		if (currentPressure > lastPressure) {
			std::cout << "Improving weather on the way!";
		} else if (currentPressure == lastPressure) {
			std::cout << "More of the same";
		} else if (currentPressure < lastPressure) {
			std::cout << "Watch out for cooler, rainy weather";
		}
		std::cout << std::endl;
	}
};

} // namespace Observer
} // namespace HeadFirstDesignPatterns

#endif