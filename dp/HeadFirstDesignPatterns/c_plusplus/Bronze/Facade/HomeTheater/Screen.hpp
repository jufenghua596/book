#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_FACADE_HOME_THEATER_SCREEN_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_FACADE_HOME_THEATER_SCREEN_HPP_

#include "HomeTheater.hpp"

namespace HeadFirstDesignPatterns {
namespace Facade {
namespace HomeTheater {

class Screen {
	private: std::string description;
	
	public: Screen(std::string description) {
		this->description = description;
	}
	public: virtual void up() {
		std::cout << description.c_str() << " going up" << std::endl;
	}
	public: virtual void down() {
		std::cout << description.c_str() << " going down" << std::endl;
	}
    public: virtual std::string toString() {
		return description;
    }
};

} // namespace HomeTheater
} // namespace Facade
} // namespace HeadFirstDesignPatterns

#endif
