#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_COMPOSITE_MENUS_MENU_ITEM_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_COMPOSITE_MENUS_MENU_ITEM_HPP_

namespace HeadFirstDesignPatterns {
namespace Composite {
namespace Menus {

class MenuItem : public MenuComponent {
	private: std::string name;
	private: std::string description;
	private: bool vegetarian;
	private: double price;
 
	public: MenuItem(std::string name, std::string description, bool vegetarian, double price) {
		this->name = name;
		this->description = description;
		this->vegetarian = vegetarian;
		this->price = price;
	}
	public: virtual std::string getName() {
		return name;
	}
	public: virtual std::string getDescription() {
		return description;
	}
	public: virtual double getPrice() {
		return price;
	}
	public: virtual bool isVegetarian() {
		return vegetarian;
	}
	public: virtual void print() {
		std::cout << "  " << getName().c_str();
		if (isVegetarian()) {
			std::cout << "(v)";
		}
		std::cout << ", " << getPrice() << std::endl;
		std::cout << "     -- " << getDescription().c_str() << std::endl;
	}
};

} // namespace Menus
} // namespace Composite
} // namespace HeadFirstDesignPatterns

#endif
