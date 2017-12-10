#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_COMMAND_SIMPLE_REMOTE_GARAGE_DOOR_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_COMMAND_SIMPLE_REMOTE_GARAGE_DOOR_HPP_

#include "SimpleRemote.hpp"

namespace HeadFirstDesignPatterns {
namespace Command {
namespace SimpleRemote {

class GarageDoor {
	public: GarageDoor() {
	}
	public: virtual void up() {
		std::cout << "Garage Door is Open" << std::endl;
	}
	public: virtual void down() {
		std::cout << "Garage Door is Closed" << std::endl;
	}
	public: virtual void stop() {
		std::cout << "Garage Door is Stopped" << std::endl;
	}
	public: virtual void lightOn() {
		std::cout << "Garage light is on" << std::endl;
	}
	public: virtual void lightOff() {
		std::cout << "Garage light is off" << std::endl;
	}
};

} // namespace SimpleRemote
} // namespace Command
} // namespace HeadFirstDesignPatterns

#endif