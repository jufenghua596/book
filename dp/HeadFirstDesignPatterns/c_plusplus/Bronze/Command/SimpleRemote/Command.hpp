#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_COMMAND_SIMPLE_REMOTE_COMMAND_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_COMMAND_SIMPLE_REMOTE_COMMAND_HPP_

#include "SimpleRemote.hpp"

namespace HeadFirstDesignPatterns {
namespace Command {
namespace SimpleRemote {

class Command {
	public: virtual void execute() = 0;
};

} // namespace SimpleRemote
} // namespace Command
} // namespace HeadFirstDesignPatterns

#endif