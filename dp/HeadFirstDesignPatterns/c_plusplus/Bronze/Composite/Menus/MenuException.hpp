#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_COMPOSITE_MENUS_EXCEPTION_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_COMPOSITE_MENUS_EXCEPTION_HPP_

namespace HeadFirstDesignPatterns {
namespace Composite {
namespace Menus {

class UnsupportedOperationException : std::exception {
	private: std::string message;
			
	public: UnsupportedOperationException() : std::exception() {
	}
	public: UnsupportedOperationException(std::string message) : std::exception(message.c_str()) {
		this->message = message;
	}
	public: virtual std::string getMessage () {
		return message;
	}
};

} // namespace Menus
} // namespace Composite
} // namespace HeadFirstDesignPatterns

#endif
