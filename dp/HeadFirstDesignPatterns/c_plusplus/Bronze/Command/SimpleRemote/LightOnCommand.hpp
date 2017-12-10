#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_COMMAND_SIMPLE_REMOTE_LIGHT_ON_COMMAND_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_COMMAND_SIMPLE_REMOTE_LIGHT_ON_COMMAND_HPP_

#include "SimpleRemote.hpp"

namespace HeadFirstDesignPatterns {
namespace Command {
namespace SimpleRemote {

class LightOnCommand : public Command {
	private: Light* light;
 
	public:  LightOnCommand(Light* light) {
		this->light = light;
	}
	public: virtual void execute() {
		light->on();
	}
};

} // namespace SimpleRemote
} // namespace Command
} // namespace HeadFirstDesignPatterns

#endif