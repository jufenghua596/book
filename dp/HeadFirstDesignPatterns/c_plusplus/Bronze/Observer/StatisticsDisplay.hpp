#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_OBSERVER_STATISTICS_DISPLAY_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_OBSERVER_STATISTICS_DISPLAY_HPP_

#include "WeatherStation.hpp"

namespace HeadFirstDesignPatterns {
namespace Observer {

class StatisticsDisplay : public Observer, public DisplayElement {
	private: float maxTemp;
	private: float minTemp;
	private: float tempSum;
	private: int numReadings;
	private: WeatherData* weatherData;

	public: StatisticsDisplay(WeatherData* weatherData) : maxTemp(0), minTemp(200.0F), tempSum(0), numReadings(0) {
		this->weatherData = weatherData;
		weatherData->registerObserver(this);
	}
	public: virtual void update(float temp, float humidity, float pressure) {
		tempSum += temp;
		numReadings++;

		if (temp > maxTemp) {
			maxTemp = temp;
		}
 
		if (temp < minTemp) {
			minTemp = temp;
		}

		display();
	}
	public: virtual void display() {
		std::cout.setf(std::ios::showpoint);
		std::cout.precision(3);
		std::cout << "Avg/Max/Min temperature = "
				  << (tempSum / numReadings) << "/" << maxTemp << "/" << minTemp 
				  << std::endl;
	}
};

} // namespace Observer
} // namespace HeadFirstDesignPatterns

#endif