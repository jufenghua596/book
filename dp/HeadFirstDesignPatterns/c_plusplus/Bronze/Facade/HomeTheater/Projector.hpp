#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_FACADE_HOME_THEATER_PROJECTOR_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_FACADE_HOME_THEATER_PROJECTOR_HPP_

#include "HomeTheater.hpp"

namespace HeadFirstDesignPatterns {
namespace Facade {
namespace HomeTheater {

class Projector {
	private: std::string description;
	private: DvdPlayer* dvdPlayer;
	
	public: Projector(std::string description, DvdPlayer* dvdPlayer) {
		this->description = description;
		this->dvdPlayer = dvdPlayer;
	}
	public: virtual void on() {
		std::cout << description.c_str() << " on" << std::endl;
	}
	public: virtual void off() {
		std::cout << description.c_str() << " off" << std::endl;
	}
	public: virtual void wideScreenMode() {
		std::cout << description.c_str() << " in widescreen mode (16x9 aspect ratio)" << std::endl;
	}
	public: virtual void tvMode() {
		std::cout << description.c_str() << " in tv mode (4x3 aspect ratio)" << std::endl;
	}
    public: virtual std::string toString() {
		return description;
    }
};

} // namespace HomeTheater
} // namespace Facade
} // namespace HeadFirstDesignPatterns

#endif

