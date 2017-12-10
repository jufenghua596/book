#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_ITERATOR_DINER_MERGER_MENU_ITERATOR_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_ITERATOR_DINER_MERGER_MENU_ITERATOR_HPP_

namespace HeadFirstDesignPatterns {
namespace Iterator {
namespace DinerMerger {

class DinerMenuIterator : public Iterator<MenuItem> {
	private: std::vector<MenuItem*> items;
	private: int position;

	public: DinerMenuIterator(std::vector<MenuItem*> items) : position(0) {
		this->items = items;
	}
	public: virtual MenuItem* next() {
		MenuItem* menuItem = items[position];
		position = position + 1;
		return menuItem;
	}
	public: virtual bool hasNext() {
		if (position >= static_cast<int>(items.size()) || items[position] == 0) {
			return false;
		} else {
			return true;
		}
	}
};

} // namespace DinerMerger
} // namespace Iterator
} // namespace HeadFirstDesignPatterns

#endif