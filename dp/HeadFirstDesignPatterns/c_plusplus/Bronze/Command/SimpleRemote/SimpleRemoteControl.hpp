#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_COMMAND_SIMPLE_REMOTE_CONTROL_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_COMMAND_SIMPLE_REMOTE_CONTROL_HPP_

#include "SimpleRemote.hpp"

namespace HeadFirstDesignPatterns {
namespace Command {
namespace SimpleRemote {

class SimpleRemoteControl {
	private: Command* slot;
 
	public: SimpleRemoteControl() {
	}
	public: virtual void setCommand(Command* command) {
		slot = command;
	}
	public: virtual void buttonWasPressed() {
		slot->execute();
	}
};

} // namespace SimpleRemote
} // namespace Command
} // namespace HeadFirstDesignPatterns

#endif