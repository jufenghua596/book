#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_ITERATOR_DINER_MERGER_I_PANCAKE_HOUSE_ITERATOR_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_ITERATOR_DINER_MERGER_I_PANCAKE_HOUSE_ITERATOR_HPP_

namespace HeadFirstDesignPatterns {
namespace Iterator {
namespace DinerMergerI {

class PancakeHouseMenuIterator : public Iterator<MenuItem> {
	private: std::vector<MenuItem*> items;
	private: MenuItem* position;
 
	public: PancakeHouseMenuIterator(std::vector<MenuItem*> items) {
		this->items = items;
		position = *items.begin();
	}
	public: virtual MenuItem* next() {
		return position;
	}
	public: virtual bool hasNext() {
		for (std::vector<MenuItem*>::iterator itr = items.begin(); itr != items.end(); itr++) {
			if (*itr == position) {
				if (++itr != items.end()) {
					position = *itr;
					return true;
				}
				else
					return false;
			}
		}
		return false;
	}
};

} // namespace DinerMergerI
} // namespace Iterator
} // namespace HeadFirstDesignPatterns

#endif
