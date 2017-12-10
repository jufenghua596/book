#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_OBSERVER_WEATHER_DATA_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_OBSERVER_WEATHER_DATA_HPP_

#include "WeatherStation.hpp"
#include <list>

namespace HeadFirstDesignPatterns {
namespace Observer {

class WeatherData : public Subject {
	private: std::list<Observer*> observers;
	private: float temperature;
	private: float humidity;
	private: float pressure;
	
	public: WeatherData() : temperature(0), humidity(0), pressure(0) {
	}
	public: virtual void registerObserver(Observer* o) {
		observers.push_back(o);
	}
	public: virtual void removeObserver(Observer* o) {
		observers.remove(o);
	}
	public: virtual void notifyObservers() {
		for (std::list<Observer*>::iterator it = observers.begin(); observers.end() != it; ++it) {
			Observer* observer = *it;
			observer->update(temperature, humidity, pressure);
		}
	}
	public: virtual void measurementsChanged() {
		notifyObservers();
	}
	public: virtual void setMeasurements(float temperature, float humidity, float pressure) {
		this->temperature = temperature;
		this->humidity = humidity;
		this->pressure = pressure;
		measurementsChanged();
	}
	
	// other WeatherData methods here
	
	public: virtual float getTemperature() {
		return temperature;
	}
	public: virtual float getHumidity() {
		return humidity;
	}
	public: virtual float getPressure() {
		return pressure;
	}

};

} // namespace Observer
} // namespace HeadFirstDesignPatterns

#endif