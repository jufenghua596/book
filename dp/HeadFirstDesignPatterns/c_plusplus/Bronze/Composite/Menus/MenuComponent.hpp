#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_COMPOSITE_MENUS_MENU_COMPONENT_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_COMPOSITE_MENUS_MENU_COMPONENT_HPP_

namespace HeadFirstDesignPatterns {
namespace Composite {
namespace Menus {

class MenuComponent {
	public: virtual void add(MenuComponent* menuComponent) {
		throw new UnsupportedOperationException();
	}
	public: virtual void remove(MenuComponent* menuComponent) {
		throw new UnsupportedOperationException();
	}
	public: virtual MenuComponent* getChild(int i) {
		throw new UnsupportedOperationException();
	}
	public: virtual std::string getName() {
		throw new UnsupportedOperationException();
	}
	public: virtual std::string getDescription() {
		throw new UnsupportedOperationException();
	}
	public: virtual double getPrice() {
		throw new UnsupportedOperationException();
	}
	public: virtual bool isVegetarian() {
		throw new UnsupportedOperationException();
	}
	public: virtual void print() {
		throw new UnsupportedOperationException();
	}
};

} // namespace Menus
} // namespace Composite
} // namespace HeadFirstDesignPatterns

#endif
