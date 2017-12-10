#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_FACADE_HOME_THEATER_TUNER_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_FACADE_HOME_THEATER_TUNER_HPP_

#include "HomeTheater.hpp"

namespace HeadFirstDesignPatterns {
namespace Facade {
namespace HomeTheater {

class Amplifier;

class Tuner {
	private: std::string description;
	private: Amplifier* amplifier;
	private: double frequency;

	public: Tuner(std::string description, Amplifier* amplifier) {
		this->description = description;
	}
	public: virtual void on() {
		std::cout << description.c_str() << " on" << std::endl;
	}
	public: virtual void off() {
		std::cout << description.c_str() << " off" << std::endl;
	}
	public: virtual void setFrequency(double frequency) {
		std::cout << description.c_str() << " setting frequency to " << frequency << std::endl;
		this->frequency = frequency;
	}
	public: virtual void setAm() {
		std::cout << description.c_str() << " setting AM mode" << std::endl;
	}
	public: virtual void setFm() {
		std::cout << description.c_str() << " setting FM mode" << std::endl;
	}
	public: virtual std::string toString() {
		return description;
	}
};

} // namespace HomeTheater
} // namespace Facade
} // namespace HeadFirstDesignPatterns

#endif
