#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_ITERATOR_DINER_MERGER_I_MENU_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_ITERATOR_DINER_MERGER_I_MENU_HPP_

namespace HeadFirstDesignPatterns {
namespace Iterator {
namespace DinerMergerI {

class Menu {
	public: virtual Iterator<MenuItem>* createIterator() = 0;
};

} // namespace DinerMergerI
} // namespace Iterator
} // namespace HeadFirstDesignPatterns

#endif