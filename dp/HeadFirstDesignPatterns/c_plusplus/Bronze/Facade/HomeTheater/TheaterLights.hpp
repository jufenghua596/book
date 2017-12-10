#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_FACADE_HOME_THEATER_THEATER_LIGHTS_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_FACADE_HOME_THEATER_THEATER_LIGHTS_HPP_

#include "HomeTheater.hpp"

namespace HeadFirstDesignPatterns {
namespace Facade {
namespace HomeTheater {

class TheaterLights {
	private: std::string description;
	
	public: TheaterLights(std::string description) {
		this->description = description;
	}
	public: virtual void on() {
		std::cout << description.c_str() << " on" << std::endl;
	}

	public: virtual void off() {
		std::cout << description.c_str() << " off" << std::endl;
	}

	public: virtual void dim(int level) {
		std::cout << description.c_str() << " dimming to " << level  << "%" << std::endl;
	}

	public: virtual std::string toString() {
		return description;
	}
};

} // namespace HomeTheater
} // namespace Facade
} // namespace HeadFirstDesignPatterns

#endif
