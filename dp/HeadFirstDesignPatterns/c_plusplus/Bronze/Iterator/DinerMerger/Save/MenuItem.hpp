#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_ITERATOR_DINER_MERGER_MENU_ITEM_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_ITERATOR_DINER_MERGER_MENU_ITEM_HPP_

namespace HeadFirstDesignPatterns {
namespace Iterator {
namespace DinerMerger {

class MenuItem /*: public Object<MenuItem> */ {
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
	public: std::string toString() {
		std::stringstream result (name.c_str());
		result << " $" << price << std::endl << description.c_str();
		return result.str();
	}
};

} // namespace DinerMerger
} // namespace Iterator
} // namespace HeadFirstDesignPatterns

#endif
