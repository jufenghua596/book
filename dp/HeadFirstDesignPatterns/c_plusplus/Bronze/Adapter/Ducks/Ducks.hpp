#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_ADAPTER_BIRDS_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_ADAPTER_BIRDS_HPP_

#include <iostream>
#include <sstream>
#include <string>

#include "Duck.hpp"
#include "MallardDuck.hpp"

#include "Turkey.hpp"
#include "WildTurkey.hpp"
#include "TurkeyAdapter.hpp"

//#define _DUCK_ADAPTER_
#ifdef  _DUCK_ADAPTER_
#include "DuckAdapter.hpp"
#endif

#endif