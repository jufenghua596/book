#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_ITERATOR_DINER_MERGER_I_MENU_ITEM_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_ITERATOR_DINER_MERGER_I_MENU_ITEM_HPP_

namespace HeadFirstDesignPatterns {
namespace Iterator {
namespace DinerMergerI {

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
};

} // namespace DinerMergerI
} // namespace Iterator
} // namespace HeadFirstDesignPatterns

#endif
